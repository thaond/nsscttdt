package com.sgs.portlet.receivergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ReceiverLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.receivergroup.service.ReceiverLocalService</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverLocalService
 * @see com.sgs.portlet.receivergroup.service.ReceiverLocalServiceUtil
 *
 */
public class ReceiverLocalServiceFactory {
    private static final String _FACTORY = ReceiverLocalServiceFactory.class.getName();
    private static final String _IMPL = ReceiverLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ReceiverLocalService.class.getName() +
        ".transaction";
    private static ReceiverLocalServiceFactory _factory;
    private static ReceiverLocalService _impl;
    private static ReceiverLocalService _txImpl;
    private ReceiverLocalService _service;

    /**
     * @deprecated
     */
    public static ReceiverLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ReceiverLocalService getImpl() {
        if (_impl == null) {
            _impl = (ReceiverLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ReceiverLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ReceiverLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ReceiverLocalService service) {
        _service = service;
    }

    private static ReceiverLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ReceiverLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
