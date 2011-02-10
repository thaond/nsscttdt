package com.ext.portlet.processtype.service.base;

import com.ext.portlet.processtype.service.ProcessTypeLocalService;
import com.ext.portlet.processtype.service.ProcessTypeService;
import com.ext.portlet.processtype.service.persistence.ProcessTypeFinder;
import com.ext.portlet.processtype.service.persistence.ProcessTypePersistence;

import com.liferay.counter.service.CounterLocalService;
import com.liferay.counter.service.CounterService;

import com.liferay.portal.service.base.PrincipalBean;


public abstract class ProcessTypeServiceBaseImpl extends PrincipalBean
    implements ProcessTypeService {
    @javax.annotation.Resource(name = "com.ext.portlet.processtype.service.ProcessTypeLocalService.impl")
    protected ProcessTypeLocalService processTypeLocalService;
    @javax.annotation.Resource(name = "com.ext.portlet.processtype.service.ProcessTypeService.impl")
    protected ProcessTypeService processTypeService;
    @javax.annotation.Resource(name = "com.ext.portlet.processtype.service.persistence.ProcessTypePersistence.impl")
    protected ProcessTypePersistence processTypePersistence;
    @javax.annotation.Resource(name = "com.ext.portlet.processtype.service.persistence.ProcessTypeFinder.impl")
    protected ProcessTypeFinder processTypeFinder;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterLocalService.impl")
    protected CounterLocalService counterLocalService;
    @javax.annotation.Resource(name = "com.liferay.counter.service.CounterService.impl")
    protected CounterService counterService;

    public ProcessTypeLocalService getProcessTypeLocalService() {
        return processTypeLocalService;
    }

    public void setProcessTypeLocalService(
        ProcessTypeLocalService processTypeLocalService) {
        this.processTypeLocalService = processTypeLocalService;
    }

    public ProcessTypeService getProcessTypeService() {
        return processTypeService;
    }

    public void setProcessTypeService(ProcessTypeService processTypeService) {
        this.processTypeService = processTypeService;
    }

    public ProcessTypePersistence getProcessTypePersistence() {
        return processTypePersistence;
    }

    public void setProcessTypePersistence(
        ProcessTypePersistence processTypePersistence) {
        this.processTypePersistence = processTypePersistence;
    }

    public ProcessTypeFinder getProcessTypeFinder() {
        return processTypeFinder;
    }

    public void setProcessTypeFinder(ProcessTypeFinder processTypeFinder) {
        this.processTypeFinder = processTypeFinder;
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
