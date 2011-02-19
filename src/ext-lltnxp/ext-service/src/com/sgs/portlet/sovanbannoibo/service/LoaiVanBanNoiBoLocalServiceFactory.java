package com.sgs.portlet.sovanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="LoaiVanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoLocalService
 * @see com.sgs.portlet.sovanbannoibo.service.LoaiVanBanNoiBoLocalServiceUtil
 *
 */
public class LoaiVanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = LoaiVanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = LoaiVanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = LoaiVanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static LoaiVanBanNoiBoLocalServiceFactory _factory;
    private static LoaiVanBanNoiBoLocalService _impl;
    private static LoaiVanBanNoiBoLocalService _txImpl;
    private LoaiVanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (LoaiVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static LoaiVanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (LoaiVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(LoaiVanBanNoiBoLocalService service) {
        _service = service;
    }

    private static LoaiVanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (LoaiVanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
