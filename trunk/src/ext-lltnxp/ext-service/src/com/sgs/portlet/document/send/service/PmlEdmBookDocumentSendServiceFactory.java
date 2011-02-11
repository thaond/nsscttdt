package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmBookDocumentSendServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendService
 * @see com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendServiceUtil
 *
 */
public class PmlEdmBookDocumentSendServiceFactory {
    private static final String _FACTORY = PmlEdmBookDocumentSendServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmBookDocumentSendService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmBookDocumentSendService.class.getName() +
        ".transaction";
    private static PmlEdmBookDocumentSendServiceFactory _factory;
    private static PmlEdmBookDocumentSendService _impl;
    private static PmlEdmBookDocumentSendService _txImpl;
    private PmlEdmBookDocumentSendService _service;

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentSendService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentSendService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmBookDocumentSendService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentSendService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmBookDocumentSendService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmBookDocumentSendService service) {
        _service = service;
    }

    private static PmlEdmBookDocumentSendServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmBookDocumentSendServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
