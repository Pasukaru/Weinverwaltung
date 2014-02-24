package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import model.Wine;

public class WineRepository extends Repository<Wine>{

	public WineRepository() {
		super(Wine.class);
	}
	
	@Override
	public List<Wine> search(String query) {
		query = "%"+query+"%";

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Wine> cq = cb.createQuery(model);
        Root<Wine> root = cq.from(Wine.class);
		
        List<Predicate> conditions = new ArrayList<Predicate>();
		
		String[] joins = {"winery", "type", "sort", "city", "vine"};
		
		for(String join : joins){
			Expression<String> path = root.join(join).get("name");
			conditions.add(cb.like(path, query));
		}

		Expression<String> regionPath = root.join("city").join("region").get("name");
		conditions.add(cb.like(regionPath, query));
		Expression<String> countryPath = root.join("city").join("region").join("country").get("name");
		conditions.add(cb.like(countryPath, query));
		
		cq.distinct(true);
		cq.where(cb.or(conditions.toArray(new Predicate[conditions.size()])));
		
		return entityManager.createQuery(cq).getResultList();
	}
}
