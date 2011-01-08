package com.sgs.portlet.report_registry_work.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ReportRegistryLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService</code>.
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
 * @see com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService
 * @see com.sgs.portlet.report_registry_work.service.ReportRegistryLocalServiceUtil
 *
 */
public class ReportRegistryLocalServiceFactory {
    private static final String _FACTORY = ReportRegistryLocalServiceFactory.class.getName();
    private static final String _IMPL = ReportRegistryLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ReportRegistryLocalService.class.getName() +
        ".transaction";
    private static ReportRegistryLocalServiceFactory _factory;
    private static ReportRegistryLocalService _impl;
    private static ReportRegistryLocalService _txImpl;
    private ReportRegistryLocalService _service;

    /**
     * @deprecated
     */
    public static ReportRegistryLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ReportRegistryLocalService getImpl() {
        if (_impl == null) {
            _impl = (ReportRegistryLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ReportRegistryLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ReportRegistryLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ReportRegistryLocalService service) {
        _service = service;
    }

    private static ReportRegistryLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ReportRegistryLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
