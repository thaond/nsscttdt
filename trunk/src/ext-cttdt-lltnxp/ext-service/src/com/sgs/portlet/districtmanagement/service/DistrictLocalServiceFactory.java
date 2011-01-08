package com.sgs.portlet.districtmanagement.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="DistrictLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.districtmanagement.service.DistrictLocalService</code>.
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
 * @see com.sgs.portlet.districtmanagement.service.DistrictLocalService
 * @see com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil
 *
 */
public class DistrictLocalServiceFactory {
    private static final String _FACTORY = DistrictLocalServiceFactory.class.getName();
    private static final String _IMPL = DistrictLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = DistrictLocalService.class.getName() +
        ".transaction";
    private static DistrictLocalServiceFactory _factory;
    private static DistrictLocalService _impl;
    private static DistrictLocalService _txImpl;
    private DistrictLocalService _service;

    /**
     * @deprecated
     */
    public static DistrictLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static DistrictLocalService getImpl() {
        if (_impl == null) {
            _impl = (DistrictLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static DistrictLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (DistrictLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(DistrictLocalService service) {
        _service = service;
    }

    private static DistrictLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (DistrictLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
