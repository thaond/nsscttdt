package com.sgs.portlet.agency.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="AgencyLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.agency.service.AgencyLocalService</code>.
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
 * @see com.sgs.portlet.agency.service.AgencyLocalService
 * @see com.sgs.portlet.agency.service.AgencyLocalServiceUtil
 *
 */
public class AgencyLocalServiceFactory {
    private static final String _FACTORY = AgencyLocalServiceFactory.class.getName();
    private static final String _IMPL = AgencyLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = AgencyLocalService.class.getName() +
        ".transaction";
    private static AgencyLocalServiceFactory _factory;
    private static AgencyLocalService _impl;
    private static AgencyLocalService _txImpl;
    private AgencyLocalService _service;

    /**
     * @deprecated
     */
    public static AgencyLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static AgencyLocalService getImpl() {
        if (_impl == null) {
            _impl = (AgencyLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static AgencyLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (AgencyLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(AgencyLocalService service) {
        _service = service;
    }

    private static AgencyLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (AgencyLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
