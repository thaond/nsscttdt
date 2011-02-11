package com.sgs.portlet.report_registry_work.service.persistence;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.model.impl.ReportRegistryImpl;

public class ReportRegistryFinderImpl extends BasePersistenceImpl implements ReportRegistryFinder{
	public static String COUNT_REPORT_REGISTRY_BOOK = ReportRegistryFinder.class.getName()+ ".COUNT_REPORT_REGISTRY_BOOK";
	public static String FIND_REPORT_REGISTRY_BOOK = ReportRegistryFinder.class.getName()+ ".FIND_REPORT_REGISTRY_BOOK";
	public static String COUNT_REPORT_REGISTRY = ReportRegistryFinder.class.getName()+ ".COUNT_REPORT_REGISTRY";
	public static String FIND_REPORT_REGISTRY = ReportRegistryFinder.class.getName()+ ".FIND_REPORT_REGISTRY";
	
	public int count_report_registry(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, Long departmentId, boolean andOperator) throws SystemException {
		return count_report_registry(new String[] { reportRegistryCodes }, new String[] { userCreates }, new String[] { resultWorks }, new String[] { programWorks }, departmentId, andOperator);

	}

	public int count_report_registry(String[] reportRegistryCodes, String [] userCreates, String[] resultWorks, String[] programWorks, Long departmentId, boolean andOperator) throws SystemException {
		reportRegistryCodes = CustomSQLUtil.keywords(reportRegistryCodes);
		userCreates = CustomSQLUtil.keywords(userCreates);
		resultWorks = CustomSQLUtil.keywords(resultWorks);
		programWorks = CustomSQLUtil.keywords(programWorks);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_REPORT_REGISTRY_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(reportRegistryCode)", StringPool.LIKE, false, reportRegistryCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(userCreate)", StringPool.LIKE, false, userCreates);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(resultWork)", StringPool.LIKE, false, resultWorks);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(programWork)", StringPool.LIKE, true, programWorks);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(reportRegistryCodes, 2);
			qpos.add(userCreates, 2);
			qpos.add(resultWorks, 2);
			qpos.add(programWorks, 2);
			
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

	public List<ReportRegistry> find_report_registry(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, Long departmentId, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_report_registry(new String[] { reportRegistryCodes },new String[] { userCreates }, new String[] { resultWorks }, new String[] { programWorks },
				departmentId ,andOperator, start, end, obc);
	}

	public List<ReportRegistry> find_report_registry(String[] reportRegistryCodes, String[] userCreates, String[] resultWorks, String[] programWorks, Long departmentId, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		reportRegistryCodes = CustomSQLUtil.keywords(reportRegistryCodes);
		resultWorks = CustomSQLUtil.keywords(resultWorks);
		programWorks = CustomSQLUtil.keywords(programWorks);
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_REPORT_REGISTRY_BOOK);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(reportRegistryCode)", StringPool.LIKE, false, reportRegistryCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(userCreate)", StringPool.LIKE, false, userCreates);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(resultWork)", StringPool.LIKE, false, resultWorks);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(programWork)", StringPool.LIKE, true, programWorks);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("report_registry_work", ReportRegistryImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			qpos.add(reportRegistryCodes, 2);
			qpos.add(userCreates, 2);
			qpos.add(resultWorks, 2);
			qpos.add(programWorks, 2);
			return (List<ReportRegistry>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
	
	public int count_report_registry_test(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, long departmentId, String dateFrom, String dateTo, boolean andOperator) throws SystemException{
		return count_report_registry_test(new String[] { reportRegistryCodes }, new String[] { userCreates }, new String[] { resultWorks }, new String[] { programWorks }, departmentId, dateFrom, dateTo, andOperator);
	}
	
	public int count_report_registry_test(String[] reportRegistryCodes, String[] userCreates,
			String[] resultWorks, String[] programWorks, long departmentId,
			String dateFrom, String dateTo, boolean andOperator) throws SystemException{
		reportRegistryCodes = CustomSQLUtil.keywords(reportRegistryCodes);
		userCreates = CustomSQLUtil.keywords(userCreates);
		resultWorks = CustomSQLUtil.keywords(resultWorks);
		programWorks = CustomSQLUtil.keywords(programWorks);
		
		Timestamp dateFromTT = null;
		Timestamp dateToTT = null;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(dateFrom != null){
				Date dFrom = format.parse(dateFrom);
				dateFromTT = CalendarUtil.getTimestamp(dFrom);
			}
			if(dateTo != null){
				Date dTo = format.parse(dateTo);
				dTo.setDate(dTo.getDate() + 1);
				dateToTT = CalendarUtil.getTimestamp(dTo);
			}
		} catch (Exception e) {
			throw new SystemException(e);
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_REPORT_REGISTRY);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(reportRegistryCode)", StringPool.LIKE, false, reportRegistryCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(userCreate)", StringPool.LIKE, false, userCreates);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(resultWork)", StringPool.LIKE, false, resultWorks);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(programWork)", StringPool.LIKE, true, programWorks);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			if(departmentId <= 0){
				sql = StringUtil.replace(sql, "(departmentId = ?) AND", "");
			}
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			
			if(departmentId > 0){
				qpos.add(departmentId);
			}
			
			qpos.add(dateFromTT);
			qpos.add(dateFromTT);
			qpos.add(dateToTT);
			qpos.add(dateToTT);
			
			qpos.add(reportRegistryCodes, 2);
			qpos.add(userCreates, 2);
			qpos.add(resultWorks, 2);
			qpos.add(programWorks, 2);
			
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
	
	public List<ReportRegistry> find_report_registry_test(String reportRegistryCodes, String userCreates, String resultWorks, String programWorks, long departmentId, String dateFrom, String dateTo, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_report_registry_test(new String[] { reportRegistryCodes },new String[] { userCreates }, new String[] { resultWorks }, new String[] { programWorks },
				departmentId, dateFrom, dateTo ,andOperator, start, end, obc);
	}

	public List<ReportRegistry> find_report_registry_test(String[] reportRegistryCodes,
			String[] userCreates, String[] resultWorks, String[] programWorks,
			long departmentId, String dateFrom, String dateTo, boolean andOperator,
			int start, int end, OrderByComparator obc) throws SystemException{
		reportRegistryCodes = CustomSQLUtil.keywords(reportRegistryCodes);
		userCreates = CustomSQLUtil.keywords(userCreates);
		resultWorks = CustomSQLUtil.keywords(resultWorks);
		programWorks = CustomSQLUtil.keywords(programWorks);

		Timestamp dateFromTT = null;
		Timestamp dateToTT = null;
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(dateFrom != null){
				Date dFrom = format.parse(dateFrom);
				dateFromTT = CalendarUtil.getTimestamp(dFrom);
			}
			if(dateTo != null){
				Date dTo = format.parse(dateTo);
				dTo.setDate(dTo.getDate() + 1);
				dateToTT = CalendarUtil.getTimestamp(dTo);
			}
		} catch (Exception e) {
			throw new SystemException(e);
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_REPORT_REGISTRY);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(reportRegistryCode)", StringPool.LIKE, false, reportRegistryCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(userCreate)", StringPool.LIKE, false, userCreates);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(resultWork)", StringPool.LIKE, false, resultWorks);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(programWork)", StringPool.LIKE, true, programWorks);
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
			if(departmentId <= 0){
				sql = StringUtil.replace(sql, "(departmentId = ?) AND", "");
			}
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("report_registry_work", ReportRegistryImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			
			if(departmentId > 0){
				qpos.add(departmentId);
			}
			
			qpos.add(dateFromTT);
			qpos.add(dateFromTT);
			qpos.add(dateToTT);
			qpos.add(dateToTT);
			
			qpos.add(reportRegistryCodes, 2);
			qpos.add(userCreates, 2);
			qpos.add(resultWorks, 2);
			qpos.add(programWorks, 2);
			return (List<ReportRegistry>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}
