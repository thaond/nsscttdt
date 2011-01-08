package com.sgs.portlet.pml_edm_docconfuser.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocConfUserServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserService</code>.
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
 * @see com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserService
 * @see com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserServiceUtil
 *
 */
public class PmlEdmDocConfUserServiceFactory {
    private static final String _FACTORY = PmlEdmDocConfUserServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocConfUserService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocConfUserService.class.getName() +
        ".transaction";
    private static PmlEdmDocConfUserServiceFactory _factory;
    private static PmlEdmDocConfUserService _impl;
    private static PmlEdmDocConfUserService _txImpl;
    private PmlEdmDocConfUserService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocConfUserService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocConfUserService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocConfUserService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocConfUserService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocConfUserService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocConfUserService service) {
        _service = service;
    }

    private static PmlEdmDocConfUserServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocConfUserServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
