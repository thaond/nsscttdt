package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalArticleImageLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalArticleImageLocalServiceImpl</code>.
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
 * @see com.nss.portlet.journal.service.JournalArticleImageLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalArticleImageLocalService {
    public com.nss.portlet.journal.model.JournalArticleImage addJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage createJournalArticleImage(
        long articleImageId);

    public void deleteJournalArticleImage(long articleImageId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleImage getJournalArticleImage(
        long articleImageId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> getJournalArticleImages(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getJournalArticleImagesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage updateJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleImage updateJournalArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage journalArticleImage,
        boolean merge) throws com.liferay.portal.SystemException;

    public void addArticleImageId(long articleImageId, long groupId,
        java.lang.String articleId, double version,
        java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteArticleImage(long articleImageId)
        throws com.liferay.portal.SystemException;

    public void deleteArticleImage(
        com.nss.portlet.journal.model.JournalArticleImage articleImage)
        throws com.liferay.portal.SystemException;

    public void deleteArticleImage(long groupId, java.lang.String articleId,
        double version, java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException;

    public void deleteImages(long groupId, java.lang.String articleId,
        double version) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleImage getArticleImage(
        long articleImageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getArticleImageId(long groupId, java.lang.String articleId,
        double version, java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getArticleImageId(long groupId, java.lang.String articleId,
        double version, java.lang.String elInstanceId, java.lang.String elName,
        java.lang.String languageId, boolean tempImage)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticleImage> getArticleImages(
        long groupId) throws com.liferay.portal.SystemException;
}
