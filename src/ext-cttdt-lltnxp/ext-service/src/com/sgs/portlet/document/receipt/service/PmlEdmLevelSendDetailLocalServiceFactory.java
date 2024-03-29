package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmLevelSendDetailLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalServiceUtil
 *
 */
public class PmlEdmLevelSendDetailLocalServiceFactory {
    private static final String _FACTORY = PmlEdmLevelSendDetailLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmLevelSendDetailLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmLevelSendDetailLocalService.class.getName() +
        ".transaction";
    private static PmlEdmLevelSendDetailLocalServiceFactory _factory;
    private static PmlEdmLevelSendDetailLocalService _impl;
    private static PmlEdmLevelSendDetailLocalService _txImpl;
    private PmlEdmLevelSendDetailLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendDetailLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendDetailLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmLevelSendDetailLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmLevelSendDetailLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmLevelSendDetailLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmLevelSendDetailLocalService service) {
        _service = service;
    }

    private static PmlEdmLevelSendDetailLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmLevelSendDetailLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
