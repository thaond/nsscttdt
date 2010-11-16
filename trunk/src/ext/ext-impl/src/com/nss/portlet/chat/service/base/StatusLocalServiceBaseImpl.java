package com.nss.portlet.chat.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.chat.model.Status;
import com.nss.portlet.chat.service.EntryLocalService;
import com.nss.portlet.chat.service.StatusLocalService;
import com.nss.portlet.chat.service.persistence.EntryFinder;
import com.nss.portlet.chat.service.persistence.EntryPersistence;
import com.nss.portlet.chat.service.persistence.StatusFinder;
import com.nss.portlet.chat.service.persistence.StatusPersistence;

import java.util.List;


public abstract class StatusLocalServiceBaseImpl implements StatusLocalService {
    @BeanReference(name = "com.nss.portlet.chat.service.EntryLocalService.impl")
    protected EntryLocalService entryLocalService;
    @BeanReference(name = "com.nss.portlet.chat.service.persistence.EntryPersistence.impl")
    protected EntryPersistence entryPersistence;
    @BeanReference(name = "com.nss.portlet.chat.service.persistence.EntryFinder.impl")
    protected EntryFinder entryFinder;
    @BeanReference(name = "com.nss.portlet.chat.service.StatusLocalService.impl")
    protected StatusLocalService statusLocalService;
    @BeanReference(name = "com.nss.portlet.chat.service.persistence.StatusPersistence.impl")
    protected StatusPersistence statusPersistence;
    @BeanReference(name = "com.nss.portlet.chat.service.persistence.StatusFinder.impl")
    protected StatusFinder statusFinder;

    public Status addStatus(Status status) throws SystemException {
        status.setNew(true);

        return statusPersistence.update(status, false);
    }

    public Status createStatus(long statusId) {
        return statusPersistence.create(statusId);
    }

    public void deleteStatus(long statusId)
        throws PortalException, SystemException {
        statusPersistence.remove(statusId);
    }

    public void deleteStatus(Status status) throws SystemException {
        statusPersistence.remove(status);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return statusPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return statusPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Status getStatus(long statusId)
        throws PortalException, SystemException {
        return statusPersistence.findByPrimaryKey(statusId);
    }

    public List<Status> getStatuses(int start, int end)
        throws SystemException {
        return statusPersistence.findAll(start, end);
    }

    public int getStatusesCount() throws SystemException {
        return statusPersistence.countAll();
    }

    public Status updateStatus(Status status) throws SystemException {
        status.setNew(false);

        return statusPersistence.update(status, true);
    }

    public Status updateStatus(Status status, boolean merge)
        throws SystemException {
        status.setNew(false);

        return statusPersistence.update(status, merge);
    }

    public EntryLocalService getEntryLocalService() {
        return entryLocalService;
    }

    public void setEntryLocalService(EntryLocalService entryLocalService) {
        this.entryLocalService = entryLocalService;
    }

    public EntryPersistence getEntryPersistence() {
        return entryPersistence;
    }

    public void setEntryPersistence(EntryPersistence entryPersistence) {
        this.entryPersistence = entryPersistence;
    }

    public EntryFinder getEntryFinder() {
        return entryFinder;
    }

    public void setEntryFinder(EntryFinder entryFinder) {
        this.entryFinder = entryFinder;
    }

    public StatusLocalService getStatusLocalService() {
        return statusLocalService;
    }

    public void setStatusLocalService(StatusLocalService statusLocalService) {
        this.statusLocalService = statusLocalService;
    }

    public StatusPersistence getStatusPersistence() {
        return statusPersistence;
    }

    public void setStatusPersistence(StatusPersistence statusPersistence) {
        this.statusPersistence = statusPersistence;
    }

    public StatusFinder getStatusFinder() {
        return statusFinder;
    }

    public void setStatusFinder(StatusFinder statusFinder) {
        this.statusFinder = statusFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
