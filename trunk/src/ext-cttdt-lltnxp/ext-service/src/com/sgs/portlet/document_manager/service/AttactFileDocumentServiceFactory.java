package com.sgs.portlet.document_manager.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="AttactFileDocumentServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document_manager.service.AttactFileDocumentService</code>.
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
 * @see com.sgs.portlet.document_manager.service.AttactFileDocumentService
 * @see com.sgs.portlet.document_manager.service.AttactFileDocumentServiceUtil
 *
 */
public class AttactFileDocumentServiceFactory {
    private static final String _FACTORY = AttactFileDocumentServiceFactory.class.getName();
    private static final String _IMPL = AttactFileDocumentService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = AttactFileDocumentService.class.getName() +
        ".transaction";
    private static AttactFileDocumentServiceFactory _factory;
    private static AttactFileDocumentService _impl;
    private static AttactFileDocumentService _txImpl;
    private AttactFileDocumentService _service;

    /**
     * @deprecated
     */
    public static AttactFileDocumentService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static AttactFileDocumentService getImpl() {
        if (_impl == null) {
            _impl = (AttactFileDocumentService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static AttactFileDocumentService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (AttactFileDocumentService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(AttactFileDocumentService service) {
        _service = service;
    }

    private static AttactFileDocumentServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (AttactFileDocumentServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
