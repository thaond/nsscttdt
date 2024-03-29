package com.nss.portlet.journal.service;


/**
 * <a href="JournalArticleServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalArticleService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalArticleService
 *
 */
public class JournalArticleServiceUtil {
    private static JournalArticleService _service;

    public static com.nss.portlet.journal.model.JournalArticle addArticle(
        long groupId, java.lang.String articleId, boolean autoArticleId,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        int displayDateMonth, int displayDateDay, int displayDateYear,
        int displayDateHour, int displayDateMinute, int expirationDateMonth,
        int expirationDateDay, int expirationDateYear, int expirationDateHour,
        int expirationDateMinute, boolean neverExpire, int reviewDateMonth,
        int reviewDateDay, int reviewDateYear, int reviewDateHour,
        int reviewDateMinute, boolean neverReview, boolean indexable,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addArticle(groupId, articleId, autoArticleId, title,
            description, content, type, structureId, templateId,
            displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
            displayDateMinute, expirationDateMonth, expirationDateDay,
            expirationDateYear, expirationDateHour, expirationDateMinute,
            neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear,
            reviewDateHour, reviewDateMinute, neverReview, indexable,
            articleURL, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalArticle addArticle(
        long groupId, java.lang.String articleId, boolean autoArticleId,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        int displayDateMonth, int displayDateDay, int displayDateYear,
        int displayDateHour, int displayDateMinute, int expirationDateMonth,
        int expirationDateDay, int expirationDateYear, int expirationDateHour,
        int expirationDateMinute, boolean neverExpire, int reviewDateMonth,
        int reviewDateDay, int reviewDateYear, int reviewDateHour,
        int reviewDateMinute, boolean neverReview, boolean indexable,
        boolean smallImage, java.lang.String smallImageURL,
        java.io.File smallFile, java.util.Map<String, byte[]> images,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addArticle(groupId, articleId, autoArticleId, title,
            description, content, type, structureId, templateId,
            displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
            displayDateMinute, expirationDateMonth, expirationDateDay,
            expirationDateYear, expirationDateHour, expirationDateMinute,
            neverExpire, reviewDateMonth, reviewDateDay, reviewDateYear,
            reviewDateHour, reviewDateMinute, neverReview, indexable,
            smallImage, smallImageURL, smallFile, images, articleURL,
            serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalArticle approveArticle(
        long groupId, java.lang.String articleId, double version,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .approveArticle(groupId, articleId, version, articleURL,
            serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalArticle copyArticle(
        long groupId, java.lang.String oldArticleId,
        java.lang.String newArticleId, boolean autoArticleId, double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .copyArticle(groupId, oldArticleId, newArticleId,
            autoArticleId, version);
    }

    public static com.nss.portlet.journal.model.JournalArticle getArticle(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getArticle(groupId, articleId);
    }

    public static com.nss.portlet.journal.model.JournalArticle getArticle(
        long groupId, java.lang.String articleId, double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getArticle(groupId, articleId, version);
    }

    public static com.nss.portlet.journal.model.JournalArticle getArticleByUrlTitle(
        long groupId, java.lang.String urlTitle)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getArticleByUrlTitle(groupId, urlTitle);
    }

    public static java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getArticleContent(groupId, articleId, languageId,
            themeDisplay);
    }

    public static java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, double version,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getArticleContent(groupId, articleId, version, languageId,
            themeDisplay);
    }

    public static void deleteArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .deleteArticle(groupId, articleId, version, articleURL,
            serviceContext);
    }

    public static void expireArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .expireArticle(groupId, articleId, version, articleURL,
            serviceContext);
    }

    public static void removeArticleLocale(long companyId,
        java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().removeArticleLocale(companyId, languageId);
    }

    public static com.nss.portlet.journal.model.JournalArticle removeArticleLocale(
        long groupId, java.lang.String articleId, double version,
        java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .removeArticleLocale(groupId, articleId, version, languageId);
    }

    public static com.nss.portlet.journal.model.JournalArticle updateArticle(
        long groupId, java.lang.String articleId, double version,
        boolean incrementVersion, java.lang.String content)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateArticle(groupId, articleId, version,
            incrementVersion, content);
    }

    public static com.nss.portlet.journal.model.JournalArticle updateArticle(
        long groupId, java.lang.String articleId, double version,
        boolean incrementVersion, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, int displayDateMonth, int displayDateDay,
        int displayDateYear, int displayDateHour, int displayDateMinute,
        int expirationDateMonth, int expirationDateDay, int expirationDateYear,
        int expirationDateHour, int expirationDateMinute, boolean neverExpire,
        int reviewDateMonth, int reviewDateDay, int reviewDateYear,
        int reviewDateHour, int reviewDateMinute, boolean neverReview,
        boolean indexable, boolean smallImage, java.lang.String smallImageURL,
        java.io.File smallFile, java.util.Map<String, byte[]> images,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateArticle(groupId, articleId, version,
            incrementVersion, title, description, content, type, structureId,
            templateId, displayDateMonth, displayDateDay, displayDateYear,
            displayDateHour, displayDateMinute, expirationDateMonth,
            expirationDateDay, expirationDateYear, expirationDateHour,
            expirationDateMinute, neverExpire, reviewDateMonth, reviewDateDay,
            reviewDateYear, reviewDateHour, reviewDateMinute, neverReview,
            indexable, smallImage, smallImageURL, smallFile, images,
            articleURL, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalArticle updateContent(
        long groupId, java.lang.String articleId, double version,
        java.lang.String content)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updateContent(groupId, articleId, version, content);
    }

    public static JournalArticleService getService() {
        if (_service == null) {
            throw new RuntimeException("JournalArticleService is not set");
        }

        return _service;
    }

    public void setService(JournalArticleService service) {
        _service = service;
    }
}
