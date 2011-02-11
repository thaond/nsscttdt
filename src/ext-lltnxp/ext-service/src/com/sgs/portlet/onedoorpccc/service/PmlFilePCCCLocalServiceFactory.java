package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFilePCCCLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalService
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCLocalServiceUtil
 *
 */
public class PmlFilePCCCLocalServiceFactory {
    private static final String _FACTORY = PmlFilePCCCLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFilePCCCLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFilePCCCLocalService.class.getName() +
        ".transaction";
    private static PmlFilePCCCLocalServiceFactory _factory;
    private static PmlFilePCCCLocalService _impl;
    private static PmlFilePCCCLocalService _txImpl;
    private PmlFilePCCCLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFilePCCCLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFilePCCCLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFilePCCCLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFilePCCCLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFilePCCCLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFilePCCCLocalService service) {
        _service = service;
    }

    private static PmlFilePCCCLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFilePCCCLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
