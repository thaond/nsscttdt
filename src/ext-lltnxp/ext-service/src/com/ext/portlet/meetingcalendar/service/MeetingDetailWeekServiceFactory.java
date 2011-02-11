package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="MeetingDetailWeekServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.MeetingDetailWeekService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.MeetingDetailWeekService
 * @see com.ext.portlet.meetingcalendar.service.MeetingDetailWeekServiceUtil
 *
 */
public class MeetingDetailWeekServiceFactory {
    private static final String _FACTORY = MeetingDetailWeekServiceFactory.class.getName();
    private static final String _IMPL = MeetingDetailWeekService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = MeetingDetailWeekService.class.getName() +
        ".transaction";
    private static MeetingDetailWeekServiceFactory _factory;
    private static MeetingDetailWeekService _impl;
    private static MeetingDetailWeekService _txImpl;
    private MeetingDetailWeekService _service;

    /**
     * @deprecated
     */
    public static MeetingDetailWeekService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static MeetingDetailWeekService getImpl() {
        if (_impl == null) {
            _impl = (MeetingDetailWeekService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static MeetingDetailWeekService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (MeetingDetailWeekService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(MeetingDetailWeekService service) {
        _service = service;
    }

    private static MeetingDetailWeekServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (MeetingDetailWeekServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
