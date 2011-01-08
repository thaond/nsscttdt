package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmProcessDocumentReceiptDetailLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmProcessDocumentReceiptDetailLocalServiceUtil
 *
 */
public class PmlEdmProcessDocumentReceiptDetailLocalServiceFactory {
    private static final String _FACTORY = PmlEdmProcessDocumentReceiptDetailLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmProcessDocumentReceiptDetailLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmProcessDocumentReceiptDetailLocalService.class.getName() +
        ".transaction";
    private static PmlEdmProcessDocumentReceiptDetailLocalServiceFactory _factory;
    private static PmlEdmProcessDocumentReceiptDetailLocalService _impl;
    private static PmlEdmProcessDocumentReceiptDetailLocalService _txImpl;
    private PmlEdmProcessDocumentReceiptDetailLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmProcessDocumentReceiptDetailLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmProcessDocumentReceiptDetailLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmProcessDocumentReceiptDetailLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmProcessDocumentReceiptDetailLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmProcessDocumentReceiptDetailLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(
        PmlEdmProcessDocumentReceiptDetailLocalService service) {
        _service = service;
    }

    private static PmlEdmProcessDocumentReceiptDetailLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmProcessDocumentReceiptDetailLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
