package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmPrivilegeLevelServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmPrivilegeLevelServiceUtil
 *
 */
public class PmlEdmPrivilegeLevelServiceFactory {
    private static final String _FACTORY = PmlEdmPrivilegeLevelServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmPrivilegeLevelService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmPrivilegeLevelService.class.getName() +
        ".transaction";
    private static PmlEdmPrivilegeLevelServiceFactory _factory;
    private static PmlEdmPrivilegeLevelService _impl;
    private static PmlEdmPrivilegeLevelService _txImpl;
    private PmlEdmPrivilegeLevelService _service;

    /**
     * @deprecated
     */
    public static PmlEdmPrivilegeLevelService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmPrivilegeLevelService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmPrivilegeLevelService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmPrivilegeLevelService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmPrivilegeLevelService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmPrivilegeLevelService service) {
        _service = service;
    }

    private static PmlEdmPrivilegeLevelServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmPrivilegeLevelServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
