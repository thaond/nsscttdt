package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="CarResourceServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.CarResourceService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.CarResourceService
 *
 */
public class CarResourceServiceUtil {
    private static CarResourceService _service;

    public static com.ext.portlet.meetingcalendar.model.CarResource updateCarResource(
        long carId, java.lang.String carCode, java.lang.String carName,
        java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService()
                   .updateCarResource(carId, carCode, carName, description);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> getCarResources()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().getCarResources();
    }

    public static void deleteCarResource(long carId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        getService().deleteCarResource(carId);
    }

    public static CarResourceService getService() {
        if (_service == null) {
            throw new RuntimeException("CarResourceService is not set");
        }

        return _service;
    }

    public void setService(CarResourceService service) {
        _service = service;
    }
}
