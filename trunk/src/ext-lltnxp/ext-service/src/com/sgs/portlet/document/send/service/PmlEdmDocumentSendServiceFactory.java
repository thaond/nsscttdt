package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentSendServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmDocumentSendService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmDocumentSendService
 * @see com.sgs.portlet.document.send.service.PmlEdmDocumentSendServiceUtil
 *
 */
public class PmlEdmDocumentSendServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentSendServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentSendService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentSendService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentSendServiceFactory _factory;
    private static PmlEdmDocumentSendService _impl;
    private static PmlEdmDocumentSendService _txImpl;
    private PmlEdmDocumentSendService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentSendService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentSendService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentSendService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentSendService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentSendService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentSendService service) {
        _service = service;
    }

    private static PmlEdmDocumentSendServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentSendServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
