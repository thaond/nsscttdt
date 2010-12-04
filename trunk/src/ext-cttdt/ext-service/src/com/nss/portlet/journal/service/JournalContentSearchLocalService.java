package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalContentSearchLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalContentSearchLocalServiceImpl</code>.
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
 * @see com.nss.portlet.journal.service.JournalContentSearchLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalContentSearchLocalService {
    public com.nss.portlet.journal.model.JournalContentSearch addJournalContentSearch(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch createJournalContentSearch(
        long contentSearchId);

    public void deleteJournalContentSearch(long contentSearchId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteJournalContentSearch(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalContentSearch getJournalContentSearch(
        long contentSearchId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> getJournalContentSearchs(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getJournalContentSearchsCount()
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch updateJournalContentSearch(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch updateJournalContentSearch(
        com.nss.portlet.journal.model.JournalContentSearch journalContentSearch,
        boolean merge) throws com.liferay.portal.SystemException;

    public void checkContentSearches(long companyId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteArticleContentSearch(long groupId, boolean privateLayout,
        long layoutId, java.lang.String portletId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteArticleContentSearches(long groupId,
        java.lang.String articleId) throws com.liferay.portal.SystemException;

    public void deleteLayoutContentSearches(long groupId,
        boolean privateLayout, long layoutId)
        throws com.liferay.portal.SystemException;

    public void deleteOwnerContentSearches(long groupId, boolean privateLayout)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> getArticleContentSearches()
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> getArticleContentSearches(
        long groupId, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<Long> getLayoutIds(long groupId,
        boolean privateLayout, java.lang.String articleId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getLayoutIdsCount(long groupId, boolean privateLayout,
        java.lang.String articleId) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch updateContentSearch(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalContentSearch updateContentSearch(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, java.lang.String articleId, boolean purge)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalContentSearch> updateContentSearch(
        long groupId, boolean privateLayout, long layoutId,
        java.lang.String portletId, java.lang.String[] articleIds)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
