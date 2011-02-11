package com.sgs.portlet.report_registry_work.service.persistence;

public interface ReportRegistryFinder {
    public int count_report_registry(java.lang.String reportRegistryCodes,
        java.lang.String userCreates, java.lang.String resultWorks,
        java.lang.String programWorks, java.lang.Long departmentId,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int count_report_registry(java.lang.String[] reportRegistryCodes,
        java.lang.String[] userCreates, java.lang.String[] resultWorks,
        java.lang.String[] programWorks, java.lang.Long departmentId,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry(
        java.lang.String reportRegistryCodes, java.lang.String userCreates,
        java.lang.String resultWorks, java.lang.String programWorks,
        java.lang.Long departmentId, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry(
        java.lang.String[] reportRegistryCodes, java.lang.String[] userCreates,
        java.lang.String[] resultWorks, java.lang.String[] programWorks,
        java.lang.Long departmentId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int count_report_registry_test(
        java.lang.String reportRegistryCodes, java.lang.String userCreates,
        java.lang.String resultWorks, java.lang.String programWorks,
        long departmentId, java.lang.String dateFrom, java.lang.String dateTo,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int count_report_registry_test(
        java.lang.String[] reportRegistryCodes, java.lang.String[] userCreates,
        java.lang.String[] resultWorks, java.lang.String[] programWorks,
        long departmentId, java.lang.String dateFrom, java.lang.String dateTo,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry_test(
        java.lang.String reportRegistryCodes, java.lang.String userCreates,
        java.lang.String resultWorks, java.lang.String programWorks,
        long departmentId, java.lang.String dateFrom, java.lang.String dateTo,
        int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry_test(
        java.lang.String[] reportRegistryCodes, java.lang.String[] userCreates,
        java.lang.String[] resultWorks, java.lang.String[] programWorks,
        long departmentId, java.lang.String dateFrom, java.lang.String dateTo,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
