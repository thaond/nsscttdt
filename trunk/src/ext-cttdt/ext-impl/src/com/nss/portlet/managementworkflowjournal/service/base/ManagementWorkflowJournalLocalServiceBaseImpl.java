package com.nss.portlet.managementworkflowjournal.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;
import com.nss.portlet.managementworkflowjournal.service.LogWorkflowJournalArticleLocalService;
import com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalService;
import com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalService;
import com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence;
import com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalFinder;
import com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence;
import com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticleFinder;
import com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence;

import java.util.List;


public abstract class ManagementWorkflowJournalLocalServiceBaseImpl
    implements ManagementWorkflowJournalLocalService {
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalService.impl")
    protected ManagementWorkflowJournalLocalService managementWorkflowJournalLocalService;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence.impl")
    protected ManagementWorkflowJournalPersistence managementWorkflowJournalPersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalFinder.impl")
    protected ManagementWorkflowJournalFinder managementWorkflowJournalFinder;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalService.impl")
    protected WorkflowJournalArticleLocalService workflowJournalArticleLocalService;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence.impl")
    protected WorkflowJournalArticlePersistence workflowJournalArticlePersistence;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticleFinder.impl")
    protected WorkflowJournalArticleFinder workflowJournalArticleFinder;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.LogWorkflowJournalArticleLocalService.impl")
    protected LogWorkflowJournalArticleLocalService logWorkflowJournalArticleLocalService;
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence.impl")
    protected LogWorkflowJournalArticlePersistence logWorkflowJournalArticlePersistence;

    public ManagementWorkflowJournal addManagementWorkflowJournal(
        ManagementWorkflowJournal managementWorkflowJournal)
        throws SystemException {
        managementWorkflowJournal.setNew(true);

        return managementWorkflowJournalPersistence.update(managementWorkflowJournal,
            false);
    }

    public ManagementWorkflowJournal createManagementWorkflowJournal(
        long managementWorkflowJournalId) {
        return managementWorkflowJournalPersistence.create(managementWorkflowJournalId);
    }

    public void deleteManagementWorkflowJournal(
        long managementWorkflowJournalId)
        throws PortalException, SystemException {
        managementWorkflowJournalPersistence.remove(managementWorkflowJournalId);
    }

    public void deleteManagementWorkflowJournal(
        ManagementWorkflowJournal managementWorkflowJournal)
        throws SystemException {
        managementWorkflowJournalPersistence.remove(managementWorkflowJournal);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return managementWorkflowJournalPersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return managementWorkflowJournalPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public ManagementWorkflowJournal getManagementWorkflowJournal(
        long managementWorkflowJournalId)
        throws PortalException, SystemException {
        return managementWorkflowJournalPersistence.findByPrimaryKey(managementWorkflowJournalId);
    }

    public List<ManagementWorkflowJournal> getManagementWorkflowJournals(
        int start, int end) throws SystemException {
        return managementWorkflowJournalPersistence.findAll(start, end);
    }

    public int getManagementWorkflowJournalsCount() throws SystemException {
        return managementWorkflowJournalPersistence.countAll();
    }

    public ManagementWorkflowJournal updateManagementWorkflowJournal(
        ManagementWorkflowJournal managementWorkflowJournal)
        throws SystemException {
        managementWorkflowJournal.setNew(false);

        return managementWorkflowJournalPersistence.update(managementWorkflowJournal,
            true);
    }

    public ManagementWorkflowJournal updateManagementWorkflowJournal(
        ManagementWorkflowJournal managementWorkflowJournal, boolean merge)
        throws SystemException {
        managementWorkflowJournal.setNew(false);

        return managementWorkflowJournalPersistence.update(managementWorkflowJournal,
            merge);
    }

    public ManagementWorkflowJournalLocalService getManagementWorkflowJournalLocalService() {
        return managementWorkflowJournalLocalService;
    }

    public void setManagementWorkflowJournalLocalService(
        ManagementWorkflowJournalLocalService managementWorkflowJournalLocalService) {
        this.managementWorkflowJournalLocalService = managementWorkflowJournalLocalService;
    }

    public ManagementWorkflowJournalPersistence getManagementWorkflowJournalPersistence() {
        return managementWorkflowJournalPersistence;
    }

    public void setManagementWorkflowJournalPersistence(
        ManagementWorkflowJournalPersistence managementWorkflowJournalPersistence) {
        this.managementWorkflowJournalPersistence = managementWorkflowJournalPersistence;
    }

    public ManagementWorkflowJournalFinder getManagementWorkflowJournalFinder() {
        return managementWorkflowJournalFinder;
    }

    public void setManagementWorkflowJournalFinder(
        ManagementWorkflowJournalFinder managementWorkflowJournalFinder) {
        this.managementWorkflowJournalFinder = managementWorkflowJournalFinder;
    }

    public WorkflowJournalArticleLocalService getWorkflowJournalArticleLocalService() {
        return workflowJournalArticleLocalService;
    }

    public void setWorkflowJournalArticleLocalService(
        WorkflowJournalArticleLocalService workflowJournalArticleLocalService) {
        this.workflowJournalArticleLocalService = workflowJournalArticleLocalService;
    }

    public WorkflowJournalArticlePersistence getWorkflowJournalArticlePersistence() {
        return workflowJournalArticlePersistence;
    }

    public void setWorkflowJournalArticlePersistence(
        WorkflowJournalArticlePersistence workflowJournalArticlePersistence) {
        this.workflowJournalArticlePersistence = workflowJournalArticlePersistence;
    }

    public WorkflowJournalArticleFinder getWorkflowJournalArticleFinder() {
        return workflowJournalArticleFinder;
    }

    public void setWorkflowJournalArticleFinder(
        WorkflowJournalArticleFinder workflowJournalArticleFinder) {
        this.workflowJournalArticleFinder = workflowJournalArticleFinder;
    }

    public LogWorkflowJournalArticleLocalService getLogWorkflowJournalArticleLocalService() {
        return logWorkflowJournalArticleLocalService;
    }

    public void setLogWorkflowJournalArticleLocalService(
        LogWorkflowJournalArticleLocalService logWorkflowJournalArticleLocalService) {
        this.logWorkflowJournalArticleLocalService = logWorkflowJournalArticleLocalService;
    }

    public LogWorkflowJournalArticlePersistence getLogWorkflowJournalArticlePersistence() {
        return logWorkflowJournalArticlePersistence;
    }

    public void setLogWorkflowJournalArticlePersistence(
        LogWorkflowJournalArticlePersistence logWorkflowJournalArticlePersistence) {
        this.logWorkflowJournalArticlePersistence = logWorkflowJournalArticlePersistence;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
