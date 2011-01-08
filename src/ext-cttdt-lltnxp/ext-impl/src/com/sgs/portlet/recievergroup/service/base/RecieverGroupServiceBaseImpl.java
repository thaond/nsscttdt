package com.sgs.portlet.recievergroup.service.base;

import com.liferay.portal.service.base.PrincipalBean;

import com.sgs.portlet.recievergroup.service.RecieverGroupLocalService;
import com.sgs.portlet.recievergroup.service.RecieverGroupService;
import com.sgs.portlet.recievergroup.service.RecieverLocalService;
import com.sgs.portlet.recievergroup.service.RecieverService;
import com.sgs.portlet.recievergroup.service.persistence.RecieverFinder;
import com.sgs.portlet.recievergroup.service.persistence.RecieverGroupPersistence;
import com.sgs.portlet.recievergroup.service.persistence.RecieverPersistence;


public abstract class RecieverGroupServiceBaseImpl extends PrincipalBean
    implements RecieverGroupService {
    @javax.annotation.Resource(name = "com.sgs.portlet.recievergroup.service.RecieverGroupLocalService.impl")
    protected RecieverGroupLocalService recieverGroupLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.recievergroup.service.RecieverGroupService.impl")
    protected RecieverGroupService recieverGroupService;
    @javax.annotation.Resource(name = "com.sgs.portlet.recievergroup.service.persistence.RecieverGroupPersistence.impl")
    protected RecieverGroupPersistence recieverGroupPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.recievergroup.service.RecieverLocalService.impl")
    protected RecieverLocalService recieverLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.recievergroup.service.RecieverService.impl")
    protected RecieverService recieverService;
    @javax.annotation.Resource(name = "com.sgs.portlet.recievergroup.service.persistence.RecieverPersistence.impl")
    protected RecieverPersistence recieverPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.recievergroup.service.persistence.RecieverFinder.impl")
    protected RecieverFinder recieverFinder;

    public RecieverGroupLocalService getRecieverGroupLocalService() {
        return recieverGroupLocalService;
    }

    public void setRecieverGroupLocalService(
        RecieverGroupLocalService recieverGroupLocalService) {
        this.recieverGroupLocalService = recieverGroupLocalService;
    }

    public RecieverGroupService getRecieverGroupService() {
        return recieverGroupService;
    }

    public void setRecieverGroupService(
        RecieverGroupService recieverGroupService) {
        this.recieverGroupService = recieverGroupService;
    }

    public RecieverGroupPersistence getRecieverGroupPersistence() {
        return recieverGroupPersistence;
    }

    public void setRecieverGroupPersistence(
        RecieverGroupPersistence recieverGroupPersistence) {
        this.recieverGroupPersistence = recieverGroupPersistence;
    }

    public RecieverLocalService getRecieverLocalService() {
        return recieverLocalService;
    }

    public void setRecieverLocalService(
        RecieverLocalService recieverLocalService) {
        this.recieverLocalService = recieverLocalService;
    }

    public RecieverService getRecieverService() {
        return recieverService;
    }

    public void setRecieverService(RecieverService recieverService) {
        this.recieverService = recieverService;
    }

    public RecieverPersistence getRecieverPersistence() {
        return recieverPersistence;
    }

    public void setRecieverPersistence(RecieverPersistence recieverPersistence) {
        this.recieverPersistence = recieverPersistence;
    }

    public RecieverFinder getRecieverFinder() {
        return recieverFinder;
    }

    public void setRecieverFinder(RecieverFinder recieverFinder) {
        this.recieverFinder = recieverFinder;
    }
}
