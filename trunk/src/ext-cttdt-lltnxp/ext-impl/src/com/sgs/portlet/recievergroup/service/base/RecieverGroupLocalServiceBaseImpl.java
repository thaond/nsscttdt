package com.sgs.portlet.recievergroup.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.recievergroup.model.RecieverGroup;
import com.sgs.portlet.recievergroup.service.RecieverGroupLocalService;
import com.sgs.portlet.recievergroup.service.RecieverGroupService;
import com.sgs.portlet.recievergroup.service.RecieverLocalService;
import com.sgs.portlet.recievergroup.service.RecieverService;
import com.sgs.portlet.recievergroup.service.persistence.RecieverFinder;
import com.sgs.portlet.recievergroup.service.persistence.RecieverGroupPersistence;
import com.sgs.portlet.recievergroup.service.persistence.RecieverPersistence;

import java.util.List;


public abstract class RecieverGroupLocalServiceBaseImpl
    implements RecieverGroupLocalService {
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

    public RecieverGroup addRecieverGroup(RecieverGroup recieverGroup)
        throws SystemException {
        recieverGroup.setNew(true);

        return recieverGroupPersistence.update(recieverGroup, false);
    }

    public RecieverGroup createRecieverGroup(long recieverGroupId) {
        return recieverGroupPersistence.create(recieverGroupId);
    }

    public void deleteRecieverGroup(long recieverGroupId)
        throws PortalException, SystemException {
        recieverGroupPersistence.remove(recieverGroupId);
    }

    public void deleteRecieverGroup(RecieverGroup recieverGroup)
        throws SystemException {
        recieverGroupPersistence.remove(recieverGroup);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return recieverGroupPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return recieverGroupPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public RecieverGroup getRecieverGroup(long recieverGroupId)
        throws PortalException, SystemException {
        return recieverGroupPersistence.findByPrimaryKey(recieverGroupId);
    }

    public List<RecieverGroup> getRecieverGroups(int start, int end)
        throws SystemException {
        return recieverGroupPersistence.findAll(start, end);
    }

    public int getRecieverGroupsCount() throws SystemException {
        return recieverGroupPersistence.countAll();
    }

    public RecieverGroup updateRecieverGroup(RecieverGroup recieverGroup)
        throws SystemException {
        recieverGroup.setNew(false);

        return recieverGroupPersistence.update(recieverGroup, true);
    }

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
