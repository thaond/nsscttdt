package com.sgs.portlet.pmlstreet.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.pmlstreet.model.PmlStreet;
import com.sgs.portlet.pmlstreet.model.impl.PmlStreetImpl;

public class PmlStreetFinderImpl extends BasePersistenceImpl implements PmlStreetFinder {
	public static String FIND_BY_TEN_DUONG = PmlStreetFinder.class.getName() + ".findBy_TEN_DUONG";
	public static String COUNT_BY_TEN_DUONG = PmlStreetFinder.class.getName() + ".countBy_TEN_DUONG";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] names = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			names = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByPmlEdmConfidentialLevel(names, andOperator);
	}

	
	
	public int countByPmlEdmConfidentialLevel(String[] names, 
			boolean andOperator) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_TEN_DUONG);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(streetname)", StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(names, 2);
			
			Iterator<Long> iter = q.list().iterator();
			if(iter.hasNext()){
				Long count = iter.next();
				if(count!= null){
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public List<PmlStreet> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] names = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			names = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findByPmlEdmConfidentialLevel(names, andOperator, start, end, obc);
	}

	
	public List<PmlStreet> findByPmlEdmConfidentialLevel(String[] names,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_TEN_DUONG);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(streetname)", StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
		
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_street", PmlStreetImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(names,2);
			
			return (List<PmlStreet>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
