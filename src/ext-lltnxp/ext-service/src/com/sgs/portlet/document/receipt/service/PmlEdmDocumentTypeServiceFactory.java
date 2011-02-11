package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentTypeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentTypeServiceUtil
 *
 */
public class PmlEdmDocumentTypeServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentTypeServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentTypeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentTypeService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentTypeServiceFactory _factory;
    private static PmlEdmDocumentTypeService _impl;
    private static PmlEdmDocumentTypeService _txImpl;
    private PmlEdmDocumentTypeService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentTypeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentTypeService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentTypeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentTypeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentTypeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentTypeService service) {
        _service = service;
    }

    private static PmlEdmDocumentTypeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentTypeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
