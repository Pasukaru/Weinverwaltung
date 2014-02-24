package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
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

		Expression<String> path = root.get("name");
		conditions.add(cb.like(path, query));

        List<Join<Object, Object>> joins = new ArrayList<Join<Object, Object>>();

		Join<Object, Object> city = root.join("city");
		Join<Object, Object> region = city.join("region");
		Join<Object, Object> country = region.join("country");

		joins.add(city);
		joins.add(region);
		joins.add(country);
		joins.add(root.join("winery"));
		joins.add(root.join("type"));
		joins.add(root.join("sort"));
		joins.add(root.join("vine"));

		for(Join<Object, Object> join : joins){
			path = join.get("name");
			conditions.add(cb.like(path, query));
		}

		cq.distinct(true);
		cq.where(cb.or(conditions.toArray(new Predicate[conditions.size()])));

		return entityManager.createQuery(cq).getResultList();
	}
}
