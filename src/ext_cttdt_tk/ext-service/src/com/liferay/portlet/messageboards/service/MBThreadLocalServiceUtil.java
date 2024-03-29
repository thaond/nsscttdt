package com.liferay.portlet.messageboards.service;


/**
 * <a href="MBThreadLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.liferay.portlet.messageboards.service.MBThreadLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portlet.messageboards.service.MBThreadLocalService
 *
 */
public class MBThreadLocalServiceUtil {
    private static MBThreadLocalService _service;

    public static com.liferay.portlet.messageboards.model.MBThread addMBThread(
        com.liferay.portlet.messageboards.model.MBThread mbThread)
        throws com.liferay.portal.SystemException {
        return getService().addMBThread(mbThread);
    }

    public static com.liferay.portlet.messageboards.model.MBThread createMBThread(
        long threadId) {
        return getService().createMBThread(threadId);
    }

    public static void deleteMBThread(long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteMBThread(threadId);
    }

    public static void deleteMBThread(
        com.liferay.portlet.messageboards.model.MBThread mbThread)
        throws com.liferay.portal.SystemException {
        getService().deleteMBThread(mbThread);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.liferay.portlet.messageboards.model.MBThread getMBThread(
        long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getMBThread(threadId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getMBThreads(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getMBThreads(start, end);
    }

    public static int getMBThreadsCount()
        throws com.liferay.portal.SystemException {
        return getService().getMBThreadsCount();
    }

    public static com.liferay.portlet.messageboards.model.MBThread updateMBThread(
        com.liferay.portlet.messageboards.model.MBThread mbThread)
        throws com.liferay.portal.SystemException {
        return getService().updateMBThread(mbThread);
    }

    public static com.liferay.portlet.messageboards.model.MBThread updateMBThread(
        com.liferay.portlet.messageboards.model.MBThread mbThread, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateMBThread(mbThread, merge);
    }

    public static void deleteThread(long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteThread(threadId);
    }

    public static void deleteThread(
        com.liferay.portlet.messageboards.model.MBThread thread)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteThread(thread);
    }

    public static void deleteThreads(long categoryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteThreads(categoryId);
    }

    public static int getCategoryThreadsCount(long categoryId)
        throws com.liferay.portal.SystemException {
        return getService().getCategoryThreadsCount(categoryId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getGroupThreads(groupId, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
        long groupId, long userId, int start, int end)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getGroupThreads(groupId, userId, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
        long groupId, long userId, boolean subscribed, int start, int end)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getGroupThreads(groupId, userId, subscribed, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getGroupThreads(
        long groupId, long userId, boolean subscribed,
        boolean includeAnonymous, int start, int end)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .getGroupThreads(groupId, userId, subscribed,
            includeAnonymous, start, end);
    }

    public static int getGroupThreadsCount(long groupId)
        throws com.liferay.portal.SystemException {
        return getService().getGroupThreadsCount(groupId);
    }

    public static int getGroupThreadsCount(long groupId, long userId)
        throws com.liferay.portal.SystemException {
        return getService().getGroupThreadsCount(groupId, userId);
    }

    public static int getGroupThreadsCount(long groupId, long userId,
        boolean subscribed) throws com.liferay.portal.SystemException {
        return getService().getGroupThreadsCount(groupId, userId, subscribed);
    }

    public static int getGroupThreadsCount(long groupId, long userId,
        boolean subscribed, boolean includeAnonymous)
        throws com.liferay.portal.SystemException {
        return getService()
                   .getGroupThreadsCount(groupId, userId, subscribed,
            includeAnonymous);
    }

    public static com.liferay.portlet.messageboards.model.MBThread getThread(
        long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getThread(threadId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBThread> getThreads(
        long categoryId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getThreads(categoryId, start, end);
    }

    public static int getThreadsCount(long categoryId)
        throws com.liferay.portal.SystemException {
        return getService().getThreadsCount(categoryId);
    }

    public static com.liferay.portlet.messageboards.model.MBThread moveThread(
        long categoryId, long threadId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().moveThread(categoryId, threadId);
    }

    public static com.liferay.portlet.messageboards.model.MBThread splitThread(
        long messageId, com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().splitThread(messageId, serviceContext);
    }

    public static com.liferay.portlet.messageboards.model.MBThread updateThread(
        long threadId, int viewCount)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().updateThread(threadId, viewCount);
    }

    public static MBThreadLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("MBThreadLocalService is not set");
        }

        return _service;
    }

    public void setService(MBThreadLocalService service) {
        _service = service;
    }
}
