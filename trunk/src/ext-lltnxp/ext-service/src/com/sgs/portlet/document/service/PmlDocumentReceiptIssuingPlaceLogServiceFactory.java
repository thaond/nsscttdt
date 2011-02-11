package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogService
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogServiceUtil
 *
 */
public class PmlDocumentReceiptIssuingPlaceLogServiceFactory {
    private static final String _FACTORY = PmlDocumentReceiptIssuingPlaceLogServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentReceiptIssuingPlaceLogService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentReceiptIssuingPlaceLogService.class.getName() +
        ".transaction";
    private static PmlDocumentReceiptIssuingPlaceLogServiceFactory _factory;
    private static PmlDocumentReceiptIssuingPlaceLogService _impl;
    private static PmlDocumentReceiptIssuingPlaceLogService _txImpl;
    private PmlDocumentReceiptIssuingPlaceLogService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptIssuingPlaceLogService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptIssuingPlaceLogService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentReceiptIssuingPlaceLogService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptIssuingPlaceLogService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentReceiptIssuingPlaceLogService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentReceiptIssuingPlaceLogService service) {
        _service = service;
    }

    private static PmlDocumentReceiptIssuingPlaceLogServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentReceiptIssuingPlaceLogServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
