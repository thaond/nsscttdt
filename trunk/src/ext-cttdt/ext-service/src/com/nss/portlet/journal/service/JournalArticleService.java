package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalArticleService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalArticleServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalArticleServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalArticleService {
    public com.nss.portlet.journal.model.JournalArticle addArticle(
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
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle addArticle(
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
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle approveArticle(
        long groupId, java.lang.String articleId, double version,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle copyArticle(
        long groupId, java.lang.String oldArticleId,
        java.lang.String newArticleId, boolean autoArticleId, double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getArticle(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getArticle(
        long groupId, java.lang.String articleId, double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getArticleByUrlTitle(
        long groupId, java.lang.String urlTitle)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, double version,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void expireArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void removeArticleLocale(long companyId, java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle removeArticleLocale(
        long groupId, java.lang.String articleId, double version,
        java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateArticle(
        long groupId, java.lang.String articleId, double version,
        boolean incrementVersion, java.lang.String content)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateArticle(
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
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateContent(
        long groupId, java.lang.String articleId, double version,
        java.lang.String content)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
