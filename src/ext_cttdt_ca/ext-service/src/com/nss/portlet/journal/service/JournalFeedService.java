package com.nss.portlet.journal.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="JournalFeedService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.nss.portlet.journal.service.impl.JournalFeedServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalFeedServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface JournalFeedService {
    public com.nss.portlet.journal.model.JournalFeed addFeed(long groupId,
        java.lang.String feedId, boolean autoFeedId, java.lang.String name,
        java.lang.String description, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.lang.String rendererTemplateId, int delta,
        java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteFeed(long groupId, long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteFeed(long groupId, java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalFeed getFeed(long groupId,
        long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.nss.portlet.journal.model.JournalFeed getFeed(long groupId,
        java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalFeed updateFeed(long groupId,
        java.lang.String feedId, java.lang.String name,
        java.lang.String description, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.lang.String rendererTemplateId, int delta,
        java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
