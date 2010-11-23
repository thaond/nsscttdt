package com.nss.portlet.media_chu_de.service.persistence;

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
import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.model.impl.MediaChuDeImpl;

public class MediaChuDeFinderImpl extends BasePersistenceImpl implements MediaChuDeFinder{
	public int countMediaChuDe(String tenMediaChuDe, boolean andOperator) throws SystemException {
		return countMediaChuDe(new String[]{tenMediaChuDe}, andOperator);
	}
	public int countMediaChuDe(String[] tenMediaChuDe, boolean andOperator) throws SystemException {
		tenMediaChuDe = CustomSQLUtil.keywords(tenMediaChuDe, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += " FROM nss_media_chu_de ";
			sql += " WHERE ";
			sql += " (lower(nss_media_chu_de.tenmediachude) LIKE ? [$AND_OR_NULL_CHECK$]) ";
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_media_chu_de.tenmediachude)", StringPool.LIKE, false, tenMediaChuDe);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(tenMediaChuDe,2);
			
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
	
	public List<MediaChuDe> findMediaChuDe(String tenMediaChuDe, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findMediaChuDe(new String[]{tenMediaChuDe}, andOperator, start, end, obc);
	}
	
	public List<MediaChuDe> findMediaChuDe(String[] tenMediaChuDe, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		tenMediaChuDe = CustomSQLUtil.keywords(tenMediaChuDe, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT nss_media_chu_de.* ";
			sql += " FROM nss_media_chu_de ";
			sql += " WHERE ";
			sql += " (lower(nss_media_chu_de.tenmediachude) LIKE ? [$AND_OR_NULL_CHECK$]) ";
			
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_media_chu_de.tenmediachude)", StringPool.LIKE, false, tenMediaChuDe);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("nss_media_chu_de", MediaChuDeImpl.class);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(tenMediaChuDe,2);
			 
			return (List<MediaChuDe>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
