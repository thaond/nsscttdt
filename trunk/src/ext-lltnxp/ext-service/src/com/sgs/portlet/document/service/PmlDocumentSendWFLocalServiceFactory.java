package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentSendWFLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentSendWFLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentSendWFLocalService
 * @see com.sgs.portlet.document.service.PmlDocumentSendWFLocalServiceUtil
 *
 */
public class PmlDocumentSendWFLocalServiceFactory {
    private static final String _FACTORY = PmlDocumentSendWFLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentSendWFLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentSendWFLocalService.class.getName() +
        ".transaction";
    private static PmlDocumentSendWFLocalServiceFactory _factory;
    private static PmlDocumentSendWFLocalService _impl;
    private static PmlDocumentSendWFLocalService _txImpl;
    private PmlDocumentSendWFLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentSendWFLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentSendWFLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentSendWFLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentSendWFLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentSendWFLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentSendWFLocalService service) {
        _service = service;
    }

    private static PmlDocumentSendWFLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentSendWFLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
