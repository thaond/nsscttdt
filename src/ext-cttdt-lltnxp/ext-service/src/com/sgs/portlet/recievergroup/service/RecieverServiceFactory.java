package com.sgs.portlet.recievergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="RecieverServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.recievergroup.service.RecieverService</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverService
 * @see com.sgs.portlet.recievergroup.service.RecieverServiceUtil
 *
 */
public class RecieverServiceFactory {
    private static final String _FACTORY = RecieverServiceFactory.class.getName();
    private static final String _IMPL = RecieverService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = RecieverService.class.getName() +
        ".transaction";
    private static RecieverServiceFactory _factory;
    private static RecieverService _impl;
    private static RecieverService _txImpl;
    private RecieverService _service;

    /**
     * @deprecated
     */
    public static RecieverService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static RecieverService getImpl() {
        if (_impl == null) {
            _impl = (RecieverService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static RecieverService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (RecieverService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(RecieverService service) {
        _service = service;
    }

    private static RecieverServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (RecieverServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
