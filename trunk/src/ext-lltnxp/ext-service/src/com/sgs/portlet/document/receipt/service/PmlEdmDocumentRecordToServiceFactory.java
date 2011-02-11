package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentRecordToServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordToServiceUtil
 *
 */
public class PmlEdmDocumentRecordToServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentRecordToServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentRecordToService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentRecordToService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentRecordToServiceFactory _factory;
    private static PmlEdmDocumentRecordToService _impl;
    private static PmlEdmDocumentRecordToService _txImpl;
    private PmlEdmDocumentRecordToService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordToService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordToService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentRecordToService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordToService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentRecordToService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentRecordToService service) {
        _service = service;
    }

    private static PmlEdmDocumentRecordToServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentRecordToServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
