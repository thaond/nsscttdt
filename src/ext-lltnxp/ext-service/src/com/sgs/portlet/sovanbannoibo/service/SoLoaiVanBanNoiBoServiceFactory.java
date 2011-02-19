package com.sgs.portlet.sovanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SoLoaiVanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoService
 * @see com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoServiceUtil
 *
 */
public class SoLoaiVanBanNoiBoServiceFactory {
    private static final String _FACTORY = SoLoaiVanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = SoLoaiVanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SoLoaiVanBanNoiBoService.class.getName() +
        ".transaction";
    private static SoLoaiVanBanNoiBoServiceFactory _factory;
    private static SoLoaiVanBanNoiBoService _impl;
    private static SoLoaiVanBanNoiBoService _txImpl;
    private SoLoaiVanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static SoLoaiVanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SoLoaiVanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (SoLoaiVanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SoLoaiVanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SoLoaiVanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SoLoaiVanBanNoiBoService service) {
        _service = service;
    }

    private static SoLoaiVanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SoLoaiVanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
