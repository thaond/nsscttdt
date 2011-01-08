package com.sgs.portlet.document.receipt.service;


/**
 * <a href="PmlEdmDocumentReceiptExtendLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptExtendLocalService
 *
 */
public class PmlEdmDocumentReceiptExtendLocalServiceUtil {
    private static PmlEdmDocumentReceiptExtendLocalService _service;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend addPmlEdmDocumentReceiptExtend(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addPmlEdmDocumentReceiptExtend(pmlEdmDocumentReceiptExtend);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend createPmlEdmDocumentReceiptExtend(
        long documentReceiptExtendId) {
        return getService()
                   .createPmlEdmDocumentReceiptExtend(documentReceiptExtendId);
    }

    public static void deletePmlEdmDocumentReceiptExtend(
        long documentReceiptExtendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmDocumentReceiptExtend(documentReceiptExtendId);
    }

    public static void deletePmlEdmDocumentReceiptExtend(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException {
        getService()
            .deletePmlEdmDocumentReceiptExtend(pmlEdmDocumentReceiptExtend);
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

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend getPmlEdmDocumentReceiptExtend(
        long documentReceiptExtendId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getPmlEdmDocumentReceiptExtend(documentReceiptExtendId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend> getPmlEdmDocumentReceiptExtends(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptExtends(start, end);
    }

    public static int getPmlEdmDocumentReceiptExtendsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmDocumentReceiptExtendsCount();
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend updatePmlEdmDocumentReceiptExtend(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend pmlEdmDocumentReceiptExtend)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updatePmlEdmDocumentReceiptExtend(pmlEdmDocumentReceiptExtend);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceiptExtend addDocumentReceiptExtend(
        long documentReceiptId, long documentReceiptLogId,
        java.util.Date startProcessDate, int numDayProcessBef,
        java.util.Date limitDateBef, java.lang.String extendReason,
        int numDayProcessAft, java.util.Date limitDateAft,
        boolean leanOnLimitDate, long extendUserId,
        java.lang.String extendDepartmentId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addDocumentReceiptExtend(documentReceiptId,
            documentReceiptLogId, startProcessDate, numDayProcessBef,
            limitDateBef, extendReason, numDayProcessAft, limitDateAft,
            leanOnLimitDate, extendUserId, extendDepartmentId);
    }

    public static PmlEdmDocumentReceiptExtendLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmDocumentReceiptExtendLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmDocumentReceiptExtendLocalService service) {
        _service = service;
    }
}
