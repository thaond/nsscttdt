package com.nss.portlet.chat.service;


/**
 * <a href="EntryLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.nss.portlet.chat.service.EntryLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.chat.service.EntryLocalService
 *
 */
public class EntryLocalServiceUtil {
    private static EntryLocalService _service;

    public static com.nss.portlet.chat.model.Entry addEntry(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException {
        return getService().addEntry(entry);
    }

    public static com.nss.portlet.chat.model.Entry createEntry(long entryId) {
        return getService().createEntry(entryId);
    }

    public static void deleteEntry(long entryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deleteEntry(entryId);
    }

    public static void deleteEntry(com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException {
        getService().deleteEntry(entry);
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

    public static com.nss.portlet.chat.model.Entry getEntry(long entryId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getEntry(entryId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> getEntries(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getEntries(start, end);
    }

    public static int getEntriesCount()
        throws com.liferay.portal.SystemException {
        return getService().getEntriesCount();
    }

    public static com.nss.portlet.chat.model.Entry updateEntry(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException {
        return getService().updateEntry(entry);
    }

    public static com.nss.portlet.chat.model.Entry updateEntry(
        com.nss.portlet.chat.model.Entry entry, boolean merge)
        throws com.liferay.portal.SystemException {
        return getService().updateEntry(entry, merge);
    }

    public static com.nss.portlet.chat.model.Entry addEntry(long fromUserId,
        long toUserId, java.lang.String content)
        throws com.liferay.portal.SystemException {
        return getService().addEntry(fromUserId, toUserId, content);
    }

    public static com.nss.portlet.chat.model.Entry addEntry(long createDate,
        long fromUserId, long toUserId, java.lang.String content)
        throws com.liferay.portal.SystemException {
        return getService().addEntry(createDate, fromUserId, toUserId, content);
    }

    public static void deleteEntries(long userId)
        throws com.liferay.portal.SystemException {
        getService().deleteEntries(userId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> getNewEntries(
        long userId, long createDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getNewEntries(userId, createDate, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> getOldEntries(
        long createDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getService().getOldEntries(createDate, start, end);
    }

    public static EntryLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("EntryLocalService is not set");
        }

        return _service;
    }

    public void setService(EntryLocalService service) {
        _service = service;
    }
}
