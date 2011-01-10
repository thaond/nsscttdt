package com.sgs.portlet.report_registry_work.service.persistence;

public interface ReportRegistryFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_report_registry(java.lang.String reportRegistryCodes,
        java.lang.String resultWorks, java.lang.String programWorks,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int count_report_registry(java.lang.String[] reportRegistryCodes,
        java.lang.String[] resultWorks, java.lang.String[] programWorks,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry(
        java.lang.String reportRegistryCodes, java.lang.String resultWorks,
        java.lang.String programWorks, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry(
        java.lang.String[] reportRegistryCodes, java.lang.String[] resultWorks,
        java.lang.String[] programWorks, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
