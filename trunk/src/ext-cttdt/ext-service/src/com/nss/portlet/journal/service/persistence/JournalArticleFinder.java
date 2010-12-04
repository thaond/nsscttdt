package com.nss.portlet.journal.service.persistence;

public interface JournalArticleFinder {
    public int countByKeywords(long companyId, long groupId,
        java.lang.String keywords, java.lang.Double version,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate)
        throws com.liferay.portal.SystemException;

    public int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(long companyId, long groupId,
        java.lang.String articleId, java.lang.Double version,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(long companyId, long groupId,
        java.lang.String articleId, java.lang.Double version,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String[] structureIds, java.lang.String[] templateIds,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByC_G_A_V_T_D_C_T_S_T_D_A_E_R(long companyId, long groupId,
        java.lang.String[] articleIds, java.lang.Double version,
        java.lang.String[] titles, java.lang.String[] descriptions,
        java.lang.String[] contents, java.lang.String type,
        java.lang.String[] structureIds, java.lang.String[] templateIds,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByExpirationDate(
        java.lang.Boolean expired, java.util.Date expirationDateLT,
        java.util.Date expirationDateGT)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByKeywords(
        long companyId, long groupId, java.lang.String keywords,
        java.lang.Double version, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.util.Date displayDateGT, java.util.Date displayDateLT,
        java.lang.Boolean approved, java.lang.Boolean expired,
        java.util.Date reviewDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByReviewDate(
        java.util.Date reviewDateLT, java.util.Date reviewDateGT)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticle findByR_D(
        long resourcePrimKey, java.util.Date displayDate)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchArticleException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(
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

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(
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

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> findByC_G_A_V_T_D_C_T_S_T_D_A_E_R(
        long companyId, long groupId, java.lang.String[] articleIds,
        java.lang.Double version, java.lang.String[] titles,
        java.lang.String[] descriptions, java.lang.String[] contents,
        java.lang.String type, java.lang.String[] structureIds,
        java.lang.String[] templateIds, java.util.Date displayDateGT,
        java.util.Date displayDateLT, java.lang.Boolean approved,
        java.lang.Boolean expired, java.util.Date reviewDate,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
