package com.nss.portlet.link.service.persistence;

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
import com.nss.portlet.link.model.LoaiWebsite;
import com.nss.portlet.link.model.impl.LoaiWebsiteImpl;

public class LoaiWebsiteFinderImpl extends BasePersistenceImpl implements LoaiWebsiteFinder{
	public static String FIND_BY_TEN_MOTA_LOAI = LoaiWebsiteFinder.class.getName() + ".findBy_TEN_MOTA_LOAI";
	public static String COUNT_BY_TEN_MOTA_LOAI = LoaiWebsiteFinder.class.getName() + ".countBy_TEN_MOTA_LOAI";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] names = null;
		String[] des = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			names = CustomSQLUtil.keywords(keywords, true);
			des = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByTEN_MOTA(names, des, andOperator);
	}

	public int countByTEN_MOTA(String name, String des, boolean andOperator) throws SystemException{
		return countByTEN_MOTA(new String[]{name}, new String[]{des}, andOperator);
	}
	
	public int countByTEN_MOTA(String[] names, String[] des,
			boolean andOperator) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		des = CustomSQLUtil.keywords(des, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_TEN_MOTA_LOAI);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ten_loai_website)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(mo_ta_loai_website)", StringPool.LIKE, true, des);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(names,2);
			qpos.add(des,2);
			
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
	
	public List<LoaiWebsite> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] names = null;
		String[] des = null;
		
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			names = CustomSQLUtil.keywords(keywords, true);
			des = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		return findTEN_MOTA (names, des, andOperator, start, end, obc);
	}

	public List<LoaiWebsite> findTEN_MOTA(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findTEN_MOTA(new String[]{name}, new String[]{des}, andOperator, start, end, obc);
	}

	public List<LoaiWebsite> findTEN_MOTA(String[] names, String[] des,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		des = CustomSQLUtil.keywords(des, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_TEN_MOTA_LOAI);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(ten_loai_website)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(mo_ta_loai_website)", StringPool.LIKE, true, des);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("nss_loai_website", LoaiWebsiteImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(names,2);
			qpos.add(des,2);
			 
			return (List<LoaiWebsite>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
