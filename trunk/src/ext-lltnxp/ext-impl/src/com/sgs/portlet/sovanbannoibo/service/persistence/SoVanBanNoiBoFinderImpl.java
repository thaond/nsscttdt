package com.sgs.portlet.sovanbannoibo.service.persistence;

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
import com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.impl.SoVanBanNoiBoImpl;

public class SoVanBanNoiBoFinderImpl extends BasePersistenceImpl implements SoVanBanNoiBoFinder{
	public static String COUNT_SO_VAN_BAN_NOI_BO = SoVanBanNoiBoFinder.class.getName()+ ".COUNT_SO_VAN_BAN_NOI_BO";
	public static String FIND_SO_VAN_BAN_NOI_BO = SoVanBanNoiBoFinder.class.getName()+ ".FIND_SO_VAN_BAN_NOI_BO";
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] maSoVanBanNoiBos = null;
		String[] tenSoVanBanNoiBos = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			maSoVanBanNoiBos = CustomSQLUtil.keywords(keywords);
			tenSoVanBanNoiBos = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return count_so_van_ban_noi_bo(maSoVanBanNoiBos, tenSoVanBanNoiBos, andOperator);

	}
	
	public int count_so_van_ban_noi_bo(String maSoVanBanNoiBos, String tenSoVanBanNoiBos, boolean andOperator) throws SystemException {
		return count_so_van_ban_noi_bo(new String[] { maSoVanBanNoiBos }, new String[] { tenSoVanBanNoiBos }, andOperator);

	}

	public int count_so_van_ban_noi_bo(String[] maSoVanBanNoiBos, String[] tenSoVanBanNoiBos, boolean andOperator) throws SystemException {
		maSoVanBanNoiBos = CustomSQLUtil.keywords(maSoVanBanNoiBos);
		tenSoVanBanNoiBos = CustomSQLUtil.keywords(tenSoVanBanNoiBos);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_SO_VAN_BAN_NOI_BO);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(masovanbannoibo)", StringPool.LIKE, false, maSoVanBanNoiBos);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(tensovanbannoibo)", StringPool.LIKE, true, tenSoVanBanNoiBos);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(maSoVanBanNoiBos, 2);
			qpos.add(tenSoVanBanNoiBos, 2);
			
			Iterator<Long> iter = q.list().iterator();
			if (iter.hasNext()) {
				Long count = iter.next();
				if (count != null) {
					return count.intValue();
				}
			}
			return 0;
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}
	}
	
	public List<SoVanBanNoiBo> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException {
		String[] maSoVanBanNoiBos = null;
		String[] tenSoVanBanNoiBos = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			maSoVanBanNoiBos = CustomSQLUtil.keywords(keywords);
			tenSoVanBanNoiBos = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return find_so_van_ban_noi_bo(maSoVanBanNoiBos, tenSoVanBanNoiBos, andOperator, start, end, obc);
	}
	
	public List<SoVanBanNoiBo> find_so_van_ban_noi_bo(String maSoVanBanNoiBos, String tenSoVanBanNoiBos, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_so_van_ban_noi_bo(new String[] { maSoVanBanNoiBos }, new String[] { tenSoVanBanNoiBos }, andOperator, start, end, obc);
	}

	public List<SoVanBanNoiBo> find_so_van_ban_noi_bo(String[] maSoVanBanNoiBos, String[] tenSoVanBanNoiBos, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		maSoVanBanNoiBos = CustomSQLUtil.keywords(maSoVanBanNoiBos);
		tenSoVanBanNoiBos = CustomSQLUtil.keywords(tenSoVanBanNoiBos);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_SO_VAN_BAN_NOI_BO);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(masovanbannoibo)", StringPool.LIKE, false, maSoVanBanNoiBos);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(tensovanbannoibo)", StringPool.LIKE, true, tenSoVanBanNoiBos);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_sovanbannoibo", SoVanBanNoiBoImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(maSoVanBanNoiBos, 2);
			qpos.add(tenSoVanBanNoiBos, 2);
			return (List<SoVanBanNoiBo>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
