package com.nss.portlet.chat.service.persistence;

public class EntryUtil {
    private static EntryPersistence _persistence;

    public static void cacheResult(com.nss.portlet.chat.model.Entry entry) {
        getPersistence().cacheResult(entry);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.chat.model.Entry> entries) {
        getPersistence().cacheResult(entries);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.chat.model.Entry create(long entryId) {
        return getPersistence().create(entryId);
    }

    public static com.nss.portlet.chat.model.Entry remove(long entryId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().remove(entryId);
    }

    public static com.nss.portlet.chat.model.Entry remove(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(entry);
    }

    /**
     * @deprecated Use <code>update(Entry entry, boolean merge)</code>.
     */
    public static com.nss.portlet.chat.model.Entry update(
        com.nss.portlet.chat.model.Entry entry)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(entry);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                entry the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when entry is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.chat.model.Entry update(
        com.nss.portlet.chat.model.Entry entry, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(entry, merge);
    }

    public static com.nss.portlet.chat.model.Entry updateImpl(
        com.nss.portlet.chat.model.Entry entry, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(entry, merge);
    }

    public static com.nss.portlet.chat.model.Entry findByPrimaryKey(
        long entryId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByPrimaryKey(entryId);
    }

    public static com.nss.portlet.chat.model.Entry fetchByPrimaryKey(
        long entryId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(entryId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByCreateDate(
        long createDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByCreateDate(createDate);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByCreateDate(
        long createDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCreateDate(createDate, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByCreateDate(
        long createDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCreateDate(createDate, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByCreateDate_First(
        long createDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByCreateDate_First(createDate, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByCreateDate_Last(
        long createDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByCreateDate_Last(createDate, obc);
    }

    public static com.nss.portlet.chat.model.Entry[] findByCreateDate_PrevAndNext(
        long entryId, long createDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByCreateDate_PrevAndNext(entryId, createDate, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByFromUserId(
        long fromUserId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFromUserId(fromUserId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByFromUserId(
        long fromUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFromUserId(fromUserId, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByFromUserId(
        long fromUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFromUserId(fromUserId, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByFromUserId_First(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByFromUserId_First(fromUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByFromUserId_Last(
        long fromUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByFromUserId_Last(fromUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry[] findByFromUserId_PrevAndNext(
        long entryId, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByFromUserId_PrevAndNext(entryId, fromUserId, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByToUserId(
        long toUserId) throws com.liferay.portal.SystemException {
        return getPersistence().findByToUserId(toUserId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByToUserId(
        long toUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByToUserId(toUserId, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByToUserId(
        long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByToUserId(toUserId, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByToUserId_First(
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByToUserId_First(toUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByToUserId_Last(
        long toUserId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByToUserId_Last(toUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry[] findByToUserId_PrevAndNext(
        long entryId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByToUserId_PrevAndNext(entryId, toUserId, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_F(
        long createDate, long fromUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByC_F(createDate, fromUserId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_F(
        long createDate, long fromUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByC_F(createDate, fromUserId, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_F(
        long createDate, long fromUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_F(createDate, fromUserId, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByC_F_First(
        long createDate, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByC_F_First(createDate, fromUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByC_F_Last(
        long createDate, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByC_F_Last(createDate, fromUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry[] findByC_F_PrevAndNext(
        long entryId, long createDate, long fromUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByC_F_PrevAndNext(entryId, createDate, fromUserId, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_T(
        long createDate, long toUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByC_T(createDate, toUserId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_T(
        long createDate, long toUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByC_T(createDate, toUserId, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_T(
        long createDate, long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByC_T(createDate, toUserId, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByC_T_First(
        long createDate, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByC_T_First(createDate, toUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByC_T_Last(
        long createDate, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence().findByC_T_Last(createDate, toUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry[] findByC_T_PrevAndNext(
        long entryId, long createDate, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByC_T_PrevAndNext(entryId, createDate, toUserId, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_F_T(
        long createDate, long fromUserId, long toUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByC_F_T(createDate, fromUserId, toUserId);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_F_T(
        long createDate, long fromUserId, long toUserId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_F_T(createDate, fromUserId, toUserId, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByC_F_T(
        long createDate, long fromUserId, long toUserId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_F_T(createDate, fromUserId, toUserId, start, end,
            obc);
    }

    public static com.nss.portlet.chat.model.Entry findByC_F_T_First(
        long createDate, long fromUserId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByC_F_T_First(createDate, fromUserId, toUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByC_F_T_Last(
        long createDate, long fromUserId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByC_F_T_Last(createDate, fromUserId, toUserId, obc);
    }

    public static com.nss.portlet.chat.model.Entry[] findByC_F_T_PrevAndNext(
        long entryId, long createDate, long fromUserId, long toUserId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByC_F_T_PrevAndNext(entryId, createDate, fromUserId,
            toUserId, obc);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByF_T_C(
        long fromUserId, long toUserId, java.lang.String content)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByF_T_C(fromUserId, toUserId, content);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByF_T_C(
        long fromUserId, long toUserId, java.lang.String content, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByF_T_C(fromUserId, toUserId, content, start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findByF_T_C(
        long fromUserId, long toUserId, java.lang.String content, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByF_T_C(fromUserId, toUserId, content, start, end, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByF_T_C_First(
        long fromUserId, long toUserId, java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByF_T_C_First(fromUserId, toUserId, content, obc);
    }

    public static com.nss.portlet.chat.model.Entry findByF_T_C_Last(
        long fromUserId, long toUserId, java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByF_T_C_Last(fromUserId, toUserId, content, obc);
    }

    public static com.nss.portlet.chat.model.Entry[] findByF_T_C_PrevAndNext(
        long entryId, long fromUserId, long toUserId, java.lang.String content,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchEntryException {
        return getPersistence()
                   .findByF_T_C_PrevAndNext(entryId, fromUserId, toUserId,
            content, obc);
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

    public static java.util.List<com.nss.portlet.chat.model.Entry> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.chat.model.Entry> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByCreateDate(long createDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCreateDate(createDate);
    }

    public static void removeByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFromUserId(fromUserId);
    }

    public static void removeByToUserId(long toUserId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByToUserId(toUserId);
    }

    public static void removeByC_F(long createDate, long fromUserId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_F(createDate, fromUserId);
    }

    public static void removeByC_T(long createDate, long toUserId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_T(createDate, toUserId);
    }

    public static void removeByC_F_T(long createDate, long fromUserId,
        long toUserId) throws com.liferay.portal.SystemException {
        getPersistence().removeByC_F_T(createDate, fromUserId, toUserId);
    }

    public static void removeByF_T_C(long fromUserId, long toUserId,
        java.lang.String content) throws com.liferay.portal.SystemException {
        getPersistence().removeByF_T_C(fromUserId, toUserId, content);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByCreateDate(long createDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCreateDate(createDate);
    }

    public static int countByFromUserId(long fromUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFromUserId(fromUserId);
    }

    public static int countByToUserId(long toUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByToUserId(toUserId);
    }

    public static int countByC_F(long createDate, long fromUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_F(createDate, fromUserId);
    }

    public static int countByC_T(long createDate, long toUserId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_T(createDate, toUserId);
    }

    public static int countByC_F_T(long createDate, long fromUserId,
        long toUserId) throws com.liferay.portal.SystemException {
        return getPersistence().countByC_F_T(createDate, fromUserId, toUserId);
    }

    public static int countByF_T_C(long fromUserId, long toUserId,
        java.lang.String content) throws com.liferay.portal.SystemException {
        return getPersistence().countByF_T_C(fromUserId, toUserId, content);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static EntryPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(EntryPersistence persistence) {
        _persistence = persistence;
    }
}
