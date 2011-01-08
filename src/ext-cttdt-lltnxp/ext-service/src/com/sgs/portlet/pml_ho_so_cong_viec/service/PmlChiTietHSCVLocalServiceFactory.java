package com.sgs.portlet.pml_ho_so_cong_viec.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlChiTietHSCVLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalService</code>.
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
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalService
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVLocalServiceUtil
 *
 */
public class PmlChiTietHSCVLocalServiceFactory {
    private static final String _FACTORY = PmlChiTietHSCVLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlChiTietHSCVLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlChiTietHSCVLocalService.class.getName() +
        ".transaction";
    private static PmlChiTietHSCVLocalServiceFactory _factory;
    private static PmlChiTietHSCVLocalService _impl;
    private static PmlChiTietHSCVLocalService _txImpl;
    private PmlChiTietHSCVLocalService _service;

    /**
     * @deprecated
     */
    public static PmlChiTietHSCVLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlChiTietHSCVLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlChiTietHSCVLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlChiTietHSCVLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlChiTietHSCVLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlChiTietHSCVLocalService service) {
        _service = service;
    }

    private static PmlChiTietHSCVLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlChiTietHSCVLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
