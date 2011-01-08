package com.sgs.portlet.pml_ho_so_cong_viec.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlHoSoCongViecLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalService</code>.
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
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalService
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlHoSoCongViecLocalServiceUtil
 *
 */
public class PmlHoSoCongViecLocalServiceFactory {
    private static final String _FACTORY = PmlHoSoCongViecLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlHoSoCongViecLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlHoSoCongViecLocalService.class.getName() +
        ".transaction";
    private static PmlHoSoCongViecLocalServiceFactory _factory;
    private static PmlHoSoCongViecLocalService _impl;
    private static PmlHoSoCongViecLocalService _txImpl;
    private PmlHoSoCongViecLocalService _service;

    /**
     * @deprecated
     */
    public static PmlHoSoCongViecLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlHoSoCongViecLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlHoSoCongViecLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlHoSoCongViecLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlHoSoCongViecLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlHoSoCongViecLocalService service) {
        _service = service;
    }

    private static PmlHoSoCongViecLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlHoSoCongViecLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
