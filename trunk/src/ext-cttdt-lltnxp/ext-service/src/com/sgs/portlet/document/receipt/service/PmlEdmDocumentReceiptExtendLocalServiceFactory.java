package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptExtendLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalServiceUtil
 *
 */
public class PmlEdmDocumentReceiptExtendLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptExtendLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptExtendLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptExtendLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptExtendLocalServiceFactory _factory;
    private static PmlEdmDocumentReceiptExtendLocalService _impl;
    private static PmlEdmDocumentReceiptExtendLocalService _txImpl;
    private PmlEdmDocumentReceiptExtendLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptExtendLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptExtendLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptExtendLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptExtendLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptExtendLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptExtendLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptExtendLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptExtendLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
