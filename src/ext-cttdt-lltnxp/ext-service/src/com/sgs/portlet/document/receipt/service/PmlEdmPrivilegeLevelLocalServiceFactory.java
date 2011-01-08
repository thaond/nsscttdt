package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmPrivilegeLevelLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelLocalServiceUtil
 *
 */
public class PmlEdmPrivilegeLevelLocalServiceFactory {
    private static final String _FACTORY = PmlEdmPrivilegeLevelLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmPrivilegeLevelLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmPrivilegeLevelLocalService.class.getName() +
        ".transaction";
    private static PmlEdmPrivilegeLevelLocalServiceFactory _factory;
    private static PmlEdmPrivilegeLevelLocalService _impl;
    private static PmlEdmPrivilegeLevelLocalService _txImpl;
    private PmlEdmPrivilegeLevelLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmPrivilegeLevelLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmPrivilegeLevelLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmPrivilegeLevelLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmPrivilegeLevelLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmPrivilegeLevelLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmPrivilegeLevelLocalService service) {
        _service = service;
    }

    private static PmlEdmPrivilegeLevelLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmPrivilegeLevelLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
