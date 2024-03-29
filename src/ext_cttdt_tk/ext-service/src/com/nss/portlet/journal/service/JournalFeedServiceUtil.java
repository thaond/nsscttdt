package com.nss.portlet.journal.service;


/**
 * <a href="JournalFeedServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.journal.service.JournalFeedService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.journal.service.JournalFeedService
 *
 */
public class JournalFeedServiceUtil {
    private static JournalFeedService _service;

    public static com.nss.portlet.journal.model.JournalFeed addFeed(
        long groupId, java.lang.String feedId, boolean autoFeedId,
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
                   .addFeed(groupId, feedId, autoFeedId, name, description,
            type, structureId, templateId, rendererTemplateId, delta,
            orderByCol, orderByType, targetLayoutFriendlyUrl, targetPortletId,
            contentField, feedType, feedVersion, serviceContext);
    }

    public static void deleteFeed(long groupId, long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFeed(groupId, feedId);
    }

    public static void deleteFeed(long groupId, java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteFeed(groupId, feedId);
    }

    public static com.nss.portlet.journal.model.JournalFeed getFeed(
        long groupId, long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFeed(groupId, feedId);
    }

    public static com.nss.portlet.journal.model.JournalFeed getFeed(
        long groupId, java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getFeed(groupId, feedId);
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

    public static JournalFeedService getService() {
        if (_service == null) {
            throw new RuntimeException("JournalFeedService is not set");
        }

        return _service;
    }

    public void setService(JournalFeedService service) {
        _service = service;
    }
}
