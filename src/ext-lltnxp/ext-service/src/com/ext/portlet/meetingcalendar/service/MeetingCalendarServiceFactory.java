package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="MeetingCalendarServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalendarService</code>.
 * Spring manages the lookup and lifecycle of the beans. This means you can
 * modify the Spring configuration files to return a different implementation or
 * to inject additional behavior.
 * </p>
 *
 * <p>
 * See the <code>spring.configs</code> property in portal.properties for
 * additional information on how to customize the Spring XML files.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarService
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarServiceUtil
 *
 */
public class MeetingCalendarServiceFactory {
    private static final String _FACTORY = MeetingCalendarServiceFactory.class.getName();
    private static final String _IMPL = MeetingCalendarService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = MeetingCalendarService.class.getName() +
        ".transaction";
    private static MeetingCalendarServiceFactory _factory;
    private static MeetingCalendarService _impl;
    private static MeetingCalendarService _txImpl;
    private MeetingCalendarService _service;

    /**
     * @deprecated
     */
    public static MeetingCalendarService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static MeetingCalendarService getImpl() {
        if (_impl == null) {
            _impl = (MeetingCalendarService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static MeetingCalendarService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (MeetingCalendarService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(MeetingCalendarService service) {
        _service = service;
    }

    private static MeetingCalendarServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (MeetingCalendarServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
