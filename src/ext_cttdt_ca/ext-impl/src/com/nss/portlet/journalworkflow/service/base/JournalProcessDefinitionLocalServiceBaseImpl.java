package com.nss.portlet.journalworkflow.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.journalworkflow.model.JournalProcessDefinition;
import com.nss.portlet.journalworkflow.service.InstanceBeanLocalService;
import com.nss.portlet.journalworkflow.service.InstanceBeanService;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalService;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionService;
import com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence;
import com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence;

import java.util.List;


public abstract class JournalProcessDefinitionLocalServiceBaseImpl
    implements JournalProcessDefinitionLocalService {
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

    public JournalProcessDefinition addJournalProcessDefinition(
        JournalProcessDefinition journalProcessDefinition)
        throws SystemException {
        journalProcessDefinition.setNew(true);

        return journalProcessDefinitionPersistence.update(journalProcessDefinition,
            false);
    }

    public JournalProcessDefinition createJournalProcessDefinition(
        long journalProcessDefinitionId) {
        return journalProcessDefinitionPersistence.create(journalProcessDefinitionId);
    }

    public void deleteJournalProcessDefinition(long journalProcessDefinitionId)
        throws PortalException, SystemException {
        journalProcessDefinitionPersistence.remove(journalProcessDefinitionId);
    }

    public void deleteJournalProcessDefinition(
        JournalProcessDefinition journalProcessDefinition)
        throws SystemException {
        journalProcessDefinitionPersistence.remove(journalProcessDefinition);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return journalProcessDefinitionPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return journalProcessDefinitionPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public JournalProcessDefinition getJournalProcessDefinition(
        long journalProcessDefinitionId)
        throws PortalException, SystemException {
        return journalProcessDefinitionPersistence.findByPrimaryKey(journalProcessDefinitionId);
    }

    public List<JournalProcessDefinition> getJournalProcessDefinitions(
        int start, int end) throws SystemException {
        return journalProcessDefinitionPersistence.findAll(start, end);
    }

    public int getJournalProcessDefinitionsCount() throws SystemException {
        return journalProcessDefinitionPersistence.countAll();
    }

    public JournalProcessDefinition updateJournalProcessDefinition(
        JournalProcessDefinition journalProcessDefinition)
        throws SystemException {
        journalProcessDefinition.setNew(false);

        return journalProcessDefinitionPersistence.update(journalProcessDefinition,
            true);
    }

    public JournalProcessDefinition updateJournalProcessDefinition(
        JournalProcessDefinition journalProcessDefinition, boolean merge)
        throws SystemException {
        journalProcessDefinition.setNew(false);

        return journalProcessDefinitionPersistence.update(journalProcessDefinition,
            merge);
    }

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
