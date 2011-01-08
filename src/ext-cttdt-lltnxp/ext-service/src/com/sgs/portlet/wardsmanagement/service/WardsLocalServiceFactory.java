package com.sgs.portlet.wardsmanagement.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="WardsLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.wardsmanagement.service.WardsLocalService</code>.
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
 * @see com.sgs.portlet.wardsmanagement.service.WardsLocalService
 * @see com.sgs.portlet.wardsmanagement.service.WardsLocalServiceUtil
 *
 */
public class WardsLocalServiceFactory {
    private static final String _FACTORY = WardsLocalServiceFactory.class.getName();
    private static final String _IMPL = WardsLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = WardsLocalService.class.getName() +
        ".transaction";
    private static WardsLocalServiceFactory _factory;
    private static WardsLocalService _impl;
    private static WardsLocalService _txImpl;
    private WardsLocalService _service;

    /**
     * @deprecated
     */
    public static WardsLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static WardsLocalService getImpl() {
        if (_impl == null) {
            _impl = (WardsLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static WardsLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (WardsLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(WardsLocalService service) {
        _service = service;
    }

    private static WardsLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (WardsLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
