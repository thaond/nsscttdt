package com.nss.portlet.department.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.department.service.DepartmentLocalService;
import com.nss.portlet.department.service.DepartmentService;
import com.nss.portlet.department.service.PmlDepartmentsLeaderLocalService;
import com.nss.portlet.department.service.PmlDepartmentsLeaderService;
import com.nss.portlet.department.service.PmlUserLocalService;
import com.nss.portlet.department.service.PmlUserService;
import com.nss.portlet.department.service.persistence.DepartmentFinder;
import com.nss.portlet.department.service.persistence.DepartmentPersistence;
import com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence;
import com.nss.portlet.department.service.persistence.PmlUserFinder;
import com.nss.portlet.department.service.persistence.PmlUserPersistence;


public abstract class PmlUserServiceBaseImpl extends PrincipalBean
    implements PmlUserService {
    @BeanReference(name = "com.nss.portlet.department.service.DepartmentLocalService.impl")
    protected DepartmentLocalService departmentLocalService;
    @BeanReference(name = "com.nss.portlet.department.service.DepartmentService.impl")
    protected DepartmentService departmentService;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.DepartmentPersistence.impl")
    protected DepartmentPersistence departmentPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.DepartmentFinder.impl")
    protected DepartmentFinder departmentFinder;
    @BeanReference(name = "com.nss.portlet.department.service.PmlUserLocalService.impl")
    protected PmlUserLocalService pmlUserLocalService;
    @BeanReference(name = "com.nss.portlet.department.service.PmlUserService.impl")
    protected PmlUserService pmlUserService;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlUserPersistence.impl")
    protected PmlUserPersistence pmlUserPersistence;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlUserFinder.impl")
    protected PmlUserFinder pmlUserFinder;
    @BeanReference(name = "com.nss.portlet.department.service.PmlDepartmentsLeaderLocalService.impl")
    protected PmlDepartmentsLeaderLocalService pmlDepartmentsLeaderLocalService;
    @BeanReference(name = "com.nss.portlet.department.service.PmlDepartmentsLeaderService.impl")
    protected PmlDepartmentsLeaderService pmlDepartmentsLeaderService;
    @BeanReference(name = "com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence.impl")
    protected PmlDepartmentsLeaderPersistence pmlDepartmentsLeaderPersistence;

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

    public PmlUserLocalService getPmlUserLocalService() {
        return pmlUserLocalService;
    }

    public void setPmlUserLocalService(PmlUserLocalService pmlUserLocalService) {
        this.pmlUserLocalService = pmlUserLocalService;
    }

    public PmlUserService getPmlUserService() {
        return pmlUserService;
    }

    public void setPmlUserService(PmlUserService pmlUserService) {
        this.pmlUserService = pmlUserService;
    }

    public PmlUserPersistence getPmlUserPersistence() {
        return pmlUserPersistence;
    }

    public void setPmlUserPersistence(PmlUserPersistence pmlUserPersistence) {
        this.pmlUserPersistence = pmlUserPersistence;
    }

    public PmlUserFinder getPmlUserFinder() {
        return pmlUserFinder;
    }

    public void setPmlUserFinder(PmlUserFinder pmlUserFinder) {
        this.pmlUserFinder = pmlUserFinder;
    }

    public PmlDepartmentsLeaderLocalService getPmlDepartmentsLeaderLocalService() {
        return pmlDepartmentsLeaderLocalService;
    }

    public void setPmlDepartmentsLeaderLocalService(
        PmlDepartmentsLeaderLocalService pmlDepartmentsLeaderLocalService) {
        this.pmlDepartmentsLeaderLocalService = pmlDepartmentsLeaderLocalService;
    }

    public PmlDepartmentsLeaderService getPmlDepartmentsLeaderService() {
        return pmlDepartmentsLeaderService;
    }

    public void setPmlDepartmentsLeaderService(
        PmlDepartmentsLeaderService pmlDepartmentsLeaderService) {
        this.pmlDepartmentsLeaderService = pmlDepartmentsLeaderService;
    }

    public PmlDepartmentsLeaderPersistence getPmlDepartmentsLeaderPersistence() {
        return pmlDepartmentsLeaderPersistence;
    }

    public void setPmlDepartmentsLeaderPersistence(
        PmlDepartmentsLeaderPersistence pmlDepartmentsLeaderPersistence) {
        this.pmlDepartmentsLeaderPersistence = pmlDepartmentsLeaderPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
