package com.sgs.portlet.holiday_calendar.service;


/**
 * <a href="AttactFileHolidayLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.holiday_calendar.service.impl.AttactFileHolidayLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.AttactFileHolidayLocalServiceUtil
 *
 */
public interface AttactFileHolidayLocalService {
    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday addAttactFileHoliday(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday createAttactFileHoliday(
        long attactFileHolidayId);

    public void deleteAttactFileHoliday(long attactFileHolidayId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteAttactFileHoliday(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday getAttactFileHoliday(
        long attactFileHolidayId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> getAttactFileHolidaies(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getAttactFileHolidaiesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.holiday_calendar.model.AttactFileHoliday updateAttactFileHoliday(
        com.sgs.portlet.holiday_calendar.model.AttactFileHoliday attactFileHoliday)
        throws com.liferay.portal.SystemException;
}
