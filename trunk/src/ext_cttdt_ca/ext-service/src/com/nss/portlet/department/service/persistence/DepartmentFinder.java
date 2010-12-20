package com.nss.portlet.department.service.persistence;

public interface DepartmentFinder {
    public java.util.List<com.nss.portlet.department.model.Department> findDepartmentsByDepartmentParentId()
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlDepartment(java.lang.String pmlDepartmentCode,
        java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByPmlDepartment(java.lang.String[] pmlDepartmentCodes,
        java.lang.String[] pmlDepartmentNames,
        java.lang.String[] pmlDepartmentAbbreviateNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.Department> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.Department> findByPmlDepartment(
        java.lang.String pmlDepartmentCode, java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.Department> findByPmlDepartment(
        java.lang.String[] pmlDepartmentCodes,
        java.lang.String[] pmlDepartmentNames,
        java.lang.String[] pmlDepartmentAbbreviateNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.department.model.Department> findDepartmentsByCodeForValidate(
        java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException;
}
