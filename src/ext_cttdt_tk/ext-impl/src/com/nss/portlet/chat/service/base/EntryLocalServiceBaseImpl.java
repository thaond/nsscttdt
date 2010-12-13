package com.nss.portlet.chat.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.chat.model.Entry;
import com.nss.portlet.chat.service.EntryLocalService;
import com.nss.portlet.chat.service.StatusLocalService;
import com.nss.portlet.chat.service.persistence.EntryFinder;
import com.nss.portlet.chat.service.persistence.EntryPersistence;
import com.nss.portlet.chat.service.persistence.StatusFinder;
import com.nss.portlet.chat.service.persistence.StatusPersistence;

import java.util.List;


public abstract class EntryLocalServiceBaseImpl implements EntryLocalService {
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

    public Entry addEntry(Entry entry) throws SystemException {
        entry.setNew(true);

        return entryPersistence.update(entry, false);
    }

    public Entry createEntry(long entryId) {
        return entryPersistence.create(entryId);
    }

    public void deleteEntry(long entryId)
        throws PortalException, SystemException {
        entryPersistence.remove(entryId);
    }

    public void deleteEntry(Entry entry) throws SystemException {
        entryPersistence.remove(entry);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return entryPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return entryPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    public Entry getEntry(long entryId) throws PortalException, SystemException {
        return entryPersistence.findByPrimaryKey(entryId);
    }

    public List<Entry> getEntries(int start, int end) throws SystemException {
        return entryPersistence.findAll(start, end);
    }

    public int getEntriesCount() throws SystemException {
        return entryPersistence.countAll();
    }

    public Entry updateEntry(Entry entry) throws SystemException {
        entry.setNew(false);

        return entryPersistence.update(entry, true);
    }

    public Entry updateEntry(Entry entry, boolean merge)
        throws SystemException {
        entry.setNew(false);

        return entryPersistence.update(entry, merge);
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
