package com.sgs.portlet.document.delegate.pmldelegate.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDelegateLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService</code>.
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
 * @see com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalService
 * @see com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalServiceUtil
 *
 */
public class PmlDelegateLocalServiceFactory {
    private static final String _FACTORY = PmlDelegateLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDelegateLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDelegateLocalService.class.getName() +
        ".transaction";
    private static PmlDelegateLocalServiceFactory _factory;
    private static PmlDelegateLocalService _impl;
    private static PmlDelegateLocalService _txImpl;
    private PmlDelegateLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDelegateLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDelegateLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDelegateLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDelegateLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDelegateLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDelegateLocalService service) {
        _service = service;
    }

    private static PmlDelegateLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDelegateLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
