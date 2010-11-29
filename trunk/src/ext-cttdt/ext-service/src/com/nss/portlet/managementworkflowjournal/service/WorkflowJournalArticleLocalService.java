package com.nss.portlet.managementworkflowjournal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="WorkflowJournalArticleLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.managementworkflowjournal.service.impl.WorkflowJournalArticleLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface WorkflowJournalArticleLocalService {
    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle addWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle createWorkflowJournalArticle(
        long workflowJournalArticleId);

    public void deleteWorkflowJournalArticle(long workflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticle(
        long workflowJournalArticleId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getWorkflowJournalArticles(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getWorkflowJournalArticlesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle updateWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle updateWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticleFromPI(
        long processInstanceId);
    
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticleByProcessDefinition(
        long processDefinitionId, int start, int end)
        throws com.liferay.portal.SystemException;
}
