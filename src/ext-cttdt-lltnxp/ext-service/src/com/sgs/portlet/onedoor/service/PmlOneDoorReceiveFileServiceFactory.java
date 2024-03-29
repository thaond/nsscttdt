package com.sgs.portlet.onedoor.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlOneDoorReceiveFileServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileService</code>.
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
 * @see com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileService
 * @see com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileServiceUtil
 *
 */
public class PmlOneDoorReceiveFileServiceFactory {
    private static final String _FACTORY = PmlOneDoorReceiveFileServiceFactory.class.getName();
    private static final String _IMPL = PmlOneDoorReceiveFileService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlOneDoorReceiveFileService.class.getName() +
        ".transaction";
    private static PmlOneDoorReceiveFileServiceFactory _factory;
    private static PmlOneDoorReceiveFileService _impl;
    private static PmlOneDoorReceiveFileService _txImpl;
    private PmlOneDoorReceiveFileService _service;

    /**
     * @deprecated
     */
    public static PmlOneDoorReceiveFileService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlOneDoorReceiveFileService getImpl() {
        if (_impl == null) {
            _impl = (PmlOneDoorReceiveFileService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlOneDoorReceiveFileService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlOneDoorReceiveFileService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlOneDoorReceiveFileService service) {
        _service = service;
    }

    private static PmlOneDoorReceiveFileServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlOneDoorReceiveFileServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
