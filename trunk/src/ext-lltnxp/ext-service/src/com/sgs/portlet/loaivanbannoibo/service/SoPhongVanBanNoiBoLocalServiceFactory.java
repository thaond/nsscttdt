package com.sgs.portlet.loaivanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SoPhongVanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalService
 * @see com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoLocalServiceUtil
 *
 */
public class SoPhongVanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = SoPhongVanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = SoPhongVanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SoPhongVanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static SoPhongVanBanNoiBoLocalServiceFactory _factory;
    private static SoPhongVanBanNoiBoLocalService _impl;
    private static SoPhongVanBanNoiBoLocalService _txImpl;
    private SoPhongVanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static SoPhongVanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SoPhongVanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (SoPhongVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SoPhongVanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SoPhongVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SoPhongVanBanNoiBoLocalService service) {
        _service = service;
    }

    private static SoPhongVanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SoPhongVanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
