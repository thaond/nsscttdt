package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileReturningInfoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoLocalService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoLocalService
 * @see com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoLocalServiceUtil
 *
 */
public class PmlFileReturningInfoLocalServiceFactory {
    private static final String _FACTORY = PmlFileReturningInfoLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFileReturningInfoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileReturningInfoLocalService.class.getName() +
        ".transaction";
    private static PmlFileReturningInfoLocalServiceFactory _factory;
    private static PmlFileReturningInfoLocalService _impl;
    private static PmlFileReturningInfoLocalService _txImpl;
    private PmlFileReturningInfoLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFileReturningInfoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileReturningInfoLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileReturningInfoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileReturningInfoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileReturningInfoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileReturningInfoLocalService service) {
        _service = service;
    }

    private static PmlFileReturningInfoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileReturningInfoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
