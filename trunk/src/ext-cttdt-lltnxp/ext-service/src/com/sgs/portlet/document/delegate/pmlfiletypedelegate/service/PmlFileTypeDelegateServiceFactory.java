package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileTypeDelegateServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateService</code>.
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
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateService
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateServiceUtil
 *
 */
public class PmlFileTypeDelegateServiceFactory {
    private static final String _FACTORY = PmlFileTypeDelegateServiceFactory.class.getName();
    private static final String _IMPL = PmlFileTypeDelegateService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileTypeDelegateService.class.getName() +
        ".transaction";
    private static PmlFileTypeDelegateServiceFactory _factory;
    private static PmlFileTypeDelegateService _impl;
    private static PmlFileTypeDelegateService _txImpl;
    private PmlFileTypeDelegateService _service;

    /**
     * @deprecated
     */
    public static PmlFileTypeDelegateService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeDelegateService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileTypeDelegateService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeDelegateService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileTypeDelegateService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileTypeDelegateService service) {
        _service = service;
    }

    private static PmlFileTypeDelegateServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileTypeDelegateServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
