package com.nss.portlet.onedoor.service.persistence;

public class PmlStateProcessFinderUtil {
    private static PmlStateProcessFinder _finder;

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessIds(
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
