
package com.ext.portlet.meetingcalendar.service.impl;

import java.util.List;

import com.ext.portlet.meetingcalendar.model.CarResource;
import com.ext.portlet.meetingcalendar.service.base.CarResourceServiceBaseImpl;
import com.ext.portlet.meetingcalendar.util.CalendarKeys;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.permission.PortletPermissionUtil;

public class CarResourceServiceImpl extends CarResourceServiceBaseImpl {

	public CarResource updateCarResource(
		long carId, String carCode, String carName, String description)
		throws PortalException, SystemException {

		PortletPermissionUtil.check(
			getPermissionChecker(), CalendarKeys.PORTLET_ID,
			CalendarKeys.UPDATE);

		User user = getUser();

		return carResourceLocalService.updateCarResource(
			carId, user.getCompanyId(), user.getUserId(), carCode, carName,
			description);
	}

	public List<CarResource> getCarResources()
		throws PortalException, SystemException {

		PortletPermissionUtil.check(
			getPermissionChecker(), CalendarKeys.PORTLET_ID, CalendarKeys.VIEW);

		User user = getUser();

		return carResourcePersistence.findByCompanyId(user.getCompanyId());
	}

	public void deleteCarResource(long carId)
		throws PortalException, SystemException {

		PortletPermissionUtil.check(
			getPermissionChecker(), CalendarKeys.PORTLET_ID,
			CalendarKeys.DELETE);

		carResourceLocalService.deleteCarResource(carId);
	}
}
