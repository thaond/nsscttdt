package com.sgs.portlet.career.service.persistence;

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
import com.sgs.portlet.career.model.Career;
import com.sgs.portlet.career.model.impl.CareerImpl;

public class CareerFinderImpl extends BasePersistenceImpl implements CareerFinder{
	public static String FIND_BY_TEN_MA_NGHENGHIEP = CareerFinder.class.getName() + ".findBy_TEN_MA_NGHENGHIEP";
	public static String COUNT_BY_TEN_MA_NGHENGHIEP = CareerFinder.class.getName() + ".countBy_TEN_MA_NGHENGHIEP";
	
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
		
		return countByTEN_MA_NGHENGHIEP (codes, names,des, andOperator);
	}
	

	public int countByTEN_MA_NGHENGHIEP(String code, String name, String des, boolean andOperator) throws SystemException{
		return countByTEN_MA_NGHENGHIEP(new String[]{code}, new String[]{name}, new String[]{des}, andOperator);
	}
	
	public int countByTEN_MA_NGHENGHIEP(String[] codes,String[] names, String[] des,boolean andOperator) throws SystemException {
		
		codes = CustomSQLUtil.keywords(codes);
		names = CustomSQLUtil.keywords(names);
		des = CustomSQLUtil.keywords(des);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(COUNT_BY_TEN_MA_NGHENGHIEP);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(careercode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(careername)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, des);
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
	
	public List<Career> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] codes = null;
		String[] names = null;
		String[] des = null;
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			codes = CustomSQLUtil.keywords(keywords);
			names = CustomSQLUtil.keywords(keywords);
			des = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}
		
		return findTEN_MA_NGHENGHIEP(codes, names,des, andOperator, start, end, obc);
	}

	public List<Career> findTEN_MA_NGHENGHIEP(String code, String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findTEN_MA_NGHENGHIEP(new String[]{code},new String[]{name}, new String[]{des}, andOperator, start, end, obc);
	}

	public List<Career> findTEN_MA_NGHENGHIEP(String[] codes, String[] names,String[] des,boolean andOperator,
			int start, int end, OrderByComparator obc) throws SystemException {
		
		codes = CustomSQLUtil.keywords(codes);
		names = CustomSQLUtil.keywords(names);
		des = CustomSQLUtil.keywords(des);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_BY_TEN_MA_NGHENGHIEP);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(careercode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(careername)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, des);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_career", CareerImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(codes,2);
			qpos.add(names,2);
			qpos.add(des,2);
			 
			return (List<Career>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
}
