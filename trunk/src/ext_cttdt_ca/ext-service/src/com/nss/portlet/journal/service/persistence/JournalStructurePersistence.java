package com.nss.portlet.journal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface JournalStructurePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journal.model.JournalStructure journalStructure);

    public void cacheResult(
        java.util.List<com.nss.portlet.journal.model.JournalStructure> journalStructures);

    public void clearCache();

    public com.nss.portlet.journal.model.JournalStructure create(long id);

    public com.nss.portlet.journal.model.JournalStructure remove(long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure remove(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(JournalStructure journalStructure, boolean merge)</code>.
     */
    public com.nss.portlet.journal.model.JournalStructure update(
        com.nss.portlet.journal.model.JournalStructure journalStructure)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.journal.model.JournalStructure update(
        com.nss.portlet.journal.model.JournalStructure journalStructure,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure updateImpl(
        com.nss.portlet.journal.model.JournalStructure journalStructure,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure[] findByUuid_PrevAndNext(
        long id, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure[] findByGroupId_PrevAndNext(
        long id, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByStructureId(
        java.lang.String structureId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByStructureId(
        java.lang.String structureId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByStructureId(
        java.lang.String structureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure findByStructureId_First(
        java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure findByStructureId_Last(
        java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure[] findByStructureId_PrevAndNext(
        long id, java.lang.String structureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure findByG_S(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure fetchByG_S(
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure fetchByG_S(
        long groupId, java.lang.String structureId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByG_P(
        long groupId, java.lang.String parentStructureId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByG_P(
        long groupId, java.lang.String parentStructureId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findByG_P(
        long groupId, java.lang.String parentStructureId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.journal.model.JournalStructure findByG_P_First(
        long groupId, java.lang.String parentStructureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure findByG_P_Last(
        long groupId, java.lang.String parentStructureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public com.nss.portlet.journal.model.JournalStructure[] findByG_P_PrevAndNext(
        long id, long groupId, java.lang.String parentStructureId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journal.model.JournalStructure> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByStructureId(java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public void removeByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journal.NoSuchStructureException;

    public void removeByG_P(long groupId, java.lang.String parentStructureId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByStructureId(java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public int countByG_S(long groupId, java.lang.String structureId)
        throws com.liferay.portal.SystemException;

    public int countByG_P(long groupId, java.lang.String parentStructureId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
