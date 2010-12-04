package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalArticleResourceLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalArticleResourceLocalServiceImpl</code>.
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
 * @see com.nss.portlet.journal.service.JournalArticleResourceLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalArticleResourceLocalService {
    public com.nss.portlet.journal.model.JournalArticleResource addJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleResource createJournalArticleResource(
        long resourcePrimKey);

    public void deleteJournalArticleResource(long resourcePrimKey)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleResource getJournalArticleResource(
        long resourcePrimKey)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> getJournalArticleResources(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getJournalArticleResourcesCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleResource updateJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalArticleResource updateJournalArticleResource(
        com.nss.portlet.journal.model.JournalArticleResource journalArticleResource,
        boolean merge) throws com.liferay.portal.SystemException;

    public void deleteArticleResource(long groupId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalArticleResource getArticleResource(
        long articleResourcePrimKey)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public long getArticleResourcePrimKey(long groupId,
        java.lang.String articleId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalArticleResource> getArticleResources(
        long groupId) throws com.liferay.portal.SystemException;
}
