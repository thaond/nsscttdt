package com.sgs.portlet.document_manager.service.persistence;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.document_manager.model.DocumentManager;
import com.sgs.portlet.document_manager.model.impl.DocumentManagerImpl;

public class DocumentManagerFinderImpl extends BasePersistenceImpl implements DocumentManagerFinder{
	public static String COUNT_DOCUMENT_MANAGER = DocumentManagerFinder.class.getName()+ ".COUNT_DOCUMENT_MANAGER";
	public static String FIND_DOCUMENT_MANAGER = DocumentManagerFinder.class.getName()+ ".FIND_DOCUMENT_MANAGER";
	public static String COUNT_DOCUMENT_MANAGER_TEST = DocumentManagerFinder.class.getName()+ ".COUNT_DOCUMENT_MANAGER_TEST";
	public static String FIND_DOCUMENT_MANAGER_TEST = DocumentManagerFinder.class.getName()+ ".FIND_DOCUMENT_MANAGER_TEST";
	
	public int count_document_manager(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, boolean andOperator) throws SystemException {
		return count_document_manager(new String[] { documentManagerCodes }, new String[] { documentManagerCategorys }, new String[] { documentManagerDescriptions }, new String[] { documentManagerTitles }, new String[] { documentManagerStyles }, andOperator);

	}

