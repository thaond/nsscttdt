package com.sgs.portlet.sovanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LoaiVanBanNoiBoCuaSoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoService</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoService
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoServiceUtil
 *
 */
public class LoaiVanBanNoiBoCuaSoServiceFactory {
    private static final String _FACTORY = LoaiVanBanNoiBoCuaSoServiceFactory.class.getName();
    private static final String _IMPL = LoaiVanBanNoiBoCuaSoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LoaiVanBanNoiBoCuaSoService.class.getName() +
        ".transaction";
    private static LoaiVanBanNoiBoCuaSoServiceFactory _factory;
    private static LoaiVanBanNoiBoCuaSoService _impl;
    private static LoaiVanBanNoiBoCuaSoService _txImpl;
    private LoaiVanBanNoiBoCuaSoService _service;

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoCuaSoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoCuaSoService getImpl() {
        if (_impl == null) {
            _impl = (LoaiVanBanNoiBoCuaSoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoCuaSoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LoaiVanBanNoiBoCuaSoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LoaiVanBanNoiBoCuaSoService service) {
        _service = service;
    }

    private static LoaiVanBanNoiBoCuaSoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LoaiVanBanNoiBoCuaSoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
