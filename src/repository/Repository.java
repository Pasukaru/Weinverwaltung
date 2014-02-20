package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.JDBCConnectionException;

import util.ExceptionHandler;
import util.JpaUtil;
import model.City;
import model.Country;
import model.Model;
import model.Region;
import model.Sort;
import model.Type;
import model.Vine;
import model.Wine;
import model.Winery;
import events.EventManager;

@SuppressWarnings("unchecked")
public class Repository<T extends Model> {

	protected final Class<T> model;
	
	protected static ExceptionHandler exceptionHandler;
	
	protected static EntityManager entityManager = null;
	protected static Session session = null;
	protected static EventManager eventManager;
	
	private static HashMap<Class<? extends Model>, Repository<? extends Model>> instances;
	
	protected Repository(Class<T> model){
		this.model = model;
	}
	
	public static void init(EventManager eventManager){
		close();
		JpaUtil.init("WEINVERWALTUNG");
		entityManager = JpaUtil.getEM();
		session = (Session) entityManager.getDelegate();
		Repository.eventManager = eventManager;
		instances = new HashMap<Class<? extends Model>, Repository<? extends Model>>();
		instances.put(City.class, new Repository<City>(City.class));
		instances.put(Country.class, new Repository<Country>(Country.class));
		instances.put(Region.class, new Repository<Region>(Region.class));
		instances.put(Sort.class, new Repository<Sort>(Sort.class));
		instances.put(Type.class, new Repository<Type>(Type.class));
		instances.put(Vine.class, new Repository<Vine>(Vine.class));
		instances.put(Wine.class, new WineRepository());
		instances.put(Winery.class, new Repository<Winery>(Winery.class));
	}
	
	public static void close() {
		if(session != null){
			try { session.flush(); } catch(Exception e) {}
			try { session.close(); } catch(Exception e) {}
			session = null;
		}
		JpaUtil.close();
		entityManager = null;
		eventManager = null;
	}
	
	public static void setExceptionHandler(ExceptionHandler exceptionHander){
		Repository.exceptionHandler = exceptionHander;
	}
	
	public static EntityManager getEntityManager(){
		return entityManager;
	}
	
	public static EventManager getEventManager(){
		return eventManager;
	}
	
	public static <T extends Model> Repository<T> getInstance(Class<T> model){
		return (Repository<T>) instances.get(model);
	}
	
	public Criteria getSearchCriteria(String query){
		return session.createCriteria(model).add(Restrictions.like("name", "%"+query+"%"));
	}
	
	public T getOne(Criteria criteria){
		if(criteria == null){
			session.createCriteria(model);
		}
		List<T> results = getAll(criteria.setMaxResults(1));
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<T> getAll(Criteria criteria){
		try {
			if(criteria == null){
				criteria = session.createCriteria(model);
			}
			return criteria.list();
		} catch(JDBCConnectionException e){
			exceptionHandler.handleException(e);
			return new ArrayList<T>();
		}
	}
	
	public List<T> getAll(){
		return getAll(null);
	}
	
	public T getByName(String name){
		return getOne(session.createCriteria(model).add(Restrictions.eq("name", name)));
	}
	
	public List<T> search(String query){
		return getAll(getSearchCriteria(query));
	}

	public void update(T model){
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(model);
			session.update(model);
			tx.commit();
			eventManager.fireAnyModelChanged(model);	
		} catch(Exception e){
			if(tx != null){ tx.rollback(); }
			exceptionHandler.handleException(e);
		}
	}
	
	public boolean delete(T model){
		boolean deleted = false;

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
		    session.delete(model);
		    tx.commit();
		    
			Object result = session.get(model.getClass(), model.getId());
			if(result == null){
				eventManager.fireAnyModelChanged(model);
				deleted = true;
			}
		} catch(Exception e){
			if(tx != null){ tx.rollback(); }
			exceptionHandler.handleException(e);
		}
		return deleted;
	}

}