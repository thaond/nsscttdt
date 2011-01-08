package com.sgs.portlet.country.pmluserfiletype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlUserFileTypeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeService</code>.
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
 * @see com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeService
 * @see com.sgs.portlet.country.pmluserfiletype.service.PmlUserFileTypeServiceUtil
 *
 */
public class PmlUserFileTypeServiceFactory {
    private static final String _FACTORY = PmlUserFileTypeServiceFactory.class.getName();
    private static final String _IMPL = PmlUserFileTypeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlUserFileTypeService.class.getName() +
        ".transaction";
    private static PmlUserFileTypeServiceFactory _factory;
    private static PmlUserFileTypeService _impl;
    private static PmlUserFileTypeService _txImpl;
    private PmlUserFileTypeService _service;

    /**
     * @deprecated
     */
    public static PmlUserFileTypeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlUserFileTypeService getImpl() {
        if (_impl == null) {
            _impl = (PmlUserFileTypeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlUserFileTypeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlUserFileTypeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlUserFileTypeService service) {
        _service = service;
    }

    private static PmlUserFileTypeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlUserFileTypeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
