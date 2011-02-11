package com.sgs.portlet.holiday_calendar.service;


/**
 * <a href="AttactFileHolidayLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalService
 *
 */
public class AttactFileHolidayLocalServiceUtil {
    private static AttactFileHolidayLocalService _service;

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday addAttactFileHoliday(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException {
        return getService().addAttactFileHoliday(attactFileHoliday);
    }

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday createAttactFileHoliday(
        long attactFileHolidayId) {
        return getService().createAttactFileHoliday(attactFileHolidayId);
    }

    public static void deleteAttactFileHoliday(long attactFileHolidayId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteAttactFileHoliday(attactFileHolidayId);
    }

    public static void deleteAttactFileHoliday(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException {
        getService().deleteAttactFileHoliday(attactFileHoliday);
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

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday getAttactFileHoliday(
        long attactFileHolidayId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getAttactFileHoliday(attactFileHolidayId);
    }

    public static java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getAttactFileHolidaies(start, end);
    }

    public static int getAttactFileHolidaiesCount()
        throws com.liferay.portal.SystemException {
        return getService().getAttactFileHolidaiesCount();
    }

    public static com.sgs.portlet.holiday_calendar.model.AttactFileHoliday updateAttactFileHoliday(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException {
        return getService().updateAttactFileHoliday(attactFileHoliday);
    }

    public static AttactFileHolidayLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "AttactFileHolidayLocalService is not set");
        }

        return _service;
    }

    public void setService(AttactFileHolidayLocalService service) {
        _service = service;
    }
}
