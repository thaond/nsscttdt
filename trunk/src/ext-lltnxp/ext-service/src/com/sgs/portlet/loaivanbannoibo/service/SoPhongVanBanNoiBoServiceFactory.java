package com.sgs.portlet.loaivanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SoPhongVanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoService
 * @see com.sgs.portlet.loaivanbannoibo.service.SoPhongVanBanNoiBoServiceUtil
 *
 */
public class SoPhongVanBanNoiBoServiceFactory {
    private static final String _FACTORY = SoPhongVanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = SoPhongVanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SoPhongVanBanNoiBoService.class.getName() +
        ".transaction";
    private static SoPhongVanBanNoiBoServiceFactory _factory;
    private static SoPhongVanBanNoiBoService _impl;
    private static SoPhongVanBanNoiBoService _txImpl;
    private SoPhongVanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static SoPhongVanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SoPhongVanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (SoPhongVanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SoPhongVanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SoPhongVanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SoPhongVanBanNoiBoService service) {
        _service = service;
    }

    private static SoPhongVanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SoPhongVanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
