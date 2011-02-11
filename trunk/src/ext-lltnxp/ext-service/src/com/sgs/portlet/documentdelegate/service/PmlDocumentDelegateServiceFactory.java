package com.sgs.portlet.documentdelegate.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentDelegateServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateService</code>.
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
 * @see com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateService
 * @see com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateServiceUtil
 *
 */
public class PmlDocumentDelegateServiceFactory {
    private static final String _FACTORY = PmlDocumentDelegateServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentDelegateService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentDelegateService.class.getName() +
        ".transaction";
    private static PmlDocumentDelegateServiceFactory _factory;
    private static PmlDocumentDelegateService _impl;
    private static PmlDocumentDelegateService _txImpl;
    private PmlDocumentDelegateService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentDelegateService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentDelegateService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentDelegateService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentDelegateService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentDelegateService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentDelegateService service) {
        _service = service;
    }

    private static PmlDocumentDelegateServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentDelegateServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
