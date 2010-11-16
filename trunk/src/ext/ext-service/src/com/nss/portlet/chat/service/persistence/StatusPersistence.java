package com.nss.portlet.chat.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface StatusPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.chat.model.Status status);

    public void cacheResult(
        java.util.List<com.nss.portlet.chat.model.Status> statuses);

    public void clearCache();

    public com.nss.portlet.chat.model.Status create(long statusId);

    public com.nss.portlet.chat.model.Status remove(long statusId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status remove(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Status status, boolean merge)</code>.
     */
    public com.nss.portlet.chat.model.Status update(
        com.nss.portlet.chat.model.Status status)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.chat.model.Status update(
        com.nss.portlet.chat.model.Status status, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status updateImpl(
        com.nss.portlet.chat.model.Status status, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status findByPrimaryKey(long statusId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status fetchByPrimaryKey(long statusId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status findByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status fetchByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status fetchByUserId(long userId,
        boolean retrieveFromCache) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByModifiedDate(
        long modifiedDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByModifiedDate(
        long modifiedDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByModifiedDate(
        long modifiedDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status findByModifiedDate_First(
        long modifiedDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status findByModifiedDate_Last(
        long modifiedDate, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status[] findByModifiedDate_PrevAndNext(
        long statusId, long modifiedDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByOnline(
        boolean online) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByOnline(
        boolean online, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByOnline(
        boolean online, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status findByOnline_First(
        boolean online, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status findByOnline_Last(boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status[] findByOnline_PrevAndNext(
        long statusId, boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByM_O(
        long modifiedDate, boolean online)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByM_O(
        long modifiedDate, boolean online, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findByM_O(
        long modifiedDate, boolean online, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.chat.model.Status findByM_O_First(
        long modifiedDate, boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status findByM_O_Last(long modifiedDate,
        boolean online, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public com.nss.portlet.chat.model.Status[] findByM_O_PrevAndNext(
        long statusId, long modifiedDate, boolean online,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.chat.model.Status> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.chat.NoSuchStatusException;

    public void removeByModifiedDate(long modifiedDate)
        throws com.liferay.portal.SystemException;

    public void removeByOnline(boolean online)
        throws com.liferay.portal.SystemException;

    public void removeByM_O(long modifiedDate, boolean online)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByModifiedDate(long modifiedDate)
        throws com.liferay.portal.SystemException;

    public int countByOnline(boolean online)
        throws com.liferay.portal.SystemException;

    public int countByM_O(long modifiedDate, boolean online)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
