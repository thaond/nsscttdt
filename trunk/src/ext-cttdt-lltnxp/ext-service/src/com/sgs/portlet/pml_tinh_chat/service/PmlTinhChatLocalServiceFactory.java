package com.sgs.portlet.pml_tinh_chat.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTinhChatLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalService</code>.
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
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalService
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil
 *
 */
public class PmlTinhChatLocalServiceFactory {
    private static final String _FACTORY = PmlTinhChatLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlTinhChatLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTinhChatLocalService.class.getName() +
        ".transaction";
    private static PmlTinhChatLocalServiceFactory _factory;
    private static PmlTinhChatLocalService _impl;
    private static PmlTinhChatLocalService _txImpl;
    private PmlTinhChatLocalService _service;

    /**
     * @deprecated
     */
    public static PmlTinhChatLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTinhChatLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlTinhChatLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTinhChatLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTinhChatLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTinhChatLocalService service) {
        _service = service;
    }

    private static PmlTinhChatLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTinhChatLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
