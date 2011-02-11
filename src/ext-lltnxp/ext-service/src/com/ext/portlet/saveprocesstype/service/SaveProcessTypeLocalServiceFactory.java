package com.ext.portlet.saveprocesstype.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="SaveProcessTypeLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalService</code>.
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
 * @see com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalService
 * @see com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalServiceUtil
 *
 */
public class SaveProcessTypeLocalServiceFactory {
    private static final String _FACTORY = SaveProcessTypeLocalServiceFactory.class.getName();
    private static final String _IMPL = SaveProcessTypeLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = SaveProcessTypeLocalService.class.getName() +
        ".transaction";
    private static SaveProcessTypeLocalServiceFactory _factory;
    private static SaveProcessTypeLocalService _impl;
    private static SaveProcessTypeLocalService _txImpl;
    private SaveProcessTypeLocalService _service;

    /**
     * @deprecated
     */
    public static SaveProcessTypeLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static SaveProcessTypeLocalService getImpl() {
        if (_impl == null) {
            _impl = (SaveProcessTypeLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static SaveProcessTypeLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (SaveProcessTypeLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(SaveProcessTypeLocalService service) {
        _service = service;
    }

    private static SaveProcessTypeLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (SaveProcessTypeLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
