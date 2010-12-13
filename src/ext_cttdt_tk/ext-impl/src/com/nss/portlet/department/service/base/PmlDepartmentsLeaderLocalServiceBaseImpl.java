package com.nss.portlet.department.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.department.model.PmlDepartmentsLeader;
import com.nss.portlet.department.service.DepartmentLocalService;
import com.nss.portlet.department.service.DepartmentService;
import com.nss.portlet.department.service.PmlDepartmentsLeaderLocalService;
import com.nss.portlet.department.service.PmlDepartmentsLeaderService;
import com.nss.portlet.department.service.PmlUserLocalService;
import com.nss.portlet.department.service.PmlUserService;
import com.nss.portlet.department.service.persistence.DepartmentFinder;
import com.nss.portlet.department.service.persistence.DepartmentPersistence;
import com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPK;
import com.nss.portlet.department.service.persistence.PmlDepartmentsLeaderPersistence;
import com.nss.portlet.department.service.persistence.PmlUserFinder;
import com.nss.portlet.department.service.persistence.PmlUserPersistence;

import java.util.List;


public abstract class PmlDepartmentsLeaderLocalServiceBaseImpl
    implements PmlDepartmentsLeaderLocalService {
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

    public PmlDepartmentsLeader addPmlDepartmentsLeader(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        pmlDepartmentsLeader.setNew(true);

        return pmlDepartmentsLeaderPersistence.update(pmlDepartmentsLeader,
            false);
    }

    public PmlDepartmentsLeader createPmlDepartmentsLeader(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK) {
        return pmlDepartmentsLeaderPersistence.create(pmlDepartmentsLeaderPK);
    }

    public void deletePmlDepartmentsLeader(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws PortalException, SystemException {
        pmlDepartmentsLeaderPersistence.remove(pmlDepartmentsLeaderPK);
    }

    public void deletePmlDepartmentsLeader(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        pmlDepartmentsLeaderPersistence.remove(pmlDepartmentsLeader);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlDepartmentsLeaderPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlDepartmentsLeaderPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlDepartmentsLeader getPmlDepartmentsLeader(
        PmlDepartmentsLeaderPK pmlDepartmentsLeaderPK)
        throws PortalException, SystemException {
        return pmlDepartmentsLeaderPersistence.findByPrimaryKey(pmlDepartmentsLeaderPK);
    }

    public List<PmlDepartmentsLeader> getPmlDepartmentsLeaders(int start,
        int end) throws SystemException {
        return pmlDepartmentsLeaderPersistence.findAll(start, end);
    }

    public int getPmlDepartmentsLeadersCount() throws SystemException {
        return pmlDepartmentsLeaderPersistence.countAll();
    }

    public PmlDepartmentsLeader updatePmlDepartmentsLeader(
        PmlDepartmentsLeader pmlDepartmentsLeader) throws SystemException {
        pmlDepartmentsLeader.setNew(false);

        return pmlDepartmentsLeaderPersistence.update(pmlDepartmentsLeader, true);
    }

    public PmlDepartmentsLeader updatePmlDepartmentsLeader(
        PmlDepartmentsLeader pmlDepartmentsLeader, boolean merge)
        throws SystemException {
        pmlDepartmentsLeader.setNew(false);

        return pmlDepartmentsLeaderPersistence.update(pmlDepartmentsLeader,
            merge);
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
