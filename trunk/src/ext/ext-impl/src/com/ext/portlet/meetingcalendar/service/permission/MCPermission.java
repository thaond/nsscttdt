package com.ext.portlet.meetingcalendar.service.permission;

import com.liferay.portal.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * <a href="CalEventPermission.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class MCPermission {

	public static void check(
			PermissionChecker permissionChecker, long groupId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
		PermissionChecker permissionChecker, long groupId, String actionId) {

		return permissionChecker.hasPermission(
			groupId, "com.ext.portlet.meetingcalendar", groupId, actionId);
	}
	
}