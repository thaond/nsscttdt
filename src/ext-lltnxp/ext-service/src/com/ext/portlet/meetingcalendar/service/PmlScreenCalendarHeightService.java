package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="PmlScreenCalendarHeightService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.ext.portlet.meetingcalendar.service.impl.PmlScreenCalendarHeightServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightServiceUtil
 *
 */
public interface PmlScreenCalendarHeightService {
    public com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight getScreenCalendarHeigth()
        throws java.rmi.RemoteException;
}