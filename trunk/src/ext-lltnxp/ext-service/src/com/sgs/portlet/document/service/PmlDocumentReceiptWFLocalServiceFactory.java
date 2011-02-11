package com.sgs.portlet.document.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlDocumentReceiptWFLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalService</code>.
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
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalService
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptWFLocalServiceUtil
 *
 */
public class PmlDocumentReceiptWFLocalServiceFactory {
    private static final String _FACTORY = PmlDocumentReceiptWFLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlDocumentReceiptWFLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlDocumentReceiptWFLocalService.class.getName() +
        ".transaction";
    private static PmlDocumentReceiptWFLocalServiceFactory _factory;
    private static PmlDocumentReceiptWFLocalService _impl;
    private static PmlDocumentReceiptWFLocalService _txImpl;
    private PmlDocumentReceiptWFLocalService _service;

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptWFLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptWFLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlDocumentReceiptWFLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlDocumentReceiptWFLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlDocumentReceiptWFLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlDocumentReceiptWFLocalService service) {
        _service = service;
    }

    private static PmlDocumentReceiptWFLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlDocumentReceiptWFLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
