package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTeamLeaderServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderService
 * @see com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderServiceUtil
 *
 */
public class PmlTeamLeaderServiceFactory {
    private static final String _FACTORY = PmlTeamLeaderServiceFactory.class.getName();
    private static final String _IMPL = PmlTeamLeaderService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTeamLeaderService.class.getName() +
        ".transaction";
    private static PmlTeamLeaderServiceFactory _factory;
    private static PmlTeamLeaderService _impl;
    private static PmlTeamLeaderService _txImpl;
    private PmlTeamLeaderService _service;

    /**
     * @deprecated
     */
    public static PmlTeamLeaderService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTeamLeaderService getImpl() {
        if (_impl == null) {
            _impl = (PmlTeamLeaderService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTeamLeaderService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTeamLeaderService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTeamLeaderService service) {
        _service = service;
    }

    private static PmlTeamLeaderServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTeamLeaderServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
