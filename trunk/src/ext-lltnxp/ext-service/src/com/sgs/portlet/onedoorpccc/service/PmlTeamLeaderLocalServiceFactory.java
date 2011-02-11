package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTeamLeaderLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderLocalService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderLocalService
 * @see com.sgs.portlet.onedoorpccc.service.PmlTeamLeaderLocalServiceUtil
 *
 */
public class PmlTeamLeaderLocalServiceFactory {
    private static final String _FACTORY = PmlTeamLeaderLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlTeamLeaderLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTeamLeaderLocalService.class.getName() +
        ".transaction";
    private static PmlTeamLeaderLocalServiceFactory _factory;
    private static PmlTeamLeaderLocalService _impl;
    private static PmlTeamLeaderLocalService _txImpl;
    private PmlTeamLeaderLocalService _service;

    /**
     * @deprecated
     */
    public static PmlTeamLeaderLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTeamLeaderLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlTeamLeaderLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTeamLeaderLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTeamLeaderLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTeamLeaderLocalService service) {
        _service = service;
    }

    private static PmlTeamLeaderLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTeamLeaderLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
