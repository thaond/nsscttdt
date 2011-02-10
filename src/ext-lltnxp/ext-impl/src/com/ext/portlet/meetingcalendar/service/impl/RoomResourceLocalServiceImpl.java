
package com.ext.portlet.meetingcalendar.service.impl;

import java.util.Date;

import com.ext.portlet.meetingcalendar.model.RoomResource;
import com.ext.portlet.meetingcalendar.service.base.RoomResourceLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

public class RoomResourceLocalServiceImpl
	extends RoomResourceLocalServiceBaseImpl {

	public RoomResource updateRoomResource(
		int roomId, long companyId, long userId, String roomName,
		String description)
		throws PortalException, SystemException {

		RoomResource roomResource;
		Date now = new Date();
		if (roomId > 0) {
			roomResource = roomResourcePersistence.findByPrimaryKey(roomId);
		}
		else {
			roomResource =
				roomResourcePersistence.fetchByN_C(roomName, companyId);
			if (roomResource != null) {
				throw new PortalException("room-name-existed");
			}
			roomResource =
				roomResourcePersistence.create(CounterLocalServiceUtil.increment(RoomResource.class.getName()));
			roomResource.setCompanyId(companyId);
			roomResource.setUserId(userId);
			roomResource.setCreateDate(now);
		}

		roomResource.setModifiedDate(now);

		RoomResource temp =
			roomResourcePersistence.fetchByN_C(roomName, companyId);
		if ((temp != null) && (temp.getRoomId() != roomId)) {
			throw new PortalException("room-name-existed");
		}

		roomResource.setRoomName(roomName);
		roomResource.setDescription(description);

		return roomResourcePersistence.update(roomResource, false);
	}
}
