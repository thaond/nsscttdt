package com.sgs.portlet.districtmanagement.service.persistence;

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
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.model.impl.DistrictImpl;

public class DistrictFinderImpl extends BasePersistenceImpl implements DistrictFinder{
	public static String FIND_BY_TEN_MA_MOTA_QUAN = DistrictFinder.class.getName() + ".findBy_TEN_MA_MOTA_QUAN";
	public static String COUNT_BY_TEN_MA_MOTA_QUAN = DistrictFinder.class.getName() + ".countBy_TEN_MA_MOTA_QUAN";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] codes = null;
		String[] names = null;
		String[] des = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			codes = CustomSQLUtil.keywords(keywords);
			names = CustomSQLUtil.keywords(keywords);
			des = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return countByTEN_MA_MOTA_QUAN(codes,names, des,andOperator);
	}

	public int countByTEN_MA_MOTA_QUAN(String code, String name,	String des, boolean andOperator) throws SystemException {
		return countByTEN_MA_MOTA_QUAN(new String[]{code}, new String[]{name}, new String[]{des}, andOperator);
	}
	
	public int countByTEN_MA_MOTA_QUAN(String[] codes, String[] names,
			String[] des, boolean andOperator) throws SystemException {
		
		codes = CustomSQLUtil.keywords(codes);
		names = CustomSQLUtil.keywords(names);
		des = CustomSQLUtil.keywords(des);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(COUNT_BY_TEN_MA_MOTA_QUAN);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_district.districtcode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_district.districtname)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_district.description)", StringPool.LIKE, true, des);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(codes,2);
			qpos.add(names,2);
			qpos.add(des,2);
			
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
	
	
	public List<District> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] codes = null;
		String[] names = null;
		String[] des = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			codes = CustomSQLUtil.keywords(keywords);
			names = CustomSQLUtil.keywords(keywords);
			des = CustomSQLUtil.keywords(keywords);
		}else{
			andOperator = true;
		}
		
		return findTEN_MA_MOTA_QUAN (codes, names,des,andOperator, start, end, obc);
	}
	
	public List<District> findTEN_MA_MOTA_QUAN(String code,
			String name, String des, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException{
		return findTEN_MA_MOTA_QUAN(new String[]{code},new String[]{name}, new String[]{des}, andOperator, start, end, obc);
	}
	public List<District> findTEN_MA_MOTA_QUAN(String[] codes,
			String[] names, String[] des, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException{
		codes = CustomSQLUtil.keywords(codes);
		names = CustomSQLUtil.keywords(names);
		des = CustomSQLUtil.keywords(des);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_BY_TEN_MA_MOTA_QUAN);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_district.districtcode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_district.districtname)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(pml_district.description)", StringPool.LIKE, true, des);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_district", DistrictImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(codes,2);
			qpos.add(names,2);
			qpos.add(des,2);
			 
			return (List<District>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public int countDistrictByCityId(String cityId) throws SystemException{
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM pml_district ";
			sql += " WHERE pml_district.cityid LIKE '"+ cityId +"' ";
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
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
	
	public List<District> findDistrictByCityId(String cityId, int start, int end) throws SystemException {
		Session session = null;
		try {
			session = openSession();
			
			String sql = "SELECT pml_district.* ";
			sql += " FROM pml_district ";
			sql += " WHERE pml_district.cityid LIKE '"+ cityId +"' ";
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_district", DistrictImpl.class);
			 
			return (List<District>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}

}
