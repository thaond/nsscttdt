package com.sgs.portlet.documentdelegate.service.persistence;

public interface PmlDocumentDelegateFinder {
    public int countBy_SD_TD_USERISDELEGATE(long userDelegate,
        java.lang.String fromDateDelegate, java.lang.String toDateDelegate,
        java.lang.String listUserIsDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findBy_SD_TD_USERISDELEGATE(
        long userDelegate, java.lang.String fromDateDelegate,
        java.lang.String toDateDelegate, java.lang.String listUserIsDelegate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
