package com.sgs.portlet.report_registry_work.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ReportRegistryServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.report_registry_work.service.ReportRegistryService</code>.
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
 * @see com.sgs.portlet.report_registry_work.service.ReportRegistryService
 * @see com.sgs.portlet.report_registry_work.service.ReportRegistryServiceUtil
 *
 */
public class ReportRegistryServiceFactory {
    private static final String _FACTORY = ReportRegistryServiceFactory.class.getName();
    private static final String _IMPL = ReportRegistryService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ReportRegistryService.class.getName() +
        ".transaction";
    private static ReportRegistryServiceFactory _factory;
    private static ReportRegistryService _impl;
    private static ReportRegistryService _txImpl;
    private ReportRegistryService _service;

    /**
     * @deprecated
     */
    public static ReportRegistryService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ReportRegistryService getImpl() {
        if (_impl == null) {
            _impl = (ReportRegistryService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ReportRegistryService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ReportRegistryService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ReportRegistryService service) {
        _service = service;
    }

    private static ReportRegistryServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ReportRegistryServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
