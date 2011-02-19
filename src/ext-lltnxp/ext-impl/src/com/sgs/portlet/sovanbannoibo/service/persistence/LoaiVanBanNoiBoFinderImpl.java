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
import com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.impl.LoaiVanBanNoiBoImpl;

public class LoaiVanBanNoiBoFinderImpl extends BasePersistenceImpl implements LoaiVanBanNoiBoFinder{
	public static String COUNT_LOAI_VAN_BAN_NOI_BO = LoaiVanBanNoiBoFinder.class.getName()+ ".COUNT_LOAI_VAN_BAN_NOI_BO";
	public static String FIND_LOAI_VAN_BAN_NOI_BO = LoaiVanBanNoiBoFinder.class.getName()+ ".FIND_LOAI_VAN_BAN_NOI_BO";
	
	public int countByKeywords(String keywords) throws SystemException {
		String[] kyHieuLoaiVanBanNoiBos = null;
		String[] tenLoaiVanBanNoiBos = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			kyHieuLoaiVanBanNoiBos = CustomSQLUtil.keywords(keywords);
			tenLoaiVanBanNoiBos = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return count_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos, tenLoaiVanBanNoiBos, andOperator);

	}
	
	public int count_loai_van_ban_noi_bo(String kyHieuLoaiVanBanNoiBos, String tenLoaiVanBanNoiBos, boolean andOperator) throws SystemException {
		return count_loai_van_ban_noi_bo(new String[] { kyHieuLoaiVanBanNoiBos }, new String[] { tenLoaiVanBanNoiBos }, andOperator);

	}

	public int count_loai_van_ban_noi_bo(String[] kyHieuLoaiVanBanNoiBos, String[] tenLoaiVanBanNoiBos, boolean andOperator) throws SystemException {
		kyHieuLoaiVanBanNoiBos = CustomSQLUtil.keywords(kyHieuLoaiVanBanNoiBos);
		tenLoaiVanBanNoiBos = CustomSQLUtil.keywords(tenLoaiVanBanNoiBos);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_LOAI_VAN_BAN_NOI_BO);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(kyhieuloaivanbannoibo)", StringPool.LIKE, false, kyHieuLoaiVanBanNoiBos);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(tenloaivanbannoibo)", StringPool.LIKE, true, tenLoaiVanBanNoiBos);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(kyHieuLoaiVanBanNoiBos, 2);
			qpos.add(tenLoaiVanBanNoiBos, 2);
			
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
	
	public List<LoaiVanBanNoiBo> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException {
		String[] kyHieuLoaiVanBanNoiBos = null;
		String[] tenLoaiVanBanNoiBos = null;

		boolean andOperator = false;
		if (Validator.isNotNull(keywords)) {
			kyHieuLoaiVanBanNoiBos = CustomSQLUtil.keywords(keywords);
			tenLoaiVanBanNoiBos = CustomSQLUtil.keywords(keywords);
		} else {
			andOperator = true;
		}

		return find_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos, tenLoaiVanBanNoiBos, andOperator, start, end, obc);
	}
	
	public List<LoaiVanBanNoiBo> find_loai_van_ban_noi_bo(String kyHieuLoaiVanBanNoiBos, String tenLoaiVanBanNoiBos, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_loai_van_ban_noi_bo(new String[] { kyHieuLoaiVanBanNoiBos }, new String[] { tenLoaiVanBanNoiBos }, andOperator, start, end, obc);
	}

	public List<LoaiVanBanNoiBo> find_loai_van_ban_noi_bo(String[] kyHieuLoaiVanBanNoiBos, String[] tenLoaiVanBanNoiBos, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		kyHieuLoaiVanBanNoiBos = CustomSQLUtil.keywords(kyHieuLoaiVanBanNoiBos);
		tenLoaiVanBanNoiBos = CustomSQLUtil.keywords(tenLoaiVanBanNoiBos);
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_LOAI_VAN_BAN_NOI_BO);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(kyhieuloaivanbannoibo)", StringPool.LIKE, false, kyHieuLoaiVanBanNoiBos);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(tenloaivanbannoibo)", StringPool.LIKE, true, tenLoaiVanBanNoiBos);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("pml_edm_loaivanbannoibo", LoaiVanBanNoiBoImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(kyHieuLoaiVanBanNoiBos, 2);
			qpos.add(tenLoaiVanBanNoiBos, 2);
			return (List<LoaiVanBanNoiBo>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
