package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlWfOnedoorProcessServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessService
 * @see com.sgs.portlet.onedoor.service.PmlWfOnedoorProcessServiceUtil
 *
 */
public class PmlWfOnedoorProcessServiceFactory {
    private static final String _FACTORY = PmlWfOnedoorProcessServiceFactory.class.getName();
    private static final String _IMPL = PmlWfOnedoorProcessService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlWfOnedoorProcessService.class.getName() +
        ".transaction";
    private static PmlWfOnedoorProcessServiceFactory _factory;
    private static PmlWfOnedoorProcessService _impl;
    private static PmlWfOnedoorProcessService _txImpl;
    private PmlWfOnedoorProcessService _service;

    /**
     * @deprecated
     */
    public static PmlWfOnedoorProcessService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlWfOnedoorProcessService getImpl() {
        if (_impl == null) {
            _impl = (PmlWfOnedoorProcessService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlWfOnedoorProcessService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlWfOnedoorProcessService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlWfOnedoorProcessService service) {
        _service = service;
    }

    private static PmlWfOnedoorProcessServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlWfOnedoorProcessServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
