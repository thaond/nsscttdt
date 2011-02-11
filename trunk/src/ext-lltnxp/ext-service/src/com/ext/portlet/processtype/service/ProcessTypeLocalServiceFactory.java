package com.ext.portlet.processtype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ProcessTypeLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.processtype.service.ProcessTypeLocalService</code>.
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
 * @see com.ext.portlet.processtype.service.ProcessTypeLocalService
 * @see com.ext.portlet.processtype.service.ProcessTypeLocalServiceUtil
 *
 */
public class ProcessTypeLocalServiceFactory {
    private static final String _FACTORY = ProcessTypeLocalServiceFactory.class.getName();
    private static final String _IMPL = ProcessTypeLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ProcessTypeLocalService.class.getName() +
        ".transaction";
    private static ProcessTypeLocalServiceFactory _factory;
    private static ProcessTypeLocalService _impl;
    private static ProcessTypeLocalService _txImpl;
    private ProcessTypeLocalService _service;

    /**
     * @deprecated
     */
    public static ProcessTypeLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ProcessTypeLocalService getImpl() {
        if (_impl == null) {
            _impl = (ProcessTypeLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ProcessTypeLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ProcessTypeLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ProcessTypeLocalService service) {
        _service = service;
    }

    private static ProcessTypeLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ProcessTypeLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
