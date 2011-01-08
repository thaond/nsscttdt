package com.sgs.portlet.generatetemplateid.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="IdGeneratedLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalService</code>.
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
 * @see com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalService
 * @see com.sgs.portlet.generatetemplateid.service.IdGeneratedLocalServiceUtil
 *
 */
public class IdGeneratedLocalServiceFactory {
    private static final String _FACTORY = IdGeneratedLocalServiceFactory.class.getName();
    private static final String _IMPL = IdGeneratedLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = IdGeneratedLocalService.class.getName() +
        ".transaction";
    private static IdGeneratedLocalServiceFactory _factory;
    private static IdGeneratedLocalService _impl;
    private static IdGeneratedLocalService _txImpl;
    private IdGeneratedLocalService _service;

    /**
     * @deprecated
     */
    public static IdGeneratedLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static IdGeneratedLocalService getImpl() {
        if (_impl == null) {
            _impl = (IdGeneratedLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static IdGeneratedLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (IdGeneratedLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(IdGeneratedLocalService service) {
        _service = service;
    }

    private static IdGeneratedLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (IdGeneratedLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
