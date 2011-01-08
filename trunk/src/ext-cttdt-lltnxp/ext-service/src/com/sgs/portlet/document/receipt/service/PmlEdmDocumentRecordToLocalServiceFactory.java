package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentRecordToLocalServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToLocalServiceUtil
 *
 */
public class PmlEdmDocumentRecordToLocalServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentRecordToLocalServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentRecordToLocalService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentRecordToLocalService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentRecordToLocalServiceFactory _factory;
    private static PmlEdmDocumentRecordToLocalService _impl;
    private static PmlEdmDocumentRecordToLocalService _txImpl;
    private PmlEdmDocumentRecordToLocalService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordToLocalService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordToLocalService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentRecordToLocalService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordToLocalService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentRecordToLocalService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentRecordToLocalService service) {
        _service = service;
    }

    private static PmlEdmDocumentRecordToLocalServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentRecordToLocalServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
