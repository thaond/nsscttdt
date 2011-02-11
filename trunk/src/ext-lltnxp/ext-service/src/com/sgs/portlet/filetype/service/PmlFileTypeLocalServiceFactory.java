package com.sgs.portlet.filetype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileTypeLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.filetype.service.PmlFileTypeLocalService</code>.
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
 * @see com.sgs.portlet.filetype.service.PmlFileTypeLocalService
 * @see com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil
 *
 */
public class PmlFileTypeLocalServiceFactory {
    private static final String _FACTORY = PmlFileTypeLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFileTypeLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileTypeLocalService.class.getName() +
        ".transaction";
    private static PmlFileTypeLocalServiceFactory _factory;
    private static PmlFileTypeLocalService _impl;
    private static PmlFileTypeLocalService _txImpl;
    private PmlFileTypeLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFileTypeLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileTypeLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileTypeLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileTypeLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileTypeLocalService service) {
        _service = service;
    }

    private static PmlFileTypeLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileTypeLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
