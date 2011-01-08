package com.sgs.portlet.document.receipt.service;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;


/**
 * <a href="PmlEdmDocumentRecordTypeServiceFactory.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is responsible for the lookup of the implementation for
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeService</code>.
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
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeService
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentRecordTypeServiceUtil
 *
 */
public class PmlEdmDocumentRecordTypeServiceFactory {
    private static final String _FACTORY = PmlEdmDocumentRecordTypeServiceFactory.class.getName();
    private static final String _IMPL = PmlEdmDocumentRecordTypeService.class.getName() +
        ".impl";
    private static final String _TX_IMPL = PmlEdmDocumentRecordTypeService.class.getName() +
        ".transaction";
    private static PmlEdmDocumentRecordTypeServiceFactory _factory;
    private static PmlEdmDocumentRecordTypeService _impl;
    private static PmlEdmDocumentRecordTypeService _txImpl;
    private PmlEdmDocumentRecordTypeService _service;

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordTypeService getService() {
        return _getFactory()._service;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordTypeService getImpl() {
        if (_impl == null) {
            _impl = (PmlEdmDocumentRecordTypeService) PortalBeanLocatorUtil.locate(_IMPL);
        }

        return _impl;
    }

    /**
     * @deprecated
     */
    public static PmlEdmDocumentRecordTypeService getTxImpl() {
        if (_txImpl == null) {
            _txImpl = (PmlEdmDocumentRecordTypeService) PortalBeanLocatorUtil.locate(_TX_IMPL);
        }

        return _txImpl;
    }

    /**
     * @deprecated
     */
    public void setService(PmlEdmDocumentRecordTypeService service) {
        _service = service;
    }

    private static PmlEdmDocumentRecordTypeServiceFactory _getFactory() {
        if (_factory == null) {
            _factory = (PmlEdmDocumentRecordTypeServiceFactory) PortalBeanLocatorUtil.locate(_FACTORY);
        }

        return _factory;
    }
}
