package com.sgs.portlet.pml_template.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTemplateLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_template.service.PmlTemplateLocalService</code>.
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
 * @see com.sgs.portlet.pml_template.service.PmlTemplateLocalService
 * @see com.sgs.portlet.pml_template.service.PmlTemplateLocalServiceUtil
 *
 */
public class PmlTemplateLocalServiceFactory {
    private static final String _FACTORY = PmlTemplateLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlTemplateLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTemplateLocalService.class.getName() +
        ".transaction";
    private static PmlTemplateLocalServiceFactory _factory;
    private static PmlTemplateLocalService _impl;
    private static PmlTemplateLocalService _txImpl;
    private PmlTemplateLocalService _service;

    /**
     * @deprecated
     */
    public static PmlTemplateLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTemplateLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlTemplateLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTemplateLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTemplateLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTemplateLocalService service) {
        _service = service;
    }

    private static PmlTemplateLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTemplateLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
