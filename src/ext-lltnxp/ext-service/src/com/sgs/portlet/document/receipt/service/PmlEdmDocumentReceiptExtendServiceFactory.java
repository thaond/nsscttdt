package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptExtendServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendServiceUtil
 *
 */
public class PmlEdmDocumentReceiptExtendServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptExtendServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptExtendService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptExtendService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptExtendServiceFactory _factory;
    private static PmlEdmDocumentReceiptExtendService _impl;
    private static PmlEdmDocumentReceiptExtendService _txImpl;
    private PmlEdmDocumentReceiptExtendService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptExtendService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptExtendService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptExtendService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptExtendService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptExtendService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptExtendService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptExtendServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptExtendServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
