package com.sgs.portlet.pml_do_quan_trong.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongLocalService;
import com.sgs.portlet.pml_do_quan_trong.service.PmlDoQuanTrongService;
import com.sgs.portlet.pml_do_quan_trong.service.persistence.PmlDoQuanTrongFinder;
import com.sgs.portlet.pml_do_quan_trong.service.persistence.PmlDoQuanTrongPersistence;


public abstract class PmlDoQuanTrongServiceBaseImpl extends PrincipalBean
    implements PmlDoQuanTrongService {
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
