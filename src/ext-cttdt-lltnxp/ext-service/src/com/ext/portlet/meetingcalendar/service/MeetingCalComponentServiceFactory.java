package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="MeetingCalComponentServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.MeetingCalComponentService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalComponentService
 * @see com.ext.portlet.meetingcalendar.service.MeetingCalComponentServiceUtil
 *
 */
public class MeetingCalComponentServiceFactory {
    private static final String _FACTORY = MeetingCalComponentServiceFactory.class.getName();
    private static final String _IMPL = MeetingCalComponentService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = MeetingCalComponentService.class.getName() +
        ".transaction";
    private static MeetingCalComponentServiceFactory _factory;
    private static MeetingCalComponentService _impl;
    private static MeetingCalComponentService _txImpl;
    private MeetingCalComponentService _service;

    /**
     * @deprecated
     */
    public static MeetingCalComponentService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static MeetingCalComponentService getImpl() {
        if (_impl == null) {
            _impl = (MeetingCalComponentService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static MeetingCalComponentService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (MeetingCalComponentService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(MeetingCalComponentService service) {
        _service = service;
    }

    private static MeetingCalComponentServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (MeetingCalComponentServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
