package com.sgs.portlet.pml_trang_thai_hscv.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlTrangThaiHSCVServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVService</code>.
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
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVService
 * @see com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVServiceUtil
 *
 */
public class PmlTrangThaiHSCVServiceFactory {
    private static final String _FACTORY = PmlTrangThaiHSCVServiceFactory.class.getName();
    private static final String _IMPL = PmlTrangThaiHSCVService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlTrangThaiHSCVService.class.getName() +
        ".transaction";
    private static PmlTrangThaiHSCVServiceFactory _factory;
    private static PmlTrangThaiHSCVService _impl;
    private static PmlTrangThaiHSCVService _txImpl;
    private PmlTrangThaiHSCVService _service;

    /**
     * @deprecated
     */
    public static PmlTrangThaiHSCVService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlTrangThaiHSCVService getImpl() {
        if (_impl == null) {
            _impl = (PmlTrangThaiHSCVService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlTrangThaiHSCVService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlTrangThaiHSCVService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlTrangThaiHSCVService service) {
        _service = service;
    }

    private static PmlTrangThaiHSCVServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlTrangThaiHSCVServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
