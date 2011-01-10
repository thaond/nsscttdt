package com.sgs.portlet.report_registry_work.service;


/**
 * <a href="ReportRegistryLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.report_registry_work.service.impl.ReportRegistryLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.report_registry_work.service.ReportRegistryLocalServiceUtil
 *
 */
public interface ReportRegistryLocalService {
    public com.sgs.portlet.report_registry_work.model.ReportRegistry addReportRegistry(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry createReportRegistry(
        long reportRegistryId);

    public void deleteReportRegistry(long reportRegistryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteReportRegistry(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry getReportRegistry(
        long reportRegistryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getReportRegistriesCount()
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry updateReportRegistry(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException;

    public int countByKeyword(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByKeyword(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countReportRegistry(java.lang.String reportRegistryCodes,
        java.lang.String resultWorks, java.lang.String programWorks,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findReportRegistry(
        java.lang.String reportRegistryCodes, java.lang.String resultWorks,
        java.lang.String programWorks, int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
