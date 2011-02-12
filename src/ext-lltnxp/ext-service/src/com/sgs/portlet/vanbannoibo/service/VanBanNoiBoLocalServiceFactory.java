package com.sgs.portlet.vanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="VanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalService
 * @see com.sgs.portlet.vanbannoibo.service.VanBanNoiBoLocalServiceUtil
 *
 */
public class VanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = VanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = VanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = VanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static VanBanNoiBoLocalServiceFactory _factory;
    private static VanBanNoiBoLocalService _impl;
    private static VanBanNoiBoLocalService _txImpl;
    private VanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static VanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static VanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (VanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static VanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (VanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(VanBanNoiBoLocalService service) {
        _service = service;
    }

    private static VanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (VanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
