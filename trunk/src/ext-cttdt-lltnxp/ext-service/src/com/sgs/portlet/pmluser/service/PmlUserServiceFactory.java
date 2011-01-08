package com.sgs.portlet.pmluser.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlUserServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pmluser.service.PmlUserService</code>.
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
 * @see com.sgs.portlet.pmluser.service.PmlUserService
 * @see com.sgs.portlet.pmluser.service.PmlUserServiceUtil
 *
 */
public class PmlUserServiceFactory {
    private static final String _FACTORY = PmlUserServiceFactory.class.getName();
    private static final String _IMPL = PmlUserService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlUserService.class.getName() +
        ".transaction";
    private static PmlUserServiceFactory _factory;
    private static PmlUserService _impl;
    private static PmlUserService _txImpl;
    private PmlUserService _service;

    /**
     * @deprecated
     */
    public static PmlUserService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlUserService getImpl() {
        if (_impl == null) {
            _impl = (PmlUserService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlUserService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlUserService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlUserService service) {
        _service = service;
    }

    private static PmlUserServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlUserServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
