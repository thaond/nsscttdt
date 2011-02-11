package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlScreenCalendarHeightServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightService
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightServiceUtil
 *
 */
public class PmlScreenCalendarHeightServiceFactory {
    private static final String _FACTORY = PmlScreenCalendarHeightServiceFactory.class.getName();
    private static final String _IMPL = PmlScreenCalendarHeightService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlScreenCalendarHeightService.class.getName() +
        ".transaction";
    private static PmlScreenCalendarHeightServiceFactory _factory;
    private static PmlScreenCalendarHeightService _impl;
    private static PmlScreenCalendarHeightService _txImpl;
    private PmlScreenCalendarHeightService _service;

    /**
     * @deprecated
     */
    public static PmlScreenCalendarHeightService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlScreenCalendarHeightService getImpl() {
        if (_impl == null) {
            _impl = (PmlScreenCalendarHeightService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlScreenCalendarHeightService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlScreenCalendarHeightService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlScreenCalendarHeightService service) {
        _service = service;
    }

    private static PmlScreenCalendarHeightServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlScreenCalendarHeightServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
