package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmConfidentialLevelLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil
 *
 */
public class PmlEdmConfidentialLevelLocalServiceFactory {
    private static final String _FACTORY = PmlEdmConfidentialLevelLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmConfidentialLevelLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmConfidentialLevelLocalService.class.getName() +
        ".transaction";
    private static PmlEdmConfidentialLevelLocalServiceFactory _factory;
    private static PmlEdmConfidentialLevelLocalService _impl;
    private static PmlEdmConfidentialLevelLocalService _txImpl;
    private PmlEdmConfidentialLevelLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmConfidentialLevelLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmConfidentialLevelLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmConfidentialLevelLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmConfidentialLevelLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmConfidentialLevelLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmConfidentialLevelLocalService service) {
        _service = service;
    }

    private static PmlEdmConfidentialLevelLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmConfidentialLevelLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
