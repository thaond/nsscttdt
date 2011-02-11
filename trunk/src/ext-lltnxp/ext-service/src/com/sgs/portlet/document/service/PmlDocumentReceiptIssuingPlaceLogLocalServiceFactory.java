package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalService
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalServiceUtil
 *
 */
public class PmlDocumentReceiptIssuingPlaceLogLocalServiceFactory {
    private static final String _FACTORY = PmlDocumentReceiptIssuingPlaceLogLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentReceiptIssuingPlaceLogLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentReceiptIssuingPlaceLogLocalService.class.getName() +
        ".transaction";
    private static PmlDocumentReceiptIssuingPlaceLogLocalServiceFactory _factory;
    private static PmlDocumentReceiptIssuingPlaceLogLocalService _impl;
    private static PmlDocumentReceiptIssuingPlaceLogLocalService _txImpl;
    private PmlDocumentReceiptIssuingPlaceLogLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptIssuingPlaceLogLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptIssuingPlaceLogLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentReceiptIssuingPlaceLogLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptIssuingPlaceLogLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentReceiptIssuingPlaceLogLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(
        PmlDocumentReceiptIssuingPlaceLogLocalService service) {
        _service = service;
    }

    private static PmlDocumentReceiptIssuingPlaceLogLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentReceiptIssuingPlaceLogLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
