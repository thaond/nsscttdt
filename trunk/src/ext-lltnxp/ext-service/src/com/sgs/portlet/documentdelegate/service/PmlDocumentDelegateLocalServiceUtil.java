package com.sgs.portlet.documentdelegate.service;


/**
 * <a href="PmlDocumentDelegateLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.documentdelegate.service.PmlDocumentDelegateLocalService
 *
 */
public class PmlDocumentDelegateLocalServiceUtil {
    private static PmlDocumentDelegateLocalService _service;

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate addPmlDocumentDelegate(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException {
        return getService().addPmlDocumentDelegate(pmlDocumentDelegate);
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate createPmlDocumentDelegate(
        long documentDelegateId) {
        return getService().createPmlDocumentDelegate(documentDelegateId);
    }

    public static void deletePmlDocumentDelegate(long documentDelegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlDocumentDelegate(documentDelegateId);
    }

    public static void deletePmlDocumentDelegate(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException {
        getService().deletePmlDocumentDelegate(pmlDocumentDelegate);
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

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate getPmlDocumentDelegate(
        long documentDelegateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlDocumentDelegate(documentDelegateId);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> getPmlDocumentDelegates(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentDelegates(start, end);
    }

    public static int getPmlDocumentDelegatesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlDocumentDelegatesCount();
    }

    public static com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate updatePmlDocumentDelegate(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlDocumentDelegate(pmlDocumentDelegate);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> getPmlDocumentDelegate_ALLUSERISDELEGATE(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getPmlDocumentDelegate_ALLUSERISDELEGATE(start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> getPmlDocumentDelegate_SD_TD_USERISDELEGATE(
        long userDelegate, java.lang.String fromDateDelegate,
        java.lang.String toDateDelegate, java.lang.String listUserIsDelegate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getPmlDocumentDelegate_SD_TD_USERISDELEGATE(userDelegate,
            fromDateDelegate, toDateDelegate, listUserIsDelegate, start, end,
            obc);
    }

    public static int countPmlDocumentDelegate_SD_TD_USERISDELEGATE(
        long userDelegate, java.lang.String fromDateDelegate,
        java.lang.String toDateDelegate, java.lang.String listUserIsDelegate) {
        return getService()
                   .countPmlDocumentDelegate_SD_TD_USERISDELEGATE(userDelegate,
            fromDateDelegate, toDateDelegate, listUserIsDelegate);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getDanhSachNguoiUyQuyen(
        long userIsDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getDanhSachNguoiUyQuyen(userIsDelegateId, start, end, obc);
    }

    public static int countDanhSachNguoiUyQuyen(long userIsDelegateId) {
        return getService().countDanhSachNguoiUyQuyen(userIsDelegateId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getDanhSachNguoiDuocUyQuyen(
        long userDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc) {
        return getService()
                   .getDanhSachNguoiDuocUyQuyen(userDelegateId, start, end, obc);
    }

    public static int countDanhSachNguoiDuocUyQuyen(long userDelegateId) {
        return getService().countDanhSachNguoiDuocUyQuyen(userDelegateId);
    }

    public static int countNumOfDocumentReceiptIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate) throws com.liferay.portal.SystemException {
        return getService()
                   .countNumOfDocumentReceiptIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getNumOfDocumentReceiptIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getNumOfDocumentReceiptIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate, start, end, obc);
    }

    public static int countNumOfDocumentSendIsDelegated(long userDelegateId,
        long userIsDelegateId, java.util.Date fromDate, java.util.Date toDate)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countNumOfDocumentSendIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getNumOfDocumentSendIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getNumOfDocumentSendIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate, start, end, obc);
    }

    public static PmlDocumentDelegateLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "PmlDocumentDelegateLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlDocumentDelegateLocalService service) {
        _service = service;
    }
}
