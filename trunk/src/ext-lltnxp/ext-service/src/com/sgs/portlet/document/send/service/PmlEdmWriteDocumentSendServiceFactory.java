package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmWriteDocumentSendServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendService
 * @see com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendServiceUtil
 *
 */
public class PmlEdmWriteDocumentSendServiceFactory {
    private static final String _FACTORY = PmlEdmWriteDocumentSendServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmWriteDocumentSendService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmWriteDocumentSendService.class.getName() +
        ".transaction";
    private static PmlEdmWriteDocumentSendServiceFactory _factory;
    private static PmlEdmWriteDocumentSendService _impl;
    private static PmlEdmWriteDocumentSendService _txImpl;
    private PmlEdmWriteDocumentSendService _service;

    /**
     * @deprecated
     */
    public static PmlEdmWriteDocumentSendService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmWriteDocumentSendService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmWriteDocumentSendService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmWriteDocumentSendService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmWriteDocumentSendService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmWriteDocumentSendService service) {
        _service = service;
    }

    private static PmlEdmWriteDocumentSendServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmWriteDocumentSendServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
