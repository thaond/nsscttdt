package com.sgs.portlet.department.service.persistence;

public interface DepartmentFinder {
    public java.util.List<com.sgs.portlet.department.model.Department> findDepartments(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countDepartments(java.lang.String departmentsId)
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

    public java.util.List<com.sgs.portlet.department.model.Department> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByPmlDepartment(
        java.lang.String pmlDepartmentCode, java.lang.String pmlDepartmentName,
        java.lang.String pmlDepartmentAbbreviateName, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findByPmlDepartment(
        java.lang.String[] pmlDepartmentCodes,
        java.lang.String[] pmlDepartmentNames,
        java.lang.String[] pmlDepartmentAbbreviateNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByDepartmentParentId(
        int start, int end) throws com.liferay.portal.SystemException;

    public int countTinhHinhThuLyCongVanPhongBan() throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.department.model.Department> findDepartmentsByCodeForValidate(
        java.lang.String departmentsCode)
        throws com.liferay.portal.SystemException;
}
