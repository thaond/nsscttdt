package com.sgs.portlet.department.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.department.service.DepartmentLocalService;
import com.sgs.portlet.department.service.DepartmentService;
import com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService;
import com.sgs.portlet.department.service.persistence.DepartmentFinder;
import com.sgs.portlet.department.service.persistence.DepartmentPersistence;
import com.sgs.portlet.department.service.persistence.PmlDepartmentHSCVPersistence;


public abstract class DepartmentServiceBaseImpl extends PrincipalBean
    implements DepartmentService {
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
