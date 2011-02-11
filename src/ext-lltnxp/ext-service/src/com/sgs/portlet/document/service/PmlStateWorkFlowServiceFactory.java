package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlStateWorkFlowServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlStateWorkFlowService</code>.
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
 * @see com.sgs.portlet.document.service.PmlStateWorkFlowService
 * @see com.sgs.portlet.document.service.PmlStateWorkFlowServiceUtil
 *
 */
public class PmlStateWorkFlowServiceFactory {
    private static final String _FACTORY = PmlStateWorkFlowServiceFactory.class.getName();
    private static final String _IMPL = PmlStateWorkFlowService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlStateWorkFlowService.class.getName() +
        ".transaction";
    private static PmlStateWorkFlowServiceFactory _factory;
    private static PmlStateWorkFlowService _impl;
    private static PmlStateWorkFlowService _txImpl;
    private PmlStateWorkFlowService _service;

    /**
     * @deprecated
     */
    public static PmlStateWorkFlowService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlStateWorkFlowService getImpl() {
        if (_impl == null) {
            _impl = (PmlStateWorkFlowService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlStateWorkFlowService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlStateWorkFlowService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlStateWorkFlowService service) {
        _service = service;
    }

    private static PmlStateWorkFlowServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlStateWorkFlowServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
