package com.sgs.portlet.report_registry_work.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ResultProgramLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.report_registry_work.service.ResultProgramLocalService</code>.
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
 * @see com.sgs.portlet.report_registry_work.service.ResultProgramLocalService
 * @see com.sgs.portlet.report_registry_work.service.ResultProgramLocalServiceUtil
 *
 */
public class ResultProgramLocalServiceFactory {
    private static final String _FACTORY = ResultProgramLocalServiceFactory.class.getName();
    private static final String _IMPL = ResultProgramLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ResultProgramLocalService.class.getName() +
        ".transaction";
    private static ResultProgramLocalServiceFactory _factory;
    private static ResultProgramLocalService _impl;
    private static ResultProgramLocalService _txImpl;
    private ResultProgramLocalService _service;

    /**
     * @deprecated
     */
    public static ResultProgramLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ResultProgramLocalService getImpl() {
        if (_impl == null) {
            _impl = (ResultProgramLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ResultProgramLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ResultProgramLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ResultProgramLocalService service) {
        _service = service;
    }

    private static ResultProgramLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ResultProgramLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
