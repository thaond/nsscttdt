package com.sgs.portlet.department.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDepartmentHSCVLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService</code>.
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
 * @see com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService
 * @see com.sgs.portlet.department.service.PmlDepartmentHSCVLocalServiceUtil
 *
 */
public class PmlDepartmentHSCVLocalServiceFactory {
    private static final String _FACTORY = PmlDepartmentHSCVLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDepartmentHSCVLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDepartmentHSCVLocalService.class.getName() +
        ".transaction";
    private static PmlDepartmentHSCVLocalServiceFactory _factory;
    private static PmlDepartmentHSCVLocalService _impl;
    private static PmlDepartmentHSCVLocalService _txImpl;
    private PmlDepartmentHSCVLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDepartmentHSCVLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDepartmentHSCVLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDepartmentHSCVLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDepartmentHSCVLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDepartmentHSCVLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDepartmentHSCVLocalService service) {
        _service = service;
    }

    private static PmlDepartmentHSCVLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDepartmentHSCVLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
