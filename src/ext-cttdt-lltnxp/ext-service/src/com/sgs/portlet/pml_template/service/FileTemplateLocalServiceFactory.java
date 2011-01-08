package com.sgs.portlet.pml_template.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="FileTemplateLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_template.service.FileTemplateLocalService</code>.
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
 * @see com.sgs.portlet.pml_template.service.FileTemplateLocalService
 * @see com.sgs.portlet.pml_template.service.FileTemplateLocalServiceUtil
 *
 */
public class FileTemplateLocalServiceFactory {
    private static final String _FACTORY = FileTemplateLocalServiceFactory.class.getName();
    private static final String _IMPL = FileTemplateLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = FileTemplateLocalService.class.getName() +
        ".transaction";
    private static FileTemplateLocalServiceFactory _factory;
    private static FileTemplateLocalService _impl;
    private static FileTemplateLocalService _txImpl;
    private FileTemplateLocalService _service;

    /**
     * @deprecated
     */
    public static FileTemplateLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static FileTemplateLocalService getImpl() {
        if (_impl == null) {
            _impl = (FileTemplateLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static FileTemplateLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (FileTemplateLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(FileTemplateLocalService service) {
        _service = service;
    }

    private static FileTemplateLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (FileTemplateLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
