package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileTypeAttachedFileLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileLocalService
 * @see com.sgs.portlet.onedoor.service.PmlFileTypeAttachedFileLocalServiceUtil
 *
 */
public class PmlFileTypeAttachedFileLocalServiceFactory {
    private static final String _FACTORY = PmlFileTypeAttachedFileLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFileTypeAttachedFileLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileTypeAttachedFileLocalService.class.getName() +
        ".transaction";
    private static PmlFileTypeAttachedFileLocalServiceFactory _factory;
    private static PmlFileTypeAttachedFileLocalService _impl;
    private static PmlFileTypeAttachedFileLocalService _txImpl;
    private PmlFileTypeAttachedFileLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFileTypeAttachedFileLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeAttachedFileLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileTypeAttachedFileLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeAttachedFileLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileTypeAttachedFileLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileTypeAttachedFileLocalService service) {
        _service = service;
    }

    private static PmlFileTypeAttachedFileLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileTypeAttachedFileLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
