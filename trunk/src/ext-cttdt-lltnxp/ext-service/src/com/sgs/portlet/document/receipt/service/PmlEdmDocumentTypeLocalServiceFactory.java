package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentTypeLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeLocalServiceUtil
 *
 */
public class PmlEdmDocumentTypeLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentTypeLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentTypeLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentTypeLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentTypeLocalServiceFactory _factory;
    private static PmlEdmDocumentTypeLocalService _impl;
    private static PmlEdmDocumentTypeLocalService _txImpl;
    private PmlEdmDocumentTypeLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentTypeLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentTypeLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentTypeLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentTypeLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentTypeLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentTypeLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentTypeLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentTypeLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
