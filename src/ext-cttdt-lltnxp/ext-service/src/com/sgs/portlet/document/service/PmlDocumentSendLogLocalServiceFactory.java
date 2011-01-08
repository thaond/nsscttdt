package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentSendLogLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentSendLogLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentSendLogLocalService
 * @see com.sgs.portlet.document.service.PmlDocumentSendLogLocalServiceUtil
 *
 */
public class PmlDocumentSendLogLocalServiceFactory {
    private static final String _FACTORY = PmlDocumentSendLogLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentSendLogLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentSendLogLocalService.class.getName() +
        ".transaction";
    private static PmlDocumentSendLogLocalServiceFactory _factory;
    private static PmlDocumentSendLogLocalService _impl;
    private static PmlDocumentSendLogLocalService _txImpl;
    private PmlDocumentSendLogLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentSendLogLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentSendLogLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentSendLogLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentSendLogLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentSendLogLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentSendLogLocalService service) {
        _service = service;
    }

    private static PmlDocumentSendLogLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentSendLogLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
