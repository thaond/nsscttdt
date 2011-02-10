package com.sgs.portlet.citymanagement.service.persistence;

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
import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.model.impl.CityImpl;

public class CityFinderImpl extends BasePersistenceImpl implements CityFinder{
	public static String FIND_BY_TEN_MA_THANH_PHO = CityFinder.class.getName() + ".findBy_TEN_MA_THANH_PHO";
	public static String COUNT_BY_TEN_MA_THANH_PHO = CityFinder.class.getName() + ".countBy_TEN_MA_THANH_PHO";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] cityCodes = null;
		String[] cityNames = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			cityCodes = CustomSQLUtil.keywords(keywords);
			cityNames = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return countByTEN_MA_THANH_PHO (cityCodes, cityNames, andOperator);
	}
	
	
	public int countByTEN_MA_THANH_PHO(String cityCode, String cityName, boolean andOperator) throws SystemException {
		return countByTEN_MA_THANH_PHO(new String[]{cityCode}, new String[]{cityName}, andOperator);
	}

	public int countByTEN_MA_THANH_PHO(String[] cityCodes, String[] cityNames, boolean andOperator) throws SystemException{
		cityCodes = CustomSQLUtil.keywords(cityCodes);
		cityNames = CustomSQLUtil.keywords(cityNames);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(COUNT_BY_TEN_MA_THANH_PHO);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_city.citycode)", StringPool.LIKE, false, cityCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_city.cityname)", StringPool.LIKE, true, cityNames);
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(cityCodes,2);
			qpos.add(cityNames,2);
			
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
		finally{
			closeSession(session);
		}
	}
	
	public List<City> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] cityCodes = null;
		String[] cityNames = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			cityCodes = CustomSQLUtil.keywords(keywords);
			cityNames = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return findByTEN_MA_THANH_PHO (cityCodes, cityNames, andOperator, start, end, obc);
	}
	
	
	public List<City> findByTEN_MA_THANH_PHO(String cityCode, String cityName, boolean andOperator,int start, int end, OrderByComparator obc) throws SystemException {
		return findByTEN_MA_THANH_PHO(new String[]{cityCode}, new String[]{cityName}, andOperator, start, end, obc);
	}
	
	
	public List<City> findByTEN_MA_THANH_PHO(String[] cityCodes, String[] cityNames, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		cityCodes = CustomSQLUtil.keywords(cityCodes);
		cityNames = CustomSQLUtil.keywords(cityNames);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_BY_TEN_MA_THANH_PHO);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_city.citycode)", StringPool.LIKE, false, cityCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_city.cityname)", StringPool.LIKE, true, cityNames);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_city", CityImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(cityCodes,2);
			qpos.add(cityNames,2);
			
			return (List<City>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}

}
