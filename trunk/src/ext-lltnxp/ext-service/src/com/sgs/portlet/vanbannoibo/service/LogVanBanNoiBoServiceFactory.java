package com.sgs.portlet.vanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LogVanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoService
 * @see com.sgs.portlet.vanbannoibo.service.LogVanBanNoiBoServiceUtil
 *
 */
public class LogVanBanNoiBoServiceFactory {
    private static final String _FACTORY = LogVanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = LogVanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LogVanBanNoiBoService.class.getName() +
        ".transaction";
    private static LogVanBanNoiBoServiceFactory _factory;
    private static LogVanBanNoiBoService _impl;
    private static LogVanBanNoiBoService _txImpl;
    private LogVanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static LogVanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LogVanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (LogVanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LogVanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LogVanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LogVanBanNoiBoService service) {
        _service = service;
    }

    private static LogVanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LogVanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
