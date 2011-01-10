package com.sgs.portlet.report_registry_work.service.persistence;

public class DepartmentFinderUtil {
    private static DepartmentFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int count_department(java.lang.String departmentCodes,
        java.lang.String departmentNames,
        java.lang.String departmentDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_department(departmentCodes, departmentNames,
            departmentDescriptions, andOperator);
    }

    public static int count_department(java.lang.String[] departmentCodes,
        java.lang.String[] departmentNames,
        java.lang.String[] departmentDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_department(departmentCodes, departmentNames,
            departmentDescriptions, andOperator);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> find_department(
        java.lang.String departmentCodes, java.lang.String departmentNames,
        java.lang.String departmentDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_department(departmentCodes, departmentNames,
            departmentDescriptions, start, end, andOperator, obc);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> find_department(
        java.lang.String[] departmentCodes, java.lang.String[] departmentNames,
        java.lang.String[] departmentDescriptions, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_department(departmentCodes, departmentNames,
            departmentDescriptions, andOperator, start, end, obc);
    }

    public static DepartmentFinder getFinder() {
        return _finder;
    }

    public void setFinder(DepartmentFinder finder) {
        _finder = finder;
    }
}
