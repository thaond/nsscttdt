package com.sgs.portlet.recievergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="RecieverGroupLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.recievergroup.service.RecieverGroupLocalService</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupLocalService
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupLocalServiceUtil
 *
 */
public class RecieverGroupLocalServiceFactory {
    private static final String _FACTORY = RecieverGroupLocalServiceFactory.class.getName();
    private static final String _IMPL = RecieverGroupLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = RecieverGroupLocalService.class.getName() +
        ".transaction";
    private static RecieverGroupLocalServiceFactory _factory;
    private static RecieverGroupLocalService _impl;
    private static RecieverGroupLocalService _txImpl;
    private RecieverGroupLocalService _service;

    /**
     * @deprecated
     */
    public static RecieverGroupLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static RecieverGroupLocalService getImpl() {
        if (_impl == null) {
            _impl = (RecieverGroupLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static RecieverGroupLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (RecieverGroupLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(RecieverGroupLocalService service) {
        _service = service;
    }

    private static RecieverGroupLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (RecieverGroupLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
