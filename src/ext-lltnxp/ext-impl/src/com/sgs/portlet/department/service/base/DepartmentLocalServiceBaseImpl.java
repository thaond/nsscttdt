package com.sgs.portlet.department.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.DepartmentLocalService;
import com.sgs.portlet.department.service.DepartmentService;
import com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService;
import com.sgs.portlet.department.service.persistence.DepartmentFinder;
import com.sgs.portlet.department.service.persistence.DepartmentPersistence;
import com.sgs.portlet.department.service.persistence.PmlDepartmentHSCVPersistence;

import java.util.List;


public abstract class DepartmentLocalServiceBaseImpl
    implements DepartmentLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.department.service.DepartmentLocalService.impl")
    protected DepartmentLocalService departmentLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.department.service.DepartmentService.impl")
    protected DepartmentService departmentService;
    @javax.annotation.Resource(name = "com.sgs.portlet.department.service.persistence.DepartmentPersistence.impl")
    protected DepartmentPersistence departmentPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.department.service.persistence.DepartmentFinder.impl")
    protected DepartmentFinder departmentFinder;
    @javax.annotation.Resource(name = "com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService.impl")
    protected PmlDepartmentHSCVLocalService pmlDepartmentHSCVLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.department.service.persistence.PmlDepartmentHSCVPersistence.impl")
    protected PmlDepartmentHSCVPersistence pmlDepartmentHSCVPersistence;

    public Department addDepartment(Department department)
        throws SystemException {
        department.setNew(true);

        return departmentPersistence.update(department, false);
    }

    public Department createDepartment(String departmentsId) {
        return departmentPersistence.create(departmentsId);
    }

    public void deleteDepartment(String departmentsId)
        throws PortalException, SystemException {
        departmentPersistence.remove(departmentsId);
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

    public Department getDepartment(String departmentsId)
        throws PortalException, SystemException {
        return departmentPersistence.findByPrimaryKey(departmentsId);
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

    public PmlDepartmentHSCVLocalService getPmlDepartmentHSCVLocalService() {
        return pmlDepartmentHSCVLocalService;
    }

    public void setPmlDepartmentHSCVLocalService(
        PmlDepartmentHSCVLocalService pmlDepartmentHSCVLocalService) {
        this.pmlDepartmentHSCVLocalService = pmlDepartmentHSCVLocalService;
    }

    public PmlDepartmentHSCVPersistence getPmlDepartmentHSCVPersistence() {
        return pmlDepartmentHSCVPersistence;
    }

    public void setPmlDepartmentHSCVPersistence(
        PmlDepartmentHSCVPersistence pmlDepartmentHSCVPersistence) {
        this.pmlDepartmentHSCVPersistence = pmlDepartmentHSCVPersistence;
    }
}
