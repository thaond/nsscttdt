package com.sgs.portlet.pmlissuingplace.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmIssuingPlaceLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService</code>.
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
 * @see com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalService
 * @see com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil
 *
 */
public class PmlEdmIssuingPlaceLocalServiceFactory {
    private static final String _FACTORY = PmlEdmIssuingPlaceLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmIssuingPlaceLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmIssuingPlaceLocalService.class.getName() +
        ".transaction";
    private static PmlEdmIssuingPlaceLocalServiceFactory _factory;
    private static PmlEdmIssuingPlaceLocalService _impl;
    private static PmlEdmIssuingPlaceLocalService _txImpl;
    private PmlEdmIssuingPlaceLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmIssuingPlaceLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmIssuingPlaceLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmIssuingPlaceLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmIssuingPlaceLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmIssuingPlaceLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmIssuingPlaceLocalService service) {
        _service = service;
    }

    private static PmlEdmIssuingPlaceLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmIssuingPlaceLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
