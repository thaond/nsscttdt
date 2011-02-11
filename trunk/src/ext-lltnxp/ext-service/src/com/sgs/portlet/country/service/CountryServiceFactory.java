package com.sgs.portlet.country.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="CountryServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.country.service.CountryService</code>.
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
 * @see com.sgs.portlet.country.service.CountryService
 * @see com.sgs.portlet.country.service.CountryServiceUtil
 *
 */
public class CountryServiceFactory {
    private static final String _FACTORY = CountryServiceFactory.class.getName();
    private static final String _IMPL = CountryService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = CountryService.class.getName() +
        ".transaction";
    private static CountryServiceFactory _factory;
    private static CountryService _impl;
    private static CountryService _txImpl;
    private CountryService _service;

    /**
     * @deprecated
     */
    public static CountryService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static CountryService getImpl() {
        if (_impl == null) {
            _impl = (CountryService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static CountryService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (CountryService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(CountryService service) {
        _service = service;
    }

    private static CountryServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (CountryServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
