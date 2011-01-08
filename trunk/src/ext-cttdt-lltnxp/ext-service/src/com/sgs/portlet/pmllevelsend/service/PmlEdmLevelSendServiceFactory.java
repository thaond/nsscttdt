package com.sgs.portlet.pmllevelsend.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmLevelSendServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendService</code>.
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
 * @see com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendService
 * @see com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendServiceUtil
 *
 */
public class PmlEdmLevelSendServiceFactory {
    private static final String _FACTORY = PmlEdmLevelSendServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmLevelSendService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmLevelSendService.class.getName() +
        ".transaction";
    private static PmlEdmLevelSendServiceFactory _factory;
    private static PmlEdmLevelSendService _impl;
    private static PmlEdmLevelSendService _txImpl;
    private PmlEdmLevelSendService _service;

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmLevelSendService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmLevelSendService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmLevelSendService service) {
        _service = service;
    }

    private static PmlEdmLevelSendServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmLevelSendServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
