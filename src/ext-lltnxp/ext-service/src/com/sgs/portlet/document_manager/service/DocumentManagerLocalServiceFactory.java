package com.sgs.portlet.document_manager.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="DocumentManagerLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document_manager.service.DocumentManagerLocalService</code>.
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
 * @see com.sgs.portlet.document_manager.service.DocumentManagerLocalService
 * @see com.sgs.portlet.document_manager.service.DocumentManagerLocalServiceUtil
 *
 */
public class DocumentManagerLocalServiceFactory {
    private static final String _FACTORY = DocumentManagerLocalServiceFactory.class.getName();
    private static final String _IMPL = DocumentManagerLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = DocumentManagerLocalService.class.getName() +
        ".transaction";
    private static DocumentManagerLocalServiceFactory _factory;
    private static DocumentManagerLocalService _impl;
    private static DocumentManagerLocalService _txImpl;
    private DocumentManagerLocalService _service;

    /**
     * @deprecated
     */
    public static DocumentManagerLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static DocumentManagerLocalService getImpl() {
        if (_impl == null) {
            _impl = (DocumentManagerLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static DocumentManagerLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (DocumentManagerLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(DocumentManagerLocalService service) {
        _service = service;
    }

    private static DocumentManagerLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (DocumentManagerLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
