package com.nss.portlet.managementworkflowjournal.service;


/**
 * <a href="LogWorkflowJournalArticleLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.managementworkflowjournal.service.LogWorkflowJournalArticleLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.managementworkflowjournal.service.LogWorkflowJournalArticleLocalService
 *
 */
public class LogWorkflowJournalArticleLocalServiceUtil {
    private static LogWorkflowJournalArticleLocalService _service;

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle addLogWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getService()
                   .addLogWorkflowJournalArticle(logWorkflowJournalArticle);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle createLogWorkflowJournalArticle(
        long logWorkflowJournalArticleId) {
        return getService()
                   .createLogWorkflowJournalArticle(logWorkflowJournalArticleId);
    }

    public static void deleteLogWorkflowJournalArticle(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteLogWorkflowJournalArticle(logWorkflowJournalArticleId);
    }

    public static void deleteLogWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws com.liferay.portal.SystemException {
        getService().deleteLogWorkflowJournalArticle(logWorkflowJournalArticle);
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

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle getLogWorkflowJournalArticle(
        long logWorkflowJournalArticleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getLogWorkflowJournalArticle(logWorkflowJournalArticleId);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle> getLogWorkflowJournalArticles(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getLogWorkflowJournalArticles(start, end);
    }

    public static int getLogWorkflowJournalArticlesCount()
        throws com.liferay.portal.SystemException {
        return getService().getLogWorkflowJournalArticlesCount();
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle updateLogWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle)
        throws com.liferay.portal.SystemException {
        return getService()
                   .updateLogWorkflowJournalArticle(logWorkflowJournalArticle);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle updateLogWorkflowJournalArticle(
        com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle logWorkflowJournalArticle,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updateLogWorkflowJournalArticle(logWorkflowJournalArticle,
            merge);
    }

    public static int countLogWorkflowJournalArticle(long resourcePrimkey) {
        return getService().countLogWorkflowJournalArticle(resourcePrimkey);
    }

    public static com.nss.portlet.managementworkflowjournal.model.LogWorkflowJournalArticle getLogByResourceTrainsition(
        long resourcePrimkey) throws com.liferay.portal.SystemException {
        return getService().getLogByResourceTrainsition(resourcePrimkey);
    }

    public static LogWorkflowJournalArticleLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "LogWorkflowJournalArticleLocalService is not set");
        }

        return _service;
    }

    public void setService(LogWorkflowJournalArticleLocalService service) {
        _service = service;
    }
}
