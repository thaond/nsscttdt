package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTeamLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlTeamLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlTeamLocalService
 * @see com.sgs.portlet.onedoor.service.PmlTeamLocalServiceUtil
 *
 */
public class PmlTeamLocalServiceFactory {
    private static final String _FACTORY = PmlTeamLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlTeamLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTeamLocalService.class.getName() +
        ".transaction";
    private static PmlTeamLocalServiceFactory _factory;
    private static PmlTeamLocalService _impl;
    private static PmlTeamLocalService _txImpl;
    private PmlTeamLocalService _service;

    /**
     * @deprecated
     */
    public static PmlTeamLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTeamLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlTeamLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTeamLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTeamLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTeamLocalService service) {
        _service = service;
    }

    private static PmlTeamLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTeamLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
