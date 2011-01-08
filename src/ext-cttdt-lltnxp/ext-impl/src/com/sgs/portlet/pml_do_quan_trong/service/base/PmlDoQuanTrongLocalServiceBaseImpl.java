package com.sgs.portlet.pml_do_quan_trong.service.base;

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

import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalService;
import com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongService;
import com.sgs.portlet.pml_do_quan_trong.service.persistence.PmlDoQuanTrongFinder;
import com.sgs.portlet.pml_do_quan_trong.service.persistence.PmlDoQuanTrongPersistence;

import java.util.List;


public abstract class PmlDoQuanTrongLocalServiceBaseImpl
    implements PmlDoQuanTrongLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalService.impl")
    protected PmlDoQuanTrongLocalService pmlDoQuanTrongLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongService.impl")
    protected PmlDoQuanTrongService pmlDoQuanTrongService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_do_quan_trong.service.persistence.PmlDoQuanTrongPersistence.impl")
    protected PmlDoQuanTrongPersistence pmlDoQuanTrongPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_do_quan_trong.service.persistence.PmlDoQuanTrongFinder.impl")
    protected PmlDoQuanTrongFinder pmlDoQuanTrongFinder;
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

    public PmlDoQuanTrong addPmlDoQuanTrong(PmlDoQuanTrong pmlDoQuanTrong)
        throws SystemException {
        pmlDoQuanTrong.setNew(true);

        return pmlDoQuanTrongPersistence.update(pmlDoQuanTrong, false);
    }

    public PmlDoQuanTrong createPmlDoQuanTrong(long idDoQuanTrong) {
        return pmlDoQuanTrongPersistence.create(idDoQuanTrong);
    }

    public void deletePmlDoQuanTrong(long idDoQuanTrong)
        throws PortalException, SystemException {
        pmlDoQuanTrongPersistence.remove(idDoQuanTrong);
    }

    public void deletePmlDoQuanTrong(PmlDoQuanTrong pmlDoQuanTrong)
        throws SystemException {
        pmlDoQuanTrongPersistence.remove(pmlDoQuanTrong);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlDoQuanTrongPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlDoQuanTrongPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public PmlDoQuanTrong getPmlDoQuanTrong(long idDoQuanTrong)
        throws PortalException, SystemException {
        return pmlDoQuanTrongPersistence.findByPrimaryKey(idDoQuanTrong);
    }

    public List<PmlDoQuanTrong> getPmlDoQuanTrongs(int start, int end)
        throws SystemException {
        return pmlDoQuanTrongPersistence.findAll(start, end);
    }

    public int getPmlDoQuanTrongsCount() throws SystemException {
        return pmlDoQuanTrongPersistence.countAll();
    }

    public PmlDoQuanTrong updatePmlDoQuanTrong(PmlDoQuanTrong pmlDoQuanTrong)
        throws SystemException {
        pmlDoQuanTrong.setNew(false);

        return pmlDoQuanTrongPersistence.update(pmlDoQuanTrong, true);
    }

    public PmlDoQuanTrongLocalService getPmlDoQuanTrongLocalService() {
        return pmlDoQuanTrongLocalService;
    }

    public void setPmlDoQuanTrongLocalService(
        PmlDoQuanTrongLocalService pmlDoQuanTrongLocalService) {
        this.pmlDoQuanTrongLocalService = pmlDoQuanTrongLocalService;
    }

    public PmlDoQuanTrongService getPmlDoQuanTrongService() {
        return pmlDoQuanTrongService;
    }

    public void setPmlDoQuanTrongService(
        PmlDoQuanTrongService pmlDoQuanTrongService) {
        this.pmlDoQuanTrongService = pmlDoQuanTrongService;
    }

    public PmlDoQuanTrongPersistence getPmlDoQuanTrongPersistence() {
        return pmlDoQuanTrongPersistence;
    }

    public void setPmlDoQuanTrongPersistence(
        PmlDoQuanTrongPersistence pmlDoQuanTrongPersistence) {
        this.pmlDoQuanTrongPersistence = pmlDoQuanTrongPersistence;
    }

    public PmlDoQuanTrongFinder getPmlDoQuanTrongFinder() {
        return pmlDoQuanTrongFinder;
    }

    public void setPmlDoQuanTrongFinder(
        PmlDoQuanTrongFinder pmlDoQuanTrongFinder) {
        this.pmlDoQuanTrongFinder = pmlDoQuanTrongFinder;
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
