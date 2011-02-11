package com.ext.portlet.saveprocesstype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SaveProcessTypeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.saveprocesstype.service.SaveProcessTypeService</code>.
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
 * @see com.ext.portlet.saveprocesstype.service.SaveProcessTypeService
 * @see com.ext.portlet.saveprocesstype.service.SaveProcessTypeServiceUtil
 *
 */
public class SaveProcessTypeServiceFactory {
    private static final String _FACTORY = SaveProcessTypeServiceFactory.class.getName();
    private static final String _IMPL = SaveProcessTypeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SaveProcessTypeService.class.getName() +
        ".transaction";
    private static SaveProcessTypeServiceFactory _factory;
    private static SaveProcessTypeService _impl;
    private static SaveProcessTypeService _txImpl;
    private SaveProcessTypeService _service;

    /**
     * @deprecated
     */
    public static SaveProcessTypeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SaveProcessTypeService getImpl() {
        if (_impl == null) {
            _impl = (SaveProcessTypeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SaveProcessTypeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SaveProcessTypeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SaveProcessTypeService service) {
        _service = service;
    }

    private static SaveProcessTypeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SaveProcessTypeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
