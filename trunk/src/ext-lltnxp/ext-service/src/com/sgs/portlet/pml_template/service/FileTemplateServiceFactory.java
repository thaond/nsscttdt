package com.sgs.portlet.pml_template.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="FileTemplateServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_template.service.FileTemplateService</code>.
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
 * @see com.sgs.portlet.pml_template.service.FileTemplateService
 * @see com.sgs.portlet.pml_template.service.FileTemplateServiceUtil
 *
 */
public class FileTemplateServiceFactory {
    private static final String _FACTORY = FileTemplateServiceFactory.class.getName();
    private static final String _IMPL = FileTemplateService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = FileTemplateService.class.getName() +
        ".transaction";
    private static FileTemplateServiceFactory _factory;
    private static FileTemplateService _impl;
    private static FileTemplateService _txImpl;
    private FileTemplateService _service;

    /**
     * @deprecated
     */
    public static FileTemplateService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static FileTemplateService getImpl() {
        if (_impl == null) {
            _impl = (FileTemplateService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static FileTemplateService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (FileTemplateService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(FileTemplateService service) {
        _service = service;
    }

    private static FileTemplateServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (FileTemplateServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
