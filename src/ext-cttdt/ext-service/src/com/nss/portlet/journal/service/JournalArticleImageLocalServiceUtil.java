package com.nss.portlet.journal.service;


/**
 * <a href="JournalArticleImageLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalArticleImageLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalArticleImageLocalService
 *
 */
public class JournalArticleImageLocalServiceUtil {
    private static JournalArticleImageLocalService _service;

    public static com.nss.portlet.journal.model.JournalArticleImage addJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException {
        return getService().addJournalArticleImage(journalArticleImage);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage createJournalArticleImage(
        long articleImageId) {
        return getService().createJournalArticleImage(articleImageId);
    }

    public static void deleteJournalArticleImage(long articleImageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteJournalArticleImage(articleImageId);
    }

    public static void deleteJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException {
        getService().deleteJournalArticleImage(journalArticleImage);
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

    public static com.nss.portlet.journal.model.JournalArticleImage getJournalArticleImage(
        long articleImageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getJournalArticleImage(articleImageId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> getJournalArticleImages(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getJournalArticleImages(start, end);
    }

    public static int getJournalArticleImagesCount()
        throws com.liferay.portal.SystemException {
        return getService().getJournalArticleImagesCount();
    }

    public static com.nss.portlet.journal.model.JournalArticleImage updateJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException {
        return getService().updateJournalArticleImage(journalArticleImage);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage updateJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage,
        boolean merge) throws com.liferay.portal.SystemException {
        return getService().updateJournalArticleImage(journalArticleImage, merge);
    }

    public static void addArticleImageId(long articleImageId, long groupId,
        java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addArticleImageId(articleImageId, groupId, articleId, version,
            elInstanceId, elName, languageId);
    }

    public static void deleteArticleImage(long articleImageId)
        throws com.liferay.portal.SystemException {
        getService().deleteArticleImage(articleImageId);
    }

    public static void deleteArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage articleImage)
        throws com.liferay.portal.SystemException {
        getService().deleteArticleImage(articleImage);
    }

    public static void deleteArticleImage(long groupId,
        java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException {
        getService()
            .deleteArticleImage(groupId, articleId, version, elInstanceId,
            elName, languageId);
    }

    public static void deleteImages(long groupId, java.lang.String articleId,
        double version) throws com.liferay.portal.SystemException {
        getService().deleteImages(groupId, articleId, version);
    }

    public static com.nss.portlet.journal.model.JournalArticleImage getArticleImage(
        long articleImageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getArticleImage(articleImageId);
    }

    public static long getArticleImageId(long groupId,
        java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException {
        return getService()
                   .getArticleImageId(groupId, articleId, version,
            elInstanceId, elName, languageId);
    }

    public static long getArticleImageId(long groupId,
        java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId, boolean tempImage)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getArticleImageId(groupId, articleId, version,
            elInstanceId, elName, languageId, tempImage);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticleImage> getArticleImages(
        long groupId) throws com.liferay.portal.SystemException {
        return getService().getArticleImages(groupId);
    }

    public static JournalArticleImageLocalService getService() {
        if (_service == null) {
            throw new RuntimeException(
                "JournalArticleImageLocalService is not set");
        }

        return _service;
    }

    public void setService(JournalArticleImageLocalService service) {
        _service = service;
    }
}