	public int count_document_manager(String[] documentManagerCodes, String[] documentManagerCategorys, String[] documentManagerDescriptions, String[] documentManagerTitles, String[] documentManagerStyles, boolean andOperator) throws SystemException {
		documentManagerCodes = CustomSQLUtil.keywords(documentManagerCodes);
		documentManagerCategorys = CustomSQLUtil.keywords(documentManagerCategorys);
		documentManagerDescriptions = CustomSQLUtil.keywords(documentManagerDescriptions);
		documentManagerTitles = CustomSQLUtil.keywords(documentManagerTitles);
		documentManagerStyles = CustomSQLUtil.keywords(documentManagerStyles);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_DOCUMENT_MANAGER);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCode)", StringPool.LIKE, false, documentManagerCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCategory)", StringPool.LIKE, false, documentManagerCategorys);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerDescription)", StringPool.LIKE, false, documentManagerDescriptions);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerTitle)", StringPool.LIKE, true, documentManagerTitles);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(documentManagerCodes, 2);
			qpos.add(documentManagerCategorys, 2);
			qpos.add(documentManagerDescriptions, 2);
			qpos.add(documentManagerTitles, 2);
			qpos.add(documentManagerStyles);
			
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

	public List<DocumentManager> find_document_manager(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_document_manager(new String[] { documentManagerCodes }, new String[] { documentManagerCategorys }, new String[] { documentManagerDescriptions }, new String[] { documentManagerTitles }, new String[] { documentManagerStyles }, andOperator, start, end, obc);
	}

	public List<DocumentManager> find_document_manager(String[] documentManagerCodes, String[] documentManagerCategorys,String[] documentManagerDescriptions, String[] documentManagerTitles, String[] documentManagerStyles, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		documentManagerCodes = CustomSQLUtil.keywords(documentManagerCodes);
		documentManagerCategorys = CustomSQLUtil.keywords(documentManagerCategorys);
		documentManagerDescriptions = CustomSQLUtil.keywords(documentManagerDescriptions);
		documentManagerTitles = CustomSQLUtil.keywords(documentManagerTitles);
		documentManagerStyles = CustomSQLUtil.keywords(documentManagerStyles);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_DOCUMENT_MANAGER);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCode)", StringPool.LIKE, false, documentManagerCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCategory)", StringPool.LIKE, false, documentManagerCategorys);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerDescription)", StringPool.LIKE, false, documentManagerDescriptions);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerTitle)", StringPool.LIKE, true, documentManagerTitles);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("document_manager", DocumentManagerImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(documentManagerCodes, 2);
			qpos.add(documentManagerCategorys, 2);
			qpos.add(documentManagerDescriptions, 2);
			qpos.add(documentManagerTitles, 2);
			qpos.add(documentManagerStyles);
			return (List<DocumentManager>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
	
	public int count_document_manager_test(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, String dateFrom, String dateTo, boolean andOperator) throws SystemException {
		return count_document_manager_test(new String[] { documentManagerCodes }, new String[] { documentManagerCategorys }, new String[] { documentManagerDescriptions }, new String[] { documentManagerTitles }, new String[] { documentManagerStyles }, dateFrom, dateTo, andOperator);

	}

	public int count_document_manager_test(String[] documentManagerCodes, String[] documentManagerCategorys, String[] documentManagerDescriptions, String[] documentManagerTitles, String[] documentManagerStyles, String dateFrom, String dateTo, boolean andOperator) throws SystemException {
		documentManagerCodes = CustomSQLUtil.keywords(documentManagerCodes);
		documentManagerCategorys = CustomSQLUtil.keywords(documentManagerCategorys);
		documentManagerDescriptions = CustomSQLUtil.keywords(documentManagerDescriptions);
		documentManagerTitles = CustomSQLUtil.keywords(documentManagerTitles);
		documentManagerStyles = CustomSQLUtil.keywords(documentManagerStyles);
		Timestamp dateFromTT = null;
		Timestamp dateToTT = null;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(dateFrom != null && !dateFrom.equals("")){
				Date dFrom = format.parse(dateFrom);
				dateFromTT = CalendarUtil.getTimestamp(dFrom);
			}
			if(dateTo != null && !dateTo.equals("")){
				Date dTo = format.parse(dateTo);
				dTo.setTime(dTo.getTime() + 24*60*60* 1000l);
				dateToTT = CalendarUtil.getTimestamp(dTo);
			}
		} catch (Exception e) {
			throw new SystemException(e);
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_DOCUMENT_MANAGER_TEST);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCode)", StringPool.LIKE, false, documentManagerCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCategory)", StringPool.LIKE, false, documentManagerCategorys);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerDescription)", StringPool.LIKE, false, documentManagerDescriptions);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerTitle)", StringPool.LIKE, true, documentManagerTitles);
			
			if(dateFromTT != null){
				sql = sql.replace("documentManagerDateCreate >= ? [$AND_OR_NULL_CHECK$]", "documentManagerDateCreate >= TIMESTAMP " + "'" + dateFromTT.toString() + "'");
			}else{
				sql = sql.replace("(documentManagerDateCreate >= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			if(dateToTT != null){
				sql = sql.replace("documentManagerDateCreate <= ? [$AND_OR_NULL_CHECK$]", "documentManagerDateCreate <= TIMESTAMP " + "'" + dateToTT.toString() + "'");
			}else{
				sql = sql.replace("(documentManagerDateCreate <= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(documentManagerCodes, 2);
			qpos.add(documentManagerCategorys, 2);
			qpos.add(documentManagerDescriptions, 2);
			qpos.add(documentManagerTitles, 2);
			qpos.add(documentManagerStyles);
			
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
	
	public List<DocumentManager> find_document_manager_test(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, String dateFrom, String dateTo, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_document_manager_test(new String[] { documentManagerCodes }, new String[] { documentManagerCategorys }, new String[] { documentManagerDescriptions }, new String[] { documentManagerTitles }, new String[] { documentManagerStyles }, andOperator, dateFrom, dateTo, start, end, obc);
	}

	public List<DocumentManager> find_document_manager_test(String[] documentManagerCodes, String[] documentManagerCategorys,String[] documentManagerDescriptions, String[] documentManagerTitles, String[] documentManagerStyles, boolean andOperator, String dateFrom, String dateTo, int start, int end, OrderByComparator obc) throws SystemException {
		documentManagerCodes = CustomSQLUtil.keywords(documentManagerCodes);
		documentManagerCategorys = CustomSQLUtil.keywords(documentManagerCategorys);
		documentManagerDescriptions = CustomSQLUtil.keywords(documentManagerDescriptions);
		documentManagerTitles = CustomSQLUtil.keywords(documentManagerTitles);
		documentManagerStyles = CustomSQLUtil.keywords(documentManagerStyles);
		
		Timestamp dateFromTT = null;
		Timestamp dateToTT = null;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(dateFrom != null && !dateFrom.equals("")){
				Date dFrom = format.parse(dateFrom);
				dateFromTT = CalendarUtil.getTimestamp(dFrom);
			}
			if(dateTo != null && !dateTo.equals("")){
				Date dTo = format.parse(dateTo);
				dTo.setTime(dTo.getTime() + 24*60*60* 1000l);
				dateToTT = CalendarUtil.getTimestamp(dTo);
			}
		} catch (Exception e) {
			throw new SystemException(e);
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_DOCUMENT_MANAGER_TEST);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCode)", StringPool.LIKE, false, documentManagerCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerCategory)", StringPool.LIKE, false, documentManagerCategorys);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerDescription)", StringPool.LIKE, false, documentManagerDescriptions);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(documentManagerTitle)", StringPool.LIKE, true, documentManagerTitles);
			
			if(dateFromTT != null){
				sql = sql.replace("documentManagerDateCreate >= ? [$AND_OR_NULL_CHECK$]", "documentManagerDateCreate >= TIMESTAMP " + "'" + dateFromTT.toString() + "'");
			}else{
				sql = sql.replace("(documentManagerDateCreate >= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			if(dateToTT != null){
				sql = sql.replace("documentManagerDateCreate <= ? [$AND_OR_NULL_CHECK$]", "documentManagerDateCreate <= TIMESTAMP " + "'" + dateToTT.toString() + "'");
			}else{
				sql = sql.replace("(documentManagerDateCreate <= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("document_manager", DocumentManagerImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(documentManagerCodes, 2);
			qpos.add(documentManagerCategorys, 2);
			qpos.add(documentManagerDescriptions, 2);
			qpos.add(documentManagerTitles, 2);
			qpos.add(documentManagerStyles);
			return (List<DocumentManager>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}


