package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlAgencyLeaderServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlAgencyLeaderService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlAgencyLeaderService
 * @see com.sgs.portlet.onedoor.service.PmlAgencyLeaderServiceUtil
 *
 */
public class PmlAgencyLeaderServiceFactory {
    private static final String _FACTORY = PmlAgencyLeaderServiceFactory.class.getName();
    private static final String _IMPL = PmlAgencyLeaderService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlAgencyLeaderService.class.getName() +
        ".transaction";
    private static PmlAgencyLeaderServiceFactory _factory;
    private static PmlAgencyLeaderService _impl;
    private static PmlAgencyLeaderService _txImpl;
    private PmlAgencyLeaderService _service;

    /**
     * @deprecated
     */
    public static PmlAgencyLeaderService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlAgencyLeaderService getImpl() {
        if (_impl == null) {
            _impl = (PmlAgencyLeaderService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlAgencyLeaderService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlAgencyLeaderService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlAgencyLeaderService service) {
        _service = service;
    }

    private static PmlAgencyLeaderServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlAgencyLeaderServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
