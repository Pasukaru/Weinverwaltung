package util;

import java.util.List;

import model.City;
import model.Country;
import model.Model;
import model.Region;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;

import org.hibernate.FlushMode;
import org.hibernate.Session;

import events.EventManager;

@SuppressWarnings("unchecked")
public class Repository {

	private static Repository instance = null;

	private Session session = null;
	private EventManager eventManager;

	private Repository(Session session, EventManager eventManager) {
		this.session = session;
		this.eventManager = eventManager;
		session.setFlushMode(FlushMode.ALWAYS);
	}
	
	public static Repository init(EventManager eventManager){
		if (instance == null) {
			instance = new Repository((Session) JpaUtil.getEM().getDelegate(), eventManager);
			return instance;
		} else {
			throw new RuntimeException("Repository is already initialized!");
		}
	}

	public static Repository getInstance() {
		return instance;
	}

	public void updateModel(Model model) {
		session.persist(model);
		session.update(model);
		session.flush();
		eventManager.fireAnyModelChanged(model);
	}

	public List<City> getAllCities() {
		return session.createCriteria(City.class).list();
	}

	public List<Country> getAllCountries() {
		return session.createCriteria(Country.class).list();
	}

	public List<Region> getAllRegions() {
		return session.createCriteria(Region.class).list();
	}

	public List<Vine> getAllVines() {
		return session.createCriteria(Vine.class).list();
	}

	public List<Wine> getAllWines() {
		return session.createCriteria(Wine.class).list();
	}

	public List<Sort> getAllSorts() {
		return session.createCriteria(Sort.class).list();
	}

	public List<Winery> getAllWineries() {
		return session.createCriteria(Winery.class).list();
	}

	public List<Type> getAllTypes() {
		return session.createCriteria(Type.class).list();
	}
}