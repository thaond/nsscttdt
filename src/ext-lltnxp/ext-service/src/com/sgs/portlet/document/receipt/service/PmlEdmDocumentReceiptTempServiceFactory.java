package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptTempServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptTempServiceUtil
 *
 */
public class PmlEdmDocumentReceiptTempServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptTempServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptTempService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptTempService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptTempServiceFactory _factory;
    private static PmlEdmDocumentReceiptTempService _impl;
    private static PmlEdmDocumentReceiptTempService _txImpl;
    private PmlEdmDocumentReceiptTempService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptTempService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptTempService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptTempService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptTempService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptTempService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptTempService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptTempServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptTempServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
