package com.nss.portlet.journal.service;


/**
 * <a href="JournalFeedLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalFeedLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalFeedLocalService
 *
 */
public class JournalFeedLocalServiceUtil {
    private static JournalFeedLocalService _service;

    public static com.nss.portlet.journal.model.JournalFeed addJournalFeed(
        com.nss.portlet.journal.model.JournalFeed journalFeed)
        throws com.liferay.portal.SystemException {
        return getService().addJournalFeed(journalFeed);
    }

    public static com.nss.portlet.journal.model.JournalFeed createJournalFeed(
        long id) {
        return getService().createJournalFeed(id);
    }

    public static void deleteJournalFeed(long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteJournalFeed(id);
    }

    public static void deleteJournalFeed(
        com.nss.portlet.journal.model.JournalFeed journalFeed)
        throws com.liferay.portal.SystemException {
        getService().deleteJournalFeed(journalFeed);
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

    public static com.nss.portlet.journal.model.JournalFeed getJournalFeed(
        long id)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getJournalFeed(id);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> getJournalFeeds(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getJournalFeeds(start, end);
    }

    public static int getJournalFeedsCount()
        throws com.liferay.portal.SystemException {
        return getService().getJournalFeedsCount();
    }

    public static com.nss.portlet.journal.model.JournalFeed updateJournalFeed(
        com.nss.portlet.journal.model.JournalFeed journalFeed)
        throws com.liferay.portal.SystemException {
        return getService().updateJournalFeed(journalFeed);
    }

    public static com.nss.portlet.journal.model.JournalFeed updateJournalFeed(
        com.nss.portlet.journal.model.JournalFeed journalFeed, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateJournalFeed(journalFeed, merge);
    }

    public static com.nss.portlet.journal.model.JournalFeed addFeed(
        long userId, long groupId, java.lang.String feedId, boolean autoFeedId,
        java.lang.String name, java.lang.String description,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.lang.String rendererTemplateId,
        int delta, java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .addFeed(userId, groupId, feedId, autoFeedId, name,
            description, type, structureId, templateId, rendererTemplateId,
            delta, orderByCol, orderByType, targetLayoutFriendlyUrl,
            targetPortletId, contentField, feedType, feedVersion, serviceContext);
    }

    public static com.nss.portlet.journal.model.JournalFeed addFeed(
        java.lang.String uuid, long userId, long groupId,
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
            com.liferay.portal.SystemException {
        return getService()
                   .addFeed(uuid, userId, groupId, feedId, autoFeedId, name,
            description, type, structureId, templateId, rendererTemplateId,
            delta, orderByCol, orderByType, targetLayoutFriendlyUrl,
            targetPortletId, contentField, feedType, feedVersion, serviceContext);
    }

    public static void addFeedResources(long feedId,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addFeedResources(feedId, addCommunityPermissions,
            addGuestPermissions);
    }

    public static void addFeedResources(
        com.nss.portlet.journal.model.JournalFeed feed,
        boolean addCommunityPermissions, boolean addGuestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addFeedResources(feed, addCommunityPermissions, addGuestPermissions);
    }

    public static void addFeedResources(long feedId,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addFeedResources(feedId, communityPermissions, guestPermissions);
    }

    public static void addFeedResources(
        com.nss.portlet.journal.model.JournalFeed feed,
        java.lang.String[] communityPermissions,
        java.lang.String[] guestPermissions)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService()
            .addFeedResources(feed, communityPermissions, guestPermissions);
    }

    public static void deleteFeed(long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFeed(feedId);
    }

    public static void deleteFeed(long groupId, java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFeed(groupId, feedId);
    }

    public static void deleteFeed(
        com.nss.portlet.journal.model.JournalFeed feed)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFeed(feed);
    }

    public static com.nss.portlet.journal.model.JournalFeed getFeed(long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFeed(feedId);
    }

    public static com.nss.portlet.journal.model.JournalFeed getFeed(
        long groupId, java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFeed(groupId, feedId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> getFeeds()
        throws com.liferay.portal.SystemException {
        return getService().getFeeds();
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> getFeeds(
        long groupId) throws com.liferay.portal.SystemException {
        return getService().getFeeds(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> getFeeds(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getFeeds(groupId, start, end);
    }

    public static int getFeedsCount(long groupId)
        throws com.liferay.portal.SystemException {
        return getService().getFeedsCount(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> search(
        long companyId, long groupId, java.lang.String keywords, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService().search(companyId, groupId, keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalFeed> search(
        long companyId, long groupId, java.lang.String feedId,
        java.lang.String name, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getService()
                   .search(companyId, groupId, feedId, name, description,
            andOperator, start, end, obc);
    }

    public static int searchCount(long companyId, long groupId,
        java.lang.String keywords) throws com.liferay.portal.SystemException {
        return getService().searchCount(companyId, groupId, keywords);
    }

    public static int searchCount(long companyId, long groupId,
        java.lang.String feedId, java.lang.String name,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getService()
                   .searchCount(companyId, groupId, feedId, name, description,
            andOperator);
    }

    public static com.nss.portlet.journal.model.JournalFeed updateFeed(
        long groupId, java.lang.String feedId, java.lang.String name,
        java.lang.String description, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.lang.String rendererTemplateId, int delta,
        java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService()
                   .updateFeed(groupId, feedId, name, description, type,
            structureId, templateId, rendererTemplateId, delta, orderByCol,
            orderByType, targetLayoutFriendlyUrl, targetPortletId,
            contentField, feedType, feedVersion, serviceContext);
    }

    public static JournalFeedLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("JournalFeedLocalService is not set");
        }

        return _service;
    }

    public void setService(JournalFeedLocalService service) {
        _service = service;
    }
}
