package com.sgs.portlet.generatetemplateid.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="IdTemplateLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.generatetemplateid.service.IdTemplateLocalService</code>.
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
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateLocalService
 * @see com.sgs.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil
 *
 */
public class IdTemplateLocalServiceFactory {
    private static final String _FACTORY = IdTemplateLocalServiceFactory.class.getName();
    private static final String _IMPL = IdTemplateLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = IdTemplateLocalService.class.getName() +
        ".transaction";
    private static IdTemplateLocalServiceFactory _factory;
    private static IdTemplateLocalService _impl;
    private static IdTemplateLocalService _txImpl;
    private IdTemplateLocalService _service;

    /**
     * @deprecated
     */
    public static IdTemplateLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static IdTemplateLocalService getImpl() {
        if (_impl == null) {
            _impl = (IdTemplateLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static IdTemplateLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (IdTemplateLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(IdTemplateLocalService service) {
        _service = service;
    }

    private static IdTemplateLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (IdTemplateLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
