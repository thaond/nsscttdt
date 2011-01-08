package com.sgs.portlet.pml_edm_docconfuser.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocConfUserLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalService</code>.
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
 * @see com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalService
 * @see com.sgs.portlet.pml_edm_docconfuser.service.PmlEdmDocConfUserLocalServiceUtil
 *
 */
public class PmlEdmDocConfUserLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocConfUserLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocConfUserLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocConfUserLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocConfUserLocalServiceFactory _factory;
    private static PmlEdmDocConfUserLocalService _impl;
    private static PmlEdmDocConfUserLocalService _txImpl;
    private PmlEdmDocConfUserLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocConfUserLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocConfUserLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocConfUserLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocConfUserLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocConfUserLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocConfUserLocalService service) {
        _service = service;
    }

    private static PmlEdmDocConfUserLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocConfUserLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
