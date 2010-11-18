package com.ext.portlet.meetingcalendar.service.permission;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil;
/**
 * <a href="CalEventPermission.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class MeetingCalendarPermission {

	public static void check(
			PermissionChecker permissionChecker, long mcalId, String actionId)
		throws PortalException, SystemException {

		if (!contains(permissionChecker, mcalId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, MeetingCalendar mCal,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, mCal, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long mcalId, String actionId)
		throws PortalException, SystemException {

		MeetingCalendar mCal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(mcalId);

		return contains(permissionChecker, mCal, actionId);
	}

	public static boolean contains(
		PermissionChecker permissionChecker, MeetingCalendar mCal, String actionId) {
		return permissionChecker.hasPermission(
			mCal.getGroupId(),MeetingCalendar.class.getName(), mCal.getMcalId(),
			actionId);
	}

}