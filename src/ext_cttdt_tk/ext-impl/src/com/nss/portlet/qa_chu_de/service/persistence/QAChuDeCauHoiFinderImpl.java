package com.nss.portlet.qa_chu_de.service.persistence;

import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.nss.portlet.linh_vuc_thu_tuc.model.impl.LinhVucThuTucHanhChinhImpl;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;
import com.nss.portlet.qa_chu_de.model.impl.QAChuDeCauHoiImpl;

public class QAChuDeCauHoiFinderImpl extends BasePersistenceImpl implements QAChuDeCauHoiFinder{
	public int countChuDeCauHoi(String tenChuDeCauHoi, boolean andOperator) throws SystemException {
		return countChuDeCauHoi(new String[]{tenChuDeCauHoi}, andOperator);
	}
	public int countChuDeCauHoi(String[] tenChuDeCauHoi, boolean andOperator) throws SystemException {
		tenChuDeCauHoi = CustomSQLUtil.keywords(tenChuDeCauHoi, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM nss_qa_chu_de ";
			sql += " WHERE ";
			sql += " (lower(nss_qa_chu_de.tenchudecauhoi) LIKE ? [$AND_OR_NULL_CHECK$]) ";
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_chu_de.tenchudecauhoi)", StringPool.LIKE, false, tenChuDeCauHoi);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(tenChuDeCauHoi,2);
			
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
	
	public List<QAChuDeCauHoi> findChuDeCauHoi(String tenChuDeCauHoi, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findChuDeCauHoi(new String[]{tenChuDeCauHoi}, andOperator, start, end, obc);
	}
	
	public List<QAChuDeCauHoi> findChuDeCauHoi(String[] tenChuDeCauHoi, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		tenChuDeCauHoi = CustomSQLUtil.keywords(tenChuDeCauHoi, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT nss_qa_chu_de.* ";
			sql += " FROM nss_qa_chu_de ";
			sql += " WHERE ";
			sql += " (lower(nss_qa_chu_de.tenchudecauhoi) LIKE ? [$AND_OR_NULL_CHECK$]) ";
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_qa_chu_de.tenchudecauhoi)", StringPool.LIKE, false, tenChuDeCauHoi);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("nss_qa_chu_de", QAChuDeCauHoiImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(tenChuDeCauHoi,2);
			 
			return (List<QAChuDeCauHoi>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
