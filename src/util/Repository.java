package util;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
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
	
	public static void init(EventManager em){
		
		if(session == null){
			EntityManager entityManager = JpaUtil.getEM();
			session = (Session) entityManager.getDelegate();
			eventManager = em;
			instances = new HashMap<Class<? extends Model>, Repository<? extends Model>>();
			instances.put(City.class, new Repository<City>(City.class));
			instances.put(Country.class, new Repository<Country>(Country.class));
			instances.put(Region.class, new Repository<Region>(Region.class));
			instances.put(Sort.class, new Repository<Sort>(Sort.class));
			instances.put(Type.class, new Repository<Type>(Type.class));
			instances.put(Vine.class, new Repository<Vine>(Vine.class));
			instances.put(Wine.class, new WineRepository());
			instances.put(Winery.class, new Repository<Winery>(Winery.class));
		} else {
			throw new RuntimeException("Repository is already initialized!");
		}
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
		session.persist(model);
		session.update(model);
		session.flush();
		eventManager.fireAnyModelChanged(model);
	}
	
	public List<T> search(String query){
		return getSearchCriteria(query).list();
	}
	
	public boolean delete(Integer id){
		boolean deleted = false;
		
		T model = getById(id);
		
	    session.delete(model);
		session.flush();
		Object result = session.get(model.getClass(), model.getId());
		if(result == null){
			eventManager.fireAnyModelChanged(model);
			deleted = true;
		}
		return deleted;
	}
}