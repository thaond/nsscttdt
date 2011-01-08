package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDepartmentsLeaderServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderService
 * @see com.sgs.portlet.onedoor.service.PmlDepartmentsLeaderServiceUtil
 *
 */
public class PmlDepartmentsLeaderServiceFactory {
    private static final String _FACTORY = PmlDepartmentsLeaderServiceFactory.class.getName();
    private static final String _IMPL = PmlDepartmentsLeaderService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDepartmentsLeaderService.class.getName() +
        ".transaction";
    private static PmlDepartmentsLeaderServiceFactory _factory;
    private static PmlDepartmentsLeaderService _impl;
    private static PmlDepartmentsLeaderService _txImpl;
    private PmlDepartmentsLeaderService _service;

    /**
     * @deprecated
     */
    public static PmlDepartmentsLeaderService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDepartmentsLeaderService getImpl() {
        if (_impl == null) {
            _impl = (PmlDepartmentsLeaderService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDepartmentsLeaderService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDepartmentsLeaderService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDepartmentsLeaderService service) {
        _service = service;
    }

    private static PmlDepartmentsLeaderServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDepartmentsLeaderServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
