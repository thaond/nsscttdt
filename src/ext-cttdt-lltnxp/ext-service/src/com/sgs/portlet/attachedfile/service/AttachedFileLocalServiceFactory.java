package com.sgs.portlet.attachedfile.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="AttachedFileLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.attachedfile.service.AttachedFileLocalService</code>.
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
 * @see com.sgs.portlet.attachedfile.service.AttachedFileLocalService
 * @see com.sgs.portlet.attachedfile.service.AttachedFileLocalServiceUtil
 *
 */
public class AttachedFileLocalServiceFactory {
    private static final String _FACTORY = AttachedFileLocalServiceFactory.class.getName();
    private static final String _IMPL = AttachedFileLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = AttachedFileLocalService.class.getName() +
        ".transaction";
    private static AttachedFileLocalServiceFactory _factory;
    private static AttachedFileLocalService _impl;
    private static AttachedFileLocalService _txImpl;
    private AttachedFileLocalService _service;

    /**
     * @deprecated
     */
    public static AttachedFileLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static AttachedFileLocalService getImpl() {
        if (_impl == null) {
            _impl = (AttachedFileLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static AttachedFileLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (AttachedFileLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(AttachedFileLocalService service) {
        _service = service;
    }

    private static AttachedFileLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (AttachedFileLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
