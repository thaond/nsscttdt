package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFileStatusStateProcessServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessService
 * @see com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessServiceUtil
 *
 */
public class PmlFileStatusStateProcessServiceFactory {
    private static final String _FACTORY = PmlFileStatusStateProcessServiceFactory.class.getName();
    private static final String _IMPL = PmlFileStatusStateProcessService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFileStatusStateProcessService.class.getName() +
        ".transaction";
    private static PmlFileStatusStateProcessServiceFactory _factory;
    private static PmlFileStatusStateProcessService _impl;
    private static PmlFileStatusStateProcessService _txImpl;
    private PmlFileStatusStateProcessService _service;

    /**
     * @deprecated
     */
    public static PmlFileStatusStateProcessService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFileStatusStateProcessService getImpl() {
        if (_impl == null) {
            _impl = (PmlFileStatusStateProcessService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFileStatusStateProcessService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFileStatusStateProcessService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFileStatusStateProcessService service) {
        _service = service;
    }

    private static PmlFileStatusStateProcessServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFileStatusStateProcessServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
