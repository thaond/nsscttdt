package com.nss.portlet.journalworkflow.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.journalworkflow.model.InstanceBean;
import com.nss.portlet.journalworkflow.service.InstanceBeanLocalService;
import com.nss.portlet.journalworkflow.service.InstanceBeanService;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalService;
import com.nss.portlet.journalworkflow.service.JournalProcessDefinitionService;
import com.nss.portlet.journalworkflow.service.persistence.InstanceBeanPersistence;
import com.nss.portlet.journalworkflow.service.persistence.JournalProcessDefinitionPersistence;

import java.util.List;


public abstract class InstanceBeanLocalServiceBaseImpl
    implements InstanceBeanLocalService {
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

    public InstanceBean addInstanceBean(InstanceBean instanceBean)
        throws SystemException {
        instanceBean.setNew(true);

        return instanceBeanPersistence.update(instanceBean, false);
    }

    public InstanceBean createInstanceBean(long processInstanceId) {
        return instanceBeanPersistence.create(processInstanceId);
    }

    public void deleteInstanceBean(long processInstanceId)
        throws PortalException, SystemException {
        instanceBeanPersistence.remove(processInstanceId);
    }

    public void deleteInstanceBean(InstanceBean instanceBean)
        throws SystemException {
        instanceBeanPersistence.remove(instanceBean);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return instanceBeanPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return instanceBeanPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public InstanceBean getInstanceBean(long processInstanceId)
        throws PortalException, SystemException {
        return instanceBeanPersistence.findByPrimaryKey(processInstanceId);
    }

    public List<InstanceBean> getInstanceBeans(int start, int end)
        throws SystemException {
        return instanceBeanPersistence.findAll(start, end);
    }

    public int getInstanceBeansCount() throws SystemException {
        return instanceBeanPersistence.countAll();
    }

    public InstanceBean updateInstanceBean(InstanceBean instanceBean)
        throws SystemException {
        instanceBean.setNew(false);

        return instanceBeanPersistence.update(instanceBean, true);
    }

    public InstanceBean updateInstanceBean(InstanceBean instanceBean,
        boolean merge) throws SystemException {
        instanceBean.setNew(false);

        return instanceBeanPersistence.update(instanceBean, merge);
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
