package com.sgs.portlet.position.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PositionServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.position.service.PositionService</code>.
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
 * @see com.sgs.portlet.position.service.PositionService
 * @see com.sgs.portlet.position.service.PositionServiceUtil
 *
 */
public class PositionServiceFactory {
    private static final String _FACTORY = PositionServiceFactory.class.getName();
    private static final String _IMPL = PositionService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PositionService.class.getName() +
        ".transaction";
    private static PositionServiceFactory _factory;
    private static PositionService _impl;
    private static PositionService _txImpl;
    private PositionService _service;

    /**
     * @deprecated
     */
    public static PositionService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PositionService getImpl() {
        if (_impl == null) {
            _impl = (PositionService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PositionService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PositionService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PositionService service) {
        _service = service;
    }

    private static PositionServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PositionServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
