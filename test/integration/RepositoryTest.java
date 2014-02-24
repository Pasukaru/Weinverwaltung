package integration;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.City;
import model.Country;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import events.EventManager;
import repository.Repository;
import util.ExceptionHandler;


public class RepositoryTest {

	private static String testCountry;
	private static Repository<Country> country;
	private static Repository<City> city;
	
	public static void resetDB(){
		System.out.println("Setting up test DB...");

		Connection c = null;
		try {
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			c.createStatement().execute("drop database if exists weinverwaltungtest");
			c.createStatement().execute("create database weinverwaltungtest");
		} catch(Exception e){
			fail("Failed to create test DB: "+e.getMessage());
		}
		
		//cleanup
		if(c != null){ try { c.close(); } catch (SQLException e1) {} }
	}
	
	public static void resetErrorHandler(){
		Repository.setExceptionHandler(new TestExceptionHandler());
	}
	
	public static void initRepo(){
		Repository.setExceptionHandler(new TestExceptionHandler());
		Repository.init(new EventManager(), "TEST");
	}
	
	@BeforeClass
	public static void beforeClass() {
		resetDB();
		initRepo();
	}
	
	@Before
	public void before(){
		resetErrorHandler();
		testCountry = "Test-123";
		country = Repository.getInstance(Country.class);
		city = Repository.getInstance(City.class);
	}

	@AfterClass
	public static void afterClass(){
		Repository.close();
	}
	
	@Test
	public void testErrorHandling(){
		final List<Boolean> l = new ArrayList<Boolean>();
		Repository.setExceptionHandler(new ExceptionHandler() {
			@Override
			public void handleException(Exception e) {
				l.add(true);
			}
		});
		
		city.update(new City("asdf", "326598", null));
		
		assertFalse("Exception was not handled properly", l.isEmpty());
		assertTrue("Exception was not handled properly", l.get(0));
	}

	@Test
	public void testCreateAndGetByName() {
		country.update(new Country(testCountry));
		Country c = country.getByName(testCountry);
		assertNotNull("Failed to find created country", c);
		assertNotNull("Created country should have an ID", c.getId());
		assertEquals("Country name does not match", testCountry, c.getName());
	}
	
	@Test
	public void testDelete(){
		Country c = country.getByName(testCountry);
		assertNotNull("Failed to find Country", c);
		assertNotNull("Failed to find Country", c.getId());

		System.out.println(c.getId());
		boolean res = country.delete(c);
		assertTrue("Delete should return true", res);

		c = country.getByName(testCountry);
		assertNull("Finding a deleted model should return null", c);
	}
	
	@Test
	public void testSearch(){
		country.update(new Country("Test 1"));
		country.update(new Country("Test 2"));
		country.update(new Country("Test 3"));
		country.update(new Country("Test 4"));
		
		assertTrue("Should find 4 countries", country.search("Test").size() == 4);
	}

}
