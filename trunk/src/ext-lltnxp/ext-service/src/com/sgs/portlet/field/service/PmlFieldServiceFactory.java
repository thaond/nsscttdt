package com.sgs.portlet.field.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFieldServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.field.service.PmlFieldService</code>.
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
 * @see com.sgs.portlet.field.service.PmlFieldService
 * @see com.sgs.portlet.field.service.PmlFieldServiceUtil
 *
 */
public class PmlFieldServiceFactory {
    private static final String _FACTORY = PmlFieldServiceFactory.class.getName();
    private static final String _IMPL = PmlFieldService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFieldService.class.getName() +
        ".transaction";
    private static PmlFieldServiceFactory _factory;
    private static PmlFieldService _impl;
    private static PmlFieldService _txImpl;
    private PmlFieldService _service;

    /**
     * @deprecated
     */
    public static PmlFieldService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFieldService getImpl() {
        if (_impl == null) {
            _impl = (PmlFieldService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFieldService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFieldService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFieldService service) {
        _service = service;
    }

    private static PmlFieldServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFieldServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
