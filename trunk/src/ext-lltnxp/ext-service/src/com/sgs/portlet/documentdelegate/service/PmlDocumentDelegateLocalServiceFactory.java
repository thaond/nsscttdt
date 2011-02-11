package com.sgs.portlet.documentdelegate.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentDelegateLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService</code>.
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
 * @see com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService
 * @see com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalServiceUtil
 *
 */
public class PmlDocumentDelegateLocalServiceFactory {
    private static final String _FACTORY = PmlDocumentDelegateLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentDelegateLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentDelegateLocalService.class.getName() +
        ".transaction";
    private static PmlDocumentDelegateLocalServiceFactory _factory;
    private static PmlDocumentDelegateLocalService _impl;
    private static PmlDocumentDelegateLocalService _txImpl;
    private PmlDocumentDelegateLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentDelegateLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentDelegateLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentDelegateLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentDelegateLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentDelegateLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentDelegateLocalService service) {
        _service = service;
    }

    private static PmlDocumentDelegateLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentDelegateLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
