package com.sgs.portlet.onedoor.role.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlRoleLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.role.service.PmlRoleLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.role.service.PmlRoleLocalService
 * @see com.sgs.portlet.onedoor.role.service.PmlRoleLocalServiceUtil
 *
 */
public class PmlRoleLocalServiceFactory {
    private static final String _FACTORY = PmlRoleLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlRoleLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlRoleLocalService.class.getName() +
        ".transaction";
    private static PmlRoleLocalServiceFactory _factory;
    private static PmlRoleLocalService _impl;
    private static PmlRoleLocalService _txImpl;
    private PmlRoleLocalService _service;

    /**
     * @deprecated
     */
    public static PmlRoleLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlRoleLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlRoleLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlRoleLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlRoleLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlRoleLocalService service) {
        _service = service;
    }

    private static PmlRoleLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlRoleLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
