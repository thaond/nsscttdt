package com.sgs.portlet.pmlstreet.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlStreetLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pmlstreet.service.PmlStreetLocalService</code>.
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
 * @see com.sgs.portlet.pmlstreet.service.PmlStreetLocalService
 * @see com.sgs.portlet.pmlstreet.service.PmlStreetLocalServiceUtil
 *
 */
public class PmlStreetLocalServiceFactory {
    private static final String _FACTORY = PmlStreetLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlStreetLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlStreetLocalService.class.getName() +
        ".transaction";
    private static PmlStreetLocalServiceFactory _factory;
    private static PmlStreetLocalService _impl;
    private static PmlStreetLocalService _txImpl;
    private PmlStreetLocalService _service;

    /**
     * @deprecated
     */
    public static PmlStreetLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlStreetLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlStreetLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlStreetLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlStreetLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlStreetLocalService service) {
        _service = service;
    }

    private static PmlStreetLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlStreetLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
