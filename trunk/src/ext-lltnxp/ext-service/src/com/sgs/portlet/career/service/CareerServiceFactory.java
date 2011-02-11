package com.sgs.portlet.career.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="CareerServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.career.service.CareerService</code>.
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
 * @see com.sgs.portlet.career.service.CareerService
 * @see com.sgs.portlet.career.service.CareerServiceUtil
 *
 */
public class CareerServiceFactory {
    private static final String _FACTORY = CareerServiceFactory.class.getName();
    private static final String _IMPL = CareerService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = CareerService.class.getName() +
        ".transaction";
    private static CareerServiceFactory _factory;
    private static CareerService _impl;
    private static CareerService _txImpl;
    private CareerService _service;

    /**
     * @deprecated
     */
    public static CareerService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static CareerService getImpl() {
        if (_impl == null) {
            _impl = (CareerService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static CareerService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (CareerService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(CareerService service) {
        _service = service;
    }

    private static CareerServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (CareerServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
