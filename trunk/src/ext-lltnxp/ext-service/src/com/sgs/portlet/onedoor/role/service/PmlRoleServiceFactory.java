package com.sgs.portlet.onedoor.role.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlRoleServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.role.service.PmlRoleService</code>.
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
 * @see com.sgs.portlet.onedoor.role.service.PmlRoleService
 * @see com.sgs.portlet.onedoor.role.service.PmlRoleServiceUtil
 *
 */
public class PmlRoleServiceFactory {
    private static final String _FACTORY = PmlRoleServiceFactory.class.getName();
    private static final String _IMPL = PmlRoleService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlRoleService.class.getName() +
        ".transaction";
    private static PmlRoleServiceFactory _factory;
    private static PmlRoleService _impl;
    private static PmlRoleService _txImpl;
    private PmlRoleService _service;

    /**
     * @deprecated
     */
    public static PmlRoleService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlRoleService getImpl() {
        if (_impl == null) {
            _impl = (PmlRoleService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlRoleService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlRoleService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlRoleService service) {
        _service = service;
    }

    private static PmlRoleServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlRoleServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
