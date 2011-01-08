package com.sgs.portlet.filetype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileTypeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.filetype.service.PmlFileTypeService</code>.
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
 * @see com.sgs.portlet.filetype.service.PmlFileTypeService
 * @see com.sgs.portlet.filetype.service.PmlFileTypeServiceUtil
 *
 */
public class PmlFileTypeServiceFactory {
    private static final String _FACTORY = PmlFileTypeServiceFactory.class.getName();
    private static final String _IMPL = PmlFileTypeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileTypeService.class.getName() +
        ".transaction";
    private static PmlFileTypeServiceFactory _factory;
    private static PmlFileTypeService _impl;
    private static PmlFileTypeService _txImpl;
    private PmlFileTypeService _service;

    /**
     * @deprecated
     */
    public static PmlFileTypeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileTypeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileTypeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileTypeService service) {
        _service = service;
    }

    private static PmlFileTypeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileTypeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
