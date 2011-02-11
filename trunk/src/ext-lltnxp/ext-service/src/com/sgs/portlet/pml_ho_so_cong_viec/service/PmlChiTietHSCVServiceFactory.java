package com.sgs.portlet.pml_ho_so_cong_viec.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlChiTietHSCVServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVService</code>.
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
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVService
 * @see com.sgs.portlet.pml_ho_so_cong_viec.service.PmlChiTietHSCVServiceUtil
 *
 */
public class PmlChiTietHSCVServiceFactory {
    private static final String _FACTORY = PmlChiTietHSCVServiceFactory.class.getName();
    private static final String _IMPL = PmlChiTietHSCVService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlChiTietHSCVService.class.getName() +
        ".transaction";
    private static PmlChiTietHSCVServiceFactory _factory;
    private static PmlChiTietHSCVService _impl;
    private static PmlChiTietHSCVService _txImpl;
    private PmlChiTietHSCVService _service;

    /**
     * @deprecated
     */
    public static PmlChiTietHSCVService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlChiTietHSCVService getImpl() {
        if (_impl == null) {
            _impl = (PmlChiTietHSCVService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlChiTietHSCVService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlChiTietHSCVService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlChiTietHSCVService service) {
        _service = service;
    }

    private static PmlChiTietHSCVServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlChiTietHSCVServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
