package com.sgs.portlet.department.service.persistence;

public class DepartmentFinderUtil {
    private static DepartmentFinder _finder;

    public static java.util.List<com.sgs.portlet.department.model.Department> findDepartments(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findDepartments(departmentsId, start, end, obc);
    }

    public static int countDepartments(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getFinder().countDepartments(departmentsId);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlDepartment(java.lang.String pmlDepartmentCode,
        java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlDepartment(pmlDepartmentCode, pmlDepartmentName,
            pmlDepartmentAbbreviateName, andOperator);
    }

    public static int countByPmlDepartment(
        java.lang.String[] pmlDepartmentCodes,
        java.lang.String[] pmlDepartmentNames,
        java.lang.String[] pmlDepartmentAbbreviateNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlDepartment(pmlDepartmentCodes,
            pmlDepartmentNames, pmlDepartmentAbbreviateNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findByPmlDepartment(
        java.lang.String pmlDepartmentCode, java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlDepartment(pmlDepartmentCode, pmlDepartmentName,
            pmlDepartmentAbbreviateName, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findByPmlDepartment(
        java.lang.String[] pmlDepartmentCodes,
        java.lang.String[] pmlDepartmentNames,
        java.lang.String[] pmlDepartmentAbbreviateNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlDepartment(pmlDepartmentCodes, pmlDepartmentNames,
            pmlDepartmentAbbreviateNames, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId()
        throws com.liferay.portal.SystemException {
        return getFinder().findDepartmentsByDepartmentParentId();
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId(
        int start, int end) throws com.liferay.portal.SystemException {
        return getFinder().findDepartmentsByDepartmentParentId(start, end);
    }

    public static int countTinhHinhThuLyCongVanPhongBan()
        throws java.lang.Exception {
        return getFinder().countTinhHinhThuLyCongVanPhongBan();
    }

    public static java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByCodeForValidate(
        java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException {
        return getFinder().findDepartmentsByCodeForValidate(departmentsCode);
    }

    public static DepartmentFinder getFinder() {
        return _finder;
    }

    public void setFinder(DepartmentFinder finder) {
        _finder = finder;
    }
}
