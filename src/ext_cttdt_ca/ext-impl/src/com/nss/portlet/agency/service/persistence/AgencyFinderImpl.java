package com.nss.portlet.agency.service.persistence;

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
import com.nss.portlet.agency.model.Agency;
import com.nss.portlet.agency.model.impl.AgencyImpl;

public class AgencyFinderImpl extends BasePersistenceImpl implements AgencyFinder{
	public static String FIND_BY_TEN_MA_COQUAN = AgencyFinder.class.getName() + ".findBy_TEN_MA_COQUAN";
	public static String COUNT_BY_TEN_MA_COQUAN = AgencyFinder.class.getName() + ".countBy_TEN_MA_COQUAN";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] leaderLastNames = null;
		String[] leaderFirstNames = null;
		String[] agencyCodes = null;
		String[] agencyNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			leaderLastNames = CustomSQLUtil.keywords(keywords, true);
			leaderFirstNames = CustomSQLUtil.keywords(keywords, true);
			agencyCodes = CustomSQLUtil.keywords(keywords, true);
			agencyNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByTEN_MA_COQUAN (leaderLastNames,leaderFirstNames, agencyCodes,agencyNames,andOperator);
	}
	

	public int countByTEN_MA_COQUAN(String leaderLastNames, String leaderFirstNames, String agencyCode, String agencyName, boolean andOperator) throws SystemException{
		return countByTEN_MA_COQUAN(new String[]{leaderLastNames}, new String[]{leaderFirstNames}, new String[]{agencyCode}, new String[]{agencyName}, andOperator);
	}
	
	public int countByTEN_MA_COQUAN(String[] leaderLastNames,String[] leaderFirstNames,
			String[] agencyCodes, String[] agencyNames, boolean andOperator) throws SystemException {
		
		leaderLastNames = CustomSQLUtil.keywords(leaderLastNames, true);
		leaderFirstNames = CustomSQLUtil.keywords(leaderFirstNames, true);
		agencyCodes = CustomSQLUtil.keywords(agencyCodes, true);
		agencyNames = CustomSQLUtil.keywords(agencyNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_TEN_MA_COQUAN);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(user_.lastname)", StringPool.LIKE, false, leaderLastNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(user_.firstname)", StringPool.LIKE, false, leaderFirstNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_agency.agencycode)", StringPool.LIKE, false, agencyCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_agency.agencyname)", StringPool.LIKE, true, agencyNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(leaderLastNames,2);
			qpos.add(leaderFirstNames,2);
			qpos.add(agencyCodes,2);
			qpos.add(agencyNames,2);
			
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
	
	public List<Agency> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] leaderLastNames = null;
		String[] leaderFirstNames = null;
		String[] agencyCodes = null;
		String[] agencyNames = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			leaderLastNames = CustomSQLUtil.keywords(keywords, true);
			leaderFirstNames = CustomSQLUtil.keywords(keywords, true);
			agencyCodes = CustomSQLUtil.keywords(keywords, true);
			agencyNames = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findTEN_MA_COQUAN (leaderLastNames, leaderFirstNames,agencyCodes,agencyNames,andOperator, start, end, obc);
	}

	public List<Agency> findTEN_MA_COQUAN(String leaderLastNames, String leaderFirstNames,String agencyCode, String agencyName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findTEN_MA_COQUAN(new String[]{leaderLastNames},new String[]{leaderFirstNames}, new String[]{agencyCode}, new String[]{agencyName}, andOperator, start, end, obc);
	}

	public List<Agency> findTEN_MA_COQUAN(String[] leaderLastNames, String[] leaderFirstNames,
			String[] agencyCodes, String[] agencyNames, boolean andOperator,
			int start, int end, OrderByComparator obc) throws SystemException {
		
		leaderLastNames = CustomSQLUtil.keywords(leaderLastNames, true);
		leaderFirstNames = CustomSQLUtil.keywords(leaderFirstNames, true);
		agencyCodes = CustomSQLUtil.keywords(agencyCodes, true);
		agencyNames = CustomSQLUtil.keywords(agencyNames, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_TEN_MA_COQUAN);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(user_.lastname)", StringPool.LIKE, false, leaderLastNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(user_.firstname)", StringPool.LIKE, false, leaderFirstNames);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_agency.agencycode)", StringPool.LIKE, false, agencyCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_agency.agencyname)", StringPool.LIKE, true, agencyNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_agency", AgencyImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(leaderLastNames,2);
			qpos.add(leaderFirstNames,2);
			qpos.add(agencyCodes,2);
			qpos.add(agencyNames,2);
			 
			return (List<Agency>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
}
