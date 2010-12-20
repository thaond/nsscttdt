package com.nss.portlet.qa_cau_hoi.service.persistence;

import java.util.ArrayList;
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
import com.nss.portlet.qa_cau_hoi.model.CauHoiQA;
import com.nss.portlet.qa_cau_hoi.model.impl.CauHoiQAImpl;
import com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen;
import com.nss.portlet.qa_phan_quyen.service.QAPhanQuyenLocalServiceUtil;

public class CauHoiQAFinderImpl extends BasePersistenceImpl implements CauHoiQAFinder{
	public int countByTieuDe_ChuDe(long maChuDeCauHoi, String name, boolean andOperator) throws SystemException{
		return countByTieuDe_ChuDe(maChuDeCauHoi, new String[]{name}, andOperator);
	}
	
	public int countByTieuDe_ChuDe(long maChuDeCauHoi, String[] names, boolean andOperator) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT COUNT(*) AS COUNT_VALUE";
			sql += " FROM nss_qa_cau_hoi";
			sql += " WHERE ";
			sql += " (lower(nss_qa_cau_hoi.tieude) LIKE ? [$AND_OR_NULL_CHECK$]) ";

			if (0 != maChuDeCauHoi) {
				sql += "AND nss_qa_cau_hoi.machudecauhoi = " + maChuDeCauHoi;
			}
			sql += " AND nss_qa_cau_hoi.publish is true";
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_cau_hoi.tieude)", StringPool.LIKE, false, names); 
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
	

	public List<CauHoiQA> findTieuDe_ChuDe(long maChuDeCauHoi, String name, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findTieuDe_ChuDe(maChuDeCauHoi, new String[]{name}, andOperator, start, end, obc);
	}

	public List<CauHoiQA> findTieuDe_ChuDe(long maChuDeCauHoi, String[] names, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT DISTINCT nss_qa_cau_hoi.*";
			sql += " FROM nss_qa_cau_hoi";
			sql += " WHERE ";
			sql += " (lower(nss_qa_cau_hoi.tieude) LIKE ? [$AND_OR_NULL_CHECK$]) ";

			if (0 != maChuDeCauHoi) {
				sql += "AND nss_qa_cau_hoi.machudecauhoi = " + maChuDeCauHoi;
			}
			sql += " AND nss_qa_cau_hoi.publish is true";
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_cau_hoi.tieude)", StringPool.LIKE, false, names);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("nss_qa_cau_hoi", CauHoiQAImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(names,2);
			 
			return (List<CauHoiQA>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
	
	public int countByTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi, String name, boolean andOperator) throws SystemException{
		return countByTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, new String[]{name}, andOperator);
	}
	
	public int countByTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi, String[] names, boolean andOperator) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		
		List<QAPhanQuyen> qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		qAPhanQuyenList = QAPhanQuyenLocalServiceUtil.findByMaNguoiTraLoi_QuyenXem(userId);
		String dsMaChuDe = "";
		if (qAPhanQuyenList.size() > 0) {
			for (int i = 0; i < qAPhanQuyenList.size(); i++) {
				QAPhanQuyen phanQuyen = qAPhanQuyenList.get(i);
				dsMaChuDe += phanQuyen.getMaChuDeCauHoi();
				if (i + 1 <qAPhanQuyenList.size()) {
					dsMaChuDe += ",";
				}
			}
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = " SELECT COUNT(*) AS COUNT_VALUE ";
			sql += "FROM nss_qa_cau_hoi";
			
			if (0 == maChuDeCauHoi) {
				if (!"".equals(dsMaChuDe)) {
					sql += " WHERE ";
					sql += " (lower(nss_qa_cau_hoi.tieude) LIKE ? [$AND_OR_NULL_CHECK$]) ";
					sql = sql.replaceAll("FROM nss_qa_cau_hoi", "FROM nss_qa_cau_hoi, nss_qa_phan_quyen");
					sql += " AND nss_qa_cau_hoi.machudecauhoi in ( " + dsMaChuDe + ")";
					sql += " AND nss_qa_phan_quyen.machudecauhoi = nss_qa_cau_hoi.machudecauhoi";
					sql += " AND nss_qa_phan_quyen.manguoitraloi = " + userId;
					sql += " AND nss_qa_phan_quyen.quyenxem is true ";
					sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_cau_hoi.tieude)", StringPool.LIKE, false, names); 
				} else {
					sql += " WHERE 1 = -1 ";
				}
			} else {
				sql += " WHERE ";
				sql += " (lower(nss_qa_cau_hoi.tieude) LIKE ? [$AND_OR_NULL_CHECK$]) ";
				sql = sql.replaceAll("FROM nss_qa_cau_hoi", "FROM nss_qa_cau_hoi, nss_qa_phan_quyen");
				sql += " AND nss_qa_cau_hoi.machudecauhoi = " + maChuDeCauHoi;
				sql += " AND nss_qa_phan_quyen.machudecauhoi = nss_qa_cau_hoi.machudecauhoi";
				sql += " AND nss_qa_phan_quyen.manguoitraloi = " + userId;
				sql += " AND nss_qa_phan_quyen.quyenxem is true ";
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_cau_hoi.tieude)", StringPool.LIKE, false, names); 
			}

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			if ((0 == maChuDeCauHoi && !"".equals(dsMaChuDe)) || 0 != maChuDeCauHoi) {
				QueryPos qpos = QueryPos.getInstance(q);
				qpos.add(names,2);
			}
			
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
	
	public List<CauHoiQA> findTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi, String name, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findTieuDe_ChuDe_PhanQuyen(userId, maChuDeCauHoi, new String[]{name}, andOperator, start, end, obc);
	}

	public List<CauHoiQA> findTieuDe_ChuDe_PhanQuyen(long userId,long maChuDeCauHoi, String[] names, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		names = CustomSQLUtil.keywords(names, true);
		List<QAPhanQuyen> qAPhanQuyenList = new ArrayList<QAPhanQuyen>();
		qAPhanQuyenList = QAPhanQuyenLocalServiceUtil.findByMaNguoiTraLoi_QuyenXem(userId);
		String dsMaChuDe = "";
		if (qAPhanQuyenList.size() > 0) {
			for (int i = 0; i < qAPhanQuyenList.size(); i++) {
				QAPhanQuyen phanQuyen = qAPhanQuyenList.get(i);
				dsMaChuDe += phanQuyen.getMaChuDeCauHoi();
				if (i + 1 <qAPhanQuyenList.size()) {
					dsMaChuDe += ",";
				}
			}
		}
		Session session = null;
		try {
			session = openSession();
			
			String sql = " SELECT DISTINCT nss_qa_cau_hoi.*";
			sql += "FROM nss_qa_cau_hoi";
			if (0 == maChuDeCauHoi) {
				if (!"".equals(dsMaChuDe)) {
					sql += " WHERE ";
					sql += " (lower(nss_qa_cau_hoi.tieude) LIKE ? [$AND_OR_NULL_CHECK$]) ";
					sql = sql.replaceAll("FROM nss_qa_cau_hoi", "FROM nss_qa_cau_hoi, nss_qa_phan_quyen");
					sql += " AND nss_qa_cau_hoi.machudecauhoi in ( " + dsMaChuDe + ")";
					sql += " AND nss_qa_phan_quyen.machudecauhoi = nss_qa_cau_hoi.machudecauhoi";
					sql += " AND nss_qa_phan_quyen.manguoitraloi = " + userId;
					sql += " AND nss_qa_phan_quyen.quyenxem is true ";
					sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_cau_hoi.tieude)", StringPool.LIKE, false, names); 
				} else {
					sql += " WHERE 1 = -1 ";
				}
			} else {
				sql += " WHERE ";
				sql += " (lower(nss_qa_cau_hoi.tieude) LIKE ? [$AND_OR_NULL_CHECK$]) ";
				sql = sql.replaceAll("FROM nss_qa_cau_hoi", "FROM nss_qa_cau_hoi, nss_qa_phan_quyen");
				sql += " AND nss_qa_cau_hoi.machudecauhoi = " + maChuDeCauHoi;
				sql += " AND nss_qa_phan_quyen.machudecauhoi = nss_qa_cau_hoi.machudecauhoi";
				sql += " AND nss_qa_phan_quyen.manguoitraloi = " + userId;
				sql += " AND nss_qa_phan_quyen.quyenxem is true ";
				sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_cau_hoi.tieude)", StringPool.LIKE, false, names); 
			}

			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("nss_qa_cau_hoi", CauHoiQAImpl.class);
			
			if ((0 == maChuDeCauHoi && !"".equals(dsMaChuDe)) || 0 != maChuDeCauHoi) {
				QueryPos qpos = QueryPos.getInstance(q);
				qpos.add(names,2);
			}
			 
			return (List<CauHoiQA>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
