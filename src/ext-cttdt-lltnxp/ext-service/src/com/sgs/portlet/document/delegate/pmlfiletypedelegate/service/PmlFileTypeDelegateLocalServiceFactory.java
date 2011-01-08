package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileTypeDelegateLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService</code>.
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
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalService
 * @see com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.PmlFileTypeDelegateLocalServiceUtil
 *
 */
public class PmlFileTypeDelegateLocalServiceFactory {
    private static final String _FACTORY = PmlFileTypeDelegateLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFileTypeDelegateLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileTypeDelegateLocalService.class.getName() +
        ".transaction";
    private static PmlFileTypeDelegateLocalServiceFactory _factory;
    private static PmlFileTypeDelegateLocalService _impl;
    private static PmlFileTypeDelegateLocalService _txImpl;
    private PmlFileTypeDelegateLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFileTypeDelegateLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeDelegateLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileTypeDelegateLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeDelegateLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileTypeDelegateLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileTypeDelegateLocalService service) {
        _service = service;
    }

    private static PmlFileTypeDelegateLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileTypeDelegateLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
