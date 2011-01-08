package com.sgs.portlet.document.service.persistence;

public class PmlStateProcessFinderUtil {
    private static PmlStateProcessFinder _finder;

    public static java.util.List<com.sgs.portlet.document.model.PmlStateProcess> findByStateProcessIds(
        java.util.List<Long> stateProcessIds) throws java.lang.Exception {
        return getFinder().findByStateProcessIds(stateProcessIds);
    }

    public static PmlStateProcessFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlStateProcessFinder finder) {
        _finder = finder;
    }
}
