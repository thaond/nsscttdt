package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlOneDoorReceiveFileLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalService
 * @see com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil
 *
 */
public class PmlOneDoorReceiveFileLocalServiceFactory {
    private static final String _FACTORY = PmlOneDoorReceiveFileLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlOneDoorReceiveFileLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlOneDoorReceiveFileLocalService.class.getName() +
        ".transaction";
    private static PmlOneDoorReceiveFileLocalServiceFactory _factory;
    private static PmlOneDoorReceiveFileLocalService _impl;
    private static PmlOneDoorReceiveFileLocalService _txImpl;
    private PmlOneDoorReceiveFileLocalService _service;

    /**
     * @deprecated
     */
    public static PmlOneDoorReceiveFileLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlOneDoorReceiveFileLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlOneDoorReceiveFileLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlOneDoorReceiveFileLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlOneDoorReceiveFileLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlOneDoorReceiveFileLocalService service) {
        _service = service;
    }

    private static PmlOneDoorReceiveFileLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlOneDoorReceiveFileLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
