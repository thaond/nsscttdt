package com.sgs.portlet.recievergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="RecieverGroupServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.recievergroup.service.RecieverGroupService</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupService
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil
 *
 */
public class RecieverGroupServiceFactory {
    private static final String _FACTORY = RecieverGroupServiceFactory.class.getName();
    private static final String _IMPL = RecieverGroupService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = RecieverGroupService.class.getName() +
        ".transaction";
    private static RecieverGroupServiceFactory _factory;
    private static RecieverGroupService _impl;
    private static RecieverGroupService _txImpl;
    private RecieverGroupService _service;

    /**
     * @deprecated
     */
    public static RecieverGroupService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static RecieverGroupService getImpl() {
        if (_impl == null) {
            _impl = (RecieverGroupService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static RecieverGroupService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (RecieverGroupService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(RecieverGroupService service) {
        _service = service;
    }

    private static RecieverGroupServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (RecieverGroupServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
