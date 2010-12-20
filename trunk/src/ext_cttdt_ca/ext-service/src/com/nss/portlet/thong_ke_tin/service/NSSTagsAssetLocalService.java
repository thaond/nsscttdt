package com.nss.portlet.thong_ke_tin.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="NSSTagsAssetLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.thong_ke_tin.service.impl.NSSTagsAssetLocalServiceImpl</code>.
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
 * @see com.nss.portlet.thong_ke_tin.service.NSSTagsAssetLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface NSSTagsAssetLocalService {
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

    public int countArticleImage(long userId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    public int countImageByVocabulary(long vocabularyId,
        java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getAllArticleByVocabulary(
        long vocabularyId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticle> getArticle(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getNSSWorkflow(
        long userId, java.util.Date createdateF, java.util.Date createdateT,
        java.util.Date approveddateF, java.util.Date approveddateT,
        java.util.Date displaydateF, java.util.Date displaydateT,
        java.util.Date expirationdateF, java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.managementworkflowjournal.model.WorkflowJournalArticle> getNSSWorkflowByVoccabulary(
        long vocabularyId, java.util.Date createdateF,
        java.util.Date createdateT, java.util.Date approveddateF,
        java.util.Date approveddateT, java.util.Date displaydateF,
        java.util.Date displaydateT, java.util.Date expirationdateF,
        java.util.Date expirationdateT)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.tags.model.TagsAsset> getTagsAsset(
        long userId, java.lang.String articleIds)
        throws com.liferay.portal.SystemException;
}
