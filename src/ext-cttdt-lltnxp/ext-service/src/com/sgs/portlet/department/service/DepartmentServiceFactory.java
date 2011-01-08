package com.sgs.portlet.department.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="DepartmentServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.department.service.DepartmentService</code>.
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
 * @see com.sgs.portlet.department.service.DepartmentService
 * @see com.sgs.portlet.department.service.DepartmentServiceUtil
 *
 */
public class DepartmentServiceFactory {
    private static final String _FACTORY = DepartmentServiceFactory.class.getName();
    private static final String _IMPL = DepartmentService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = DepartmentService.class.getName() +
        ".transaction";
    private static DepartmentServiceFactory _factory;
    private static DepartmentService _impl;
    private static DepartmentService _txImpl;
    private DepartmentService _service;

    /**
     * @deprecated
     */
    public static DepartmentService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static DepartmentService getImpl() {
        if (_impl == null) {
            _impl = (DepartmentService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static DepartmentService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (DepartmentService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(DepartmentService service) {
        _service = service;
    }

    private static DepartmentServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (DepartmentServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
