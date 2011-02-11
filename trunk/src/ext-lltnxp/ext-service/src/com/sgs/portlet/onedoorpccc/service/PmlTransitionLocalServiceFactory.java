package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTransitionLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlTransitionLocalService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlTransitionLocalService
 * @see com.sgs.portlet.onedoorpccc.service.PmlTransitionLocalServiceUtil
 *
 */
public class PmlTransitionLocalServiceFactory {
    private static final String _FACTORY = PmlTransitionLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlTransitionLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTransitionLocalService.class.getName() +
        ".transaction";
    private static PmlTransitionLocalServiceFactory _factory;
    private static PmlTransitionLocalService _impl;
    private static PmlTransitionLocalService _txImpl;
    private PmlTransitionLocalService _service;

    /**
     * @deprecated
     */
    public static PmlTransitionLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTransitionLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlTransitionLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTransitionLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTransitionLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTransitionLocalService service) {
        _service = service;
    }

    private static PmlTransitionLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTransitionLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
