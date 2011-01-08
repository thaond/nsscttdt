package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlStateProcessLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlStateProcessLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlStateProcessLocalService
 * @see com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil
 *
 */
public class PmlStateProcessLocalServiceFactory {
    private static final String _FACTORY = PmlStateProcessLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlStateProcessLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlStateProcessLocalService.class.getName() +
        ".transaction";
    private static PmlStateProcessLocalServiceFactory _factory;
    private static PmlStateProcessLocalService _impl;
    private static PmlStateProcessLocalService _txImpl;
    private PmlStateProcessLocalService _service;

    /**
     * @deprecated
     */
    public static PmlStateProcessLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlStateProcessLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlStateProcessLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlStateProcessLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlStateProcessLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlStateProcessLocalService service) {
        _service = service;
    }

    private static PmlStateProcessLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlStateProcessLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
