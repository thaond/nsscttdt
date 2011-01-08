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
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.model.impl.PmlEdmPrivilegeLevelImpl;

public class PmlEdmPrivilegeLevelFinderImpl extends BasePersistenceImpl implements PmlEdmPrivilegeLevelFinder{

	// minh 20100206
	public static String COUNT_BY_PMLEDMPRIVILEGELEVEL = PmlEdmPrivilegeLevelFinder.class.getName() + ".countByPmlEdmPrivilegeLevel";
	public static String FIND_BY_PMLEDMPRIVILEGELEVEL = PmlEdmPrivilegeLevelFinder.class.getName()+ ".findByPmlEdmPrivilegeLevel";
	
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] pmlEdmPrivilegeLevelNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmPrivilegeLevelNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByPmlEdmPrivilegeLevel(pmlEdmPrivilegeLevelNames, andOperator);
	}

	
	
	public int countByPmlEdmPrivilegeLevel(String[] pmlEdmPrivilegeLevelNames, 
			boolean andOperator) throws SystemException {
		pmlEdmPrivilegeLevelNames = CustomSQLUtil.keywords(pmlEdmPrivilegeLevelNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_PMLEDMPRIVILEGELEVEL);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(privilegelevelname)", StringPool.LIKE, true, pmlEdmPrivilegeLevelNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmPrivilegeLevelNames, 2);
			
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
	
	public List<PmlEdmPrivilegeLevel> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] pmlEdmPrivilegeLevelNames = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			pmlEdmPrivilegeLevelNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findByPmlEdmPrivilegeLevel(pmlEdmPrivilegeLevelNames, andOperator, start, end, obc);
	}

	
	public List<PmlEdmPrivilegeLevel> findByPmlEdmPrivilegeLevel(String[] pmlEdmPrivilegeLevelNames,
			boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		pmlEdmPrivilegeLevelNames = CustomSQLUtil.keywords(pmlEdmPrivilegeLevelNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_PMLEDMPRIVILEGELEVEL);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(privilegelevelname)", StringPool.LIKE, true, pmlEdmPrivilegeLevelNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_privilegelevel", PmlEdmPrivilegeLevelImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(pmlEdmPrivilegeLevelNames,2);
			
			return (List<PmlEdmPrivilegeLevel>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// end
}
