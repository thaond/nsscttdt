package com.sgs.portlet.pml_template.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTemplateServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_template.service.PmlTemplateService</code>.
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
 * @see com.sgs.portlet.pml_template.service.PmlTemplateService
 * @see com.sgs.portlet.pml_template.service.PmlTemplateServiceUtil
 *
 */
public class PmlTemplateServiceFactory {
    private static final String _FACTORY = PmlTemplateServiceFactory.class.getName();
    private static final String _IMPL = PmlTemplateService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTemplateService.class.getName() +
        ".transaction";
    private static PmlTemplateServiceFactory _factory;
    private static PmlTemplateService _impl;
    private static PmlTemplateService _txImpl;
    private PmlTemplateService _service;

    /**
     * @deprecated
     */
    public static PmlTemplateService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTemplateService getImpl() {
        if (_impl == null) {
            _impl = (PmlTemplateService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTemplateService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTemplateService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTemplateService service) {
        _service = service;
    }

    private static PmlTemplateServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTemplateServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
