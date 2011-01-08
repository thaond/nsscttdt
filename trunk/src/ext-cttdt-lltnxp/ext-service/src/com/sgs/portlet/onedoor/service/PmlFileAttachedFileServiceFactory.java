package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileAttachedFileServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlFileAttachedFileService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlFileAttachedFileService
 * @see com.sgs.portlet.onedoor.service.PmlFileAttachedFileServiceUtil
 *
 */
public class PmlFileAttachedFileServiceFactory {
    private static final String _FACTORY = PmlFileAttachedFileServiceFactory.class.getName();
    private static final String _IMPL = PmlFileAttachedFileService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileAttachedFileService.class.getName() +
        ".transaction";
    private static PmlFileAttachedFileServiceFactory _factory;
    private static PmlFileAttachedFileService _impl;
    private static PmlFileAttachedFileService _txImpl;
    private PmlFileAttachedFileService _service;

    /**
     * @deprecated
     */
    public static PmlFileAttachedFileService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileAttachedFileService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileAttachedFileService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileAttachedFileService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileAttachedFileService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileAttachedFileService service) {
        _service = service;
    }

    private static PmlFileAttachedFileServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileAttachedFileServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
