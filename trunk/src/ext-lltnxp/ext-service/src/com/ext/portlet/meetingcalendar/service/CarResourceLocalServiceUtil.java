package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="CarResourceLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.CarResourceLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.CarResourceLocalService
 *
 */
public class CarResourceLocalServiceUtil {
    private static CarResourceLocalService _service;

    public static com.ext.portlet.meetingcalendar.model.CarResource addCarResource(
        com.ext.portlet.meetingcalendar.model.CarResource carResource)
        throws com.liferay.portal.SystemException {
        return getService().addCarResource(carResource);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource createCarResource(
        long carId) {
        return getService().createCarResource(carId);
    }

    public static void deleteCarResource(long carId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteCarResource(carId);
    }

    public static void deleteCarResource(
        com.ext.portlet.meetingcalendar.model.CarResource carResource)
        throws com.liferay.portal.SystemException {
        getService().deleteCarResource(carResource);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource getCarResource(
        long carId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCarResource(carId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> getCarResources(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getCarResources(start, end);
    }

    public static int getCarResourcesCount()
        throws com.liferay.portal.SystemException {
        return getService().getCarResourcesCount();
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource updateCarResource(
        com.ext.portlet.meetingcalendar.model.CarResource carResource)
        throws com.liferay.portal.SystemException {
        return getService().updateCarResource(carResource);
    }

    public static com.ext.portlet.meetingcalendar.model.CarResource updateCarResource(
        long carId, long companyId, long userId, java.lang.String carCode,
        java.lang.String carName, java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateCarResource(carId, companyId, userId, carCode,
            carName, description);
    }

    public static CarResourceLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("CarResourceLocalService is not set");
        }

        return _service;
    }

    public void setService(CarResourceLocalService service) {
        _service = service;
    }
}
