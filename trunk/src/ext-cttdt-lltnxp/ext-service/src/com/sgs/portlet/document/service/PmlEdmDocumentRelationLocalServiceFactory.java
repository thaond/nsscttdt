package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentRelationLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalService
 * @see com.sgs.portlet.document.service.PmlEdmDocumentRelationLocalServiceUtil
 *
 */
public class PmlEdmDocumentRelationLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentRelationLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentRelationLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentRelationLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentRelationLocalServiceFactory _factory;
    private static PmlEdmDocumentRelationLocalService _impl;
    private static PmlEdmDocumentRelationLocalService _txImpl;
    private PmlEdmDocumentRelationLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRelationLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRelationLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentRelationLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRelationLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentRelationLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentRelationLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentRelationLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentRelationLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
