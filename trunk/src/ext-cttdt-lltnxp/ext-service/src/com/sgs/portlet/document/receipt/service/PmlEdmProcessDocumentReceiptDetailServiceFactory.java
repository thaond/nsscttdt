package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailServiceUtil
 *
 */
public class PmlEdmProcessDocumentReceiptDetailServiceFactory {
    private static final String _FACTORY = PmlEdmProcessDocumentReceiptDetailServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmProcessDocumentReceiptDetailService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmProcessDocumentReceiptDetailService.class.getName() +
        ".transaction";
    private static PmlEdmProcessDocumentReceiptDetailServiceFactory _factory;
    private static PmlEdmProcessDocumentReceiptDetailService _impl;
    private static PmlEdmProcessDocumentReceiptDetailService _txImpl;
    private PmlEdmProcessDocumentReceiptDetailService _service;

    /**
     * @deprecated
     */
    public static PmlEdmProcessDocumentReceiptDetailService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmProcessDocumentReceiptDetailService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmProcessDocumentReceiptDetailService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmProcessDocumentReceiptDetailService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmProcessDocumentReceiptDetailService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmProcessDocumentReceiptDetailService service) {
        _service = service;
    }

    private static PmlEdmProcessDocumentReceiptDetailServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmProcessDocumentReceiptDetailServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
