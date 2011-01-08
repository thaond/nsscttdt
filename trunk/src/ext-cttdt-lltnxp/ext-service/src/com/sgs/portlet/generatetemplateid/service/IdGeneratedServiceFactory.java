package com.sgs.portlet.generatetemplateid.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="IdGeneratedServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.generatetemplateid.service.IdGeneratedService</code>.
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
 * @see com.sgs.portlet.generatetemplateid.service.IdGeneratedService
 * @see com.sgs.portlet.generatetemplateid.service.IdGeneratedServiceUtil
 *
 */
public class IdGeneratedServiceFactory {
    private static final String _FACTORY = IdGeneratedServiceFactory.class.getName();
    private static final String _IMPL = IdGeneratedService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = IdGeneratedService.class.getName() +
        ".transaction";
    private static IdGeneratedServiceFactory _factory;
    private static IdGeneratedService _impl;
    private static IdGeneratedService _txImpl;
    private IdGeneratedService _service;

    /**
     * @deprecated
     */
    public static IdGeneratedService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static IdGeneratedService getImpl() {
        if (_impl == null) {
            _impl = (IdGeneratedService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static IdGeneratedService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (IdGeneratedService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(IdGeneratedService service) {
        _service = service;
    }

    private static IdGeneratedServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (IdGeneratedServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
