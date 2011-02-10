package com.sgs.portlet.document.receipt.service.persistence;

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
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmConfidentialLevelImpl;

public class PmlEdmConfidentialLevelFinderImpl extends BasePersistenceImpl implements PmlEdmConfidentialLevelFinder {
	// minh 20100206
	public static String COUNT_BY_PMLEDMCONFIDENTIALLEVEL = PmlEdmConfidentialLevelFinder.class.getName() + ".countByPmlEdmConfidentialLevel";
	public static String FIND_BY_PMLEDMCONFIDENTIALLEVEL = PmlEdmConfidentialLevelFinder.class.getName()+ ".findByPmlEdmConfidentialLevel";
	
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] pmlEdmConfidentialLevelNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmConfidentialLevelNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByPmlEdmConfidentialLevel(pmlEdmConfidentialLevelNames, andOperator);
	}

	
	
	public int countByPmlEdmConfidentialLevel(String[] pmlEdmConfidentialLevelNames, 
			boolean andOperator) throws SystemException {
		pmlEdmConfidentialLevelNames = CustomSQLUtil.keywords(pmlEdmConfidentialLevelNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PMLEDMCONFIDENTIALLEVEL);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(confidentiallevelname)", StringPool.LIKE, true, pmlEdmConfidentialLevelNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmConfidentialLevelNames, 2);
			
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
	
	public List<PmlEdmConfidentialLevel> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] pmlEdmConfidentialLevelNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmConfidentialLevelNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findByPmlEdmConfidentialLevel(pmlEdmConfidentialLevelNames, andOperator, start, end, obc);
	}

	
	public List<PmlEdmConfidentialLevel> findByPmlEdmConfidentialLevel(String[] pmlEdmConfidentialLevelNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		pmlEdmConfidentialLevelNames = CustomSQLUtil.keywords(pmlEdmConfidentialLevelNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PMLEDMCONFIDENTIALLEVEL);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(confidentiallevelname)", StringPool.LIKE, true, pmlEdmConfidentialLevelNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
		
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_confidentiallevel", PmlEdmConfidentialLevelImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmConfidentialLevelNames,2);
			
			return (List<PmlEdmConfidentialLevel>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// end
}
