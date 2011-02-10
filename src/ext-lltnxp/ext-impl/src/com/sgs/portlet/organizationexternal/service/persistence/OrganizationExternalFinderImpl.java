package com.sgs.portlet.organizationexternal.service.persistence;

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
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.model.impl.OrganizationExternalImpl;

public class OrganizationExternalFinderImpl extends BasePersistenceImpl implements OrganizationExternalFinder {
	
	public static String FIND_DON_VI_LIEN_THONG = OrganizationExternalFinder.class.getName() + ".findDonViLienThong";
	public static String COUNT_DON_VI_LIEN_THONG = OrganizationExternalFinder.class.getName() + ".countDonViLienThong";
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] codes = null;
		String[] names = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)) {
			codes = CustomSQLUtil.keywords(keywords);
			names = CustomSQLUtil.keywords(keywords);
		}
		else {
			andOperator = true;
		}
		return countByTEN_MA_DONVILIENTHONG(codes, names, andOperator);
	}

	public int countByTEN_MA_DONVILIENTHONG(String code, String name, boolean andOperator) throws SystemException {
		
		return countByTEN_MA_DONVILIENTHONG(new String[]{code}, new String[]{name}, andOperator);
	}
	
	public int countByTEN_MA_DONVILIENTHONG(String[] codes,String[] names, boolean andOperator) throws SystemException {
		
		codes = CustomSQLUtil.keywords(codes);
		names = CustomSQLUtil.keywords(names);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(COUNT_DON_VI_LIEN_THONG);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(orgexternalcode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(orgexternalname)", StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(codes, 2);
			qpos.add(names, 2);
			
			Iterator<Long> iter = q.list().iterator();
			
			if (iter.hasNext()) {
				Long count = iter.next();
				if( count!= null) {
					return count.intValue();
				}
			}

			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public List<OrganizationExternal> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException {
		String[] codes = null;
		String[] names = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			codes = CustomSQLUtil.keywords(keywords);
			names = CustomSQLUtil.keywords(keywords);
		}
		else {
			andOperator = true;
		}
		
		return findTEN_MA_DONVILIENTHONG(codes, names, andOperator, start, end, obc);
	}

	public List<OrganizationExternal> findTEN_MA_DONVILIENTHONG(String code, String name, boolean andOperator, 
								int start, int end, OrderByComparator obc) throws SystemException {
		
		return findTEN_MA_DONVILIENTHONG(new String[]{code}, new String[]{name}, andOperator, start, end, obc);
	}

	public List<OrganizationExternal> findTEN_MA_DONVILIENTHONG(String[] codes, String[] names, boolean andOperator,
								int start, int end, OrderByComparator obc) throws SystemException {
		
		codes = CustomSQLUtil.keywords(codes);
		names = CustomSQLUtil.keywords(names);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_DON_VI_LIEN_THONG);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(orgexternalcode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(orgexternalname)", StringPool.LIKE, true, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_organization_external", OrganizationExternalImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(codes, 2);
			qpos.add(names, 2);
			 
			return (List<OrganizationExternal>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
}
