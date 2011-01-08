package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileStatusLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlFileStatusLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlFileStatusLocalService
 * @see com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil
 *
 */
public class PmlFileStatusLocalServiceFactory {
    private static final String _FACTORY = PmlFileStatusLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFileStatusLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileStatusLocalService.class.getName() +
        ".transaction";
    private static PmlFileStatusLocalServiceFactory _factory;
    private static PmlFileStatusLocalService _impl;
    private static PmlFileStatusLocalService _txImpl;
    private PmlFileStatusLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFileStatusLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileStatusLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileStatusLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileStatusLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileStatusLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileStatusLocalService service) {
        _service = service;
    }

    private static PmlFileStatusLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileStatusLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
