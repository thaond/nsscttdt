package com.nss.portlet.journal.service.persistence;

public class JournalStructureUtil {
    private static JournalStructurePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.journal.model.JournalStructure journalStructure) {
        getPersistence().cacheResult(journalStructure);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalStructure> journalStructures) {
        getPersistence().cacheResult(journalStructures);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.journal.model.JournalStructure create(long id) {
        return getPersistence().create(id);
    }

    public static com.nss.portlet.journal.model.JournalStructure remove(long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().remove(id);
    }

    public static com.nss.portlet.journal.model.JournalStructure remove(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(journalStructure);
    }

    /**
     * @deprecated Use <code>update(JournalStructure journalStructure, boolean merge)</code>.
     */
    public static com.nss.portlet.journal.model.JournalStructure update(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(journalStructure);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalStructure the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalStructure is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.journal.model.JournalStructure update(
        com.nss.portlet.journal.model.JournalStructure journalStructure,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(journalStructure, merge);
    }

    public static com.nss.portlet.journal.model.JournalStructure updateImpl(
        com.nss.portlet.journal.model.JournalStructure journalStructure,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(journalStructure, merge);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByPrimaryKey(id);
    }

    public static com.nss.portlet.journal.model.JournalStructure fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUuid(uuid, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByUuid_First(uuid, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByUuid_Last(uuid, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByUuid_PrevAndNext(id, uuid, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    public static com.nss.portlet.journal.model.JournalStructure fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    public static com.nss.portlet.journal.model.JournalStructure fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByGroupId(groupId, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByGroupId_First(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByGroupId_Last(groupId, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByGroupId_PrevAndNext(id, groupId, obc);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByStructureId(
        java.lang.String structureId) throws com.liferay.portal.SystemException {
        return getPersistence().findByStructureId(structureId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByStructureId(
        java.lang.String structureId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStructureId(structureId, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByStructureId(
        java.lang.String structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStructureId(structureId, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByStructureId_First(
        java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByStructureId_First(structureId, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByStructureId_Last(
        java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByStructureId_Last(structureId, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure[] findByStructureId_PrevAndNext(
        long id, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence()
                   .findByStructureId_PrevAndNext(id, structureId, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByG_S(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByG_S(groupId, structureId);
    }

    public static com.nss.portlet.journal.model.JournalStructure fetchByG_S(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByG_S(groupId, structureId);
    }

    public static com.nss.portlet.journal.model.JournalStructure fetchByG_S(
        long groupId, java.lang.String structureId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByG_S(groupId, structureId, retrieveFromCache);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByG_P(
        long groupId, java.lang.String parentStructureId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_P(groupId, parentStructureId);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByG_P(
        long groupId, java.lang.String parentStructureId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByG_P(groupId, parentStructureId, start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findByG_P(
        long groupId, java.lang.String parentStructureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByG_P(groupId, parentStructureId, start, end, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByG_P_First(
        long groupId, java.lang.String parentStructureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByG_P_First(groupId, parentStructureId, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure findByG_P_Last(
        long groupId, java.lang.String parentStructureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence().findByG_P_Last(groupId, parentStructureId, obc);
    }

    public static com.nss.portlet.journal.model.JournalStructure[] findByG_P_PrevAndNext(
        long id, long groupId, java.lang.String parentStructureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        return getPersistence()
                   .findByG_P_PrevAndNext(id, groupId, parentStructureId, obc);
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

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.journal.model.JournalStructure> findAll(
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
            com.nss.portlet.journal.NoSuchStructureException {
        getPersistence().removeByUUID_G(uuid, groupId);
    }

    public static void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByGroupId(groupId);
    }

    public static void removeByStructureId(java.lang.String structureId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStructureId(structureId);
    }

    public static void removeByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException {
        getPersistence().removeByG_S(groupId, structureId);
    }

    public static void removeByG_P(long groupId,
        java.lang.String parentStructureId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByG_P(groupId, parentStructureId);
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

    public static int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByGroupId(groupId);
    }

    public static int countByStructureId(java.lang.String structureId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStructureId(structureId);
    }

    public static int countByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_S(groupId, structureId);
    }

    public static int countByG_P(long groupId,
        java.lang.String parentStructureId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByG_P(groupId, parentStructureId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static JournalStructurePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(JournalStructurePersistence persistence) {
        _persistence = persistence;
    }
}
