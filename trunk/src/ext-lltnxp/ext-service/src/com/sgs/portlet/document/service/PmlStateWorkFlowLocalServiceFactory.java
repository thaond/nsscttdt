package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlStateWorkFlowLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlStateWorkFlowLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlStateWorkFlowLocalService
 * @see com.sgs.portlet.document.service.PmlStateWorkFlowLocalServiceUtil
 *
 */
public class PmlStateWorkFlowLocalServiceFactory {
    private static final String _FACTORY = PmlStateWorkFlowLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlStateWorkFlowLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlStateWorkFlowLocalService.class.getName() +
        ".transaction";
    private static PmlStateWorkFlowLocalServiceFactory _factory;
    private static PmlStateWorkFlowLocalService _impl;
    private static PmlStateWorkFlowLocalService _txImpl;
    private PmlStateWorkFlowLocalService _service;

    /**
     * @deprecated
     */
    public static PmlStateWorkFlowLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlStateWorkFlowLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlStateWorkFlowLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlStateWorkFlowLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlStateWorkFlowLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlStateWorkFlowLocalService service) {
        _service = service;
    }

    private static PmlStateWorkFlowLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlStateWorkFlowLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
