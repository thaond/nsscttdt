package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmWriteDocumentSendLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalService
 * @see com.sgs.portlet.document.send.service.PmlEdmWriteDocumentSendLocalServiceUtil
 *
 */
public class PmlEdmWriteDocumentSendLocalServiceFactory {
    private static final String _FACTORY = PmlEdmWriteDocumentSendLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmWriteDocumentSendLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmWriteDocumentSendLocalService.class.getName() +
        ".transaction";
    private static PmlEdmWriteDocumentSendLocalServiceFactory _factory;
    private static PmlEdmWriteDocumentSendLocalService _impl;
    private static PmlEdmWriteDocumentSendLocalService _txImpl;
    private PmlEdmWriteDocumentSendLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmWriteDocumentSendLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmWriteDocumentSendLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmWriteDocumentSendLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmWriteDocumentSendLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmWriteDocumentSendLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmWriteDocumentSendLocalService service) {
        _service = service;
    }

    private static PmlEdmWriteDocumentSendLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmWriteDocumentSendLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
