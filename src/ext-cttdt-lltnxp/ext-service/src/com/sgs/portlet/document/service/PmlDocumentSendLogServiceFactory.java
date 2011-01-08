package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentSendLogServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentSendLogService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentSendLogService
 * @see com.sgs.portlet.document.service.PmlDocumentSendLogServiceUtil
 *
 */
public class PmlDocumentSendLogServiceFactory {
    private static final String _FACTORY = PmlDocumentSendLogServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentSendLogService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentSendLogService.class.getName() +
        ".transaction";
    private static PmlDocumentSendLogServiceFactory _factory;
    private static PmlDocumentSendLogService _impl;
    private static PmlDocumentSendLogService _txImpl;
    private PmlDocumentSendLogService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentSendLogService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentSendLogService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentSendLogService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentSendLogService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentSendLogService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentSendLogService service) {
        _service = service;
    }

    private static PmlDocumentSendLogServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentSendLogServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
