package com.sgs.portlet.documentdelegate.service.persistence;

public class PmlDocumentDelegateFinderUtil {
    private static PmlDocumentDelegateFinder _finder;

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findBy_ALLUSERISDELEGATE(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findBy_ALLUSERISDELEGATE(start, end, obc);
    }

    public static int countBy_SD_TD_USERISDELEGATE(long userDelegate,
        java.lang.String fromDateDelegate, java.lang.String toDateDelegate,
        java.lang.String listUserIsDelegate)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countBy_SD_TD_USERISDELEGATE(userDelegate,
            fromDateDelegate, toDateDelegate, listUserIsDelegate);
    }

    public static java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findBy_SD_TD_USERISDELEGATE(
        long userDelegate, java.lang.String fromDateDelegate,
        java.lang.String toDateDelegate, java.lang.String listUserIsDelegate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findBy_SD_TD_USERISDELEGATE(userDelegate, fromDateDelegate,
            toDateDelegate, listUserIsDelegate, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getDanhSachNguoiUyQuyen(
        long userIsDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getDanhSachNguoiUyQuyen(userIsDelegateId, start, end, obc);
    }

    public static int countDanhSachNguoiUyQuyen(long userIsDelegateId)
        throws com.liferay.portal.SystemException {
        return getFinder().countDanhSachNguoiUyQuyen(userIsDelegateId);
    }

    public static java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getDanhSachNguoiDuocUyQuyen(
        long userDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getDanhSachNguoiDuocUyQuyen(userDelegateId, start, end, obc);
    }

    public static int countDanhSachNguoiDuocUyQuyen(long userDelegateId)
        throws com.liferay.portal.SystemException {
        return getFinder().countDanhSachNguoiDuocUyQuyen(userDelegateId);
    }

    public static int countNumOfDocumentReceiptIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countNumOfDocumentReceiptIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getNumOfDocumentReceiptIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getNumOfDocumentReceiptIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate, start, end, obc);
    }

    public static int countNumOfDocumentSendIsDelegated(long userDelegateId,
        long userIsDelegateId, java.util.Date fromDate, java.util.Date toDate)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countNumOfDocumentSendIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate);
    }

    public static java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getNumOfDocumentSendIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getNumOfDocumentSendIsDelegated(userDelegateId,
            userIsDelegateId, fromDate, toDate, start, end, obc);
    }

    public static PmlDocumentDelegateFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlDocumentDelegateFinder finder) {
        _finder = finder;
    }
}
