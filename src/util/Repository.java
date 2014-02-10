package util;

import java.util.List;

import model.City;
import model.Type;
import model.Wine;

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

	public List<Type> getAllTypes() {
		return session.createCriteria(Type.class).list();
	}
}
