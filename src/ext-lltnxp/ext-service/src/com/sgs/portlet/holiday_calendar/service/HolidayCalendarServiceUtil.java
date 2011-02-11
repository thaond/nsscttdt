package com.sgs.portlet.holiday_calendar.service;


/**
 * <a href="HolidayCalendarServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.holiday_calendar.service.HolidayCalendarService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.HolidayCalendarService
 *
 */
public class HolidayCalendarServiceUtil {
    private static HolidayCalendarService _service;

    public static HolidayCalendarService getService() {
        if (_service == null) {
            throw new RuntimeException("HolidayCalendarService is not set");
        }

        return _service;
    }

    public void setService(HolidayCalendarService service) {
        _service = service;
    }
}
