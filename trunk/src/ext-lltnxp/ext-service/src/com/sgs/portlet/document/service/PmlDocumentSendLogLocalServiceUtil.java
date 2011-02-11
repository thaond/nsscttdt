package com.sgs.portlet.document.service;


/**
 * <a href="PmlDocumentSendLogLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.service.PmlDocumentSendLogLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.service.PmlDocumentSendLogLocalService
 *
 */
public class PmlDocumentSendLogLocalServiceUtil {
    private static PmlDocumentSendLogLocalService _service;

    public static com.sgs.portlet.document.model.PmlDocumentSendLog addPmlDocumentSendLog(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDocumentSendLog(pmlDocumentSendLog);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog createPmlDocumentSendLog(
        long documentSendLogId) {
        return getService().createPmlDocumentSendLog(documentSendLogId);
    }

    public static void deletePmlDocumentSendLog(long documentSendLogId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDocumentSendLog(documentSendLogId);
    }

    public static void deletePmlDocumentSendLog(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDocumentSendLog(pmlDocumentSendLog);
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

    public static com.sgs.portlet.document.model.PmlDocumentSendLog getPmlDocumentSendLog(
        long documentSendLogId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDocumentSendLog(documentSendLogId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> getPmlDocumentSendLogs(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentSendLogs(start, end);
    }

    public static int getPmlDocumentSendLogsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentSendLogsCount();
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog updatePmlDocumentSendLog(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDocumentSendLog(pmlDocumentSendLog);
    }

    public static int deletePmlDocumentSendLogBySendId(long documentSendId) {
        return getService().deletePmlDocumentSendLogBySendId(documentSendId);
    }

    public static PmlDocumentSendLogLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDocumentSendLogLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDocumentSendLogLocalService service) {
        _service = service;
    }
}
