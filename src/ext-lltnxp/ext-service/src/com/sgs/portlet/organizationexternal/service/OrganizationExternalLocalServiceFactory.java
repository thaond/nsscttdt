package com.sgs.portlet.organizationexternal.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="OrganizationExternalLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService</code>.
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
 * @see com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalService
 * @see com.sgs.portlet.organizationexternal.service.OrganizationExternalLocalServiceUtil
 *
 */
public class OrganizationExternalLocalServiceFactory {
    private static final String _FACTORY = OrganizationExternalLocalServiceFactory.class.getName();
    private static final String _IMPL = OrganizationExternalLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = OrganizationExternalLocalService.class.getName() +
        ".transaction";
    private static OrganizationExternalLocalServiceFactory _factory;
    private static OrganizationExternalLocalService _impl;
    private static OrganizationExternalLocalService _txImpl;
    private OrganizationExternalLocalService _service;

    /**
     * @deprecated
     */
    public static OrganizationExternalLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static OrganizationExternalLocalService getImpl() {
        if (_impl == null) {
            _impl = (OrganizationExternalLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static OrganizationExternalLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (OrganizationExternalLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(OrganizationExternalLocalService service) {
        _service = service;
    }

    private static OrganizationExternalLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (OrganizationExternalLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
