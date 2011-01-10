package com.sgs.portlet.report_registry_work.service.persistence;

public class DepartmentFinderUtil {
    private static DepartmentFinder _finder;

    public static DepartmentFinder getFinder() {
        return _finder;
    }

    public void setFinder(DepartmentFinder finder) {
        _finder = finder;
    }
}
