package com.nss.portlet.journal.service;


/**
 * <a href="JournalArticleResourceLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalArticleResourceLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalArticleResourceLocalService
 *
 */
public class JournalArticleResourceLocalServiceUtil {
    private static JournalArticleResourceLocalService _service;

    public static com.nss.portlet.journal.model.JournalArticleResource addJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException {
        return getService().addJournalArticleResource(journalArticleResource);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource createJournalArticleResource(
        long resourcePrimKey) {
        return getService().createJournalArticleResource(resourcePrimKey);
    }

    public static void deleteJournalArticleResource(long resourcePrimKey)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteJournalArticleResource(resourcePrimKey);
    }

    public static void deleteJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException {
        getService().deleteJournalArticleResource(journalArticleResource);
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

    public static com.nss.portlet.journal.model.JournalArticleResource getJournalArticleResource(
        long resourcePrimKey)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getJournalArticleResource(resourcePrimKey);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> getJournalArticleResources(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getJournalArticleResources(start, end);
    }

    public static int getJournalArticleResourcesCount()
        throws com.liferay.portal.SystemException {
        return getService().getJournalArticleResourcesCount();
    }

    public static com.nss.portlet.journal.model.JournalArticleResource updateJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException {
        return getService().updateJournalArticleResource(journalArticleResource);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource updateJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService()
                   .updateJournalArticleResource(journalArticleResource, merge);
    }

    public static void deleteArticleResource(long groupId,
        java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteArticleResource(groupId, articleId);
    }

    public static com.nss.portlet.journal.model.JournalArticleResource getArticleResource(
        long articleResourcePrimKey)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getArticleResource(articleResourcePrimKey);
    }

    public static long getArticleResourcePrimKey(long groupId,
        java.lang.String articleId) throws com.liferay.portal.SystemException {
        return getService().getArticleResourcePrimKey(groupId, articleId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleResource> getArticleResources(
        long groupId) throws com.liferay.portal.SystemException {
        return getService().getArticleResources(groupId);
    }

    public static JournalArticleResourceLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "JournalArticleResourceLocalService is not set");
        }

        return _service;
    }

    public void setService(JournalArticleResourceLocalService service) {
        _service = service;
    }
}
