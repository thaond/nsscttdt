package com.sgs.portlet.document.send.service;


/**
 * <a href="PmlEdmAnswerDetailLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.document.send.service.PmlEdmAnswerDetailLocalService
 *
 */
public class PmlEdmAnswerDetailLocalServiceUtil {
    private static PmlEdmAnswerDetailLocalService _service;

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail addPmlEdmAnswerDetail(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws com.liferay.portal.SystemException {
        return getService().addPmlEdmAnswerDetail(pmlEdmAnswerDetail);
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail createPmlEdmAnswerDetail(
        long documentReceiptId) {
        return getService().createPmlEdmAnswerDetail(documentReceiptId);
    }

    public static void deletePmlEdmAnswerDetail(long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlEdmAnswerDetail(documentReceiptId);
    }

    public static void deletePmlEdmAnswerDetail(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws com.liferay.portal.SystemException {
        getService().deletePmlEdmAnswerDetail(pmlEdmAnswerDetail);
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

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail getPmlEdmAnswerDetail(
        long documentReceiptId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlEdmAnswerDetail(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmAnswerDetail> getPmlEdmAnswerDetails(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlEdmAnswerDetails(start, end);
    }

    public static int getPmlEdmAnswerDetailsCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlEdmAnswerDetailsCount();
    }

    public static com.sgs.portlet.document.send.model.PmlEdmAnswerDetail updatePmlEdmAnswerDetail(
        com.sgs.portlet.document.send.model.PmlEdmAnswerDetail pmlEdmAnswerDetail)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlEdmAnswerDetail(pmlEdmAnswerDetail);
    }

    public static int deletePmlEdmAnswerDetailBySendId(long documentSendId) {
        return getService().deletePmlEdmAnswerDetailBySendId(documentSendId);
    }

    public static PmlEdmAnswerDetailLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlEdmAnswerDetailLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlEdmAnswerDetailLocalService service) {
        _service = service;
    }
}
