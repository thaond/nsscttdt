package com.sgs.portlet.receivergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ReceiverGroupServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.receivergroup.service.ReceiverGroupService</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupService
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil
 *
 */
public class ReceiverGroupServiceFactory {
    private static final String _FACTORY = ReceiverGroupServiceFactory.class.getName();
    private static final String _IMPL = ReceiverGroupService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ReceiverGroupService.class.getName() +
        ".transaction";
    private static ReceiverGroupServiceFactory _factory;
    private static ReceiverGroupService _impl;
    private static ReceiverGroupService _txImpl;
    private ReceiverGroupService _service;

    /**
     * @deprecated
     */
    public static ReceiverGroupService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ReceiverGroupService getImpl() {
        if (_impl == null) {
            _impl = (ReceiverGroupService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ReceiverGroupService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ReceiverGroupService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ReceiverGroupService service) {
        _service = service;
    }

    private static ReceiverGroupServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ReceiverGroupServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
