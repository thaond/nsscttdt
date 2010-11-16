package com.nss.portlet.van_ban_phap_quy.service.persistence;

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
import com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy;
import com.nss.portlet.van_ban_phap_quy.model.impl.VanBanPhapQuyImpl;

public class VanBanPhapQuyFinderImpl extends BasePersistenceImpl implements VanBanPhapQuyFinder{

// minh 20100204
	public static String COUNT_BY_VANBANPHAPQUY = VanBanPhapQuyFinder.class.getName() + ".countByVanBanPhapQuy";
	public static String FIND_BY_VANBANPHAPQUY = VanBanPhapQuyFinder.class.getName()+ ".findByVanBanPhapQuy";
	
	public int countByKeywords(String keywords) throws SystemException{
		String[] kyHieuVanBans = null;
	
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			kyHieuVanBans = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countByVanBanPhapQuy(kyHieuVanBans, andOperator);
	}
	
	public int countByVanBanPhapQuy(String kyHieuVanBan, boolean andOperator) throws SystemException{
		return countByVanBanPhapQuy(new String[]{kyHieuVanBan}, andOperator);
	}
	
	
	public int countByVanBanPhapQuy(String[] kyHieuVanBans, boolean andOperator) throws SystemException {
		kyHieuVanBans = CustomSQLUtil.keywords(kyHieuVanBans, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_BY_VANBANPHAPQUY);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_van_ban_phap_quy.ky_hieu_van_ban)", StringPool.LIKE, true, kyHieuVanBans);			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(kyHieuVanBans, 2);
			
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
	
	
	public List<VanBanPhapQuy> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		String[] kyHieuVanBans = null;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			kyHieuVanBans = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findByVanBanPhapQuy(kyHieuVanBans, andOperator, start, end, obc);
	}

	public List<VanBanPhapQuy> findByVanBanPhapQuy(String kyHieuVanBan, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return findByVanBanPhapQuy(new String[]{kyHieuVanBan}, andOperator, start, end, obc);
	}
	
	public List<VanBanPhapQuy> findByVanBanPhapQuy(String[] kyHieuVanBans, boolean andOperator, int start, int end,
			OrderByComparator obc) throws SystemException {
		
		kyHieuVanBans = CustomSQLUtil.keywords(kyHieuVanBans, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_BY_VANBANPHAPQUY);
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_van_ban_phap_quy.ky_hieu_van_ban)", StringPool.LIKE, true, kyHieuVanBans);			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("nss_van_ban_phap_quy", VanBanPhapQuyImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(kyHieuVanBans,2);
			
			return (List<VanBanPhapQuy>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	// end 
}
