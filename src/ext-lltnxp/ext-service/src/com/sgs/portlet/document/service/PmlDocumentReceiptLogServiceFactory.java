package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentReceiptLogServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptLogService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptLogService
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptLogServiceUtil
 *
 */
public class PmlDocumentReceiptLogServiceFactory {
    private static final String _FACTORY = PmlDocumentReceiptLogServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentReceiptLogService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentReceiptLogService.class.getName() +
        ".transaction";
    private static PmlDocumentReceiptLogServiceFactory _factory;
    private static PmlDocumentReceiptLogService _impl;
    private static PmlDocumentReceiptLogService _txImpl;
    private PmlDocumentReceiptLogService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptLogService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptLogService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentReceiptLogService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptLogService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentReceiptLogService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentReceiptLogService service) {
        _service = service;
    }

    private static PmlDocumentReceiptLogServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentReceiptLogServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
