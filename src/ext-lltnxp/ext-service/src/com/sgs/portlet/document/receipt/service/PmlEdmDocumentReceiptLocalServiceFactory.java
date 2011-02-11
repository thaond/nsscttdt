package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil
 *
 */
public class PmlEdmDocumentReceiptLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptLocalServiceFactory _factory;
    private static PmlEdmDocumentReceiptLocalService _impl;
    private static PmlEdmDocumentReceiptLocalService _txImpl;
    private PmlEdmDocumentReceiptLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
