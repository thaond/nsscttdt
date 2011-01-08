package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlMainSupportLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlMainSupportLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlMainSupportLocalService
 * @see com.sgs.portlet.document.service.PmlMainSupportLocalServiceUtil
 *
 */
public class PmlMainSupportLocalServiceFactory {
    private static final String _FACTORY = PmlMainSupportLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlMainSupportLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlMainSupportLocalService.class.getName() +
        ".transaction";
    private static PmlMainSupportLocalServiceFactory _factory;
    private static PmlMainSupportLocalService _impl;
    private static PmlMainSupportLocalService _txImpl;
    private PmlMainSupportLocalService _service;

    /**
     * @deprecated
     */
    public static PmlMainSupportLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlMainSupportLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlMainSupportLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlMainSupportLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlMainSupportLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlMainSupportLocalService service) {
        _service = service;
    }

    private static PmlMainSupportLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlMainSupportLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
