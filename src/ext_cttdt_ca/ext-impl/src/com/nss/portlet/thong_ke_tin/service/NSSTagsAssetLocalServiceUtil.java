package com.nss.portlet.thong_ke_tin.service;


/**
 * <a href="NSSTagsAssetLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalService
 *
 */
public class NSSTagsAssetLocalServiceUtil {
    private static NSSTagsAssetLocalService _service;

    public static int countArticle(long userId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
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
        return getService()
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
        return getService()
                   .countArticleByVocabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static int countArticleImage(long userId,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countArticleImage(userId, createdateF, createdateT,
            approveddateF, approveddateT, displaydateF, displaydateT,
            expirationdateF, expirationdateT);
    }

    public static int countImageByVocabulary(long vocabularyId,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getService()
                   .countImageByVocabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> getAllArticleByVocabulary(
        long vocabularyId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getAllArticleByVocabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticle(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getArticle(userId, createdateF, createdateT, approveddateF,
            approveddateT, displaydateF, displaydateT, expirationdateF,
            expirationdateT);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getNSSWorkflow(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException {
        return getService()
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
        return getService()
                   .getNSSWorkflowByVoccabulary(vocabularyId, createdateF,
            createdateT, approveddateF, approveddateT, displaydateF,
            displaydateT, expirationdateF, expirationdateT);
    }

    public static java.util.List<com.liferay.portlet.tags.model.TagsAsset> getTagsAsset(
        long userId, java.lang.String articleIds)
        throws com.liferay.portal.SystemException {
        return getService().getTagsAsset(userId, articleIds);
    }

    public static NSSTagsAssetLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("NSSTagsAssetLocalService is not set");
        }

        return _service;
    }

    public void setService(NSSTagsAssetLocalService service) {
        _service = service;
    }
}
