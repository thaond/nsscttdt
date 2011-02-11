package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeLocalServiceUtil
 *
 */
public class PmlEdmDocumentReceiptProcessTypeLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptProcessTypeLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptProcessTypeLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptProcessTypeLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptProcessTypeLocalServiceFactory _factory;
    private static PmlEdmDocumentReceiptProcessTypeLocalService _impl;
    private static PmlEdmDocumentReceiptProcessTypeLocalService _txImpl;
    private PmlEdmDocumentReceiptProcessTypeLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptProcessTypeLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptProcessTypeLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptProcessTypeLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptProcessTypeLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptProcessTypeLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptProcessTypeLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptProcessTypeLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptProcessTypeLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
