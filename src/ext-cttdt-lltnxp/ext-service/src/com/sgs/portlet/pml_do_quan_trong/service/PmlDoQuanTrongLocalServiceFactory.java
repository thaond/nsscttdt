package com.sgs.portlet.pml_do_quan_trong.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDoQuanTrongLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalService</code>.
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
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalService
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalServiceUtil
 *
 */
public class PmlDoQuanTrongLocalServiceFactory {
    private static final String _FACTORY = PmlDoQuanTrongLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDoQuanTrongLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDoQuanTrongLocalService.class.getName() +
        ".transaction";
    private static PmlDoQuanTrongLocalServiceFactory _factory;
    private static PmlDoQuanTrongLocalService _impl;
    private static PmlDoQuanTrongLocalService _txImpl;
    private PmlDoQuanTrongLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDoQuanTrongLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDoQuanTrongLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDoQuanTrongLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDoQuanTrongLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDoQuanTrongLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDoQuanTrongLocalService service) {
        _service = service;
    }

    private static PmlDoQuanTrongLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDoQuanTrongLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
