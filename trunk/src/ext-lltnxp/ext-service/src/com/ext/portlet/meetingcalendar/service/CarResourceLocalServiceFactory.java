package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="CarResourceLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.CarResourceLocalService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.CarResourceLocalService
 * @see com.ext.portlet.meetingcalendar.service.CarResourceLocalServiceUtil
 *
 */
public class CarResourceLocalServiceFactory {
    private static final String _FACTORY = CarResourceLocalServiceFactory.class.getName();
    private static final String _IMPL = CarResourceLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = CarResourceLocalService.class.getName() +
        ".transaction";
    private static CarResourceLocalServiceFactory _factory;
    private static CarResourceLocalService _impl;
    private static CarResourceLocalService _txImpl;
    private CarResourceLocalService _service;

    /**
     * @deprecated
     */
    public static CarResourceLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static CarResourceLocalService getImpl() {
        if (_impl == null) {
            _impl = (CarResourceLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static CarResourceLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (CarResourceLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(CarResourceLocalService service) {
        _service = service;
    }

    private static CarResourceLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (CarResourceLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
