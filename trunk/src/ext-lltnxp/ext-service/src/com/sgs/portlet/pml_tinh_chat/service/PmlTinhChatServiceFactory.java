package com.sgs.portlet.pml_tinh_chat.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTinhChatServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatService</code>.
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
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatService
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil
 *
 */
public class PmlTinhChatServiceFactory {
    private static final String _FACTORY = PmlTinhChatServiceFactory.class.getName();
    private static final String _IMPL = PmlTinhChatService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTinhChatService.class.getName() +
        ".transaction";
    private static PmlTinhChatServiceFactory _factory;
    private static PmlTinhChatService _impl;
    private static PmlTinhChatService _txImpl;
    private PmlTinhChatService _service;

    /**
     * @deprecated
     */
    public static PmlTinhChatService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTinhChatService getImpl() {
        if (_impl == null) {
            _impl = (PmlTinhChatService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTinhChatService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTinhChatService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTinhChatService service) {
        _service = service;
    }

    private static PmlTinhChatServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTinhChatServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
