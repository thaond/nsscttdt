package com.sgs.portlet.sovanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LoaiVanBanNoiBoCuaSoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalService</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalService
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoCuaSoLocalServiceUtil
 *
 */
public class LoaiVanBanNoiBoCuaSoLocalServiceFactory {
    private static final String _FACTORY = LoaiVanBanNoiBoCuaSoLocalServiceFactory.class.getName();
    private static final String _IMPL = LoaiVanBanNoiBoCuaSoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LoaiVanBanNoiBoCuaSoLocalService.class.getName() +
        ".transaction";
    private static LoaiVanBanNoiBoCuaSoLocalServiceFactory _factory;
    private static LoaiVanBanNoiBoCuaSoLocalService _impl;
    private static LoaiVanBanNoiBoCuaSoLocalService _txImpl;
    private LoaiVanBanNoiBoCuaSoLocalService _service;

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoCuaSoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoCuaSoLocalService getImpl() {
        if (_impl == null) {
            _impl = (LoaiVanBanNoiBoCuaSoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoCuaSoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LoaiVanBanNoiBoCuaSoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LoaiVanBanNoiBoCuaSoLocalService service) {
        _service = service;
    }

    private static LoaiVanBanNoiBoCuaSoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LoaiVanBanNoiBoCuaSoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
