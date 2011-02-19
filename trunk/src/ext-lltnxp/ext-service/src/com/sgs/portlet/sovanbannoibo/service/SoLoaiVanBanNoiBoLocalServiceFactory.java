package com.sgs.portlet.sovanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SoLoaiVanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalService
 * @see com.sgs.portlet.sovanbannoibo.service.SoLoaiVanBanNoiBoLocalServiceUtil
 *
 */
public class SoLoaiVanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = SoLoaiVanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = SoLoaiVanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SoLoaiVanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static SoLoaiVanBanNoiBoLocalServiceFactory _factory;
    private static SoLoaiVanBanNoiBoLocalService _impl;
    private static SoLoaiVanBanNoiBoLocalService _txImpl;
    private SoLoaiVanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static SoLoaiVanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SoLoaiVanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (SoLoaiVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SoLoaiVanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SoLoaiVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SoLoaiVanBanNoiBoLocalService service) {
        _service = service;
    }

    private static SoLoaiVanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SoLoaiVanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
