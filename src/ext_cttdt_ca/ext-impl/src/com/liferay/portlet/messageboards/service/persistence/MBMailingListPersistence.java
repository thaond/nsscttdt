package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MBMailingListPersistence extends BasePersistence {
    public void cacheResult(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList);

    public void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> mbMailingLists);

    public void clearCache();

    public com.liferay.portlet.messageboards.model.MBMailingList create(
        long mailingListId);

    public com.liferay.portlet.messageboards.model.MBMailingList remove(
        long mailingListId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList remove(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MBMailingList mbMailingList, boolean merge)</code>.
     */
    public com.liferay.portlet.messageboards.model.MBMailingList update(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList)
        throws com.liferay.portal.SystemException;

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
    public com.liferay.portlet.messageboards.model.MBMailingList update(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList updateImpl(
        com.liferay.portlet.messageboards.model.MBMailingList mbMailingList,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList findByPrimaryKey(
        long mailingListId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList fetchByPrimaryKey(
        long mailingListId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByUuid(
        java.lang.String uuid) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList[] findByUuid_PrevAndNext(
        long mailingListId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList findByCategoryId(
        long categoryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList fetchByCategoryId(
        long categoryId) throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList fetchByCategoryId(
        long categoryId, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByActive(
        boolean active) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByActive(
        boolean active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findByActive(
        boolean active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBMailingList findByActive_First(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList findByActive_Last(
        boolean active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public com.liferay.portlet.messageboards.model.MBMailingList[] findByActive_PrevAndNext(
        long mailingListId, boolean active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBMailingList> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public void removeByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public void removeByCategoryId(long categoryId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchMailingListException;

    public void removeByActive(boolean active)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.SystemException;

    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.SystemException;

    public int countByCategoryId(long categoryId)
        throws com.liferay.portal.SystemException;

    public int countByActive(boolean active)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
