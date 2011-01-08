package com.ext.portlet.saveprocesstype.service.base;

import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalService;
import com.ext.portlet.saveprocesstype.service.SaveProcessTypeService;
import com.ext.portlet.saveprocesstype.service.persistence.SaveProcessTypePersistence;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;

import java.util.List;


public abstract class SaveProcessTypeLocalServiceBaseImpl
    implements SaveProcessTypeLocalService {
    @javax.annotation.Resource(name = "com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalService.impl")
    protected SaveProcessTypeLocalService saveProcessTypeLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.saveprocesstype.service.SaveProcessTypeService.impl")
    protected SaveProcessTypeService saveProcessTypeService;
    @javax.annotation.Resource(name = "com.ext.portlet.saveprocesstype.service.persistence.SaveProcessTypePersistence.impl")
    protected SaveProcessTypePersistence saveProcessTypePersistence;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;

    public SaveProcessType addSaveProcessType(SaveProcessType saveProcessType)
        throws SystemException {
        saveProcessType.setNew(true);

        return saveProcessTypePersistence.update(saveProcessType, false);
    }

    public SaveProcessType createSaveProcessType(long sptId) {
        return saveProcessTypePersistence.create(sptId);
    }

    public void deleteSaveProcessType(long sptId)
        throws PortalException, SystemException {
        saveProcessTypePersistence.remove(sptId);
    }

    public void deleteSaveProcessType(SaveProcessType saveProcessType)
        throws SystemException {
        saveProcessTypePersistence.remove(saveProcessType);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return saveProcessTypePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return saveProcessTypePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public SaveProcessType getSaveProcessType(long sptId)
        throws PortalException, SystemException {
        return saveProcessTypePersistence.findByPrimaryKey(sptId);
    }

    public List<SaveProcessType> getSaveProcessTypes(int start, int end)
        throws SystemException {
        return saveProcessTypePersistence.findAll(start, end);
    }

    public int getSaveProcessTypesCount() throws SystemException {
        return saveProcessTypePersistence.countAll();
    }

    public SaveProcessType updateSaveProcessType(
        SaveProcessType saveProcessType) throws SystemException {
        saveProcessType.setNew(false);

        return saveProcessTypePersistence.update(saveProcessType, true);
    }

    public SaveProcessTypeLocalService getSaveProcessTypeLocalService() {
        return saveProcessTypeLocalService;
    }

    public void setSaveProcessTypeLocalService(
        SaveProcessTypeLocalService saveProcessTypeLocalService) {
        this.saveProcessTypeLocalService = saveProcessTypeLocalService;
    }

    public SaveProcessTypeService getSaveProcessTypeService() {
        return saveProcessTypeService;
    }

    public void setSaveProcessTypeService(
        SaveProcessTypeService saveProcessTypeService) {
        this.saveProcessTypeService = saveProcessTypeService;
    }

    public SaveProcessTypePersistence getSaveProcessTypePersistence() {
        return saveProcessTypePersistence;
    }

    public void setSaveProcessTypePersistence(
        SaveProcessTypePersistence saveProcessTypePersistence) {
        this.saveProcessTypePersistence = saveProcessTypePersistence;
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
}
