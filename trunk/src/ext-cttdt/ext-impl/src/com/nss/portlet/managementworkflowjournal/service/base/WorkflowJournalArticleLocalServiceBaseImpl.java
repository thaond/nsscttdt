package com.nss.portlet.managementworkflowjournal.service.base;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.BeanReference;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.util.PortalUtil;

import com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle;
import com.nss.portlet.managementworkflowjournal.service.LogWorkflowJournalArticleLocalService;
import com.nss.portlet.managementworkflowjournal.service.ManagementWorkflowJournalLocalService;
import com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalService;
import com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticleFinder;
import com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticlePersistence;
import com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalFinder;
import com.nss.portlet.managementworkflowjournal.service.persistence.ManagementWorkflowJournalPersistence;
import com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticleFinder;
import com.nss.portlet.managementworkflowjournal.service.persistence.WorkflowJournalArticlePersistence;

import java.util.List;


public abstract class WorkflowJournalArticleLocalServiceBaseImpl
    implements WorkflowJournalArticleLocalService {
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
    @BeanReference(name = "com.nss.portlet.managementworkflowjournal.service.persistence.LogWorkflowJournalArticleFinder.impl")
    protected LogWorkflowJournalArticleFinder logWorkflowJournalArticleFinder;

    public WorkflowJournalArticle addWorkflowJournalArticle(
        WorkflowJournalArticle workflowJournalArticle)
        throws SystemException {
        workflowJournalArticle.setNew(true);

        return workflowJournalArticlePersistence.update(workflowJournalArticle,
            false);
    }

    public WorkflowJournalArticle createWorkflowJournalArticle(
        long workflowJournalArticleId) {
        return workflowJournalArticlePersistence.create(workflowJournalArticleId);
    }

    public void deleteWorkflowJournalArticle(long workflowJournalArticleId)
        throws PortalException, SystemException {
        workflowJournalArticlePersistence.remove(workflowJournalArticleId);
    }

    public void deleteWorkflowJournalArticle(
        WorkflowJournalArticle workflowJournalArticle)
        throws SystemException {
        workflowJournalArticlePersistence.remove(workflowJournalArticle);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return workflowJournalArticlePersistence.findWithDynamicQuery(dynamicQuery);
    }

    public List<Object> dynamicQuery(DynamicQuery dynamicQuery, int start,
        int end) throws SystemException {
        return workflowJournalArticlePersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    public WorkflowJournalArticle getWorkflowJournalArticle(
        long workflowJournalArticleId) throws PortalException, SystemException {
        return workflowJournalArticlePersistence.findByPrimaryKey(workflowJournalArticleId);
    }

    public List<WorkflowJournalArticle> getWorkflowJournalArticles(int start,
        int end) throws SystemException {
        return workflowJournalArticlePersistence.findAll(start, end);
    }

    public int getWorkflowJournalArticlesCount() throws SystemException {
        return workflowJournalArticlePersistence.countAll();
    }

    public WorkflowJournalArticle updateWorkflowJournalArticle(
        WorkflowJournalArticle workflowJournalArticle)
        throws SystemException {
        workflowJournalArticle.setNew(false);

        return workflowJournalArticlePersistence.update(workflowJournalArticle,
            true);
    }

    public WorkflowJournalArticle updateWorkflowJournalArticle(
        WorkflowJournalArticle workflowJournalArticle, boolean merge)
        throws SystemException {
        workflowJournalArticle.setNew(false);

        return workflowJournalArticlePersistence.update(workflowJournalArticle,
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

    public LogWorkflowJournalArticleFinder getLogWorkflowJournalArticleFinder() {
        return logWorkflowJournalArticleFinder;
    }

    public void setLogWorkflowJournalArticleFinder(
        LogWorkflowJournalArticleFinder logWorkflowJournalArticleFinder) {
        this.logWorkflowJournalArticleFinder = logWorkflowJournalArticleFinder;
    }

    protected void runSQL(String sql) throws SystemException {
        try {
            PortalUtil.runSQL(sql);
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
