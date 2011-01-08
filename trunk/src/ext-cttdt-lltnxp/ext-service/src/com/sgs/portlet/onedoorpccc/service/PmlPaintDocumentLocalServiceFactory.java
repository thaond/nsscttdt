package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlPaintDocumentLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentLocalService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentLocalService
 * @see com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentLocalServiceUtil
 *
 */
public class PmlPaintDocumentLocalServiceFactory {
    private static final String _FACTORY = PmlPaintDocumentLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlPaintDocumentLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlPaintDocumentLocalService.class.getName() +
        ".transaction";
    private static PmlPaintDocumentLocalServiceFactory _factory;
    private static PmlPaintDocumentLocalService _impl;
    private static PmlPaintDocumentLocalService _txImpl;
    private PmlPaintDocumentLocalService _service;

    /**
     * @deprecated
     */
    public static PmlPaintDocumentLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlPaintDocumentLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlPaintDocumentLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlPaintDocumentLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlPaintDocumentLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlPaintDocumentLocalService service) {
        _service = service;
    }

    private static PmlPaintDocumentLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlPaintDocumentLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
