package com.sgs.portlet.report_registry_work.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.report_registry_work.model.Department;
import com.sgs.portlet.report_registry_work.service.DepartmentLocalService;
import com.sgs.portlet.report_registry_work.service.DepartmentService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryLocalService;
import com.sgs.portlet.report_registry_work.service.ReportRegistryService;
import com.sgs.portlet.report_registry_work.service.persistence.DepartmentFinder;
import com.sgs.portlet.report_registry_work.service.persistence.DepartmentPersistence;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryFinder;
import com.sgs.portlet.report_registry_work.service.persistence.ReportRegistryPersistence;

import java.util.List;


public abstract class DepartmentLocalServiceBaseImpl
    implements DepartmentLocalService {
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

    public Department addDepartment(Department department)
        throws SystemException {
        department.setNew(true);

        return departmentPersistence.update(department, false);
    }

    public Department createDepartment(long departmentId) {
        return departmentPersistence.create(departmentId);
    }

    public void deleteDepartment(long departmentId)
        throws PortalException, SystemException {
        departmentPersistence.remove(departmentId);
    }

    public void deleteDepartment(Department department)
        throws SystemException {
        departmentPersistence.remove(department);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return departmentPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return departmentPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public Department getDepartment(long departmentId)
        throws PortalException, SystemException {
        return departmentPersistence.findByPrimaryKey(departmentId);
    }

    public List<Department> getDepartments(int start, int end)
        throws SystemException {
        return departmentPersistence.findAll(start, end);
    }

    public int getDepartmentsCount() throws SystemException {
        return departmentPersistence.countAll();
    }

    public Department updateDepartment(Department department)
        throws SystemException {
        department.setNew(false);

        return departmentPersistence.update(department, true);
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
