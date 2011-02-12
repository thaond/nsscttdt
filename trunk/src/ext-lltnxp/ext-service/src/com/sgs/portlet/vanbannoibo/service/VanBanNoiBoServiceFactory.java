package com.sgs.portlet.vanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="VanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.VanBanNoiBoService
 * @see com.sgs.portlet.vanbannoibo.service.VanBanNoiBoServiceUtil
 *
 */
public class VanBanNoiBoServiceFactory {
    private static final String _FACTORY = VanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = VanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = VanBanNoiBoService.class.getName() +
        ".transaction";
    private static VanBanNoiBoServiceFactory _factory;
    private static VanBanNoiBoService _impl;
    private static VanBanNoiBoService _txImpl;
    private VanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static VanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static VanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (VanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static VanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (VanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(VanBanNoiBoService service) {
        _service = service;
    }

    private static VanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (VanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
