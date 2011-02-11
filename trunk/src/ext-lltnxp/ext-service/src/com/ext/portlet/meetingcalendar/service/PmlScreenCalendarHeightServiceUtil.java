package com.ext.portlet.meetingcalendar.service;


/**
 * <a href="PmlScreenCalendarHeightServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightService
 *
 */
public class PmlScreenCalendarHeightServiceUtil {
    private static PmlScreenCalendarHeightService _service;

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight getScreenCalendarHeigth()
        throws java.rmi.RemoteException {
        return getService().getScreenCalendarHeigth();
    }

    public static PmlScreenCalendarHeightService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlScreenCalendarHeightService is not set");
        }

        return _service;
    }

    public void setService(PmlScreenCalendarHeightService service) {
        _service = service;
    }
}
