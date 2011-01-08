package com.sgs.portlet.document.send.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmAnswerDetailLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalService</code>.
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
 * @see com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalService
 * @see com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalServiceUtil
 *
 */
public class PmlEdmAnswerDetailLocalServiceFactory {
    private static final String _FACTORY = PmlEdmAnswerDetailLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmAnswerDetailLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmAnswerDetailLocalService.class.getName() +
        ".transaction";
    private static PmlEdmAnswerDetailLocalServiceFactory _factory;
    private static PmlEdmAnswerDetailLocalService _impl;
    private static PmlEdmAnswerDetailLocalService _txImpl;
    private PmlEdmAnswerDetailLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmAnswerDetailLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmAnswerDetailLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmAnswerDetailLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmAnswerDetailLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmAnswerDetailLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmAnswerDetailLocalService service) {
        _service = service;
    }

    private static PmlEdmAnswerDetailLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmAnswerDetailLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
