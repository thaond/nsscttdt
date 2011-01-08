package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentRelationServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlEdmDocumentRelationService</code>.
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
 * @see com.sgs.portlet.document.service.PmlEdmDocumentRelationService
 * @see com.sgs.portlet.document.service.PmlEdmDocumentRelationServiceUtil
 *
 */
public class PmlEdmDocumentRelationServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentRelationServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentRelationService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentRelationService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentRelationServiceFactory _factory;
    private static PmlEdmDocumentRelationService _impl;
    private static PmlEdmDocumentRelationService _txImpl;
    private PmlEdmDocumentRelationService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRelationService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRelationService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentRelationService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRelationService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentRelationService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentRelationService service) {
        _service = service;
    }

    private static PmlEdmDocumentRelationServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentRelationServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
