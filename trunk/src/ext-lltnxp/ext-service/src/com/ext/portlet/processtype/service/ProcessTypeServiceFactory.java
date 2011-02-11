package com.ext.portlet.processtype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ProcessTypeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.processtype.service.ProcessTypeService</code>.
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
 * @see com.ext.portlet.processtype.service.ProcessTypeService
 * @see com.ext.portlet.processtype.service.ProcessTypeServiceUtil
 *
 */
public class ProcessTypeServiceFactory {
    private static final String _FACTORY = ProcessTypeServiceFactory.class.getName();
    private static final String _IMPL = ProcessTypeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ProcessTypeService.class.getName() +
        ".transaction";
    private static ProcessTypeServiceFactory _factory;
    private static ProcessTypeService _impl;
    private static ProcessTypeService _txImpl;
    private ProcessTypeService _service;

    /**
     * @deprecated
     */
    public static ProcessTypeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ProcessTypeService getImpl() {
        if (_impl == null) {
            _impl = (ProcessTypeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ProcessTypeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ProcessTypeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ProcessTypeService service) {
        _service = service;
    }

    private static ProcessTypeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ProcessTypeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
