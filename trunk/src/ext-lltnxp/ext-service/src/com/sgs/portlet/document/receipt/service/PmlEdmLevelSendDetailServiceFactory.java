package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmLevelSendDetailServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailServiceUtil
 *
 */
public class PmlEdmLevelSendDetailServiceFactory {
    private static final String _FACTORY = PmlEdmLevelSendDetailServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmLevelSendDetailService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmLevelSendDetailService.class.getName() +
        ".transaction";
    private static PmlEdmLevelSendDetailServiceFactory _factory;
    private static PmlEdmLevelSendDetailService _impl;
    private static PmlEdmLevelSendDetailService _txImpl;
    private PmlEdmLevelSendDetailService _service;

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendDetailService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendDetailService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmLevelSendDetailService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendDetailService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmLevelSendDetailService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmLevelSendDetailService service) {
        _service = service;
    }

    private static PmlEdmLevelSendDetailServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmLevelSendDetailServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
