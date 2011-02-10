
package com.ext.portlet.meetingcalendar.service.impl;

import java.util.List;

import com.ext.portlet.meetingcalendar.model.RoomResource;
import com.ext.portlet.meetingcalendar.service.base.RoomResourceServiceBaseImpl;
import com.ext.portlet.meetingcalendar.util.CalendarKeys;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.permission.PortletPermissionUtil;

public class RoomResourceServiceImpl extends RoomResourceServiceBaseImpl {

	public RoomResource updateResource(
		int roomId, String roomName, String description)
		throws PortalException, SystemException {

		PortletPermissionUtil.check(
			getPermissionChecker(), CalendarKeys.PORTLET_ID,
			CalendarKeys.UPDATE);

		User user = getUser();

		return roomResourceLocalService.updateRoomResource(
			roomId, user.getCompanyId(), user.getUserId(), roomName,
			description);
	}

	public List<RoomResource> getRoomResources()
		throws PortalException, SystemException {

		PortletPermissionUtil.check(
			getPermissionChecker(), CalendarKeys.PORTLET_ID, CalendarKeys.VIEW);

		User user = getUser();

		return roomResourcePersistence.findByCompanyId(user.getCompanyId());
	}

	public void deleteRoomResource(long roomId)
		throws PortalException, SystemException {

		PortletPermissionUtil.check(
			getPermissionChecker(), CalendarKeys.PORTLET_ID,
			CalendarKeys.DELETE);
		roomResourceLocalService.deleteRoomResource(roomId);
	}
}
