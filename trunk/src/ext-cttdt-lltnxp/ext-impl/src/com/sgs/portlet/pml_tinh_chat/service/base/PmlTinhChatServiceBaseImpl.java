package com.sgs.portlet.pml_tinh_chat.service.base;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.service.CompanyLocalService;
import com.liferay.portal.service.CompanyService;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserService;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalService;
import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatService;
import com.sgs.portlet.pml_tinh_chat.service.persistence.PmlTinhChatFinder;
import com.sgs.portlet.pml_tinh_chat.service.persistence.PmlTinhChatPersistence;


public abstract class PmlTinhChatServiceBaseImpl extends PrincipalBean
    implements PmlTinhChatService {
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalService.impl")
    protected PmlTinhChatLocalService pmlTinhChatLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatService.impl")
    protected PmlTinhChatService pmlTinhChatService;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_tinh_chat.service.persistence.PmlTinhChatPersistence.impl")
    protected PmlTinhChatPersistence pmlTinhChatPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.pml_tinh_chat.service.persistence.PmlTinhChatFinder.impl")
    protected PmlTinhChatFinder pmlTinhChatFinder;
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

    public PmlTinhChatLocalService getPmlTinhChatLocalService() {
        return pmlTinhChatLocalService;
    }

    public void setPmlTinhChatLocalService(
        PmlTinhChatLocalService pmlTinhChatLocalService) {
        this.pmlTinhChatLocalService = pmlTinhChatLocalService;
    }

    public PmlTinhChatService getPmlTinhChatService() {
        return pmlTinhChatService;
    }

    public void setPmlTinhChatService(PmlTinhChatService pmlTinhChatService) {
        this.pmlTinhChatService = pmlTinhChatService;
    }

    public PmlTinhChatPersistence getPmlTinhChatPersistence() {
        return pmlTinhChatPersistence;
    }

    public void setPmlTinhChatPersistence(
        PmlTinhChatPersistence pmlTinhChatPersistence) {
        this.pmlTinhChatPersistence = pmlTinhChatPersistence;
    }

    public PmlTinhChatFinder getPmlTinhChatFinder() {
        return pmlTinhChatFinder;
    }

    public void setPmlTinhChatFinder(PmlTinhChatFinder pmlTinhChatFinder) {
        this.pmlTinhChatFinder = pmlTinhChatFinder;
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
