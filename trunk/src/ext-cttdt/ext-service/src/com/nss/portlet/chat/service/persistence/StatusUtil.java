package com.nss.portlet.chat.service.persistence;

public class StatusUtil {
    private static StatusPersistence _persistence;

    public static void cacheResult(com.nss.portlet.chat.model.Status status) {
        getPersistence().cacheResult(status);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.chat.model.Status> statuses) {
        getPersistence().cacheResult(statuses);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.chat.model.Status create(long statusId) {
        return getPersistence().create(statusId);
    }

    public static com.nss.portlet.chat.model.Status remove(long statusId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().remove(statusId);
    }

    public static com.nss.portlet.chat.model.Status remove(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(status);
    }

    /**
     * @deprecated Use <code>update(Status status, boolean merge)</code>.
     */
    public static com.nss.portlet.chat.model.Status update(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(status);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                status the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when status is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.chat.model.Status update(
        com.nss.portlet.chat.model.Status status, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(status, merge);
    }

    public static com.nss.portlet.chat.model.Status updateImpl(
        com.nss.portlet.chat.model.Status status, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(status, merge);
    }

    public static com.nss.portlet.chat.model.Status findByPrimaryKey(
        long statusId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByPrimaryKey(statusId);
    }

    public static com.nss.portlet.chat.model.Status fetchByPrimaryKey(
        long statusId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(statusId);
    }

    public static com.nss.portlet.chat.model.Status findByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByUserId(userId);
    }

    public static com.nss.portlet.chat.model.Status fetchByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUserId(userId);
    }

    public static com.nss.portlet.chat.model.Status fetchByUserId(long userId,
        boolean retrieveFromCache) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUserId(userId, retrieveFromCache);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByModifiedDate(
        long modifiedDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByModifiedDate(modifiedDate);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByModifiedDate(
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByModifiedDate(modifiedDate, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByModifiedDate(
        long modifiedDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByModifiedDate(modifiedDate, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Status findByModifiedDate_First(
        long modifiedDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByModifiedDate_First(modifiedDate, obc);
    }

    public static com.nss.portlet.chat.model.Status findByModifiedDate_Last(
        long modifiedDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByModifiedDate_Last(modifiedDate, obc);
    }

    public static com.nss.portlet.chat.model.Status[] findByModifiedDate_PrevAndNext(
        long statusId, long modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence()
                   .findByModifiedDate_PrevAndNext(statusId, modifiedDate, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByOnline(
        boolean online) throws com.liferay.portal.SystemException {
        return getPersistence().findByOnline(online);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByOnline(
        boolean online, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOnline(online, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByOnline(
        boolean online, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOnline(online, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Status findByOnline_First(
        boolean online, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByOnline_First(online, obc);
    }

    public static com.nss.portlet.chat.model.Status findByOnline_Last(
        boolean online, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByOnline_Last(online, obc);
    }

    public static com.nss.portlet.chat.model.Status[] findByOnline_PrevAndNext(
        long statusId, boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByOnline_PrevAndNext(statusId, online, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByM_O(
        long modifiedDate, boolean online)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByM_O(modifiedDate, online);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByM_O(
        long modifiedDate, boolean online, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByM_O(modifiedDate, online, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findByM_O(
        long modifiedDate, boolean online, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByM_O(modifiedDate, online, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Status findByM_O_First(
        long modifiedDate, boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByM_O_First(modifiedDate, online, obc);
    }

    public static com.nss.portlet.chat.model.Status findByM_O_Last(
        long modifiedDate, boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence().findByM_O_Last(modifiedDate, online, obc);
    }

    public static com.nss.portlet.chat.model.Status[] findByM_O_PrevAndNext(
        long statusId, long modifiedDate, boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        return getPersistence()
                   .findByM_O_PrevAndNext(statusId, modifiedDate, online, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Status> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeByModifiedDate(long modifiedDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByModifiedDate(modifiedDate);
    }

    public static void removeByOnline(boolean online)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOnline(online);
    }

    public static void removeByM_O(long modifiedDate, boolean online)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByM_O(modifiedDate, online);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
    }

    public static int countByModifiedDate(long modifiedDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByModifiedDate(modifiedDate);
    }

    public static int countByOnline(boolean online)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOnline(online);
    }

    public static int countByM_O(long modifiedDate, boolean online)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByM_O(modifiedDate, online);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static StatusPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(StatusPersistence persistence) {
        _persistence = persistence;
    }
}
