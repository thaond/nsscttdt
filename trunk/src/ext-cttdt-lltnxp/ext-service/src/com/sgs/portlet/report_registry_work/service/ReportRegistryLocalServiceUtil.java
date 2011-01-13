package com.sgs.portlet.report_registry_work.service;


/**
 * <a href="ReportRegistryLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService
 *
 */
public class ReportRegistryLocalServiceUtil {
    private static ReportRegistryLocalService _service;

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry addReportRegistry(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException {
        return getService().addReportRegistry(reportRegistry);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry createReportRegistry(
        long reportRegistryId) {
        return getService().createReportRegistry(reportRegistryId);
    }

    public static void deleteReportRegistry(long reportRegistryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteReportRegistry(reportRegistryId);
    }

    public static void deleteReportRegistry(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException {
        getService().deleteReportRegistry(reportRegistry);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry getReportRegistry(
        long reportRegistryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getReportRegistry(reportRegistryId);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getReportRegistries(start, end);
    }

    public static int getReportRegistriesCount()
        throws com.liferay.portal.SystemException {
        return getService().getReportRegistriesCount();
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry updateReportRegistry(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException {
        return getService().updateReportRegistry(reportRegistry);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ResultProgram> getResultPrograms(
        long reportRegistryId) throws com.liferay.portal.SystemException {
        return getService().getResultPrograms(reportRegistryId);
    }

    public static int countReportRegistry(
        java.lang.String reportRegistryCodes, java.lang.String userCreates,
        java.lang.String resultWorks, java.lang.String programWorks,
        java.lang.Long departmentId, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countReportRegistry(reportRegistryCodes, userCreates,
            resultWorks, programWorks, departmentId, andOperator);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findReportRegistry(
        java.lang.String reportRegistryCodes, java.lang.String userCreates,
        java.lang.String resultWorks, java.lang.String programWorks,
        java.lang.Long departmentId, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .findReportRegistry(reportRegistryCodes, userCreates,
            resultWorks, programWorks, departmentId, start, end, andOperator,
            obc);
    }

    public static ReportRegistryLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("ReportRegistryLocalService is not set");
        }

        return _service;
    }

    public void setService(ReportRegistryLocalService service) {
        _service = service;
    }
}
