package com.sgs.portlet.report_registry_work.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.report_registry_work.service.DepartmentLocalService;
import com.sgs.portlet.report_registry_work.service.DepartmentService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryService;
import com.sgs.portlet.report_registry_work.service.ResultProgramLocalService;
import com.sgs.portlet.report_registry_work.service.ResultProgramService;
import com.sgs.portlet.report_registry_work.service.persistence.DepartmentFinder;
import com.sgs.portlet.report_registry_work.service.persistence.DepartmentPersistence;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryFinder;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence;
import com.sgs.portlet.report_registry_work.service.persistence.ResultProgramPersistence;


public abstract class ResultProgramServiceBaseImpl extends PrincipalBean
    implements ResultProgramService {
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
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ResultProgramLocalService.impl")
    protected ResultProgramLocalService resultProgramLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.ResultProgramService.impl")
    protected ResultProgramService resultProgramService;
    @javax.annotation.Resource(name = "com.sgs.portlet.report_registry_work.service.persistence.ResultProgramPersistence.impl")
    protected ResultProgramPersistence resultProgramPersistence;

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

    public ResultProgramLocalService getResultProgramLocalService() {
        return resultProgramLocalService;
    }

    public void setResultProgramLocalService(
        ResultProgramLocalService resultProgramLocalService) {
        this.resultProgramLocalService = resultProgramLocalService;
    }

    public ResultProgramService getResultProgramService() {
        return resultProgramService;
    }

    public void setResultProgramService(
        ResultProgramService resultProgramService) {
        this.resultProgramService = resultProgramService;
    }

    public ResultProgramPersistence getResultProgramPersistence() {
        return resultProgramPersistence;
    }

    public void setResultProgramPersistence(
        ResultProgramPersistence resultProgramPersistence) {
        this.resultProgramPersistence = resultProgramPersistence;
    }
}
