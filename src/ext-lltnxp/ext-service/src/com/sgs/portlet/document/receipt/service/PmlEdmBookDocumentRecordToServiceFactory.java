package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmBookDocumentRecordToServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToServiceUtil
 *
 */
public class PmlEdmBookDocumentRecordToServiceFactory {
    private static final String _FACTORY = PmlEdmBookDocumentRecordToServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmBookDocumentRecordToService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmBookDocumentRecordToService.class.getName() +
        ".transaction";
    private static PmlEdmBookDocumentRecordToServiceFactory _factory;
    private static PmlEdmBookDocumentRecordToService _impl;
    private static PmlEdmBookDocumentRecordToService _txImpl;
    private PmlEdmBookDocumentRecordToService _service;

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentRecordToService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentRecordToService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmBookDocumentRecordToService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmBookDocumentRecordToService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmBookDocumentRecordToService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmBookDocumentRecordToService service) {
        _service = service;
    }

    private static PmlEdmBookDocumentRecordToServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmBookDocumentRecordToServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
