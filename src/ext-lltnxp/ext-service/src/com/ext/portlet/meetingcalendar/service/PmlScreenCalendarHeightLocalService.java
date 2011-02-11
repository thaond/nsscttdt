package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="PmlScreenCalendarHeightLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.meetingcalendar.service.impl.PmlScreenCalendarHeightLocalServiceImpl</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightLocalServiceUtil
 *
 */
public interface PmlScreenCalendarHeightLocalService {
    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight addPmlScreenCalendarHeight(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight createPmlScreenCalendarHeight(
        long screenCalendarHeightId);

    public void deletePmlScreenCalendarHeight(long screenCalendarHeightId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlScreenCalendarHeight(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight getPmlScreenCalendarHeight(
        long screenCalendarHeightId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> getPmlScreenCalendarHeights(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlScreenCalendarHeightsCount()
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight updatePmlScreenCalendarHeight(
        com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight pmlScreenCalendarHeight)
        throws com.liferay.portal.SystemException;
}
