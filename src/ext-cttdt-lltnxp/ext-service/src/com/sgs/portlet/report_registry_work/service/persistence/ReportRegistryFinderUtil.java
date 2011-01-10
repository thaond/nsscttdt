package com.sgs.portlet.report_registry_work.service.persistence;

public class ReportRegistryFinderUtil {
    private static ReportRegistryFinder _finder;

    public static ReportRegistryFinder getFinder() {
        return _finder;
    }

    public void setFinder(ReportRegistryFinder finder) {
        _finder = finder;
    }
}
