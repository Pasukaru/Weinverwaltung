package util;

import java.util.List;

import model.City;

import org.hibernate.Session;

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

	@SuppressWarnings("unchecked")
	public List<City> getAllCities() {
		return session.createCriteria(City.class).list();
	}
}
