package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="MeetingCalendarLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalService
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil
 *
 */
public class MeetingCalendarLocalServiceFactory {
    private static final String _FACTORY = MeetingCalendarLocalServiceFactory.class.getName();
    private static final String _IMPL = MeetingCalendarLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = MeetingCalendarLocalService.class.getName() +
        ".transaction";
    private static MeetingCalendarLocalServiceFactory _factory;
    private static MeetingCalendarLocalService _impl;
    private static MeetingCalendarLocalService _txImpl;
    private MeetingCalendarLocalService _service;

    /**
     * @deprecated
     */
    public static MeetingCalendarLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static MeetingCalendarLocalService getImpl() {
        if (_impl == null) {
            _impl = (MeetingCalendarLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static MeetingCalendarLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (MeetingCalendarLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(MeetingCalendarLocalService service) {
        _service = service;
    }

    private static MeetingCalendarLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (MeetingCalendarLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
