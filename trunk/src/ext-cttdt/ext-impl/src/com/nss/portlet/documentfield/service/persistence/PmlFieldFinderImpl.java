package com.nss.portlet.documentfield.service.persistence;

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
import com.nss.portlet.documentfield.model.PmlField;
import com.nss.portlet.documentfield.model.impl.PmlFieldImpl;

public class PmlFieldFinderImpl extends BasePersistenceImpl implements PmlFieldFinder{
	public static String COUNT_BY_FIELD = PmlFieldFinder.class.getName() + ".countByField";
	public static String FIND_BY_FIELD = PmlFieldFinder.class.getName()+ ".findByField";
	
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] fieldCodes = null;
		String[] fieldNames = null;		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			fieldCodes = CustomSQLUtil.keywords(keywords, true);
			fieldNames = CustomSQLUtil.keywords(keywords, true);		
		}else{
			andOperator = true;
		}
		
		return countByField(fieldCodes, fieldNames, andOperator);
	}
	public int countByField(String fieldCode, String fieldName, boolean andOperator) throws SystemException{
		return countByField(new String[]{fieldCode}, new String[]{fieldName}, andOperator);
	}
	
	
	public int countByField(String[] fieldCodes, String[] fieldNames,
			boolean andOperator) throws SystemException {
		fieldCodes = CustomSQLUtil.keywords(fieldCodes, true);
		fieldNames = CustomSQLUtil.keywords(fieldNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_FIELD);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_field.fieldcode)", StringPool.LIKE, false, fieldCodes);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_field.fieldname)", StringPool.LIKE, true, fieldNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fieldCodes, 2);
			qpos.add(fieldNames, 2);
			
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
	
	public List<PmlField> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] fieldCodes = null;
		String[] fieldNames = null;		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			fieldCodes = CustomSQLUtil.keywords(keywords, true);
			fieldNames = CustomSQLUtil.keywords(keywords, true);		
		}else{
			andOperator = true;
		}
		
		return findByField(fieldCodes, fieldNames, andOperator, start, end, obc);
	}

	public List<PmlField> findByField(String fieldCode, String fieldName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByField(new String[]{fieldCode}, new String[]{fieldName}, andOperator, start, end, obc);
	}
	
	public List<PmlField> findByField(String[] fieldCodes, String[] fieldNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		fieldCodes = CustomSQLUtil.keywords(fieldCodes, true);
		fieldNames = CustomSQLUtil.keywords(fieldNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_FIELD);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_field.fieldcode)", StringPool.LIKE, false, fieldCodes);			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_field.fieldname)", StringPool.LIKE, true, fieldNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_field", PmlFieldImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(fieldCodes,2);
			qpos.add(fieldNames,2);
			
			return (List<PmlField>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
