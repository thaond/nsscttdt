package com.sgs.portlet.onedoorpccc.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlFilePCCCAttachedFileLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalService</code>.
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
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalService
 * @see com.sgs.portlet.onedoorpccc.service.PmlFilePCCCAttachedFileLocalServiceUtil
 *
 */
public class PmlFilePCCCAttachedFileLocalServiceFactory {
    private static final String _FACTORY = PmlFilePCCCAttachedFileLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlFilePCCCAttachedFileLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlFilePCCCAttachedFileLocalService.class.getName() +
        ".transaction";
    private static PmlFilePCCCAttachedFileLocalServiceFactory _factory;
    private static PmlFilePCCCAttachedFileLocalService _impl;
    private static PmlFilePCCCAttachedFileLocalService _txImpl;
    private PmlFilePCCCAttachedFileLocalService _service;

    /**
     * @deprecated
     */
    public static PmlFilePCCCAttachedFileLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlFilePCCCAttachedFileLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlFilePCCCAttachedFileLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlFilePCCCAttachedFileLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlFilePCCCAttachedFileLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlFilePCCCAttachedFileLocalService service) {
        _service = service;
    }

    private static PmlFilePCCCAttachedFileLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlFilePCCCAttachedFileLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
