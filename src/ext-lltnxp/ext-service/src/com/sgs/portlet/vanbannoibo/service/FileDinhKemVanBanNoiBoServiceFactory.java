package com.sgs.portlet.vanbannoibo.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="FileDinhKemVanBanNoiBoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoService</code>.
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
 * @see com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoService
 * @see com.sgs.portlet.vanbannoibo.service.FileDinhKemVanBanNoiBoServiceUtil
 *
 */
public class FileDinhKemVanBanNoiBoServiceFactory {
    private static final String _FACTORY = FileDinhKemVanBanNoiBoServiceFactory.class.getName();
    private static final String _IMPL = FileDinhKemVanBanNoiBoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = FileDinhKemVanBanNoiBoService.class.getName() +
        ".transaction";
    private static FileDinhKemVanBanNoiBoServiceFactory _factory;
    private static FileDinhKemVanBanNoiBoService _impl;
    private static FileDinhKemVanBanNoiBoService _txImpl;
    private FileDinhKemVanBanNoiBoService _service;

    /**
     * @deprecated
     */
    public static FileDinhKemVanBanNoiBoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static FileDinhKemVanBanNoiBoService getImpl() {
        if (_impl == null) {
            _impl = (FileDinhKemVanBanNoiBoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static FileDinhKemVanBanNoiBoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (FileDinhKemVanBanNoiBoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(FileDinhKemVanBanNoiBoService service) {
        _service = service;
    }

    private static FileDinhKemVanBanNoiBoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (FileDinhKemVanBanNoiBoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
