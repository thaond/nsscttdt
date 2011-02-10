package com.sgs.portlet.holiday_calendar.service.persistence;

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
import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;
import com.sgs.portlet.holiday_calendar.model.impl.HolidayCalendarImpl;

public class HolidayCalendarFinderImpl extends BasePersistenceImpl implements HolidayCalendarFinder{
	public static String COUNT_HOLIDAY_CALENDAR_TEST = HolidayCalendarFinder.class.getName()+ ".COUNT_HOLIDAY_CALENDAR_TEST";
	public static String FIND_HOLIDAY_CALENDAR_TEST = HolidayCalendarFinder.class.getName()+ ".FIND_HOLIDAY_CALENDAR_TEST";
	
	public int count_holiday_calendar_test(String holidayCalendarCodes, String holidayCalendarTitles, String dateFrom, String dateTo, boolean andOperator) throws SystemException {
		return count_holiday_calendar_test(new String[] { holidayCalendarCodes }, new String[] { holidayCalendarTitles }, dateFrom, dateTo, andOperator);

	}

	public int count_holiday_calendar_test(String[] holidayCalendarCodes, String[] holidayCalendarTitles, String dateFrom, String dateTo, boolean andOperator) throws SystemException {
		holidayCalendarCodes = CustomSQLUtil.keywords(holidayCalendarCodes);
		holidayCalendarTitles = CustomSQLUtil.keywords(holidayCalendarTitles);
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
				dateToTT = CalendarUtil.getTimestamp(dTo);
			}
		} catch (Exception e) {
			throw new SystemException(e);
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(COUNT_HOLIDAY_CALENDAR_TEST);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(holidayCalendarCode)", StringPool.LIKE, false, holidayCalendarCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(holidayCalendarTitle)", StringPool.LIKE, true, holidayCalendarTitles);
			if(dateFromTT != null){
				sql = sql.replace("holidayCalendarDateCreate >= ? [$AND_OR_NULL_CHECK$]", "holidayCalendarDateCreate >= TIMESTAMP " + "'" + dateFromTT.toString() + "'");
			}else{
				sql = sql.replace("(holidayCalendarDateCreate >= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			if(dateToTT != null){
				sql = sql.replace("holidayCalendarDateCreate <= ? [$AND_OR_NULL_CHECK$]", "holidayCalendarDateCreate <= TIMESTAMP " + "'" + dateToTT.toString() + "'");
			}else{
				sql = sql.replace("(holidayCalendarDateCreate <= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
			SQLQuery q = session.createSQLQuery(sql);
			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(holidayCalendarCodes, 2);
			qpos.add(holidayCalendarTitles, 2);
			
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
	
	public List<HolidayCalendar> find_holiday_calendar_test(String holidayCalendarCodes, String holidayCalendarTitles, String dateFrom, String dateTo, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException {
		return find_holiday_calendar_test(new String[] { holidayCalendarCodes }, new String[] { holidayCalendarTitles }, dateFrom, dateTo, andOperator, start, end, obc);
	}

	public List<HolidayCalendar> find_holiday_calendar_test(String[] holidayCalendarCodes, String[] holidayCalendarTitles, String dateFrom, String dateTo, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		holidayCalendarCodes = CustomSQLUtil.keywords(holidayCalendarCodes);
		holidayCalendarTitles = CustomSQLUtil.keywords(holidayCalendarTitles);
		
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
				dateToTT = CalendarUtil.getTimestamp(dTo);
			}
		} catch (Exception e) {
			throw new SystemException(e);
		}
		
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(FIND_HOLIDAY_CALENDAR_TEST);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(holidayCalendarCode)", StringPool.LIKE, false, holidayCalendarCodes);
			sql = CustomSQLUtil.replaceKeywords(sql, "lower(holidayCalendarTitle)", StringPool.LIKE, true, holidayCalendarTitles);
			if(dateFromTT != null){
				sql = sql.replace("holidayCalendarDateCreate >= ? [$AND_OR_NULL_CHECK$]", "holidayCalendarDateCreate >= TIMESTAMP " + "'" + dateFromTT.toString() + "'");
			}else{
				sql = sql.replace("(holidayCalendarDateCreate >= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			if(dateToTT != null){
				sql = sql.replace("holidayCalendarDateCreate <= ? [$AND_OR_NULL_CHECK$]", "holidayCalendarDateCreate <= TIMESTAMP " + "'" + dateToTT.toString() + "'");
			}else{
				sql = sql.replace("(holidayCalendarDateCreate <= ? [$AND_OR_NULL_CHECK$]) [$AND_OR_CONNECTOR$]", "");
			}
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			SQLQuery q = session.createSQLQuery(sql);
			q.addEntity("holiday_calendar", HolidayCalendarImpl.class);
			QueryPos qpos = QueryPos.getInstance(q);
			
			qpos.add(holidayCalendarCodes, 2);
			qpos.add(holidayCalendarTitles, 2);
			return (List<HolidayCalendar>) QueryUtil.list(q, getDialect(), start, end);
		} catch (Exception e) {
			throw new SystemException();
		} finally {
			closeSession(session);
		}
	}
}


