package com.nss.portlet.thong_ke_tin.service.persistence;

public class NSSTagsAssetFinderUtil {
    private static NSSTagsAssetFinder _finder;

    public static int countArticle(long userId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countArticle(userId, createdateF, createdateT,
            approveddateF, approveddateT, displaydateF, displaydateT,
            expirationdateF, expirationdateT);
    }

    public static int countArticleApproved(long userId, boolean approved,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countArticleApproved(userId, approved, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static int countArticleApprovedByVocabulary(long vocabularyId,
        boolean approved, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countArticleApprovedByVocabulary(vocabularyId, approved,
            createdateF, createdateT, approveddateF, approveddateT,
            displaydateF, displaydateT, expirationdateF, expirationdateT);
    }

    public static int countArticleByVocabulary(long vocabularyId,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countArticleByVocabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static int countImageByVocabulary(long vocabularyId,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countImageByVocabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticle(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getArticle(userId, createdateF, createdateT, approveddateF,
            approveddateT, displaydateF, displaydateT, expirationdateF,
            expirationdateT);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticleByVoccabulary(
        long vocabularyId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getArticleByVoccabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getNSSWorkflow(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getNSSWorkflow(userId, createdateF, createdateT,
            approveddateF, approveddateT, displaydateF, displaydateT,
            expirationdateF, expirationdateT);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getNSSWorkflowByVoccabulary(
        long vocabularyId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .getNSSWorkflowByVoccabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static java.util.List<com.liferay.portlet.tags.model.TagsAsset> getTagsAsset(
        long userId, java.lang.String articleIds)
        throws com.liferay.portal.SystemException {
        return getFinder().getTagsAsset(userId, articleIds);
    }

    public static NSSTagsAssetFinder getFinder() {
        return _finder;
    }

    public void setFinder(NSSTagsAssetFinder finder) {
        _finder = finder;
    }
}
