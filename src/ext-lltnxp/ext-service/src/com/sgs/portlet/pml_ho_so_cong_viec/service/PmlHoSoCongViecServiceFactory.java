package com.sgs.portlet.pml_ho_so_cong_viec.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlHoSoCongViecServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecService</code>.
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
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecService
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecServiceUtil
 *
 */
public class PmlHoSoCongViecServiceFactory {
    private static final String _FACTORY = PmlHoSoCongViecServiceFactory.class.getName();
    private static final String _IMPL = PmlHoSoCongViecService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlHoSoCongViecService.class.getName() +
        ".transaction";
    private static PmlHoSoCongViecServiceFactory _factory;
    private static PmlHoSoCongViecService _impl;
    private static PmlHoSoCongViecService _txImpl;
    private PmlHoSoCongViecService _service;

    /**
     * @deprecated
     */
    public static PmlHoSoCongViecService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlHoSoCongViecService getImpl() {
        if (_impl == null) {
            _impl = (PmlHoSoCongViecService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlHoSoCongViecService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlHoSoCongViecService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlHoSoCongViecService service) {
        _service = service;
    }

    private static PmlHoSoCongViecServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlHoSoCongViecServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
