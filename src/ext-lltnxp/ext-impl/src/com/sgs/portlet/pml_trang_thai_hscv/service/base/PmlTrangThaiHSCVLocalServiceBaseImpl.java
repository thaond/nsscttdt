package com.sgs.portlet.pml_trang_thai_hscv.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalService;
import com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVService;
import com.sgs.portlet.pml_trang_thai_hscv.service.persistence.PmlTrangThaiHSCVFinder;
import com.sgs.portlet.pml_trang_thai_hscv.service.persistence.PmlTrangThaiHSCVPersistence;

import java.util.List;


public abstract class PmlTrangThaiHSCVLocalServiceBaseImpl
    implements PmlTrangThaiHSCVLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVLocalService.impl")
    protected PmlTrangThaiHSCVLocalService pmlTrangThaiHSCVLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_trang_thai_hscv.service.PmlTrangThaiHSCVService.impl")
    protected PmlTrangThaiHSCVService pmlTrangThaiHSCVService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_trang_thai_hscv.service.persistence.PmlTrangThaiHSCVPersistence.impl")
    protected PmlTrangThaiHSCVPersistence pmlTrangThaiHSCVPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_trang_thai_hscv.service.persistence.PmlTrangThaiHSCVFinder.impl")
    protected PmlTrangThaiHSCVFinder pmlTrangThaiHSCVFinder;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.CompanyLocalService.impl")
    protected CompanyLocalService companyLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.CompanyService.impl")
    protected CompanyService companyService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.CompanyPersistence.impl")
    protected CompanyPersistence companyPersistence;
    @javax.annotation.Resource(name = "com.liferay.portal.service.UserLocalService.impl")
    protected UserLocalService userLocalService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.UserService.impl")
    protected UserService userService;
    @javax.annotation.Resource(name = "com.liferay.portal.service.persistence.UserPersistence.impl")
    protected UserPersistence userPersistence;

    public PmlTrangThaiHSCV addPmlTrangThaiHSCV(
        PmlTrangThaiHSCV pmlTrangThaiHSCV) throws SystemException {
        pmlTrangThaiHSCV.setNew(true);

        return pmlTrangThaiHSCVPersistence.update(pmlTrangThaiHSCV, false);
    }

    public PmlTrangThaiHSCV createPmlTrangThaiHSCV(long idTrangThaiHSCV) {
        return pmlTrangThaiHSCVPersistence.create(idTrangThaiHSCV);
    }

    public void deletePmlTrangThaiHSCV(long idTrangThaiHSCV)
        throws PortalException, SystemException {
        pmlTrangThaiHSCVPersistence.remove(idTrangThaiHSCV);
    }

    public void deletePmlTrangThaiHSCV(PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws SystemException {
        pmlTrangThaiHSCVPersistence.remove(pmlTrangThaiHSCV);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlTrangThaiHSCVPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlTrangThaiHSCVPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlTrangThaiHSCV getPmlTrangThaiHSCV(long idTrangThaiHSCV)
        throws PortalException, SystemException {
        return pmlTrangThaiHSCVPersistence.findByPrimaryKey(idTrangThaiHSCV);
    }

    public List<PmlTrangThaiHSCV> getPmlTrangThaiHSCVs(int start, int end)
        throws SystemException {
        return pmlTrangThaiHSCVPersistence.findAll(start, end);
    }

    public int getPmlTrangThaiHSCVsCount() throws SystemException {
        return pmlTrangThaiHSCVPersistence.countAll();
    }

    public PmlTrangThaiHSCV updatePmlTrangThaiHSCV(
        PmlTrangThaiHSCV pmlTrangThaiHSCV) throws SystemException {
        pmlTrangThaiHSCV.setNew(false);

        return pmlTrangThaiHSCVPersistence.update(pmlTrangThaiHSCV, true);
    }

    public PmlTrangThaiHSCVLocalService getPmlTrangThaiHSCVLocalService() {
        return pmlTrangThaiHSCVLocalService;
    }

    public void setPmlTrangThaiHSCVLocalService(
        PmlTrangThaiHSCVLocalService pmlTrangThaiHSCVLocalService) {
        this.pmlTrangThaiHSCVLocalService = pmlTrangThaiHSCVLocalService;
    }

    public PmlTrangThaiHSCVService getPmlTrangThaiHSCVService() {
        return pmlTrangThaiHSCVService;
    }

    public void setPmlTrangThaiHSCVService(
        PmlTrangThaiHSCVService pmlTrangThaiHSCVService) {
        this.pmlTrangThaiHSCVService = pmlTrangThaiHSCVService;
    }

    public PmlTrangThaiHSCVPersistence getPmlTrangThaiHSCVPersistence() {
        return pmlTrangThaiHSCVPersistence;
    }

    public void setPmlTrangThaiHSCVPersistence(
        PmlTrangThaiHSCVPersistence pmlTrangThaiHSCVPersistence) {
        this.pmlTrangThaiHSCVPersistence = pmlTrangThaiHSCVPersistence;
    }

    public PmlTrangThaiHSCVFinder getPmlTrangThaiHSCVFinder() {
        return pmlTrangThaiHSCVFinder;
    }

    public void setPmlTrangThaiHSCVFinder(
        PmlTrangThaiHSCVFinder pmlTrangThaiHSCVFinder) {
        this.pmlTrangThaiHSCVFinder = pmlTrangThaiHSCVFinder;
    }

    public CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    public void setCounterLocalService(CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    public CounterService getCounterService() {
        return counterService;
    }

    public void setCounterService(CounterService counterService) {
        this.counterService = counterService;
    }

    public CompanyLocalService getCompanyLocalService() {
        return companyLocalService;
    }

    public void setCompanyLocalService(CompanyLocalService companyLocalService) {
        this.companyLocalService = companyLocalService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    public CompanyPersistence getCompanyPersistence() {
        return companyPersistence;
    }

    public void setCompanyPersistence(CompanyPersistence companyPersistence) {
        this.companyPersistence = companyPersistence;
    }

    public UserLocalService getUserLocalService() {
        return userLocalService;
    }

    public void setUserLocalService(UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }
}
