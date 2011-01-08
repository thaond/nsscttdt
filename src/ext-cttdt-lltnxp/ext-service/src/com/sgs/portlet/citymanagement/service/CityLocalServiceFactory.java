package com.sgs.portlet.citymanagement.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="CityLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.citymanagement.service.CityLocalService</code>.
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
 * @see com.sgs.portlet.citymanagement.service.CityLocalService
 * @see com.sgs.portlet.citymanagement.service.CityLocalServiceUtil
 *
 */
public class CityLocalServiceFactory {
    private static final String _FACTORY = CityLocalServiceFactory.class.getName();
    private static final String _IMPL = CityLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = CityLocalService.class.getName() +
        ".transaction";
    private static CityLocalServiceFactory _factory;
    private static CityLocalService _impl;
    private static CityLocalService _txImpl;
    private CityLocalService _service;

    /**
     * @deprecated
     */
    public static CityLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static CityLocalService getImpl() {
        if (_impl == null) {
            _impl = (CityLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static CityLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (CityLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(CityLocalService service) {
        _service = service;
    }

    private static CityLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (CityLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
