package com.sgs.portlet.report_registry_work.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.report_registry_work.model.ReportRegistry;
import com.sgs.portlet.report_registry_work.service.DepartmentLocalService;
import com.sgs.portlet.report_registry_work.service.DepartmentService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryService;
import com.sgs.portlet.report_registry_work.service.persistence.DepartmentFinder;
import com.sgs.portlet.report_registry_work.service.persistence.DepartmentPersistence;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryFinder;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence;

import java.util.List;


public abstract class ReportRegistryLocalServiceBaseImpl
    implements ReportRegistryLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.DepartmentLocalService.impl")
    protected DepartmentLocalService departmentLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.DepartmentService.impl")
    protected DepartmentService departmentService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.DepartmentPersistence.impl")
    protected DepartmentPersistence departmentPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.DepartmentFinder.impl")
    protected DepartmentFinder departmentFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService.impl")
    protected ReportRegistryLocalService reportRegistryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryService.impl")
    protected ReportRegistryService reportRegistryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence.impl")
    protected ReportRegistryPersistence reportRegistryPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryFinder.impl")
    protected ReportRegistryFinder reportRegistryFinder;

    public ReportRegistry addReportRegistry(ReportRegistry reportRegistry)
        throws SystemException {
        reportRegistry.setNew(true);

        return reportRegistryPersistence.update(reportRegistry, false);
    }

    public ReportRegistry createReportRegistry(long reportRegistryId) {
        return reportRegistryPersistence.create(reportRegistryId);
    }

    public void deleteReportRegistry(long reportRegistryId)
        throws PortalException, SystemException {
        reportRegistryPersistence.remove(reportRegistryId);
    }

    public void deleteReportRegistry(ReportRegistry reportRegistry)
        throws SystemException {
        reportRegistryPersistence.remove(reportRegistry);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return reportRegistryPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return reportRegistryPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public ReportRegistry getReportRegistry(long reportRegistryId)
        throws PortalException, SystemException {
        return reportRegistryPersistence.findByPrimaryKey(reportRegistryId);
    }

    public List<ReportRegistry> getReportRegistries(int start, int end)
        throws SystemException {
        return reportRegistryPersistence.findAll(start, end);
    }

    public int getReportRegistriesCount() throws SystemException {
        return reportRegistryPersistence.countAll();
    }

    public ReportRegistry updateReportRegistry(ReportRegistry reportRegistry)
        throws SystemException {
        reportRegistry.setNew(false);

        return reportRegistryPersistence.update(reportRegistry, true);
    }

    public DepartmentLocalService getDepartmentLocalService() {
        return departmentLocalService;
    }

    public void setDepartmentLocalService(
        DepartmentLocalService departmentLocalService) {
        this.departmentLocalService = departmentLocalService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public DepartmentPersistence getDepartmentPersistence() {
        return departmentPersistence;
    }

    public void setDepartmentPersistence(
        DepartmentPersistence departmentPersistence) {
        this.departmentPersistence = departmentPersistence;
    }

    public DepartmentFinder getDepartmentFinder() {
        return departmentFinder;
    }

    public void setDepartmentFinder(DepartmentFinder departmentFinder) {
        this.departmentFinder = departmentFinder;
    }

    public ReportRegistryLocalService getReportRegistryLocalService() {
        return reportRegistryLocalService;
    }

    public void setReportRegistryLocalService(
        ReportRegistryLocalService reportRegistryLocalService) {
        this.reportRegistryLocalService = reportRegistryLocalService;
    }

    public ReportRegistryService getReportRegistryService() {
        return reportRegistryService;
    }

    public void setReportRegistryService(
        ReportRegistryService reportRegistryService) {
        this.reportRegistryService = reportRegistryService;
    }

    public ReportRegistryPersistence getReportRegistryPersistence() {
        return reportRegistryPersistence;
    }

    public void setReportRegistryPersistence(
        ReportRegistryPersistence reportRegistryPersistence) {
        this.reportRegistryPersistence = reportRegistryPersistence;
    }

    public ReportRegistryFinder getReportRegistryFinder() {
        return reportRegistryFinder;
    }

    public void setReportRegistryFinder(
        ReportRegistryFinder reportRegistryFinder) {
        this.reportRegistryFinder = reportRegistryFinder;
    }
}
