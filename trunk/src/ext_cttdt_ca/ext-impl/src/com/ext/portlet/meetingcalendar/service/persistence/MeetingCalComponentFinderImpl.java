package com.ext.portlet.meetingcalendar.service.persistence;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
import com.ext.portlet.meetingcalendar.model.impl.MeetingCalComponentImpl;

import java.sql.Timestamp;

import java.util.Date;
import java.util.List;

/**
 * <a href="CalEventFinderImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class MeetingCalComponentFinderImpl
	extends BasePersistenceImpl implements MeetingCalComponentFinder {

	public static String FIND_BY_G_SD =
		MeetingCalComponentFinder.class.getName() + ".findByG_SD";

	public List<MeetingCalComponent> findByG_SD(
			long groupId, Date startDateGT, Date startDateLT)
		throws SystemException {

		Timestamp startDateGT_TS = CalendarUtil.getTimestamp(startDateGT);
		Timestamp startDateLT_TS = CalendarUtil.getTimestamp(startDateLT);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_G_SD);
			String[] strGroupId = CustomSQLUtil.keywords(String.valueOf(groupId));
			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("MeetingCalComponent", MeetingCalComponentImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(strGroupId);
			qPos.add(startDateGT_TS);
			qPos.add(startDateLT_TS);

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