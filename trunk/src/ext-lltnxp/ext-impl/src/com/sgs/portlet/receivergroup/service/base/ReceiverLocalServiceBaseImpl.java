package com.sgs.portlet.receivergroup.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import com.sgs.portlet.receivergroup.model.Receiver;
import com.sgs.portlet.receivergroup.service.ReceiverGroupLocalService;
import com.sgs.portlet.receivergroup.service.ReceiverGroupService;
import com.sgs.portlet.receivergroup.service.ReceiverLocalService;
import com.sgs.portlet.receivergroup.service.ReceiverService;
import com.sgs.portlet.receivergroup.service.persistence.ReceiverFinder;
import com.sgs.portlet.receivergroup.service.persistence.ReceiverGroupPersistence;
import com.sgs.portlet.receivergroup.service.persistence.ReceiverPersistence;

import java.util.List;


public abstract class ReceiverLocalServiceBaseImpl
    implements ReceiverLocalService {
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

    public Receiver addReceiver(Receiver receiver) throws SystemException {
        receiver.setNew(true);

        return receiverPersistence.update(receiver, false);
    }

    public Receiver createReceiver(long receiverId) {
        return receiverPersistence.create(receiverId);
    }

    public void deleteReceiver(long receiverId)
        throws PortalException, SystemException {
        receiverPersistence.remove(receiverId);
    }

    public void deleteReceiver(Receiver receiver) throws SystemException {
        receiverPersistence.remove(receiver);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return receiverPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return receiverPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Receiver getReceiver(long receiverId)
        throws PortalException, SystemException {
        return receiverPersistence.findByPrimaryKey(receiverId);
    }

    public List<Receiver> getReceivers(int start, int end)
        throws SystemException {
        return receiverPersistence.findAll(start, end);
    }

    public int getReceiversCount() throws SystemException {
        return receiverPersistence.countAll();
    }

    public Receiver updateReceiver(Receiver receiver) throws SystemException {
        receiver.setNew(false);

        return receiverPersistence.update(receiver, true);
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