package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlProcessDisposeLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlProcessDisposeLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlProcessDisposeLocalService
 * @see com.sgs.portlet.document.service.PmlProcessDisposeLocalServiceUtil
 *
 */
public class PmlProcessDisposeLocalServiceFactory {
    private static final String _FACTORY = PmlProcessDisposeLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlProcessDisposeLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlProcessDisposeLocalService.class.getName() +
        ".transaction";
    private static PmlProcessDisposeLocalServiceFactory _factory;
    private static PmlProcessDisposeLocalService _impl;
    private static PmlProcessDisposeLocalService _txImpl;
    private PmlProcessDisposeLocalService _service;

    /**
     * @deprecated
     */
    public static PmlProcessDisposeLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlProcessDisposeLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlProcessDisposeLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlProcessDisposeLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlProcessDisposeLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlProcessDisposeLocalService service) {
        _service = service;
    }

    private static PmlProcessDisposeLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlProcessDisposeLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
