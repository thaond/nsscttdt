package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlStateDepartmentServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlStateDepartmentService</code>.
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
 * @see com.sgs.portlet.document.service.PmlStateDepartmentService
 * @see com.sgs.portlet.document.service.PmlStateDepartmentServiceUtil
 *
 */
public class PmlStateDepartmentServiceFactory {
    private static final String _FACTORY = PmlStateDepartmentServiceFactory.class.getName();
    private static final String _IMPL = PmlStateDepartmentService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlStateDepartmentService.class.getName() +
        ".transaction";
    private static PmlStateDepartmentServiceFactory _factory;
    private static PmlStateDepartmentService _impl;
    private static PmlStateDepartmentService _txImpl;
    private PmlStateDepartmentService _service;

    /**
     * @deprecated
     */
    public static PmlStateDepartmentService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlStateDepartmentService getImpl() {
        if (_impl == null) {
            _impl = (PmlStateDepartmentService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlStateDepartmentService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlStateDepartmentService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlStateDepartmentService service) {
        _service = service;
    }

    private static PmlStateDepartmentServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlStateDepartmentServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
