package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlMainSupportServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlMainSupportService</code>.
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
 * @see com.sgs.portlet.document.service.PmlMainSupportService
 * @see com.sgs.portlet.document.service.PmlMainSupportServiceUtil
 *
 */
public class PmlMainSupportServiceFactory {
    private static final String _FACTORY = PmlMainSupportServiceFactory.class.getName();
    private static final String _IMPL = PmlMainSupportService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlMainSupportService.class.getName() +
        ".transaction";
    private static PmlMainSupportServiceFactory _factory;
    private static PmlMainSupportService _impl;
    private static PmlMainSupportService _txImpl;
    private PmlMainSupportService _service;

    /**
     * @deprecated
     */
    public static PmlMainSupportService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlMainSupportService getImpl() {
        if (_impl == null) {
            _impl = (PmlMainSupportService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlMainSupportService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlMainSupportService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlMainSupportService service) {
        _service = service;
    }

    private static PmlMainSupportServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlMainSupportServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
