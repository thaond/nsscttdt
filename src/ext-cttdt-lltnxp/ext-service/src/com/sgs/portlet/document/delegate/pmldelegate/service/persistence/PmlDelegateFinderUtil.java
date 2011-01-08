package com.sgs.portlet.document.delegate.pmldelegate.service.persistence;

public class PmlDelegateFinderUtil {
    private static PmlDelegateFinder _finder;

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findAllDelegate(
        int start, int end) throws com.liferay.portal.SystemException {
        return getFinder().findAllDelegate(start, end);
    }

    public static int countAllDelegate()
        throws com.liferay.portal.SystemException {
        return getFinder().countAllDelegate();
    }

    public static PmlDelegateFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlDelegateFinder finder) {
        _finder = finder;
    }
}
