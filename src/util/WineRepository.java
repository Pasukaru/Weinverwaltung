package util;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

import model.Wine;

public class WineRepository extends Repository<Wine>{

	public WineRepository() {
		super(Wine.class);
	}
	
	public Criteria getSearchCriteria(String queryString){
		queryString = "%"+queryString+"%";

		Criteria criteria = session.createCriteria(model);
		Disjunction or = Restrictions.or(Restrictions.like("name", queryString));

		String[] joins = {"winery", "type", "sort", "city", "vine"};
		
		for(String alias : joins){
			criteria.createAlias(alias, alias);
			or.add(Restrictions.like(alias+"."+"name", queryString));
		}

		criteria.createAlias("city.region", "region");
		or.add(Restrictions.like("region.name", queryString));
		criteria.createAlias("region.country", "country");
		or.add(Restrictions.like("country.name", queryString));
		
		criteria.add(or);

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return criteria;
	}
}
