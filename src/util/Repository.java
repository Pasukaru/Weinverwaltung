package util;

import java.util.List;

import model.City;
import model.Country;
import model.Region;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;

import org.hibernate.Session;

@SuppressWarnings("unchecked")
public class Repository {

	private Session session = null;
	private static Repository instance = null;

	private Repository(Session session) {
		this.session = session;
	}

	public static Repository getInstance() {
		if (instance == null) {
			instance = new Repository((Session) JpaUtil.getEM().getDelegate());
		}
		return instance;
	}

	public void updateWine(Wine wine) {
		session.persist(wine);
	}

	public void updateCity(City city) {
		session.persist(city);
	}

	public List<City> getAllCities() {
		return session.createCriteria(City.class).list();
	}


	public List<Country> getAllCountries(){
		return session.createCriteria(Country.class).list();
	}

	public List<Region> getAllRegions(){
		return session.createCriteria(Region.class).list();
	}

	public List<Vine> getAllVines(){
		return session.createCriteria(Vine.class).list();
	}

	public List<Wine> getAllWines(){
		return session.createCriteria(Wine.class).list();
	}

	public List<Sort> getAllSorts(){
		return session.createCriteria(Sort.class).list();
	}

	public List<Winery> getAllWineries(){
		return session.createCriteria(Winery.class).list();
	}

	public List<Type> getAllTypes() {
		return session.createCriteria(Type.class).list();
	}
}