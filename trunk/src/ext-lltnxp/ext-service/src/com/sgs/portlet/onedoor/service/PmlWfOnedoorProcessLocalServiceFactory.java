package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlWfOnedoorProcessLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessLocalService
 * @see com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessLocalServiceUtil
 *
 */
public class PmlWfOnedoorProcessLocalServiceFactory {
    private static final String _FACTORY = PmlWfOnedoorProcessLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlWfOnedoorProcessLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlWfOnedoorProcessLocalService.class.getName() +
        ".transaction";
    private static PmlWfOnedoorProcessLocalServiceFactory _factory;
    private static PmlWfOnedoorProcessLocalService _impl;
    private static PmlWfOnedoorProcessLocalService _txImpl;
    private PmlWfOnedoorProcessLocalService _service;

    /**
     * @deprecated
     */
    public static PmlWfOnedoorProcessLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlWfOnedoorProcessLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlWfOnedoorProcessLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlWfOnedoorProcessLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlWfOnedoorProcessLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlWfOnedoorProcessLocalService service) {
        _service = service;
    }

    private static PmlWfOnedoorProcessLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlWfOnedoorProcessLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
