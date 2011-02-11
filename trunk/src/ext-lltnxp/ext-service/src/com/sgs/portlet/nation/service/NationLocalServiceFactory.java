package com.sgs.portlet.nation.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="NationLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.nation.service.NationLocalService</code>.
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
 * @see com.sgs.portlet.nation.service.NationLocalService
 * @see com.sgs.portlet.nation.service.NationLocalServiceUtil
 *
 */
public class NationLocalServiceFactory {
    private static final String _FACTORY = NationLocalServiceFactory.class.getName();
    private static final String _IMPL = NationLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = NationLocalService.class.getName() +
        ".transaction";
    private static NationLocalServiceFactory _factory;
    private static NationLocalService _impl;
    private static NationLocalService _txImpl;
    private NationLocalService _service;

    /**
     * @deprecated
     */
    public static NationLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static NationLocalService getImpl() {
        if (_impl == null) {
            _impl = (NationLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static NationLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (NationLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(NationLocalService service) {
        _service = service;
    }

    private static NationLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (NationLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
