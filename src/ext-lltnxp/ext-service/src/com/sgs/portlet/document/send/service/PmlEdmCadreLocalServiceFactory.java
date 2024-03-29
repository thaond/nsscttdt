package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmCadreLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmCadreLocalService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmCadreLocalService
 * @see com.sgs.portlet.document.send.service.PmlEdmCadreLocalServiceUtil
 *
 */
public class PmlEdmCadreLocalServiceFactory {
    private static final String _FACTORY = PmlEdmCadreLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmCadreLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmCadreLocalService.class.getName() +
        ".transaction";
    private static PmlEdmCadreLocalServiceFactory _factory;
    private static PmlEdmCadreLocalService _impl;
    private static PmlEdmCadreLocalService _txImpl;
    private PmlEdmCadreLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmCadreLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmCadreLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmCadreLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmCadreLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmCadreLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmCadreLocalService service) {
        _service = service;
    }

    private static PmlEdmCadreLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmCadreLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
