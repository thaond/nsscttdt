package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="PmlScreenCalendarHeightLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalService
 *
 */
public class PmlScreenCalendarHeightLocalServiceUtil {
    private static PmlScreenCalendarHeightLocalService _service;

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight addPmlScreenCalendarHeight(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException {
        return getService().addPmlScreenCalendarHeight(pmlScreenCalendarHeight);
    }

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight createPmlScreenCalendarHeight(
        long screenCalendarHeightId) {
        return getService().createPmlScreenCalendarHeight(screenCalendarHeightId);
    }

    public static void deletePmlScreenCalendarHeight(
        long screenCalendarHeightId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlScreenCalendarHeight(screenCalendarHeightId);
    }

    public static void deletePmlScreenCalendarHeight(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException {
        getService().deletePmlScreenCalendarHeight(pmlScreenCalendarHeight);
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

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight getPmlScreenCalendarHeight(
        long screenCalendarHeightId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlScreenCalendarHeight(screenCalendarHeightId);
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> getPmlScreenCalendarHeights(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlScreenCalendarHeights(start, end);
    }

    public static int getPmlScreenCalendarHeightsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlScreenCalendarHeightsCount();
    }

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight updatePmlScreenCalendarHeight(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlScreenCalendarHeight(pmlScreenCalendarHeight);
    }

    public static PmlScreenCalendarHeightLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlScreenCalendarHeightLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlScreenCalendarHeightLocalService service) {
        _service = service;
    }
}
