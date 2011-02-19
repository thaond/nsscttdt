package com.sgs.portlet.loaivanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LoaiPhongVanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoService
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoServiceUtil
 *
 */
public class LoaiPhongVanBanNoiBoServiceFactory {
    private static final String _FACTORY = LoaiPhongVanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = LoaiPhongVanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LoaiPhongVanBanNoiBoService.class.getName() +
        ".transaction";
    private static LoaiPhongVanBanNoiBoServiceFactory _factory;
    private static LoaiPhongVanBanNoiBoService _impl;
    private static LoaiPhongVanBanNoiBoService _txImpl;
    private LoaiPhongVanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static LoaiPhongVanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LoaiPhongVanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (LoaiPhongVanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LoaiPhongVanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LoaiPhongVanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LoaiPhongVanBanNoiBoService service) {
        _service = service;
    }

    private static LoaiPhongVanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LoaiPhongVanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
