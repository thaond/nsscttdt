package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileReturningInfoServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoService
 * @see com.sgs.portlet.onedoorpccc.service.PmlFileReturningInfoServiceUtil
 *
 */
public class PmlFileReturningInfoServiceFactory {
    private static final String _FACTORY = PmlFileReturningInfoServiceFactory.class.getName();
    private static final String _IMPL = PmlFileReturningInfoService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileReturningInfoService.class.getName() +
        ".transaction";
    private static PmlFileReturningInfoServiceFactory _factory;
    private static PmlFileReturningInfoService _impl;
    private static PmlFileReturningInfoService _txImpl;
    private PmlFileReturningInfoService _service;

    /**
     * @deprecated
     */
    public static PmlFileReturningInfoService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileReturningInfoService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileReturningInfoService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileReturningInfoService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileReturningInfoService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileReturningInfoService service) {
        _service = service;
    }

    private static PmlFileReturningInfoServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileReturningInfoServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
