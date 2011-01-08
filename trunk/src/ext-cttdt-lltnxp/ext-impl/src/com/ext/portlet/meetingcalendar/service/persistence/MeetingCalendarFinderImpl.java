/**
 * Copyright (c) 2000-2008 TruongSonSoft, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ext.portlet.meetingcalendar.service.persistence;

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
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.model.impl.CalEventImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.sql.Timestamp;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.ext.portlet.meetingcalendar.service.persistence.MeetingCalendarFinder;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalendarImpl;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
/**
 * <a href="CalEventFinderImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Dao Duy Duong
 *
 */
public class MeetingCalendarFinderImpl
	extends BasePersistenceImpl implements MeetingCalendarFinder {

	public static String COUNT_BY_SD_D_S_C =
		MeetingCalendarFinder.class.getName() + ".countBySD_D_S_C";
	
	public static String COUNT_BY_SD_D_S_C_S =
		MeetingCalendarFinder.class.getName() + ".countBySD_D_S_C_S";
	
	public static String FIND_BY_SD_D_S_C =
		MeetingCalendarFinder.class.getName() + ".findBySD_D_S_C";
	
	public static String FIND_BY_SD_D_S_C_S =
		MeetingCalendarFinder.class.getName() + ".findBySD_D_S_C_S";
	
	public static String FIND_BY_G_SD =
		MeetingCalendarFinder.class.getName() + ".findByG_SD";
		
	public int countBySD_D_S_C(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component, boolean andOperator)
		throws SystemException {
		
		Timestamp startDateGT_TS = CalendarUtil.getTimestamp(startDateGT);
		Timestamp startDateLT_TS = CalendarUtil.getTimestamp(startDateLT);
		String[] descriptions = new String[] {description};
		String[] sponsors = new String[] {sponsor};
		String[] components = new String[] {component};
		descriptions = CustomSQLUtil.keywords(descriptions, false);
		sponsors = CustomSQLUtil.keywords(sponsors, false);
		components = CustomSQLUtil.keywords(components, false);
		
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_SD_D_S_C);

			sql = CustomSQLUtil.replaceKeywords(
					sql, "description", StringPool.LIKE, false, descriptions);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "sponsor", StringPool.LIKE, false, sponsors);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "component", StringPool.LIKE, false, components);
          	
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
          	SQLQuery q = session.createSQLQuery(sql);

          	q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
          	QueryPos qPos = QueryPos.getInstance(q);
          	
          	qPos.add(startDateGT_TS);
			qPos.add(startDateGT_TS);
			qPos.add(startDateLT_TS);
			qPos.add(startDateLT_TS);
          	qPos.add(descriptions, 2);
			qPos.add(sponsors, 2);
			qPos.add(components, 2);
          	
			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public int countBySD_D_S_C_S(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component, int state, boolean andOperator)
		throws SystemException {
		
		Timestamp startDateGT_TS = CalendarUtil.getTimestamp(startDateGT);
		Timestamp startDateLT_TS = CalendarUtil.getTimestamp(startDateLT);
		String[] descriptions = new String[] {description};
		String[] sponsors = new String[] {sponsor};
		String[] components = new String[] {component};
		descriptions = CustomSQLUtil.keywords(descriptions, false);
		sponsors = CustomSQLUtil.keywords(sponsors, false);
		components = CustomSQLUtil.keywords(components, false);
		
		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(COUNT_BY_SD_D_S_C_S);

			sql = CustomSQLUtil.replaceKeywords(
					sql, "description", StringPool.LIKE, false, descriptions);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "sponsor", StringPool.LIKE, false, sponsors);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "component", StringPool.LIKE, false, components);
          	
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			
          	SQLQuery q = session.createSQLQuery(sql);

          	q.addScalar(COUNT_COLUMN_NAME, Type.LONG);
			
          	QueryPos qPos = QueryPos.getInstance(q);
          	
          	qPos.add(startDateGT_TS);
			qPos.add(startDateGT_TS);
			qPos.add(startDateLT_TS);
			qPos.add(startDateLT_TS);
			qPos.add(descriptions, 2);
			qPos.add(sponsors, 2);
			qPos.add(components, 2);
			qPos.add(state);
			
			Iterator<Long> itr = q.list().iterator();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public List<CalEvent> findBySD_D_S_C(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component,
			boolean andOperator, int begin, int end, OrderByComparator obc)
		throws SystemException {
		
		Timestamp startDateGT_TS = CalendarUtil.getTimestamp(startDateGT);
		Timestamp startDateLT_TS = CalendarUtil.getTimestamp(startDateLT);
		String[] descriptions = new String[] {description};
		String[] sponsors = new String[] {sponsor};
		String[] components = new String[] {component};
		descriptions = CustomSQLUtil.keywords(descriptions, false);
		sponsors = CustomSQLUtil.keywords(sponsors, false);
		components = CustomSQLUtil.keywords(components, false);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_SD_D_S_C);
			
			sql = CustomSQLUtil.replaceKeywords(
					sql, "description", StringPool.LIKE, false, descriptions);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "sponsor", StringPool.LIKE, false, sponsors);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "component", StringPool.LIKE, false, components);
          	
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
          	SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("CalEvent", CalEventImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
          	
          	qPos.add(startDateGT_TS);
			qPos.add(startDateGT_TS);
			qPos.add(startDateLT_TS);
			qPos.add(startDateLT_TS);
          	qPos.add(descriptions, 2);
			qPos.add(sponsors, 2);
			qPos.add(components, 2);
			
			 List list1= QueryUtil.list(q, getDialect(),begin, end);
			 return list1;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public List<CalEvent> findBySD_D_S_C_S(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component, int state,
			boolean andOperator, int begin, int end, OrderByComparator obc)
		throws SystemException {
		
		Timestamp startDateGT_TS = CalendarUtil.getTimestamp(startDateGT);
		Timestamp startDateLT_TS = CalendarUtil.getTimestamp(startDateLT);
		String[] descriptions = new String[] {description};
		String[] sponsors = new String[] {sponsor};
		String[] components = new String[] {component};
		descriptions = CustomSQLUtil.keywords(descriptions, false);
		sponsors = CustomSQLUtil.keywords(sponsors, false);
		components = CustomSQLUtil.keywords(components, false);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_SD_D_S_C_S);
			
			sql = CustomSQLUtil.replaceKeywords(
					sql, "description", StringPool.LIKE, false, descriptions);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "sponsor", StringPool.LIKE, false, sponsors);
			sql = CustomSQLUtil.replaceKeywords(
					sql, "component", StringPool.LIKE, false, components);
          	
			sql = CustomSQLUtil.replaceAndOperator(sql, andOperator);
			sql = CustomSQLUtil.replaceOrderBy(sql, obc);
			
          	SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("CalEvent", CalEventImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(q);
          	
          	qPos.add(startDateGT_TS);
			qPos.add(startDateGT_TS);
			qPos.add(startDateLT_TS);
			qPos.add(startDateLT_TS);
          	qPos.add(descriptions, 2);
			qPos.add(sponsors, 2);
			qPos.add(components, 2);
			qPos.add(state);
			
			 List list1= QueryUtil.list(q, getDialect(),begin, end);
			 return list1;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
	
	public List<MeetingCalendar> findByG_SD(
			long groupId, Date startDateGT, Date startDateLT, String eventType)
		throws SystemException {

		Timestamp startDateGT_TS = CalendarUtil.getTimestamp(startDateGT);
		Timestamp startDateLT_TS = CalendarUtil.getTimestamp(startDateLT);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_G_SD);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("MeetingCalendar", MeetingCalendarImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(groupId);
			qPos.add(startDateGT_TS);
			qPos.add(startDateLT_TS);
			qPos.add(eventType);

			return q.list();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}