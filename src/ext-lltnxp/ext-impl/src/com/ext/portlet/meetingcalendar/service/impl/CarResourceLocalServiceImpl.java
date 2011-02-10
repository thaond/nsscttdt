
package com.ext.portlet.meetingcalendar.service.impl;

import java.util.Date;

import com.ext.portlet.meetingcalendar.model.CarResource;
import com.ext.portlet.meetingcalendar.service.base.CarResourceLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.Validator;

public class CarResourceLocalServiceImpl
	extends CarResourceLocalServiceBaseImpl {

	public CarResource updateCarResource(
		long carId, long companyId, long userId, String carCode,
		String carName, String description)
		throws SystemException, PortalException {

		CarResource carResource;
		Date now = new Date();
		if (carId > 0) {
			carResource = carResourcePersistence.findByPrimaryKey(carId);
		}
		else {
			carResource = carResourcePersistence.fetchByC_C(carCode, companyId);
			if (carResource != null) {
				throw new PortalException("car-code-existed");
			}
			carResource =
				carResourcePersistence.create(CounterLocalServiceUtil.increment(CarResource.class.getName()));
			carResource.setCompanyId(companyId);
			carResource.setUserId(userId);
			carResource.setCreateDate(now);
		}

		carResource.setModifiedDate(now);
		if (Validator.isNotNull(carCode)) {
			CarResource temp =
				carResourcePersistence.fetchByC_C(carCode, companyId);
			if ((temp != null) && (temp.getCarId() != carId)) {
				throw new PortalException("car-code-existed");
			}
			carResource.setCarCode(carCode);
		}
		if (Validator.isNotNull(carName)) {
			carResource.setCarName(carName);
		}
		if (Validator.isNotNull(description)) {
			carResource.setDescription(description);
		}

		return carResourcePersistence.update(carResource, false);
	}
}
