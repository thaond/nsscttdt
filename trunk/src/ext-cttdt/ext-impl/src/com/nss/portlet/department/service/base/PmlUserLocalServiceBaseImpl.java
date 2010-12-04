package com.nss.portlet.department.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.department.model.PmlUser;
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

import java.util.List;


public abstract class PmlUserLocalServiceBaseImpl implements PmlUserLocalService {
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

    public PmlUser addPmlUser(PmlUser pmlUser) throws SystemException {
        pmlUser.setNew(true);

        return pmlUserPersistence.update(pmlUser, false);
    }

    public PmlUser createPmlUser(long userId) {
        return pmlUserPersistence.create(userId);
    }

    public void deletePmlUser(long userId)
        throws PortalException, SystemException {
        pmlUserPersistence.remove(userId);
    }

    public void deletePmlUser(PmlUser pmlUser) throws SystemException {
        pmlUserPersistence.remove(pmlUser);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlUserPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlUserPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public PmlUser getPmlUser(long userId)
        throws PortalException, SystemException {
        return pmlUserPersistence.findByPrimaryKey(userId);
    }

    public List<PmlUser> getPmlUsers(int start, int end)
        throws SystemException {
        return pmlUserPersistence.findAll(start, end);
    }

    public int getPmlUsersCount() throws SystemException {
        return pmlUserPersistence.countAll();
    }

    public PmlUser updatePmlUser(PmlUser pmlUser) throws SystemException {
        pmlUser.setNew(false);

        return pmlUserPersistence.update(pmlUser, true);
    }

    public PmlUser updatePmlUser(PmlUser pmlUser, boolean merge)
        throws SystemException {
        pmlUser.setNew(false);

        return pmlUserPersistence.update(pmlUser, merge);
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
