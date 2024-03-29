package com.liferay.portlet.messageboards.service.persistence;

public class MBMailingListUtil {
    private static MBMailingListPersistence _persistence;

    public static void cacheResult(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList) {
        getPersistence().cacheResult(mbMailingList);
    }

    public static void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> mbMailingLists) {
        getPersistence().cacheResult(mbMailingLists);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList create(
        long mailingListId) {
        return getPersistence().create(mailingListId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList remove(
        long mailingListId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().remove(mailingListId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList remove(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(mbMailingList);
    }

    /**
     * @deprecated Use <code>update(MBMailingList mbMailingList, boolean merge)</code>.
     */
    public static com.liferay.portlet.messageboards.model.MBMailingList update(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(mbMailingList);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbMailingList the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbMailingList is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.liferay.portlet.messageboards.model.MBMailingList update(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(mbMailingList, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList updateImpl(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(mbMailingList, merge);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList findByPrimaryKey(
        long mailingListId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByPrimaryKey(mailingListId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList fetchByPrimaryKey(
        long mailingListId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(mailingListId);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByUuid_First(uuid, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByUuid_Last(uuid, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList[] findByUuid_PrevAndNext(
        long mailingListId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByUuid_PrevAndNext(mailingListId, uuid, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList findByCategoryId(
        long categoryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByCategoryId(categoryId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList fetchByCategoryId(
        long categoryId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByCategoryId(categoryId);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList fetchByCategoryId(
        long categoryId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByCategoryId(categoryId, retrieveFromCache);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByActive(
        boolean active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByActive(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByActive(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList findByActive_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList findByActive_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.liferay.portlet.messageboards.model.MBMailingList[] findByActive_PrevAndNext(
        long mailingListId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        return getPersistence()
                   .findByActive_PrevAndNext(mailingListId, active, obc);
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

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    public static void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        getPersistence().removeByUUID_G(uuid, groupId);
    }

    public static void removeByCategoryId(long categoryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException {
        getPersistence().removeByCategoryId(categoryId);
    }

    public static void removeByActive(boolean active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    public static int countByCategoryId(long categoryId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCategoryId(categoryId);
    }

    public static int countByActive(boolean active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static MBMailingListPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(MBMailingListPersistence persistence) {
        _persistence = persistence;
    }
}
