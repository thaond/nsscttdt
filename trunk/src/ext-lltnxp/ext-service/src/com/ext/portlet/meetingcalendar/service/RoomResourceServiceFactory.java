package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="RoomResourceServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.RoomResourceService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceService
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil
 *
 */
public class RoomResourceServiceFactory {
    private static final String _FACTORY = RoomResourceServiceFactory.class.getName();
    private static final String _IMPL = RoomResourceService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = RoomResourceService.class.getName() +
        ".transaction";
    private static RoomResourceServiceFactory _factory;
    private static RoomResourceService _impl;
    private static RoomResourceService _txImpl;
    private RoomResourceService _service;

    /**
     * @deprecated
     */
    public static RoomResourceService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static RoomResourceService getImpl() {
        if (_impl == null) {
            _impl = (RoomResourceService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static RoomResourceService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (RoomResourceService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(RoomResourceService service) {
        _service = service;
    }

    private static RoomResourceServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (RoomResourceServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
