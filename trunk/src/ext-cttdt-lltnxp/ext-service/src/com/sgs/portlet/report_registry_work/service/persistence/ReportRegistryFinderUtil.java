package com.sgs.portlet.report_registry_work.service.persistence;

public class ReportRegistryFinderUtil {
    private static ReportRegistryFinder _finder;

    public static int count_report_registry(
        java.lang.String reportRegistryCodes, java.lang.String userCreates,
        java.lang.String resultWorks, java.lang.String programWorks,
        java.lang.Long departmentId, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_report_registry(reportRegistryCodes, userCreates,
            resultWorks, programWorks, departmentId, andOperator);
    }

    public static int count_report_registry(
        java.lang.String[] reportRegistryCodes, java.lang.String[] userCreates,
        java.lang.String[] resultWorks, java.lang.String[] programWorks,
        java.lang.Long departmentId, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .count_report_registry(reportRegistryCodes, userCreates,
            resultWorks, programWorks, departmentId, andOperator);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry(
        java.lang.String reportRegistryCodes, java.lang.String userCreates,
        java.lang.String resultWorks, java.lang.String programWorks,
        java.lang.Long departmentId, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_report_registry(reportRegistryCodes, userCreates,
            resultWorks, programWorks, departmentId, start, end, andOperator,
            obc);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> find_report_registry(
        java.lang.String[] reportRegistryCodes, java.lang.String[] userCreates,
        java.lang.String[] resultWorks, java.lang.String[] programWorks,
        java.lang.Long departmentId, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .find_report_registry(reportRegistryCodes, userCreates,
            resultWorks, programWorks, departmentId, andOperator, start, end,
            obc);
    }

    public static ReportRegistryFinder getFinder() {
        return _finder;
    }

    public void setFinder(ReportRegistryFinder finder) {
        _finder = finder;
    }
}
