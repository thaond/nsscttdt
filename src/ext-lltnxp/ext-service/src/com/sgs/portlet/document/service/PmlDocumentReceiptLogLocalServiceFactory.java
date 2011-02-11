package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentReceiptLogLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalService
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalServiceUtil
 *
 */
public class PmlDocumentReceiptLogLocalServiceFactory {
    private static final String _FACTORY = PmlDocumentReceiptLogLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentReceiptLogLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentReceiptLogLocalService.class.getName() +
        ".transaction";
    private static PmlDocumentReceiptLogLocalServiceFactory _factory;
    private static PmlDocumentReceiptLogLocalService _impl;
    private static PmlDocumentReceiptLogLocalService _txImpl;
    private PmlDocumentReceiptLogLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptLogLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptLogLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentReceiptLogLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptLogLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentReceiptLogLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentReceiptLogLocalService service) {
        _service = service;
    }

    private static PmlDocumentReceiptLogLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentReceiptLogLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
