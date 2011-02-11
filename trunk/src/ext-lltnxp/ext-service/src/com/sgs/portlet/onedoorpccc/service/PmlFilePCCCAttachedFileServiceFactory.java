package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFilePCCCAttachedFileServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileService
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileServiceUtil
 *
 */
public class PmlFilePCCCAttachedFileServiceFactory {
    private static final String _FACTORY = PmlFilePCCCAttachedFileServiceFactory.class.getName();
    private static final String _IMPL = PmlFilePCCCAttachedFileService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFilePCCCAttachedFileService.class.getName() +
        ".transaction";
    private static PmlFilePCCCAttachedFileServiceFactory _factory;
    private static PmlFilePCCCAttachedFileService _impl;
    private static PmlFilePCCCAttachedFileService _txImpl;
    private PmlFilePCCCAttachedFileService _service;

    /**
     * @deprecated
     */
    public static PmlFilePCCCAttachedFileService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFilePCCCAttachedFileService getImpl() {
        if (_impl == null) {
            _impl = (PmlFilePCCCAttachedFileService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFilePCCCAttachedFileService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFilePCCCAttachedFileService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFilePCCCAttachedFileService service) {
        _service = service;
    }

    private static PmlFilePCCCAttachedFileServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFilePCCCAttachedFileServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
