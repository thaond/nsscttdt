package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTransitionServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlTransitionService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlTransitionService
 * @see com.sgs.portlet.onedoorpccc.service.PmlTransitionServiceUtil
 *
 */
public class PmlTransitionServiceFactory {
    private static final String _FACTORY = PmlTransitionServiceFactory.class.getName();
    private static final String _IMPL = PmlTransitionService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTransitionService.class.getName() +
        ".transaction";
    private static PmlTransitionServiceFactory _factory;
    private static PmlTransitionService _impl;
    private static PmlTransitionService _txImpl;
    private PmlTransitionService _service;

    /**
     * @deprecated
     */
    public static PmlTransitionService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTransitionService getImpl() {
        if (_impl == null) {
            _impl = (PmlTransitionService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTransitionService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTransitionService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTransitionService service) {
        _service = service;
    }

    private static PmlTransitionServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTransitionServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
