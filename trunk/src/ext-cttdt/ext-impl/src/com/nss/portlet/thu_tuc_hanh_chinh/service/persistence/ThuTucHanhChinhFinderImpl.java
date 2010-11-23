package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

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
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh;
import com.nss.portlet.thu_tuc_hanh_chinh.model.impl.ThuTucHanhChinhImpl;

public class ThuTucHanhChinhFinderImpl extends BasePersistenceImpl implements ThuTucHanhChinhFinder {

	public int countByTEN_LINHVUC_DONVI(String name, long linhVuc, long capDonVi, long donVi, boolean andOperator) throws SystemException{
		return countByTEN_LINHVUC_DONVI(new String[]{name}, linhVuc, capDonVi, donVi, andOperator);
	}
	
	public int countByTEN_LINHVUC_DONVI(String[] names, long linhVuc, long capDonVi, long donVi, boolean andOperator) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM nss_thu_tuc_hanh_chinh, nss_don_vi_thu_tuc";
			sql += " WHERE nss_don_vi_thu_tuc.ma_don_vi_thu_tuc = nss_thu_tuc_hanh_chinh.madonvithutuchanhchinh ";
			sql += " AND nss_don_vi_thu_tuc.capdonvi = " + capDonVi;
			sql += " AND ";
			sql += "(lower(nss_thu_tuc_hanh_chinh.tenthutuchanhchinh) LIKE ? [$AND_OR_NULL_CHECK$])";
			if (0 != linhVuc) {
				sql += " AND (nss_thu_tuc_hanh_chinh.malinhvucthutuchanhchinh = " + linhVuc + " )";
			} if (0 != donVi) {
				sql += " AND (nss_thu_tuc_hanh_chinh.madonvithutuchanhchinh = " + donVi + " ) ";
			}

			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_thu_tuc_hanh_chinh.tenthutuchanhchinh)", StringPool.LIKE, false, names); 
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(names,2);
			
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
	

	public List<ThuTucHanhChinh> findTEN_LINHVUC_DONVI(String name, long linhVuc, long capDonVi, long donVi, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findTEN_LINHVUC_DONVI(new String[]{name}, linhVuc, capDonVi, donVi, andOperator, start, end, obc);
	}

	public List<ThuTucHanhChinh> findTEN_LINHVUC_DONVI(String[] names, long linhVuc, long capDonVi, long donVi,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT DISTINCT nss_thu_tuc_hanh_chinh.*";
			sql += " FROM nss_thu_tuc_hanh_chinh, nss_don_vi_thu_tuc";
			sql += " WHERE nss_don_vi_thu_tuc.ma_don_vi_thu_tuc = nss_thu_tuc_hanh_chinh.madonvithutuchanhchinh ";
			sql += " AND nss_don_vi_thu_tuc.capdonvi = " + capDonVi;
			sql += " AND ";
			sql += "(lower(nss_thu_tuc_hanh_chinh.tenthutuchanhchinh) LIKE ? [$AND_OR_NULL_CHECK$])";
			if (0 != linhVuc) {
				sql += " AND (nss_thu_tuc_hanh_chinh.malinhvucthutuchanhchinh = " + linhVuc + " )";
			} if (0 != donVi) {
				sql += " AND (nss_thu_tuc_hanh_chinh.madonvithutuchanhchinh = " + donVi + " ) ";
			}
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_thu_tuc_hanh_chinh.tenthutuchanhchinh)", StringPool.LIKE, false, names);
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("nss_thu_tuc_hanh_chinh", ThuTucHanhChinhImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(names,2);
			 
			return (List<ThuTucHanhChinh>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}

}
