package com.sgs.portlet.document.manageworkflow.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlManageWorkDocumentFlowServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService</code>.
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
 * @see com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowService
 * @see com.sgs.portlet.document.manageworkflow.service.PmlManageWorkDocumentFlowServiceUtil
 *
 */
public class PmlManageWorkDocumentFlowServiceFactory {
    private static final String _FACTORY = PmlManageWorkDocumentFlowServiceFactory.class.getName();
    private static final String _IMPL = PmlManageWorkDocumentFlowService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlManageWorkDocumentFlowService.class.getName() +
        ".transaction";
    private static PmlManageWorkDocumentFlowServiceFactory _factory;
    private static PmlManageWorkDocumentFlowService _impl;
    private static PmlManageWorkDocumentFlowService _txImpl;
    private PmlManageWorkDocumentFlowService _service;

    /**
     * @deprecated
     */
    public static PmlManageWorkDocumentFlowService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlManageWorkDocumentFlowService getImpl() {
        if (_impl == null) {
            _impl = (PmlManageWorkDocumentFlowService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlManageWorkDocumentFlowService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlManageWorkDocumentFlowService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlManageWorkDocumentFlowService service) {
        _service = service;
    }

    private static PmlManageWorkDocumentFlowServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlManageWorkDocumentFlowServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
