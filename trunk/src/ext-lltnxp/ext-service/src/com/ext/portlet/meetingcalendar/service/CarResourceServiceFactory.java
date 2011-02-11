package com.ext.portlet.meetingcalendar.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="CarResourceServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.meetingcalendar.service.CarResourceService</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.CarResourceService
 * @see com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil
 *
 */
public class CarResourceServiceFactory {
    private static final String _FACTORY = CarResourceServiceFactory.class.getName();
    private static final String _IMPL = CarResourceService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = CarResourceService.class.getName() +
        ".transaction";
    private static CarResourceServiceFactory _factory;
    private static CarResourceService _impl;
    private static CarResourceService _txImpl;
    private CarResourceService _service;

    /**
     * @deprecated
     */
    public static CarResourceService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static CarResourceService getImpl() {
        if (_impl == null) {
            _impl = (CarResourceService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static CarResourceService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (CarResourceService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(CarResourceService service) {
        _service = service;
    }

    private static CarResourceServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (CarResourceServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
