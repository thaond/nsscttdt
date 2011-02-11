package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlWorkflowServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlWorkflowService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlWorkflowService
 * @see com.sgs.portlet.onedoor.service.PmlWorkflowServiceUtil
 *
 */
public class PmlWorkflowServiceFactory {
    private static final String _FACTORY = PmlWorkflowServiceFactory.class.getName();
    private static final String _IMPL = PmlWorkflowService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlWorkflowService.class.getName() +
        ".transaction";
    private static PmlWorkflowServiceFactory _factory;
    private static PmlWorkflowService _impl;
    private static PmlWorkflowService _txImpl;
    private PmlWorkflowService _service;

    /**
     * @deprecated
     */
    public static PmlWorkflowService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlWorkflowService getImpl() {
        if (_impl == null) {
            _impl = (PmlWorkflowService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlWorkflowService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlWorkflowService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlWorkflowService service) {
        _service = service;
    }

    private static PmlWorkflowServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlWorkflowServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
