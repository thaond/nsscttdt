package com.sgs.portlet.citymanagement.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="CityServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.citymanagement.service.CityService</code>.
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
 * @see com.sgs.portlet.citymanagement.service.CityService
 * @see com.sgs.portlet.citymanagement.service.CityServiceUtil
 *
 */
public class CityServiceFactory {
    private static final String _FACTORY = CityServiceFactory.class.getName();
    private static final String _IMPL = CityService.class.getName() + ".impl";
    private static final String _TX_IMPL = CityService.class.getName() +
        ".transaction";
    private static CityServiceFactory _factory;
    private static CityService _impl;
    private static CityService _txImpl;
    private CityService _service;

    /**
     * @deprecated
     */
    public static CityService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static CityService getImpl() {
        if (_impl == null) {
            _impl = (CityService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static CityService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (CityService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(CityService service) {
        _service = service;
    }

    private static CityServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (CityServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
