package com.sgs.portlet.generatetemplateid.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="IdTemplateServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.generatetemplateid.service.IdTemplateService</code>.
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
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateService
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil
 *
 */
public class IdTemplateServiceFactory {
    private static final String _FACTORY = IdTemplateServiceFactory.class.getName();
    private static final String _IMPL = IdTemplateService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = IdTemplateService.class.getName() +
        ".transaction";
    private static IdTemplateServiceFactory _factory;
    private static IdTemplateService _impl;
    private static IdTemplateService _txImpl;
    private IdTemplateService _service;

    /**
     * @deprecated
     */
    public static IdTemplateService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static IdTemplateService getImpl() {
        if (_impl == null) {
            _impl = (IdTemplateService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static IdTemplateService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (IdTemplateService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(IdTemplateService service) {
        _service = service;
    }

    private static IdTemplateServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (IdTemplateServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
