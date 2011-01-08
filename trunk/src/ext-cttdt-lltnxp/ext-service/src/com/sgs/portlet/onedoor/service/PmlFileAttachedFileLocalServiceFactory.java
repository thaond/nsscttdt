package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileAttachedFileLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalService
 * @see com.sgs.portlet.onedoor.service.PmlFileAttachedFileLocalServiceUtil
 *
 */
public class PmlFileAttachedFileLocalServiceFactory {
    private static final String _FACTORY = PmlFileAttachedFileLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFileAttachedFileLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileAttachedFileLocalService.class.getName() +
        ".transaction";
    private static PmlFileAttachedFileLocalServiceFactory _factory;
    private static PmlFileAttachedFileLocalService _impl;
    private static PmlFileAttachedFileLocalService _txImpl;
    private PmlFileAttachedFileLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFileAttachedFileLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileAttachedFileLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileAttachedFileLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileAttachedFileLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileAttachedFileLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileAttachedFileLocalService service) {
        _service = service;
    }

    private static PmlFileAttachedFileLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileAttachedFileLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
