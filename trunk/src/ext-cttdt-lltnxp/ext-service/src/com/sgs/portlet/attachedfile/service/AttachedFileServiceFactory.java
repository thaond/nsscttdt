package com.sgs.portlet.attachedfile.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="AttachedFileServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.attachedfile.service.AttachedFileService</code>.
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
 * @see com.sgs.portlet.attachedfile.service.AttachedFileService
 * @see com.sgs.portlet.attachedfile.service.AttachedFileServiceUtil
 *
 */
public class AttachedFileServiceFactory {
    private static final String _FACTORY = AttachedFileServiceFactory.class.getName();
    private static final String _IMPL = AttachedFileService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = AttachedFileService.class.getName() +
        ".transaction";
    private static AttachedFileServiceFactory _factory;
    private static AttachedFileService _impl;
    private static AttachedFileService _txImpl;
    private AttachedFileService _service;

    /**
     * @deprecated
     */
    public static AttachedFileService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static AttachedFileService getImpl() {
        if (_impl == null) {
            _impl = (AttachedFileService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static AttachedFileService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (AttachedFileService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(AttachedFileService service) {
        _service = service;
    }

    private static AttachedFileServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (AttachedFileServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
