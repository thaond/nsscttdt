package com.sgs.portlet.documentdelegate.service.persistence;

public interface PmlDocumentDelegateFinder {
    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findBy_ALLUSERISDELEGATE(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countBy_SD_TD_USERISDELEGATE(long userDelegate,
        java.lang.String fromDateDelegate, java.lang.String toDateDelegate,
        java.lang.String listUserIsDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findBy_SD_TD_USERISDELEGATE(
        long userDelegate, java.lang.String fromDateDelegate,
        java.lang.String toDateDelegate, java.lang.String listUserIsDelegate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getDanhSachNguoiUyQuyen(
        long userIsDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countDanhSachNguoiUyQuyen(long userIsDelegateId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmluser.model.PmlUser> getDanhSachNguoiDuocUyQuyen(
        long userDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countDanhSachNguoiDuocUyQuyen(long userDelegateId)
        throws com.liferay.portal.SystemException;

    public int countNumOfDocumentReceiptIsDelegated(long userDelegateId,
        long userIsDelegateId, java.util.Date fromDate, java.util.Date toDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt> getNumOfDocumentReceiptIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countNumOfDocumentSendIsDelegated(long userDelegateId,
        long userIsDelegateId, java.util.Date fromDate, java.util.Date toDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmDocumentSend> getNumOfDocumentSendIsDelegated(
        long userDelegateId, long userIsDelegateId, java.util.Date fromDate,
        java.util.Date toDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
