package com.nss.portlet.journalworkflow.service.base;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.service.base.PrincipalBean;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.journalworkflow.service.InstanceBeanLocalService;
import com.nss.portlet.journalworkflow.service.InstanceBeanService;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalService;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionService;
import com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence;
import com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence;


public abstract class InstanceBeanServiceBaseImpl extends PrincipalBean
    implements InstanceBeanService {
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalService.impl")
    protected JournalProcessDefinitionLocalService journalProcessDefinitionLocalService;
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.JournalProcessDefinitionService.impl")
    protected JournalProcessDefinitionService journalProcessDefinitionService;
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence.impl")
    protected JournalProcessDefinitionPersistence journalProcessDefinitionPersistence;
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.InstanceBeanLocalService.impl")
    protected InstanceBeanLocalService instanceBeanLocalService;
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.InstanceBeanService.impl")
    protected InstanceBeanService instanceBeanService;
    @BeanReference(name = "com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence.impl")
    protected InstanceBeanPersistence instanceBeanPersistence;

    public JournalProcessDefinitionLocalService getJournalProcessDefinitionLocalService() {
        return journalProcessDefinitionLocalService;
    }

    public void setJournalProcessDefinitionLocalService(
        JournalProcessDefinitionLocalService journalProcessDefinitionLocalService) {
        this.journalProcessDefinitionLocalService = journalProcessDefinitionLocalService;
    }

    public JournalProcessDefinitionService getJournalProcessDefinitionService() {
        return journalProcessDefinitionService;
    }

    public void setJournalProcessDefinitionService(
        JournalProcessDefinitionService journalProcessDefinitionService) {
        this.journalProcessDefinitionService = journalProcessDefinitionService;
    }

    public JournalProcessDefinitionPersistence getJournalProcessDefinitionPersistence() {
        return journalProcessDefinitionPersistence;
    }

    public void setJournalProcessDefinitionPersistence(
        JournalProcessDefinitionPersistence journalProcessDefinitionPersistence) {
        this.journalProcessDefinitionPersistence = journalProcessDefinitionPersistence;
    }

    public InstanceBeanLocalService getInstanceBeanLocalService() {
        return instanceBeanLocalService;
    }

    public void setInstanceBeanLocalService(
        InstanceBeanLocalService instanceBeanLocalService) {
        this.instanceBeanLocalService = instanceBeanLocalService;
    }

    public InstanceBeanService getInstanceBeanService() {
        return instanceBeanService;
    }

    public void setInstanceBeanService(InstanceBeanService instanceBeanService) {
        this.instanceBeanService = instanceBeanService;
    }

    public InstanceBeanPersistence getInstanceBeanPersistence() {
        return instanceBeanPersistence;
    }

    public void setInstanceBeanPersistence(
        InstanceBeanPersistence instanceBeanPersistence) {
        this.instanceBeanPersistence = instanceBeanPersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
