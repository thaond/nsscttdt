package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalArticleLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalArticleLocalServiceImpl</code>.
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
 * @see com.nss.portlet.journal.service.JournalArticleLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalArticleLocalService {
    public com.nss.portlet.journal.model.JournalArticle addJournalArticle(
        com.nss.portlet.journal.model.JournalArticle journalArticle)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle createJournalArticle(
        long id);

    public void deleteJournalArticle(long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteJournalArticle(
        com.nss.portlet.journal.model.JournalArticle journalArticle)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getJournalArticle(
        long id)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getJournalArticles(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getJournalArticlesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateJournalArticle(
        com.nss.portlet.journal.model.JournalArticle journalArticle)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateJournalArticle(
        com.nss.portlet.journal.model.JournalArticle journalArticle,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle addArticle(
        long userId, long groupId, java.lang.String articleId,
        boolean autoArticleId, double version, java.lang.String title,
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

    public com.nss.portlet.journal.model.JournalArticle addArticle(
        long userId, long groupId, java.lang.String articleId,
        boolean autoArticleId, java.lang.String title,
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

    public com.nss.portlet.journal.model.JournalArticle addArticle(
        java.lang.String uuid, long userId, long groupId,
        java.lang.String articleId, boolean autoArticleId, double version,
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

    public void addArticleResources(
        com.nss.portlet.journal.model.JournalArticle article,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addArticleResources(
        com.nss.portlet.journal.model.JournalArticle article,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addArticleResources(long groupId, java.lang.String articleId,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addArticleResources(long groupId, java.lang.String articleId,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle approveArticle(
        long userId, long groupId, java.lang.String articleId, double version,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle checkArticleResourcePrimKey(
        long groupId, java.lang.String articleId, double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void checkArticles()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void checkNewLine(long groupId, java.lang.String articleId,
        double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void checkStructure(long groupId, java.lang.String articleId,
        double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle copyArticle(
        long userId, long groupId, java.lang.String oldArticleId,
        java.lang.String newArticleId, boolean autoArticleId, double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteArticle(
        com.nss.portlet.journal.model.JournalArticle article,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteArticles(long groupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void expireArticle(
        com.nss.portlet.journal.model.JournalArticle article,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void expireArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getArticle(long id)
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
    public java.lang.String getArticleContent(
        com.nss.portlet.journal.model.JournalArticle article,
        java.lang.String templateId, java.lang.String viewMode,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, double version, java.lang.String viewMode,
        java.lang.String templateId, java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, double version, java.lang.String viewMode,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, java.lang.String viewMode,
        java.lang.String templateId, java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.lang.String getArticleContent(long groupId,
        java.lang.String articleId, java.lang.String viewMode,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleDisplay getArticleDisplay(
        com.nss.portlet.journal.model.JournalArticle article,
        java.lang.String templateId, java.lang.String viewMode,
        java.lang.String languageId, int page, java.lang.String xmlRequest,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleDisplay getArticleDisplay(
        long groupId, java.lang.String articleId, double version,
        java.lang.String templateId, java.lang.String viewMode,
        java.lang.String languageId, int page, java.lang.String xmlRequest,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleDisplay getArticleDisplay(
        long groupId, java.lang.String articleId, double version,
        java.lang.String templateId, java.lang.String viewMode,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleDisplay getArticleDisplay(
        long groupId, java.lang.String articleId, java.lang.String viewMode,
        java.lang.String languageId, int page, java.lang.String xmlRequest,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleDisplay getArticleDisplay(
        long groupId, java.lang.String articleId, java.lang.String templateId,
        java.lang.String viewMode, java.lang.String languageId, int page,
        java.lang.String xmlRequest,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleDisplay getArticleDisplay(
        long groupId, java.lang.String articleId, java.lang.String templateId,
        java.lang.String viewMode, java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleDisplay getArticleDisplay(
        long groupId, java.lang.String articleId, java.lang.String viewMode,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticles()
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticles(
        long groupId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticles(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticles(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticles(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticlesBySmallImageId(
        long smallImageId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getArticlesCount(long groupId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getDisplayArticle(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getLatestArticle(
        long resourcePrimKey)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getLatestArticle(
        long resourcePrimKey, java.lang.Boolean approved)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getLatestArticle(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticle getLatestArticle(
        long groupId, java.lang.String articleId, java.lang.Boolean approved)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public double getLatestVersion(long groupId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public double getLatestVersion(long groupId, java.lang.String articleId,
        java.lang.Boolean approved)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getStructureArticles(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getStructureArticles(
        long groupId, java.lang.String structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getStructureArticlesCount(long groupId,
        java.lang.String structureId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getTemplateArticles(
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getTemplateArticles(
        long groupId, java.lang.String templateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getTemplateArticlesCount(long groupId,
        java.lang.String templateId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean hasArticle(long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean isLatestVersion(long groupId, java.lang.String articleId,
        double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public boolean isLatestVersion(long groupId, java.lang.String articleId,
        double version, java.lang.Boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(com.nss.portlet.journal.model.JournalArticle article)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(long resourcePrimKey)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(java.lang.String[] ids)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle removeArticleLocale(
        long groupId, java.lang.String articleId, double version,
        java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> search(
        long userId, long companyId, long groupId, java.lang.String keywords,
        java.lang.Double version, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> search(
        long userId, long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> search(
        long companyId, long groupId, java.lang.String keywords,
        java.lang.Double version, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> search(
        long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> search(
        long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String[] structureIds,
        java.lang.String[] templateIds, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        long groupId, java.lang.String keywords, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        long groupId, java.lang.String keywords,
        com.liferay.portal.kernel.search.Sort sort, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.kernel.search.Hits search(long companyId,
        long groupId, java.lang.String keywords,
        com.liferay.portal.kernel.search.Sort[] sorts, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long userId, long companyId, long groupId,
        java.lang.String keywords, java.lang.Double version,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long companyId, long groupId,
        java.lang.String keywords, java.lang.Double version,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long companyId, long groupId,
        java.lang.String articleId, java.lang.Double version,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount(long companyId, long groupId,
        java.lang.String articleId, java.lang.Double version,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String[] structureIds, java.lang.String[] templateIds,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int searchCount1(long userId, long companyId, long groupId,
        java.lang.String articleId, java.lang.Double version,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateArticle(
        long userId, long groupId, java.lang.String articleId, double version,
        boolean incrementVersion, java.lang.String content)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle updateArticle(
        long userId, long groupId, java.lang.String articleId, double version,
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

    public void updateTagsAsset(long userId,
        com.nss.portlet.journal.model.JournalArticle article,
        java.lang.String[] tagsCategories, java.lang.String[] tagsEntries)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
