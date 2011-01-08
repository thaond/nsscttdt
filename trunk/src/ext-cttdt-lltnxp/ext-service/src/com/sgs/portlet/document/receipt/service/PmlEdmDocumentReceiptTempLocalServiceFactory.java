package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptTempLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempLocalServiceUtil
 *
 */
public class PmlEdmDocumentReceiptTempLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptTempLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptTempLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptTempLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptTempLocalServiceFactory _factory;
    private static PmlEdmDocumentReceiptTempLocalService _impl;
    private static PmlEdmDocumentReceiptTempLocalService _txImpl;
    private PmlEdmDocumentReceiptTempLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptTempLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptTempLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptTempLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptTempLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptTempLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptTempLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptTempLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptTempLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
