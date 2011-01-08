package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmBookDocumentSendLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalService
 * @see com.sgs.portlet.document.send.service.PmlEdmBookDocumentSendLocalServiceUtil
 *
 */
public class PmlEdmBookDocumentSendLocalServiceFactory {
    private static final String _FACTORY = PmlEdmBookDocumentSendLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmBookDocumentSendLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmBookDocumentSendLocalService.class.getName() +
        ".transaction";
    private static PmlEdmBookDocumentSendLocalServiceFactory _factory;
    private static PmlEdmBookDocumentSendLocalService _impl;
    private static PmlEdmBookDocumentSendLocalService _txImpl;
    private PmlEdmBookDocumentSendLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentSendLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentSendLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmBookDocumentSendLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentSendLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmBookDocumentSendLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmBookDocumentSendLocalService service) {
        _service = service;
    }

    private static PmlEdmBookDocumentSendLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmBookDocumentSendLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
