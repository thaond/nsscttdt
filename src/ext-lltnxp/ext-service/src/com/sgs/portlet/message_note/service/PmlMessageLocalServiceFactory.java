package com.sgs.portlet.message_note.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlMessageLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.message_note.service.PmlMessageLocalService</code>.
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
 * @see com.sgs.portlet.message_note.service.PmlMessageLocalService
 * @see com.sgs.portlet.message_note.service.PmlMessageLocalServiceUtil
 *
 */
public class PmlMessageLocalServiceFactory {
    private static final String _FACTORY = PmlMessageLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlMessageLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlMessageLocalService.class.getName() +
        ".transaction";
    private static PmlMessageLocalServiceFactory _factory;
    private static PmlMessageLocalService _impl;
    private static PmlMessageLocalService _txImpl;
    private PmlMessageLocalService _service;

    /**
     * @deprecated
     */
    public static PmlMessageLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlMessageLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlMessageLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlMessageLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlMessageLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlMessageLocalService service) {
        _service = service;
    }

    private static PmlMessageLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlMessageLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
