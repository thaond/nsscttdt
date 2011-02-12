package com.sgs.portlet.vanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="FileDinhKemVanBanNoiBoLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalService</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalService
 * @see com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoLocalServiceUtil
 *
 */
public class FileDinhKemVanBanNoiBoLocalServiceFactory {
    private static final String _FACTORY = FileDinhKemVanBanNoiBoLocalServiceFactory.class.getName();
    private static final String _IMPL = FileDinhKemVanBanNoiBoLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = FileDinhKemVanBanNoiBoLocalService.class.getName() +
        ".transaction";
    private static FileDinhKemVanBanNoiBoLocalServiceFactory _factory;
    private static FileDinhKemVanBanNoiBoLocalService _impl;
    private static FileDinhKemVanBanNoiBoLocalService _txImpl;
    private FileDinhKemVanBanNoiBoLocalService _service;

    /**
     * @deprecated
     */
    public static FileDinhKemVanBanNoiBoLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static FileDinhKemVanBanNoiBoLocalService getImpl() {
        if (_impl == null) {
            _impl = (FileDinhKemVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static FileDinhKemVanBanNoiBoLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (FileDinhKemVanBanNoiBoLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(FileDinhKemVanBanNoiBoLocalService service) {
        _service = service;
    }

    private static FileDinhKemVanBanNoiBoLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (FileDinhKemVanBanNoiBoLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
