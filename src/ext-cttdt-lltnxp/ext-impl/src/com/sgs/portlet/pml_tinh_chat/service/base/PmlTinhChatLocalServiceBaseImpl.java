package com.sgs.portlet.pml_tinh_chat.service.base;

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

import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalService;
import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatService;
import com.sgs.portlet.pml_tinh_chat.service.persistence.PmlTinhChatFinder;
import com.sgs.portlet.pml_tinh_chat.service.persistence.PmlTinhChatPersistence;

import java.util.List;


public abstract class PmlTinhChatLocalServiceBaseImpl
    implements PmlTinhChatLocalService {
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

    public PmlTinhChat addPmlTinhChat(PmlTinhChat pmlTinhChat)
        throws SystemException {
        pmlTinhChat.setNew(true);

        return pmlTinhChatPersistence.update(pmlTinhChat, false);
    }

    public PmlTinhChat createPmlTinhChat(long idTinhChat) {
        return pmlTinhChatPersistence.create(idTinhChat);
    }

    public void deletePmlTinhChat(long idTinhChat)
        throws PortalException, SystemException {
        pmlTinhChatPersistence.remove(idTinhChat);
    }

    public void deletePmlTinhChat(PmlTinhChat pmlTinhChat)
        throws SystemException {
        pmlTinhChatPersistence.remove(pmlTinhChat);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return pmlTinhChatPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return pmlTinhChatPersistence.findWithDynamicQuery(dynamicQuery, start,
            end);
    }

    public PmlTinhChat getPmlTinhChat(long idTinhChat)
        throws PortalException, SystemException {
        return pmlTinhChatPersistence.findByPrimaryKey(idTinhChat);
    }

    public List<PmlTinhChat> getPmlTinhChats(int start, int end)
        throws SystemException {
        return pmlTinhChatPersistence.findAll(start, end);
    }

    public int getPmlTinhChatsCount() throws SystemException {
        return pmlTinhChatPersistence.countAll();
    }

    public PmlTinhChat updatePmlTinhChat(PmlTinhChat pmlTinhChat)
        throws SystemException {
        pmlTinhChat.setNew(false);

        return pmlTinhChatPersistence.update(pmlTinhChat, true);
    }

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
