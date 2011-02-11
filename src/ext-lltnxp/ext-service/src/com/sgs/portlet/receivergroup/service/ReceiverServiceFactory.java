package com.sgs.portlet.receivergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ReceiverServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.receivergroup.service.ReceiverService</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverService
 * @see com.sgs.portlet.receivergroup.service.ReceiverServiceUtil
 *
 */
public class ReceiverServiceFactory {
    private static final String _FACTORY = ReceiverServiceFactory.class.getName();
    private static final String _IMPL = ReceiverService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ReceiverService.class.getName() +
        ".transaction";
    private static ReceiverServiceFactory _factory;
    private static ReceiverService _impl;
    private static ReceiverService _txImpl;
    private ReceiverService _service;

    /**
     * @deprecated
     */
    public static ReceiverService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ReceiverService getImpl() {
        if (_impl == null) {
            _impl = (ReceiverService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ReceiverService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ReceiverService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ReceiverService service) {
        _service = service;
    }

    private static ReceiverServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ReceiverServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
