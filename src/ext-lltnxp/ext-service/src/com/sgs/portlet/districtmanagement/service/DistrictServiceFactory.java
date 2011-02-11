package com.sgs.portlet.districtmanagement.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="DistrictServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.districtmanagement.service.DistrictService</code>.
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
 * @see com.sgs.portlet.districtmanagement.service.DistrictService
 * @see com.sgs.portlet.districtmanagement.service.DistrictServiceUtil
 *
 */
public class DistrictServiceFactory {
    private static final String _FACTORY = DistrictServiceFactory.class.getName();
    private static final String _IMPL = DistrictService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = DistrictService.class.getName() +
        ".transaction";
    private static DistrictServiceFactory _factory;
    private static DistrictService _impl;
    private static DistrictService _txImpl;
    private DistrictService _service;

    /**
     * @deprecated
     */
    public static DistrictService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static DistrictService getImpl() {
        if (_impl == null) {
            _impl = (DistrictService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static DistrictService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (DistrictService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(DistrictService service) {
        _service = service;
    }

    private static DistrictServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (DistrictServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
