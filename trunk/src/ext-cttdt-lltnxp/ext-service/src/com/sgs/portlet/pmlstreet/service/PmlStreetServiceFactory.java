package com.sgs.portlet.pmlstreet.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlStreetServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pmlstreet.service.PmlStreetService</code>.
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
 * @see com.sgs.portlet.pmlstreet.service.PmlStreetService
 * @see com.sgs.portlet.pmlstreet.service.PmlStreetServiceUtil
 *
 */
public class PmlStreetServiceFactory {
    private static final String _FACTORY = PmlStreetServiceFactory.class.getName();
    private static final String _IMPL = PmlStreetService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlStreetService.class.getName() +
        ".transaction";
    private static PmlStreetServiceFactory _factory;
    private static PmlStreetService _impl;
    private static PmlStreetService _txImpl;
    private PmlStreetService _service;

    /**
     * @deprecated
     */
    public static PmlStreetService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlStreetService getImpl() {
        if (_impl == null) {
            _impl = (PmlStreetService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlStreetService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlStreetService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlStreetService service) {
        _service = service;
    }

    private static PmlStreetServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlStreetServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
