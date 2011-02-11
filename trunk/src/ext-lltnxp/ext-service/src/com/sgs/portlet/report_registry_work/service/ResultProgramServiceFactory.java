package com.sgs.portlet.report_registry_work.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ResultProgramServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.report_registry_work.service.ResultProgramService</code>.
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
 * @see com.sgs.portlet.report_registry_work.service.ResultProgramService
 * @see com.sgs.portlet.report_registry_work.service.ResultProgramServiceUtil
 *
 */
public class ResultProgramServiceFactory {
    private static final String _FACTORY = ResultProgramServiceFactory.class.getName();
    private static final String _IMPL = ResultProgramService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ResultProgramService.class.getName() +
        ".transaction";
    private static ResultProgramServiceFactory _factory;
    private static ResultProgramService _impl;
    private static ResultProgramService _txImpl;
    private ResultProgramService _service;

    /**
     * @deprecated
     */
    public static ResultProgramService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ResultProgramService getImpl() {
        if (_impl == null) {
            _impl = (ResultProgramService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ResultProgramService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ResultProgramService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ResultProgramService service) {
        _service = service;
    }

    private static ResultProgramServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ResultProgramServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
