package com.sgs.portlet.department.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.department.model.PmlDepartmentHSCV;
import com.sgs.portlet.department.service.DepartmentLocalService;
import com.sgs.portlet.department.service.DepartmentService;
import com.sgs.portlet.department.service.PmlDepartmentHSCVLocalService;
import com.sgs.portlet.department.service.persistence.DepartmentFinder;
import com.sgs.portlet.department.service.persistence.DepartmentPersistence;
import com.sgs.portlet.department.service.persistence.PmlDepartmentHSCVPersistence;

import java.util.List;


public abstract class PmlDepartmentHSCVLocalServiceBaseImpl
    implements PmlDepartmentHSCVLocalService {
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

    public PmlDepartmentHSCV addPmlDepartmentHSCV(
        PmlDepartmentHSCV pmlDepartmentHSCV) throws SystemException {
        pmlDepartmentHSCV.setNew(true);

        return pmlDepartmentHSCVPersistence.update(pmlDepartmentHSCV, false);
    }

    public PmlDepartmentHSCV createPmlDepartmentHSCV(long pmlDepartmentHSCVId) {
        return pmlDepartmentHSCVPersistence.create(pmlDepartmentHSCVId);
    }

    public void deletePmlDepartmentHSCV(long pmlDepartmentHSCVId)
        throws PortalException, SystemException {
        pmlDepartmentHSCVPersistence.remove(pmlDepartmentHSCVId);
    }

    public void deletePmlDepartmentHSCV(PmlDepartmentHSCV pmlDepartmentHSCV)
        throws SystemException {
        pmlDepartmentHSCVPersistence.remove(pmlDepartmentHSCV);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlDepartmentHSCVPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlDepartmentHSCVPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlDepartmentHSCV getPmlDepartmentHSCV(long pmlDepartmentHSCVId)
        throws PortalException, SystemException {
        return pmlDepartmentHSCVPersistence.findByPrimaryKey(pmlDepartmentHSCVId);
    }

    public List<PmlDepartmentHSCV> getPmlDepartmentHSCVs(int start, int end)
        throws SystemException {
        return pmlDepartmentHSCVPersistence.findAll(start, end);
    }

    public int getPmlDepartmentHSCVsCount() throws SystemException {
        return pmlDepartmentHSCVPersistence.countAll();
    }

    public PmlDepartmentHSCV updatePmlDepartmentHSCV(
        PmlDepartmentHSCV pmlDepartmentHSCV) throws SystemException {
        pmlDepartmentHSCV.setNew(false);

        return pmlDepartmentHSCVPersistence.update(pmlDepartmentHSCV, true);
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
