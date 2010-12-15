package com.nss.portlet.journal.service.persistence;

public class JournalArticleFinderUtil {
    private static JournalArticleFinder _finder;

    public static int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(long companyId,
        long groupId, java.lang.String articleId, java.lang.Double version,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(companyId, groupId,
            articleId, version, title, description, content, type, structureId,
            templateId, displayDateGT, displayDateLT, approved, expired,
            reviewDate, andOperator);
    }

    public static int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(long companyId,
        long groupId, java.lang.String articleId, java.lang.Double version,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String[] structureIds, java.lang.String[] templateIds,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(companyId, groupId,
            articleId, version, title, description, content, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator);
    }

    public static int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(long companyId,
        long groupId, java.lang.String[] articleIds, java.lang.Double version,
        java.lang.String[] titles, java.lang.String[] descriptions,
        java.lang.String[] contents, java.lang.String type,
        java.lang.String[] structureIds, java.lang.String[] templateIds,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(companyId, groupId,
            articleIds, version, titles, descriptions, contents, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator);
    }

    public static int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R1(long userId,
        long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureIds,
        java.lang.String templateIds, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_A_V_T_D_C_T_S_T_D_A_E_R1(userId, companyId,
            groupId, articleId, version, title, description, content, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator);
    }

    public static int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R1(long userId,
        long companyId, long groupId, java.lang.String[] articleIds,
        java.lang.Double version, java.lang.String[] titles,
        java.lang.String[] descriptions, java.lang.String[] contents,
        java.lang.String type, java.lang.String[] structureIds,
        java.lang.String[] templateIds, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByC_G_A_V_T_D_C_T_S_T_D_A_E_R1(userId, companyId,
            groupId, articleIds, version, titles, descriptions, contents, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator);
    }

    public static int countByKeywords(long userId, long companyId,
        long groupId, java.lang.String keywords, java.lang.Double version,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByKeywords(userId, companyId, groupId, keywords,
            version, type, structureId, templateId, displayDateGT,
            displayDateLT, approved, expired, reviewDate);
    }

    public static int countByKeywords(long companyId, long groupId,
        java.lang.String keywords, java.lang.Double version,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByKeywords(companyId, groupId, keywords, version,
            type, structureId, templateId, displayDateGT, displayDateLT,
            approved, expired, reviewDate);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(
        long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(companyId, groupId,
            articleId, version, title, description, content, type, structureId,
            templateId, displayDateGT, displayDateLT, approved, expired,
            reviewDate, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(
        long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String[] structureIds,
        java.lang.String[] templateIds, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(companyId, groupId,
            articleId, version, title, description, content, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(
        long companyId, long groupId, java.lang.String[] articleIds,
        java.lang.Double version, java.lang.String[] titles,
        java.lang.String[] descriptions, java.lang.String[] contents,
        java.lang.String type, java.lang.String[] structureIds,
        java.lang.String[] templateIds, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(companyId, groupId,
            articleIds, version, titles, descriptions, contents, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByExpirationDate(
        java.lang.Boolean expired, java.util.Date expirationDateLT,
        java.util.Date expirationDateGT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByExpirationDate(expired, expirationDateLT,
            expirationDateGT);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByKeywords(
        long userId, long companyId, long groupId, java.lang.String keywords,
        java.lang.Double version, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByKeywords(userId, companyId, groupId, keywords,
            version, type, structureId, templateId, displayDateGT,
            displayDateLT, approved, expired, reviewDate, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByKeywords(
        long companyId, long groupId, java.lang.String keywords,
        java.lang.Double version, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByKeywords(companyId, groupId, keywords, version, type,
            structureId, templateId, displayDateGT, displayDateLT, approved,
            expired, reviewDate, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalArticle findByR_D(
        long resourcePrimKey, java.util.Date displayDate)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException {
        return getFinder().findByR_D(resourcePrimKey, displayDate);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByReviewDate(
        java.util.Date reviewDateLT, java.util.Date reviewDateGT)
        throws com.liferay.portal.SystemException {
        return getFinder().findByReviewDate(reviewDateLT, reviewDateGT);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByU_C_G_A_V_T_D_C_T_S_T_D_A_E_R(
        long userId, long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByU_C_G_A_V_T_D_C_T_S_T_D_A_E_R(userId, companyId,
            groupId, articleId, version, title, description, content, type,
            structureId, templateId, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByU_C_G_A_V_T_D_C_T_S_T_D_A_E_R(
        long userId, long companyId, long groupId, java.lang.String articleId,
        java.lang.Double version, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String[] structureIds,
        java.lang.String[] templateIds, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByU_C_G_A_V_T_D_C_T_S_T_D_A_E_R(userId, companyId,
            groupId, articleId, version, title, description, content, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> findByU_C_G_A_V_T_D_C_T_S_T_D_A_E_R(
        long userId, long companyId, long groupId,
        java.lang.String[] articleIds, java.lang.Double version,
        java.lang.String[] titles, java.lang.String[] descriptions,
        java.lang.String[] contents, java.lang.String type,
        java.lang.String[] structureIds, java.lang.String[] templateIds,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByU_C_G_A_V_T_D_C_T_S_T_D_A_E_R(userId, companyId,
            groupId, articleIds, version, titles, descriptions, contents, type,
            structureIds, templateIds, displayDateGT, displayDateLT, approved,
            expired, reviewDate, andOperator, start, end, obc);
    }

    public static JournalArticleFinder getFinder() {
        return _finder;
    }

    public void setFinder(JournalArticleFinder finder) {
        _finder = finder;
    }
}
