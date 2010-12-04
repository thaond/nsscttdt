package com.nss.portlet.position.service.persistence;

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
import com.nss.portlet.position.model.Position;
import com.nss.portlet.position.model.impl.PositionImpl;

public class PositionFinderImpl extends BasePersistenceImpl implements PositionFinder{
	public static String FIND_BY_CODE_NAME_DESCRIPTION = PositionFinder.class.getName() + ".findBy_CODE_NAME_DESCRIPTION";
	public static String COUNT_BY_CODE_NAME_DESCRIPTION = PositionFinder.class.getName() + ".countBy_CODE_NAME_DESCRIPTION";
	
	/**
	 * tim kiem co ban
	 */
	public List<Position> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] code = null;
		String[] name = null;
		String[] description = null;
		
		boolean andOperator = false;
		
		if(Validator.isNotNull(keywords)){
			code = CustomSQLUtil.keywords(keywords, true);
			name = CustomSQLUtil.keywords(keywords, true);
			description = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findPosition(code, name, description, andOperator, start, end, obc);
	}

	/**
	 * tim kiem nang cao
	 */
	public List<Position> find_CODE_NAME_DESCRIPTION(String code, String name, String description, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findPosition(new String[]{code}, new String[]{name}, new String[]{description}, andOperator, start, end, obc);
	}

	/**
	 * cau sql cho phan tim kiem
	 */
	public List<Position> findPosition(String[] codes, String[] names, String[] descriptions, 
				boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		
		codes = CustomSQLUtil.keywords(codes, true);
		names = CustomSQLUtil.keywords(names, true);
		descriptions = CustomSQLUtil.keywords(descriptions, true);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = CustomSQLUtil.get(FIND_BY_CODE_NAME_DESCRIPTION);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(positioncode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(positionname)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, descriptions);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("pml_position", PositionImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(codes, 2);
			qpos.add(names, 2);
			qpos.add(descriptions, 2);
			 
			return (List<Position>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	/**
	 * ham dem so luong 
	 */
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] codes = null;
		String[] names = null;
		String[] description = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			codes = CustomSQLUtil.keywords(keywords, true);
			names = CustomSQLUtil.keywords(keywords, true);
			description = CustomSQLUtil.keywords(keywords, true);
		}
		else{
			andOperator = true;
		}
		return countTotalPosition (codes, names, description, andOperator);
	}
	

	public int count_CODE_NAME_DESCRIPTION(String code, String name, String description, boolean andOperator) throws SystemException{
		return countTotalPosition(new String[]{code}, new String[]{name}, new String[]{description}, andOperator);
	}
	
	/**
	 * cau sql cho ham dem total
	 */
	public int countTotalPosition(String[] codes, String[] names, String[] description, boolean andOperator) throws SystemException {
		
		codes = CustomSQLUtil.keywords(codes, true);
		names = CustomSQLUtil.keywords(names, true);
		description = CustomSQLUtil.keywords(description, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_CODE_NAME_DESCRIPTION);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(positioncode)", StringPool.LIKE, false, codes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(positionname)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(description)", StringPool.LIKE, true, description);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(codes, 2);
			qpos.add(names, 2);
			qpos.add(description, 2);
			
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
}
