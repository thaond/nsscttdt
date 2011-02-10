package com.ext.portlet.saveprocesstype.service.base;

import com.ext.portlet.saveprocesstype.service.SaveProcessTypeLocalService;
import com.ext.portlet.saveprocesstype.service.SaveProcessTypeService;
import com.ext.portlet.saveprocesstype.service.persistence.SaveProcessTypePersistence;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.service.base.PrincipalBean;


public abstract class SaveProcessTypeServiceBaseImpl extends PrincipalBean
    implements SaveProcessTypeService {
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
