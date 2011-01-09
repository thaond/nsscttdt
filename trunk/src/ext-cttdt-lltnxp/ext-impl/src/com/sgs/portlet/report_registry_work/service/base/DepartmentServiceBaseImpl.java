package com.sgs.portlet.report_registry_work.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.report_registry_work.service.DepartmentLocalService;
import com.sgs.portlet.report_registry_work.service.DepartmentService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryService;
import com.sgs.portlet.report_registry_work.service.persistence.DepartmentPersistence;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence;


public abstract class DepartmentServiceBaseImpl extends PrincipalBean
    implements DepartmentService {
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.DepartmentLocalService.impl")
    protected DepartmentLocalService departmentLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.DepartmentService.impl")
    protected DepartmentService departmentService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.DepartmentPersistence.impl")
    protected DepartmentPersistence departmentPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService.impl")
    protected ReportRegistryLocalService reportRegistryLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ReportRegistryService.impl")
    protected ReportRegistryService reportRegistryService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence.impl")
    protected ReportRegistryPersistence reportRegistryPersistence;

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
}
