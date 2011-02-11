package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentReceiptLogLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlDocumentReceiptLogLocalService
 *
 */
public class PmlDocumentReceiptLogLocalServiceUtil {
    private static PmlDocumentReceiptLogLocalService _service;

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog addPmlDocumentReceiptLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDocumentReceiptLog(pmlDocumentReceiptLog);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog createPmlDocumentReceiptLog(
        long documentReceiptLogId) {
        return getService().createPmlDocumentReceiptLog(documentReceiptLogId);
    }

    public static void deletePmlDocumentReceiptLog(long documentReceiptLogId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDocumentReceiptLog(documentReceiptLogId);
    }

    public static void deletePmlDocumentReceiptLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDocumentReceiptLog(pmlDocumentReceiptLog);
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

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog getPmlDocumentReceiptLog(
        long documentReceiptLogId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptLog(documentReceiptLogId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> getPmlDocumentReceiptLogs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptLogs(start, end);
    }

    public static int getPmlDocumentReceiptLogsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentReceiptLogsCount();
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog updatePmlDocumentReceiptLog(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDocumentReceiptLog(pmlDocumentReceiptLog);
    }

    public static int deletePmlDocumentReceiptLogByRecId(long documentReceiptId) {
        return getService().deletePmlDocumentReceiptLogByRecId(documentReceiptId);
    }

    public static int checkFirstStepDocRecByTran(long documentReceiptId,
        int transition_) {
        return getService()
                   .checkFirstStepDocRecByTran(documentReceiptId, transition_);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog updateDocumentReceiptLog(
        long documentReceiptLogId, java.util.Date expiredDate,
        int numDateProcess)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateDocumentReceiptLog(documentReceiptLogId, expiredDate,
            numDateProcess);
    }

    public static PmlDocumentReceiptLogLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDocumentReceiptLogLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDocumentReceiptLogLocalService service) {
        _service = service;
    }
}
