package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmCadreServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmCadreService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmCadreService
 * @see com.sgs.portlet.document.send.service.PmlEdmCadreServiceUtil
 *
 */
public class PmlEdmCadreServiceFactory {
    private static final String _FACTORY = PmlEdmCadreServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmCadreService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmCadreService.class.getName() +
        ".transaction";
    private static PmlEdmCadreServiceFactory _factory;
    private static PmlEdmCadreService _impl;
    private static PmlEdmCadreService _txImpl;
    private PmlEdmCadreService _service;

    /**
     * @deprecated
     */
    public static PmlEdmCadreService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmCadreService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmCadreService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmCadreService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmCadreService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmCadreService service) {
        _service = service;
    }

    private static PmlEdmCadreServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmCadreServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
