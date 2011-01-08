package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlStateProcessServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlStateProcessService</code>.
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
 * @see com.sgs.portlet.document.service.PmlStateProcessService
 * @see com.sgs.portlet.document.service.PmlStateProcessServiceUtil
 *
 */
public class PmlStateProcessServiceFactory {
    private static final String _FACTORY = PmlStateProcessServiceFactory.class.getName();
    private static final String _IMPL = PmlStateProcessService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlStateProcessService.class.getName() +
        ".transaction";
    private static PmlStateProcessServiceFactory _factory;
    private static PmlStateProcessService _impl;
    private static PmlStateProcessService _txImpl;
    private PmlStateProcessService _service;

    /**
     * @deprecated
     */
    public static PmlStateProcessService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlStateProcessService getImpl() {
        if (_impl == null) {
            _impl = (PmlStateProcessService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlStateProcessService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlStateProcessService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlStateProcessService service) {
        _service = service;
    }

    private static PmlStateProcessServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlStateProcessServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
