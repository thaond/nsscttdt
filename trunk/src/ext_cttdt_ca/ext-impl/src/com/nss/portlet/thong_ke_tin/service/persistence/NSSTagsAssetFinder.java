package com.nss.portlet.thong_ke_tin.service.persistence;

public interface NSSTagsAssetFinder {
    public int countArticle(long userId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public int countArticleApproved(long userId, boolean approved,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public int countArticleApprovedByVocabulary(long vocabularyId,
        boolean approved, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public int countArticleByVocabulary(long vocabularyId,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public int countImageByVocabulary(long vocabularyId,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticle(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticleByVoccabulary(
        long vocabularyId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getNSSWorkflow(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getNSSWorkflowByVoccabulary(
        long vocabularyId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.tags.model.TagsAsset> getTagsAsset(
        long userId, java.lang.String articleIds)
        throws com.liferay.portal.SystemException;
}
