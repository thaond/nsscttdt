package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentReceiptProcessTypeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptProcessTypeServiceUtil
 *
 */
public class PmlEdmDocumentReceiptProcessTypeServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentReceiptProcessTypeServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentReceiptProcessTypeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentReceiptProcessTypeService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentReceiptProcessTypeServiceFactory _factory;
    private static PmlEdmDocumentReceiptProcessTypeService _impl;
    private static PmlEdmDocumentReceiptProcessTypeService _txImpl;
    private PmlEdmDocumentReceiptProcessTypeService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptProcessTypeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptProcessTypeService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentReceiptProcessTypeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentReceiptProcessTypeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentReceiptProcessTypeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentReceiptProcessTypeService service) {
        _service = service;
    }

    private static PmlEdmDocumentReceiptProcessTypeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentReceiptProcessTypeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
