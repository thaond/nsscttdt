package com.sgs.portlet.loaivanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LoaiPhongVanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoLocalService
 * @see com.sgs.portlet.loaivanbannoibo.service.LoaiPhongVanBanNoiBoLocalServiceUtil
 *
 */
public class LoaiPhongVanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = LoaiPhongVanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = LoaiPhongVanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LoaiPhongVanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static LoaiPhongVanBanNoiBoLocalServiceFactory _factory;
    private static LoaiPhongVanBanNoiBoLocalService _impl;
    private static LoaiPhongVanBanNoiBoLocalService _txImpl;
    private LoaiPhongVanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static LoaiPhongVanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LoaiPhongVanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (LoaiPhongVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LoaiPhongVanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LoaiPhongVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LoaiPhongVanBanNoiBoLocalService service) {
        _service = service;
    }

    private static LoaiPhongVanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LoaiPhongVanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
