package com.sgs.portlet.agency.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="AgencyServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.agency.service.AgencyService</code>.
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
 * @see com.sgs.portlet.agency.service.AgencyService
 * @see com.sgs.portlet.agency.service.AgencyServiceUtil
 *
 */
public class AgencyServiceFactory {
    private static final String _FACTORY = AgencyServiceFactory.class.getName();
    private static final String _IMPL = AgencyService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = AgencyService.class.getName() +
        ".transaction";
    private static AgencyServiceFactory _factory;
    private static AgencyService _impl;
    private static AgencyService _txImpl;
    private AgencyService _service;

    /**
     * @deprecated
     */
    public static AgencyService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static AgencyService getImpl() {
        if (_impl == null) {
            _impl = (AgencyService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static AgencyService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (AgencyService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(AgencyService service) {
        _service = service;
    }

    private static AgencyServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (AgencyServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
