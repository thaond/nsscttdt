package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmAttachedFileLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmAttachedFileLocalServiceUtil
 *
 */
public class PmlEdmAttachedFileLocalServiceFactory {
    private static final String _FACTORY = PmlEdmAttachedFileLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmAttachedFileLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmAttachedFileLocalService.class.getName() +
        ".transaction";
    private static PmlEdmAttachedFileLocalServiceFactory _factory;
    private static PmlEdmAttachedFileLocalService _impl;
    private static PmlEdmAttachedFileLocalService _txImpl;
    private PmlEdmAttachedFileLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmAttachedFileLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmAttachedFileLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmAttachedFileLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmAttachedFileLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmAttachedFileLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmAttachedFileLocalService service) {
        _service = service;
    }

    private static PmlEdmAttachedFileLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmAttachedFileLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
