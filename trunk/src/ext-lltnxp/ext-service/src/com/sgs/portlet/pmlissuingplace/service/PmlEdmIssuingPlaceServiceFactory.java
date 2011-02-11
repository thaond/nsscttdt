package com.sgs.portlet.pmlissuingplace.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmIssuingPlaceServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceService</code>.
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
 * @see com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceService
 * @see com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceServiceUtil
 *
 */
public class PmlEdmIssuingPlaceServiceFactory {
    private static final String _FACTORY = PmlEdmIssuingPlaceServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmIssuingPlaceService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmIssuingPlaceService.class.getName() +
        ".transaction";
    private static PmlEdmIssuingPlaceServiceFactory _factory;
    private static PmlEdmIssuingPlaceService _impl;
    private static PmlEdmIssuingPlaceService _txImpl;
    private PmlEdmIssuingPlaceService _service;

    /**
     * @deprecated
     */
    public static PmlEdmIssuingPlaceService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmIssuingPlaceService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmIssuingPlaceService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmIssuingPlaceService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmIssuingPlaceService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmIssuingPlaceService service) {
        _service = service;
    }

    private static PmlEdmIssuingPlaceServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmIssuingPlaceServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
