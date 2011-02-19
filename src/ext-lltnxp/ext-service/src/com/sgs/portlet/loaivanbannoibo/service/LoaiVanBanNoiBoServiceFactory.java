package com.sgs.portlet.loaivanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LoaiVanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoService
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiVanBanNoiBoServiceUtil
 *
 */
public class LoaiVanBanNoiBoServiceFactory {
    private static final String _FACTORY = LoaiVanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = LoaiVanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LoaiVanBanNoiBoService.class.getName() +
        ".transaction";
    private static LoaiVanBanNoiBoServiceFactory _factory;
    private static LoaiVanBanNoiBoService _impl;
    private static LoaiVanBanNoiBoService _txImpl;
    private LoaiVanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (LoaiVanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LoaiVanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LoaiVanBanNoiBoService service) {
        _service = service;
    }

    private static LoaiVanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LoaiVanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
