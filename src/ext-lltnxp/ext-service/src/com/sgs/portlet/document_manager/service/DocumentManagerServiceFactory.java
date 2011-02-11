package com.sgs.portlet.document_manager.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="DocumentManagerServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document_manager.service.DocumentManagerService</code>.
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
 * @see com.sgs.portlet.document_manager.service.DocumentManagerService
 * @see com.sgs.portlet.document_manager.service.DocumentManagerServiceUtil
 *
 */
public class DocumentManagerServiceFactory {
    private static final String _FACTORY = DocumentManagerServiceFactory.class.getName();
    private static final String _IMPL = DocumentManagerService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = DocumentManagerService.class.getName() +
        ".transaction";
    private static DocumentManagerServiceFactory _factory;
    private static DocumentManagerService _impl;
    private static DocumentManagerService _txImpl;
    private DocumentManagerService _service;

    /**
     * @deprecated
     */
    public static DocumentManagerService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static DocumentManagerService getImpl() {
        if (_impl == null) {
            _impl = (DocumentManagerService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static DocumentManagerService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (DocumentManagerService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(DocumentManagerService service) {
        _service = service;
    }

    private static DocumentManagerServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (DocumentManagerServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
