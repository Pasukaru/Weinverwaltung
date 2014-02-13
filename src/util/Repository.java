package util;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	protected static Session session = null;
	protected static EventManager eventManager;
	
	private static HashMap<Class<? extends Model>, Repository<? extends Model>> instances;
	
	protected Repository(Class<T> model){
		this.model = model;
	}
	
	public static void init(String pu, EventManager eventManager){
		JpaUtil.init(pu);
		EntityManager entityManager = JpaUtil.getEM();
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
	
	public static EventManager getEventManager(){
		return eventManager;
	}
	
	public static <T extends Model> Repository<T> getInstance(Class<T> model){
		return (Repository<T>) instances.get(model);
	}
	
	public Criteria getSearchCriteria(String query){
		return session.createCriteria(model).add(Restrictions.like("name", "%"+query+"%"));
	}
	
	public List<T> getAll(Criteria criteria){
		if(criteria == null){
			criteria = session.createCriteria(model);
		}
		return criteria.list();
	}
	
	public List<T> getAll(){
		return getAll(null);
	}
	
	public T getById(Integer id){
		return (T) session.get(model, id);
	}

	public void update(T model){
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(model);
			session.update(model);
			tx.commit();
			eventManager.fireAnyModelChanged(model);	
		} catch(RuntimeException e){
			if(tx != null){
				tx.rollback();
			}
			throw e;
		}
	}
	
	public List<T> search(String query){
		return getSearchCriteria(query).list();
	}
	
	public boolean delete(Integer id){
		boolean deleted = false;
		
		T model = getById(id);
		
	    session.delete(model);
		Object result = session.get(model.getClass(), model.getId());
		if(result == null){
			eventManager.fireAnyModelChanged(model);
			deleted = true;
		}
		return deleted;
	}
}