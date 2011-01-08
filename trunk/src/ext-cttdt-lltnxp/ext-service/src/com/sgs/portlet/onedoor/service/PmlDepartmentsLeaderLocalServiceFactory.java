package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDepartmentsLeaderLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalService
 * @see com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderLocalServiceUtil
 *
 */
public class PmlDepartmentsLeaderLocalServiceFactory {
    private static final String _FACTORY = PmlDepartmentsLeaderLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDepartmentsLeaderLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDepartmentsLeaderLocalService.class.getName() +
        ".transaction";
    private static PmlDepartmentsLeaderLocalServiceFactory _factory;
    private static PmlDepartmentsLeaderLocalService _impl;
    private static PmlDepartmentsLeaderLocalService _txImpl;
    private PmlDepartmentsLeaderLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDepartmentsLeaderLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDepartmentsLeaderLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDepartmentsLeaderLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDepartmentsLeaderLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDepartmentsLeaderLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDepartmentsLeaderLocalService service) {
        _service = service;
    }

    private static PmlDepartmentsLeaderLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDepartmentsLeaderLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
