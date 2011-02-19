package com.sgs.portlet.sovanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SoVanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalService
 * @see com.sgs.portlet.sovanbannoibo.service.SoVanBanNoiBoLocalServiceUtil
 *
 */
public class SoVanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = SoVanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = SoVanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SoVanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static SoVanBanNoiBoLocalServiceFactory _factory;
    private static SoVanBanNoiBoLocalService _impl;
    private static SoVanBanNoiBoLocalService _txImpl;
    private SoVanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static SoVanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SoVanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (SoVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SoVanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SoVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SoVanBanNoiBoLocalService service) {
        _service = service;
    }

    private static SoVanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SoVanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
