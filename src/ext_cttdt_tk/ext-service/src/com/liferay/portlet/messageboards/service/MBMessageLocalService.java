package com.liferay.portlet.messageboards.service;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.annotation.Isolation;
import com.liferay.portal.kernel.annotation.Propagation;
import com.liferay.portal.kernel.annotation.Transactional;


/**
 * <a href="MBMessageLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.liferay.portlet.messageboards.service.impl.MBMessageLocalServiceImpl</code>.
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
 * @see com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil
 *
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MBMessageLocalService {
    public com.liferay.portlet.messageboards.model.MBMessage addMBMessage(
        com.liferay.portlet.messageboards.model.MBMessage mbMessage)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage createMBMessage(
        long messageId);

    public void deleteMBMessage(long messageId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deleteMBMessage(
        com.liferay.portlet.messageboards.model.MBMessage mbMessage)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMessage getMBMessage(
        long messageId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getMBMessages(
        int start, int end) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getMBMessagesCount() throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage updateMBMessage(
        com.liferay.portlet.messageboards.model.MBMessage mbMessage)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage updateMBMessage(
        com.liferay.portlet.messageboards.model.MBMessage mbMessage,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage addDiscussionMessage(
        long userId, java.lang.String userName, java.lang.String className,
        long classPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage addDiscussionMessage(
        long userId, java.lang.String userName, java.lang.String className,
        long classPK, long threadId, long parentMessageId,
        java.lang.String subject, java.lang.String body,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage addMessage(
        long userId, java.lang.String userName, long categoryId,
        java.lang.String subject, java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        boolean anonymous, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage addMessage(
        long userId, java.lang.String userName, long categoryId, long threadId,
        long parentMessageId, java.lang.String subject, java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        boolean anonymous, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage addMessage(
        java.lang.String uuid, long userId, java.lang.String userName,
        long categoryId, long threadId, long parentMessageId,
        java.lang.String subject, java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        boolean anonymous, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addMessageResources(long messageId,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addMessageResources(
        com.liferay.portlet.messageboards.model.MBMessage message,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addMessageResources(long messageId,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void addMessageResources(
        com.liferay.portlet.messageboards.model.MBMessage message,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteDiscussionMessage(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteDiscussionMessages(java.lang.String className,
        long classPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteMessage(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void deleteMessage(
        com.liferay.portlet.messageboards.model.MBMessage message)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCategoryMessages(
        long categoryId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCategoryMessages(
        long categoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCategoryMessagesCount(long categoryId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCompanyMessages(
        long companyId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCompanyMessages(
        long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getCompanyMessagesCount(long companyId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMessageDisplay getDiscussionMessageDisplay(
        long userId, java.lang.String className, long classPK)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMessageDisplay getDiscussionMessageDisplay(
        long userId, java.lang.String className, long classPK,
        java.lang.String threadView)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getDiscussionMessagesCount(long classNameId, long classPK)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBDiscussion> getDiscussions(
        java.lang.String className) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getGroupMessages(
        long groupId, long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getGroupMessagesCount(long groupId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getGroupMessagesCount(long groupId, long userId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMessage getMessage(
        long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getMessages(
        java.lang.String className, long classPK)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMessageDisplay getMessageDisplay(
        long messageId, java.lang.String threadView)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portlet.messageboards.model.MBMessageDisplay getMessageDisplay(
        com.liferay.portlet.messageboards.model.MBMessage message,
        java.lang.String threadView)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getNoAssetMessages()
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadMessages(
        long threadId) throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadMessages(
        long threadId,
        java.util.Comparator<com.liferay.portlet.messageboards.model.MBMessage> comparator)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadMessages(
        long threadId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getThreadMessagesCount(long threadId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getThreadRepliesMessages(
        long threadId, int start, int end)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(long messageId)
        throws com.liferay.portal.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public void reIndex(
        com.liferay.portlet.messageboards.model.MBMessage message)
        throws com.liferay.portal.SystemException;

    public void subscribeMessage(long userId, long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void unsubscribeMessage(long userId, long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage updateDiscussionMessage(
        long userId, long messageId, java.lang.String subject,
        java.lang.String body)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage updateMessage(
        long userId, long messageId, java.lang.String subject,
        java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        java.util.List<String> existingFiles, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage updateMessage(
        long messageId, java.util.Date createDate, java.util.Date modifiedDate)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMessage updateMessage(
        long messageId, java.lang.String body)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void updateTagsAsset(long userId,
        com.liferay.portlet.messageboards.model.MBMessage message,
        java.lang.String[] tagsEntries)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
