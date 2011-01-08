package com.sgs.portlet.recievergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="RecieverLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.recievergroup.service.RecieverLocalService</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverLocalService
 * @see com.sgs.portlet.recievergroup.service.RecieverLocalServiceUtil
 *
 */
public class RecieverLocalServiceFactory {
    private static final String _FACTORY = RecieverLocalServiceFactory.class.getName();
    private static final String _IMPL = RecieverLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = RecieverLocalService.class.getName() +
        ".transaction";
    private static RecieverLocalServiceFactory _factory;
    private static RecieverLocalService _impl;
    private static RecieverLocalService _txImpl;
    private RecieverLocalService _service;

    /**
     * @deprecated
     */
    public static RecieverLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static RecieverLocalService getImpl() {
        if (_impl == null) {
            _impl = (RecieverLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static RecieverLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (RecieverLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(RecieverLocalService service) {
        _service = service;
    }

    private static RecieverLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (RecieverLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
