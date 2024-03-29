package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBMessageServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBMessageService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBMessageService
 *
 */
public class MBMessageServiceUtil {
    private static MBMessageService _service;

    public static com.liferay.portlet.messageboards.model.MBMessage addDiscussionMessage(
        java.lang.String className, long classPK, long threadId,
        long parentMessageId, java.lang.String subject, java.lang.String body,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addDiscussionMessage(className, classPK, threadId,
            parentMessageId, subject, body, serviceContext);
    }

    public static com.liferay.portlet.messageboards.model.MBMessage addMessage(
        long categoryId, java.lang.String subject, java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        boolean anonymous, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addMessage(categoryId, subject, body, files, anonymous,
            priority, serviceContext);
    }

    public static com.liferay.portlet.messageboards.model.MBMessage addMessage(
        long categoryId, long threadId, long parentMessageId,
        java.lang.String subject, java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        boolean anonymous, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addMessage(categoryId, threadId, parentMessageId, subject,
            body, files, anonymous, priority, serviceContext);
    }

    public static void deleteDiscussionMessage(long groupId,
        java.lang.String className, long classPK, long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .deleteDiscussionMessage(groupId, className, classPK, messageId);
    }

    public static void deleteMessage(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMessage(messageId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCategoryMessages(
        long categoryId, int start, int end)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getCategoryMessages(categoryId, start, end);
    }

    public static int getCategoryMessagesCount(long categoryId)
        throws com.liferay.portal.SystemException {
        return getService().getCategoryMessagesCount(categoryId);
    }

    public static java.lang.String getCategoryMessagesRSS(long categoryId,
        int max, java.lang.String type, double version,
        java.lang.String displayStyle, java.lang.String feedURL,
        java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getCategoryMessagesRSS(categoryId, max, type, version,
            displayStyle, feedURL, entryURL, themeDisplay);
    }

    public static java.lang.String getCompanyMessagesRSS(long companyId,
        int max, java.lang.String type, double version,
        java.lang.String displayStyle, java.lang.String feedURL,
        java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getCompanyMessagesRSS(companyId, max, type, version,
            displayStyle, feedURL, entryURL, themeDisplay);
    }

    public static java.lang.String getGroupMessagesRSS(long groupId, int max,
        java.lang.String type, double version, java.lang.String displayStyle,
        java.lang.String feedURL, java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getGroupMessagesRSS(groupId, max, type, version,
            displayStyle, feedURL, entryURL, themeDisplay);
    }

    public static java.lang.String getGroupMessagesRSS(long groupId,
        long userId, int max, java.lang.String type, double version,
        java.lang.String displayStyle, java.lang.String feedURL,
        java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getGroupMessagesRSS(groupId, userId, max, type, version,
            displayStyle, feedURL, entryURL, themeDisplay);
    }

    public static com.liferay.portlet.messageboards.model.MBMessage getMessage(
        long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMessage(messageId);
    }

    public static com.liferay.portlet.messageboards.model.MBMessageDisplay getMessageDisplay(
        long messageId, java.lang.String threadView)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMessageDisplay(messageId, threadView);
    }

    public static java.lang.String getThreadMessagesRSS(long threadId, int max,
        java.lang.String type, double version, java.lang.String displayStyle,
        java.lang.String feedURL, java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getThreadMessagesRSS(threadId, max, type, version,
            displayStyle, feedURL, entryURL, themeDisplay);
    }

    public static void subscribeMessage(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().subscribeMessage(messageId);
    }

    public static void unsubscribeMessage(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().unsubscribeMessage(messageId);
    }

    public static com.liferay.portlet.messageboards.model.MBMessage updateDiscussionMessage(
        java.lang.String className, long classPK, long messageId,
        java.lang.String subject, java.lang.String body,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateDiscussionMessage(className, classPK, messageId,
            subject, body, serviceContext);
    }

    public static com.liferay.portlet.messageboards.model.MBMessage updateMessage(
        long messageId, java.lang.String subject, java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        java.util.List<String> existingFiles, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateMessage(messageId, subject, body, files,
            existingFiles, priority, serviceContext);
    }

    public static MBMessageService getService() {
        if (_service == null) {
            throw new RuntimeException("MBMessageService is not set");
        }

        return _service;
    }

    public void setService(MBMessageService service) {
        _service = service;
    }
}
