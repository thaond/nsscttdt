package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlProcessDisposeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlProcessDisposeService</code>.
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
 * @see com.sgs.portlet.document.service.PmlProcessDisposeService
 * @see com.sgs.portlet.document.service.PmlProcessDisposeServiceUtil
 *
 */
public class PmlProcessDisposeServiceFactory {
    private static final String _FACTORY = PmlProcessDisposeServiceFactory.class.getName();
    private static final String _IMPL = PmlProcessDisposeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlProcessDisposeService.class.getName() +
        ".transaction";
    private static PmlProcessDisposeServiceFactory _factory;
    private static PmlProcessDisposeService _impl;
    private static PmlProcessDisposeService _txImpl;
    private PmlProcessDisposeService _service;

    /**
     * @deprecated
     */
    public static PmlProcessDisposeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlProcessDisposeService getImpl() {
        if (_impl == null) {
            _impl = (PmlProcessDisposeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlProcessDisposeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlProcessDisposeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlProcessDisposeService service) {
        _service = service;
    }

    private static PmlProcessDisposeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlProcessDisposeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
