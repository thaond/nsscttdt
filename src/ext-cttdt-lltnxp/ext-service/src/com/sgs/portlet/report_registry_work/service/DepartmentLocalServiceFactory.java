package com.sgs.portlet.report_registry_work.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="DepartmentLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.report_registry_work.service.DepartmentLocalService</code>.
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
 * @see com.sgs.portlet.report_registry_work.service.DepartmentLocalService
 * @see com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil
 *
 */
public class DepartmentLocalServiceFactory {
    private static final String _FACTORY = DepartmentLocalServiceFactory.class.getName();
    private static final String _IMPL = DepartmentLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = DepartmentLocalService.class.getName() +
        ".transaction";
    private static DepartmentLocalServiceFactory _factory;
    private static DepartmentLocalService _impl;
    private static DepartmentLocalService _txImpl;
    private DepartmentLocalService _service;

    /**
     * @deprecated
     */
    public static DepartmentLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static DepartmentLocalService getImpl() {
        if (_impl == null) {
            _impl = (DepartmentLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static DepartmentLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (DepartmentLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(DepartmentLocalService service) {
        _service = service;
    }

    private static DepartmentLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (DepartmentLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
