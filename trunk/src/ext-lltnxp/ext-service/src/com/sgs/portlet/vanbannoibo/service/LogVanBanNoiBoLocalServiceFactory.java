package com.sgs.portlet.vanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LogVanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalService
 * @see com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoLocalServiceUtil
 *
 */
public class LogVanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = LogVanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = LogVanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LogVanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static LogVanBanNoiBoLocalServiceFactory _factory;
    private static LogVanBanNoiBoLocalService _impl;
    private static LogVanBanNoiBoLocalService _txImpl;
    private LogVanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static LogVanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LogVanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (LogVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LogVanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LogVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LogVanBanNoiBoLocalService service) {
        _service = service;
    }

    private static LogVanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LogVanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
