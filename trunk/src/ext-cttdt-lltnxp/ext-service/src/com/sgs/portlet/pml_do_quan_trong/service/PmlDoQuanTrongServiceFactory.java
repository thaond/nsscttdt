package com.sgs.portlet.pml_do_quan_trong.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDoQuanTrongServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongService</code>.
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
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongService
 * @see com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongServiceUtil
 *
 */
public class PmlDoQuanTrongServiceFactory {
    private static final String _FACTORY = PmlDoQuanTrongServiceFactory.class.getName();
    private static final String _IMPL = PmlDoQuanTrongService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDoQuanTrongService.class.getName() +
        ".transaction";
    private static PmlDoQuanTrongServiceFactory _factory;
    private static PmlDoQuanTrongService _impl;
    private static PmlDoQuanTrongService _txImpl;
    private PmlDoQuanTrongService _service;

    /**
     * @deprecated
     */
    public static PmlDoQuanTrongService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDoQuanTrongService getImpl() {
        if (_impl == null) {
            _impl = (PmlDoQuanTrongService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDoQuanTrongService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDoQuanTrongService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDoQuanTrongService service) {
        _service = service;
    }

    private static PmlDoQuanTrongServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDoQuanTrongServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
