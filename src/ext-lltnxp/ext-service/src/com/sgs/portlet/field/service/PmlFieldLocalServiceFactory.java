package com.sgs.portlet.field.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFieldLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.field.service.PmlFieldLocalService</code>.
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
 * @see com.sgs.portlet.field.service.PmlFieldLocalService
 * @see com.sgs.portlet.field.service.PmlFieldLocalServiceUtil
 *
 */
public class PmlFieldLocalServiceFactory {
    private static final String _FACTORY = PmlFieldLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFieldLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFieldLocalService.class.getName() +
        ".transaction";
    private static PmlFieldLocalServiceFactory _factory;
    private static PmlFieldLocalService _impl;
    private static PmlFieldLocalService _txImpl;
    private PmlFieldLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFieldLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFieldLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFieldLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFieldLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFieldLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFieldLocalService service) {
        _service = service;
    }

    private static PmlFieldLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFieldLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
