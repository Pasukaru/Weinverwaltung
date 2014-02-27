package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

	protected static ExceptionHandler exceptionHandler = null;

	protected static EntityManager entityManager = null;
	protected static EventManager eventManager;

	private static HashMap<Class<? extends Model>, Repository<? extends Model>> instances;

	protected Repository(Class<T> model){
		this.model = model;
	}

	private static void handleException(Exception e){
		if(exceptionHandler != null){
			exceptionHandler.handleException(e);
		}
	}
	
	public static void init(EventManager eventManager, String persistenceUnit){
		try {
			close();
			JpaUtil.init(persistenceUnit);
			entityManager = JpaUtil.getEM();
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
		} catch(Exception e){
			handleException(e);
		}
	}

	public static void init(EventManager eventManager){
		init(eventManager, "PROD");
	}
	
	public static void close() {
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
	
	public T getOne(CriteriaQuery<T> cq){
		Query q = entityManager.createQuery(cq);
		q.setMaxResults(1);
		List<T> results = q.getResultList();
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<T> getAll(Predicate p){
		try {
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	        CriteriaQuery<T> cq = cb.createQuery(model);
	        Root<T> rootEntry = cq.from(model);
	        CriteriaQuery<T> all = cq.select(rootEntry);
			if(p != null){
				all.where(p);
			}
			TypedQuery<T> allQuery = entityManager.createQuery(all);
			return allQuery.getResultList();
		} catch(Exception e){
			handleException(e);
			return new ArrayList<T>();
		}
	}
	
	public List<T> getAll(){
		return getAll(null);
	}
	
	public T getByName(String name){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(model);
		Root<T> root = cq.from(model);
		
		Expression<String> path = root.get("name");
		cq.where(cb.equal(path, name));
		
		return getOne(cq);
	}
	
	public List<T> search(String query){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(model);
		Root<T> root = cq.from(model);
		Expression<String> name = root.get("name");
		cq.where(cb.like(name, "%"+query+"%"));
		return entityManager.createQuery(cq).getResultList();
	}

	public void update(T model){
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(model);
			tx.commit();
			eventManager.fireAnyModelChanged(model);	
		} catch(Exception e){
			if(tx != null){ try { tx.rollback(); }catch(Exception e1) {}}
			handleException(e);
		}
	}
	
	public boolean delete(T model){
		boolean deleted = false;

		EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			entityManager.remove(model);
		    tx.commit();
		} catch(Exception e){
			handleException(e);
		}

		Object result = entityManager.find(model.getClass(), model.getId());
		if(result == null){
			deleted = true;
		} else {
			try { tx.rollback(); }catch(Exception e1) {}
			entityManager.refresh(model);
		}

		eventManager.fireAnyModelChanged(model);

		return deleted;
	}

}