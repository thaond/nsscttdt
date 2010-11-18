package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MeetingCalComponentLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.meetingcalendar.service.impl.MeetingCalComponentLocalServiceImpl</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MeetingCalComponentLocalService {
    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent addMeetingCalComponent(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent createMeetingCalComponent(
        long mcalId);

    public void deleteMeetingCalComponent(long mcalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMeetingCalComponent(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent getMeetingCalComponent(
        long mcalId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> getMeetingCalComponents(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMeetingCalComponentsCount()
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent updateMeetingCalComponent(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent)
        throws com.liferay.portal.SystemException;

    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent updateMeetingCalComponent(
        com.ext.portlet.meetingcalendar.model.MeetingCalComponent meetingCalComponent,
        boolean merge) throws com.liferay.portal.SystemException;

    public void addMCalComponent(long mcalId, java.lang.String[] orgIds,
        java.util.Date startDate)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void updateMCalComponent(long mcalId, java.lang.String[] orgIds,
        java.util.Date startDate)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteMCalComponent(long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.ext.portlet.meetingcalendar.model.MeetingCalComponent getBymcalId(
        long mcalId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> getByG_SD(
        long groupId, java.util.Calendar cal)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
