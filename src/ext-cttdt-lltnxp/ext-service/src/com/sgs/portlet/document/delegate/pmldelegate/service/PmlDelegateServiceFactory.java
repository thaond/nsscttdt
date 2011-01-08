package com.sgs.portlet.document.delegate.pmldelegate.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDelegateServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateService</code>.
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
 * @see com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateService
 * @see com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateServiceUtil
 *
 */
public class PmlDelegateServiceFactory {
    private static final String _FACTORY = PmlDelegateServiceFactory.class.getName();
    private static final String _IMPL = PmlDelegateService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDelegateService.class.getName() +
        ".transaction";
    private static PmlDelegateServiceFactory _factory;
    private static PmlDelegateService _impl;
    private static PmlDelegateService _txImpl;
    private PmlDelegateService _service;

    /**
     * @deprecated
     */
    public static PmlDelegateService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDelegateService getImpl() {
        if (_impl == null) {
            _impl = (PmlDelegateService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDelegateService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDelegateService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDelegateService service) {
        _service = service;
    }

    private static PmlDelegateServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDelegateServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
