package com.sgs.portlet.report_registry_work.service.persistence;

public interface DepartmentFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_department(java.lang.String departmentCodes,
        java.lang.String departmentNames,
        java.lang.String departmentDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int count_department(java.lang.String[] departmentCodes,
        java.lang.String[] departmentNames,
        java.lang.String[] departmentDescriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.Department> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.Department> find_department(
        java.lang.String departmentCodes, java.lang.String departmentNames,
        java.lang.String departmentDescriptions, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.Department> find_department(
        java.lang.String[] departmentCodes, java.lang.String[] departmentNames,
        java.lang.String[] departmentDescriptions, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
