package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTeamServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlTeamService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlTeamService
 * @see com.sgs.portlet.onedoor.service.PmlTeamServiceUtil
 *
 */
public class PmlTeamServiceFactory {
    private static final String _FACTORY = PmlTeamServiceFactory.class.getName();
    private static final String _IMPL = PmlTeamService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTeamService.class.getName() +
        ".transaction";
    private static PmlTeamServiceFactory _factory;
    private static PmlTeamService _impl;
    private static PmlTeamService _txImpl;
    private PmlTeamService _service;

    /**
     * @deprecated
     */
    public static PmlTeamService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTeamService getImpl() {
        if (_impl == null) {
            _impl = (PmlTeamService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTeamService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTeamService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTeamService service) {
        _service = service;
    }

    private static PmlTeamServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTeamServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
