package com.sgs.portlet.documentdelegate.service.persistence;

public class PmlDocumentDelegateFinderUtil {
    private static PmlDocumentDelegateFinder _finder;

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

    public static PmlDocumentDelegateFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlDocumentDelegateFinder finder) {
        _finder = finder;
    }
}
