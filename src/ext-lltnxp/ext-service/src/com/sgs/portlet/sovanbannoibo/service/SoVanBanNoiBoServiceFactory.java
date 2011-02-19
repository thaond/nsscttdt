package com.sgs.portlet.sovanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SoVanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoService
 * @see com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoServiceUtil
 *
 */
public class SoVanBanNoiBoServiceFactory {
    private static final String _FACTORY = SoVanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = SoVanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SoVanBanNoiBoService.class.getName() +
        ".transaction";
    private static SoVanBanNoiBoServiceFactory _factory;
    private static SoVanBanNoiBoService _impl;
    private static SoVanBanNoiBoService _txImpl;
    private SoVanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static SoVanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SoVanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (SoVanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SoVanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SoVanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SoVanBanNoiBoService service) {
        _service = service;
    }

    private static SoVanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SoVanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
