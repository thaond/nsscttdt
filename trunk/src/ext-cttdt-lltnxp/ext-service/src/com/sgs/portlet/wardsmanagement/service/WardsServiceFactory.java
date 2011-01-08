package com.sgs.portlet.wardsmanagement.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="WardsServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.wardsmanagement.service.WardsService</code>.
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
 * @see com.sgs.portlet.wardsmanagement.service.WardsService
 * @see com.sgs.portlet.wardsmanagement.service.WardsServiceUtil
 *
 */
public class WardsServiceFactory {
    private static final String _FACTORY = WardsServiceFactory.class.getName();
    private static final String _IMPL = WardsService.class.getName() + ".impl";
    private static final String _TX_IMPL = WardsService.class.getName() +
        ".transaction";
    private static WardsServiceFactory _factory;
    private static WardsService _impl;
    private static WardsService _txImpl;
    private WardsService _service;

    /**
     * @deprecated
     */
    public static WardsService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static WardsService getImpl() {
        if (_impl == null) {
            _impl = (WardsService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static WardsService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (WardsService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(WardsService service) {
        _service = service;
    }

    private static WardsServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (WardsServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
