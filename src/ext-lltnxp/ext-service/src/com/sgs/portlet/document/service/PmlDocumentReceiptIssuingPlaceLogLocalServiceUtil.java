package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentReceiptIssuingPlaceLogLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptIssuingPlaceLogLocalService
 *
 */
public class PmlDocumentReceiptIssuingPlaceLogLocalServiceUtil {
    private static PmlDocumentReceiptIssuingPlaceLogLocalService _service;

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog addPmlDocumentReceiptIssuingPlaceLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlDocumentReceiptIssuingPlaceLog(pmlDocumentReceiptIssuingPlaceLog);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog createPmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptIssuingPlaceLogId) {
        return getService()
                   .createPmlDocumentReceiptIssuingPlaceLog(documentReceiptIssuingPlaceLogId);
    }

    public static void deletePmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .deletePmlDocumentReceiptIssuingPlaceLog(documentReceiptIssuingPlaceLogId);
    }

    public static void deletePmlDocumentReceiptIssuingPlaceLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException {
        getService()
            .deletePmlDocumentReceiptIssuingPlaceLog(pmlDocumentReceiptIssuingPlaceLog);
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

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog getPmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getPmlDocumentReceiptIssuingPlaceLog(documentReceiptIssuingPlaceLogId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> getPmlDocumentReceiptIssuingPlaceLogs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptIssuingPlaceLogs(start, end);
    }

    public static int getPmlDocumentReceiptIssuingPlaceLogsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptIssuingPlaceLogsCount();
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog updatePmlDocumentReceiptIssuingPlaceLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlDocumentReceiptIssuingPlaceLog(pmlDocumentReceiptIssuingPlaceLog);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog addPmlDocumentReceiptIssuingPlaceLog(
        long documentReceiptId, java.util.Date dateProcess, long processor,
        long directProcessorId, java.lang.String processInfomation,
        java.lang.String receiver, int step)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlDocumentReceiptIssuingPlaceLog(documentReceiptId,
            dateProcess, processor, directProcessorId, processInfomation,
            receiver, step);
    }

    public static PmlDocumentReceiptIssuingPlaceLogLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDocumentReceiptIssuingPlaceLogLocalService is not set");
        }

        return _service;
    }

    public void setService(
        PmlDocumentReceiptIssuingPlaceLogLocalService service) {
        _service = service;
    }
}
