package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlWorkflowLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlWorkflowLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlWorkflowLocalService
 * @see com.sgs.portlet.onedoor.service.PmlWorkflowLocalServiceUtil
 *
 */
public class PmlWorkflowLocalServiceFactory {
    private static final String _FACTORY = PmlWorkflowLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlWorkflowLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlWorkflowLocalService.class.getName() +
        ".transaction";
    private static PmlWorkflowLocalServiceFactory _factory;
    private static PmlWorkflowLocalService _impl;
    private static PmlWorkflowLocalService _txImpl;
    private PmlWorkflowLocalService _service;

    /**
     * @deprecated
     */
    public static PmlWorkflowLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlWorkflowLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlWorkflowLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlWorkflowLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlWorkflowLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlWorkflowLocalService service) {
        _service = service;
    }

    private static PmlWorkflowLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlWorkflowLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
