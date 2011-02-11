package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlPaintDocumentServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentService
 * @see com.sgs.portlet.onedoorpccc.service.PmlPaintDocumentServiceUtil
 *
 */
public class PmlPaintDocumentServiceFactory {
    private static final String _FACTORY = PmlPaintDocumentServiceFactory.class.getName();
    private static final String _IMPL = PmlPaintDocumentService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlPaintDocumentService.class.getName() +
        ".transaction";
    private static PmlPaintDocumentServiceFactory _factory;
    private static PmlPaintDocumentService _impl;
    private static PmlPaintDocumentService _txImpl;
    private PmlPaintDocumentService _service;

    /**
     * @deprecated
     */
    public static PmlPaintDocumentService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlPaintDocumentService getImpl() {
        if (_impl == null) {
            _impl = (PmlPaintDocumentService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlPaintDocumentService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlPaintDocumentService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlPaintDocumentService service) {
        _service = service;
    }

    private static PmlPaintDocumentServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlPaintDocumentServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
