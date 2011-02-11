package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmBookDocumentRecordToLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil
 *
 */
public class PmlEdmBookDocumentRecordToLocalServiceFactory {
    private static final String _FACTORY = PmlEdmBookDocumentRecordToLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmBookDocumentRecordToLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmBookDocumentRecordToLocalService.class.getName() +
        ".transaction";
    private static PmlEdmBookDocumentRecordToLocalServiceFactory _factory;
    private static PmlEdmBookDocumentRecordToLocalService _impl;
    private static PmlEdmBookDocumentRecordToLocalService _txImpl;
    private PmlEdmBookDocumentRecordToLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentRecordToLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentRecordToLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmBookDocumentRecordToLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentRecordToLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmBookDocumentRecordToLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmBookDocumentRecordToLocalService service) {
        _service = service;
    }

    private static PmlEdmBookDocumentRecordToLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmBookDocumentRecordToLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
