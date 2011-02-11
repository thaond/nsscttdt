package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="RoomResourceLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.RoomResourceLocalService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceLocalService
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceLocalServiceUtil
 *
 */
public class RoomResourceLocalServiceFactory {
    private static final String _FACTORY = RoomResourceLocalServiceFactory.class.getName();
    private static final String _IMPL = RoomResourceLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = RoomResourceLocalService.class.getName() +
        ".transaction";
    private static RoomResourceLocalServiceFactory _factory;
    private static RoomResourceLocalService _impl;
    private static RoomResourceLocalService _txImpl;
    private RoomResourceLocalService _service;

    /**
     * @deprecated
     */
    public static RoomResourceLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static RoomResourceLocalService getImpl() {
        if (_impl == null) {
            _impl = (RoomResourceLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static RoomResourceLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (RoomResourceLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(RoomResourceLocalService service) {
        _service = service;
    }

    private static RoomResourceLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (RoomResourceLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
