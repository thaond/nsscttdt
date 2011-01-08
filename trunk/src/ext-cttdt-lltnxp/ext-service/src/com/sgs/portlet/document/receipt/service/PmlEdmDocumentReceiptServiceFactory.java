package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptServiceUtil
 *
 */
public class PmlEdmDocumentReceiptServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptServiceFactory _factory;
    private static PmlEdmDocumentReceiptService _impl;
    private static PmlEdmDocumentReceiptService _txImpl;
    private PmlEdmDocumentReceiptService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
