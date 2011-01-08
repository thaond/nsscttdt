package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentReceiptWFServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptWFService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptWFService
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptWFServiceUtil
 *
 */
public class PmlDocumentReceiptWFServiceFactory {
    private static final String _FACTORY = PmlDocumentReceiptWFServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentReceiptWFService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentReceiptWFService.class.getName() +
        ".transaction";
    private static PmlDocumentReceiptWFServiceFactory _factory;
    private static PmlDocumentReceiptWFService _impl;
    private static PmlDocumentReceiptWFService _txImpl;
    private PmlDocumentReceiptWFService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptWFService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptWFService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentReceiptWFService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptWFService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentReceiptWFService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentReceiptWFService service) {
        _service = service;
    }

    private static PmlDocumentReceiptWFServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentReceiptWFServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
