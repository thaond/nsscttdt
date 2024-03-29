package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentSendLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalService
 * @see com.sgs.portlet.document.send.service.PmlEdmDocumentSendLocalServiceUtil
 *
 */
public class PmlEdmDocumentSendLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentSendLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentSendLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentSendLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentSendLocalServiceFactory _factory;
    private static PmlEdmDocumentSendLocalService _impl;
    private static PmlEdmDocumentSendLocalService _txImpl;
    private PmlEdmDocumentSendLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentSendLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentSendLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentSendLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentSendLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentSendLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentSendLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentSendLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentSendLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
