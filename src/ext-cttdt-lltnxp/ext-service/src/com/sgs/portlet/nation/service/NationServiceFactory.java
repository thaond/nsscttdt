package com.sgs.portlet.nation.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="NationServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.nation.service.NationService</code>.
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
 * @see com.sgs.portlet.nation.service.NationService
 * @see com.sgs.portlet.nation.service.NationServiceUtil
 *
 */
public class NationServiceFactory {
    private static final String _FACTORY = NationServiceFactory.class.getName();
    private static final String _IMPL = NationService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = NationService.class.getName() +
        ".transaction";
    private static NationServiceFactory _factory;
    private static NationService _impl;
    private static NationService _txImpl;
    private NationService _service;

    /**
     * @deprecated
     */
    public static NationService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static NationService getImpl() {
        if (_impl == null) {
            _impl = (NationService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static NationService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (NationService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(NationService service) {
        _service = service;
    }

    private static NationServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (NationServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
