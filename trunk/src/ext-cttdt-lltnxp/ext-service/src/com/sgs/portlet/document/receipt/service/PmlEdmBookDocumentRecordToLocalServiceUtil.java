package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmBookDocumentRecordToLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalService
 *
 */
public class PmlEdmBookDocumentRecordToLocalServiceUtil {
    private static PmlEdmBookDocumentRecordToLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo addPmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmBookDocumentRecordTo(pmlEdmBookDocumentRecordTo);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo createPmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK) {
        return getService()
                   .createPmlEdmBookDocumentRecordTo(pmlEdmBookDocumentRecordToPK);
    }

    public static void deletePmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .deletePmlEdmBookDocumentRecordTo(pmlEdmBookDocumentRecordToPK);
    }

    public static void deletePmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmBookDocumentRecordTo(pmlEdmBookDocumentRecordTo);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo getPmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToPK pmlEdmBookDocumentRecordToPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getPmlEdmBookDocumentRecordTo(pmlEdmBookDocumentRecordToPK);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo> getPmlEdmBookDocumentRecordTos(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmBookDocumentRecordTos(start, end);
    }

    public static int getPmlEdmBookDocumentRecordTosCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmBookDocumentRecordTosCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo updatePmlEdmBookDocumentRecordTo(
        com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo pmlEdmBookDocumentRecordTo)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmBookDocumentRecordTo(pmlEdmBookDocumentRecordTo);
    }

    public static int deletePmdEdmBookDocumentRecordToByRecId(
        long documentReceiptId) {
        return getService()
                   .deletePmdEdmBookDocumentRecordToByRecId(documentReceiptId);
    }

    public static PmlEdmBookDocumentRecordToLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmBookDocumentRecordToLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmBookDocumentRecordToLocalService service) {
        _service = service;
    }
}
