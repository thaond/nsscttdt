package com.sgs.portlet.receivergroup.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.receivergroup.model.ReceiverGroup;
import com.sgs.portlet.receivergroup.service.ReceiverGroupLocalService;
import com.sgs.portlet.receivergroup.service.ReceiverGroupService;
import com.sgs.portlet.receivergroup.service.ReceiverLocalService;
import com.sgs.portlet.receivergroup.service.ReceiverService;
import com.sgs.portlet.receivergroup.service.persistence.ReceiverFinder;
import com.sgs.portlet.receivergroup.service.persistence.ReceiverGroupPersistence;
import com.sgs.portlet.receivergroup.service.persistence.ReceiverPersistence;

import java.util.List;


public abstract class ReceiverGroupLocalServiceBaseImpl
    implements ReceiverGroupLocalService {
    @javax.annotation.Resource(name = "com.sgs.portlet.receivergroup.service.ReceiverGroupLocalService.impl")
    protected ReceiverGroupLocalService receiverGroupLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.receivergroup.service.ReceiverGroupService.impl")
    protected ReceiverGroupService receiverGroupService;
    @javax.annotation.Resource(name = "com.sgs.portlet.receivergroup.service.persistence.ReceiverGroupPersistence.impl")
    protected ReceiverGroupPersistence receiverGroupPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.receivergroup.service.ReceiverLocalService.impl")
    protected ReceiverLocalService receiverLocalService;
    @javax.annotation.Resource(name = "com.sgs.portlet.receivergroup.service.ReceiverService.impl")
    protected ReceiverService receiverService;
    @javax.annotation.Resource(name = "com.sgs.portlet.receivergroup.service.persistence.ReceiverPersistence.impl")
    protected ReceiverPersistence receiverPersistence;
    @javax.annotation.Resource(name = "com.sgs.portlet.receivergroup.service.persistence.ReceiverFinder.impl")
    protected ReceiverFinder receiverFinder;

    public ReceiverGroup addReceiverGroup(ReceiverGroup receiverGroup)
        throws SystemException {
        receiverGroup.setNew(true);

        return receiverGroupPersistence.update(receiverGroup, false);
    }

    public ReceiverGroup createReceiverGroup(long receiverGroupId) {
        return receiverGroupPersistence.create(receiverGroupId);
    }

    public void deleteReceiverGroup(long receiverGroupId)
        throws PortalException, SystemException {
        receiverGroupPersistence.remove(receiverGroupId);
    }

    public void deleteReceiverGroup(ReceiverGroup receiverGroup)
        throws SystemException {
        receiverGroupPersistence.remove(receiverGroup);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return receiverGroupPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return receiverGroupPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public ReceiverGroup getReceiverGroup(long receiverGroupId)
        throws PortalException, SystemException {
        return receiverGroupPersistence.findByPrimaryKey(receiverGroupId);
    }

    public List<ReceiverGroup> getReceiverGroups(int start, int end)
        throws SystemException {
        return receiverGroupPersistence.findAll(start, end);
    }

    public int getReceiverGroupsCount() throws SystemException {
        return receiverGroupPersistence.countAll();
    }

    public ReceiverGroup updateReceiverGroup(ReceiverGroup receiverGroup)
        throws SystemException {
        receiverGroup.setNew(false);

        return receiverGroupPersistence.update(receiverGroup, true);
    }

    public ReceiverGroupLocalService getReceiverGroupLocalService() {
        return receiverGroupLocalService;
    }

    public void setReceiverGroupLocalService(
        ReceiverGroupLocalService receiverGroupLocalService) {
        this.receiverGroupLocalService = receiverGroupLocalService;
    }

    public ReceiverGroupService getReceiverGroupService() {
        return receiverGroupService;
    }

    public void setReceiverGroupService(
        ReceiverGroupService receiverGroupService) {
        this.receiverGroupService = receiverGroupService;
    }

    public ReceiverGroupPersistence getReceiverGroupPersistence() {
        return receiverGroupPersistence;
    }

    public void setReceiverGroupPersistence(
        ReceiverGroupPersistence receiverGroupPersistence) {
        this.receiverGroupPersistence = receiverGroupPersistence;
    }

    public ReceiverLocalService getReceiverLocalService() {
        return receiverLocalService;
    }

    public void setReceiverLocalService(
        ReceiverLocalService receiverLocalService) {
        this.receiverLocalService = receiverLocalService;
    }

    public ReceiverService getReceiverService() {
        return receiverService;
    }

    public void setReceiverService(ReceiverService receiverService) {
        this.receiverService = receiverService;
    }

    public ReceiverPersistence getReceiverPersistence() {
        return receiverPersistence;
    }

    public void setReceiverPersistence(ReceiverPersistence receiverPersistence) {
        this.receiverPersistence = receiverPersistence;
    }

    public ReceiverFinder getReceiverFinder() {
        return receiverFinder;
    }

    public void setReceiverFinder(ReceiverFinder receiverFinder) {
        this.receiverFinder = receiverFinder;
    }
}
