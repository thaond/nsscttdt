package com.sgs.portlet.receivergroup.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="ReceiverGroupLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.receivergroup.service.ReceiverGroupLocalService</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupLocalService
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupLocalServiceUtil
 *
 */
public class ReceiverGroupLocalServiceFactory {
    private static final String _FACTORY = ReceiverGroupLocalServiceFactory.class.getName();
    private static final String _IMPL = ReceiverGroupLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = ReceiverGroupLocalService.class.getName() +
        ".transaction";
    private static ReceiverGroupLocalServiceFactory _factory;
    private static ReceiverGroupLocalService _impl;
    private static ReceiverGroupLocalService _txImpl;
    private ReceiverGroupLocalService _service;

    /**
     * @deprecated
     */
    public static ReceiverGroupLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static ReceiverGroupLocalService getImpl() {
        if (_impl == null) {
            _impl = (ReceiverGroupLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static ReceiverGroupLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (ReceiverGroupLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(ReceiverGroupLocalService service) {
        _service = service;
    }

    private static ReceiverGroupLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (ReceiverGroupLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
