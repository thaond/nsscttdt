package com.sgs.portlet.pml_trang_thai_hscv.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTrangThaiHSCVLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalService</code>.
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
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalService
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalServiceUtil
 *
 */
public class PmlTrangThaiHSCVLocalServiceFactory {
    private static final String _FACTORY = PmlTrangThaiHSCVLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlTrangThaiHSCVLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTrangThaiHSCVLocalService.class.getName() +
        ".transaction";
    private static PmlTrangThaiHSCVLocalServiceFactory _factory;
    private static PmlTrangThaiHSCVLocalService _impl;
    private static PmlTrangThaiHSCVLocalService _txImpl;
    private PmlTrangThaiHSCVLocalService _service;

    /**
     * @deprecated
     */
    public static PmlTrangThaiHSCVLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTrangThaiHSCVLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlTrangThaiHSCVLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTrangThaiHSCVLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTrangThaiHSCVLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTrangThaiHSCVLocalService service) {
        _service = service;
    }

    private static PmlTrangThaiHSCVLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTrangThaiHSCVLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
