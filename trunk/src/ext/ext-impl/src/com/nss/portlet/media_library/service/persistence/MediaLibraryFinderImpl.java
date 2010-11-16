package com.nss.portlet.media_library.service.persistence;

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
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.model.impl.MediaLibraryImpl;

public class MediaLibraryFinderImpl extends BasePersistenceImpl implements MediaLibraryFinder {
	public int countByKeywords(String keywords) throws SystemException{
		String[] tieuDeMediaLibrary = null;
		String[] tenMediaLibrary = null;
		long maMediaChuDe = 0;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			tieuDeMediaLibrary = CustomSQLUtil.keywords(keywords, true);
			tenMediaLibrary = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return countMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary, maMediaChuDe, andOperator);
	}
	
	public int countMediaLibrary(String tieuDeMediaLibrary, String tenMediaLibrary, long maMediaChuDe, boolean andOperator) throws SystemException {
		return countMediaLibrary(new String[]{tieuDeMediaLibrary}, new String[]{tenMediaLibrary}, maMediaChuDe, andOperator);
	}
	public int countMediaLibrary(String[] tieuDeMediaLibrary, String[] tenMediaLibrary, long maMediaChuDe, boolean andOperator) throws SystemException {
		tieuDeMediaLibrary = CustomSQLUtil.keywords(tieuDeMediaLibrary, true);
		tenMediaLibrary = CustomSQLUtil.keywords(tenMediaLibrary, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT COUNT(*) AS COUNT_VALUE ";
			sql += "FROM nss_media_library";
			sql += " WHERE ";
			sql += " (lower(nss_media_library.tieudemedialibrary) LIKE ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$] ";
			sql += " (lower(nss_media_library.tenmedialibrary) LIKE ? [$AND_OR_NULL_CHECK$]) ";
			if (maMediaChuDe > 0) {
				sql = sql.replace("FROM nss_media_library", "FROM nss_media_library, nss_media_chu_de ");
				sql += " AND nss_media_chu_de.mamediachude = nss_media_library.mamediachude ";
				sql += " AND nss_media_chu_de.mamediachude = " + maMediaChuDe;
			}
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_media_library.tieudemedialibrary)", StringPool.LIKE, false, tenMediaLibrary);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_media_library.tenmedialibrary)", StringPool.LIKE, true, tenMediaLibrary);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(tieuDeMediaLibrary,2);
			qpos.add(tenMediaLibrary,2);
			
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
	
	public List<MediaLibrary> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		String[] tieuDeMediaLibrary = null;
		String[] tenMediaLibrary = null;
		long maMediaChuDe = 0;
		boolean andOperator = false;
		if(Validator.isNotNull(keywords)){
			tieuDeMediaLibrary = CustomSQLUtil.keywords(keywords, true);
			tenMediaLibrary = CustomSQLUtil.keywords(keywords, true);
		}else{
			andOperator = true;
		}
		
		return findMediaLibrary(tieuDeMediaLibrary, tenMediaLibrary, maMediaChuDe, andOperator, start, end, obc);
	}
	
	public List<MediaLibrary> findMediaLibrary(String tieuDeMediaLibrary, String tenMediaLibrary, long maMediaChuDe, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return findMediaLibrary(new String[]{tieuDeMediaLibrary}, new String[]{tenMediaLibrary}, maMediaChuDe, andOperator, start, end, obc);
	}
	
	public List<MediaLibrary> findMediaLibrary(String[] tieuDeMediaLibrary, String[] tenMediaLibrary, long maMediaChuDe, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		tieuDeMediaLibrary = CustomSQLUtil.keywords(tieuDeMediaLibrary, true);
		tenMediaLibrary = CustomSQLUtil.keywords(tenMediaLibrary, true);
		
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT DISTINCT (nss_media_library.*) ";
			sql += "FROM nss_media_library";
			sql += " WHERE ";
			sql += " (lower(nss_media_library.tieudemedialibrary) LIKE ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$] ";
			sql += " (lower(nss_media_library.tenmedialibrary) LIKE ? [$AND_OR_NULL_CHECK$]) ";
			if (maMediaChuDe > 0) {
				sql = sql.replace("FROM nss_media_library", "FROM nss_media_library, nss_media_chu_de ");
				sql += " AND nss_media_chu_de.mamediachude = nss_media_library.mamediachude ";
				sql += " AND nss_media_chu_de.mamediachude = " + maMediaChuDe;
			}
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_media_library.tieudemedialibrary)", StringPool.LIKE, false, tenMediaLibrary);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(nss_media_library.tenmedialibrary)", StringPool.LIKE, true, tenMediaLibrary);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);

			SQLQuery q = session.createSQLQuery(sql);
			
			q.addEntity("nss_media_library", MediaLibraryImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(tieuDeMediaLibrary,2);
			qpos.add(tenMediaLibrary,2);
			 
			return (List<MediaLibrary>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		}
		finally{
			closeSession(session);
		}
	}
}
