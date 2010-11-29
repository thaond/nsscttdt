package com.nss.portlet.managementworkflowjournal.service;


/**
 * <a href="WorkflowJournalArticleLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.service.WorkflowJournalArticleLocalService
 *
 */
public class WorkflowJournalArticleLocalServiceUtil {
    private static WorkflowJournalArticleLocalService _service;

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle addWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getService().addWorkflowJournalArticle(workflowJournalArticle);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle createWorkflowJournalArticle(
        long workflowJournalArticleId) {
        return getService()
                   .createWorkflowJournalArticle(workflowJournalArticleId);
    }

    public static void deleteWorkflowJournalArticle(
        long workflowJournalArticleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteWorkflowJournalArticle(workflowJournalArticleId);
    }

    public static void deleteWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException {
        getService().deleteWorkflowJournalArticle(workflowJournalArticle);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticle(
        long workflowJournalArticleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getWorkflowJournalArticle(workflowJournalArticleId);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getWorkflowJournalArticles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getWorkflowJournalArticles(start, end);
    }

    public static int getWorkflowJournalArticlesCount()
        throws com.liferay.portal.SystemException {
        return getService().getWorkflowJournalArticlesCount();
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle updateWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getService().updateWorkflowJournalArticle(workflowJournalArticle);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle updateWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle workflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updateWorkflowJournalArticle(workflowJournalArticle, merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticleFromPI(
        long processInstanceId) {
        return getService().getWorkflowJournalArticleFromPI(processInstanceId);
    }
    
    public static com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle getWorkflowJournalArticleByProcessDefinition(
            long processDefinitionId, int start, int end)
            throws com.liferay.portal.SystemException {
            return getService()
                       .getWorkflowJournalArticleByProcessDefinition(processDefinitionId,
                start, end);
        }
    
    public static WorkflowJournalArticleLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "WorkflowJournalArticleLocalService is not set");
        }

        return _service;
    }

    public void setService(WorkflowJournalArticleLocalService service) {
        _service = service;
    }
}
