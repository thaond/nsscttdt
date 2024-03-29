package com.liferay.portlet.messageboards.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface MBThreadPersistence extends BasePersistence {
    public void cacheResult(
        com.liferay.portlet.messageboards.model.MBThread mbThread);

    public void cacheResult(
        java.util.List<com.liferay.portlet.messageboards.model.MBThread> mbThreads);

    public void clearCache();

    public com.liferay.portlet.messageboards.model.MBThread create(
        long threadId);

    public com.liferay.portlet.messageboards.model.MBThread remove(
        long threadId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread remove(
        com.liferay.portlet.messageboards.model.MBThread mbThread)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(MBThread mbThread, boolean merge)</code>.
     */
    public com.liferay.portlet.messageboards.model.MBThread update(
        com.liferay.portlet.messageboards.model.MBThread mbThread)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                mbThread the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when mbThread is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.liferay.portlet.messageboards.model.MBThread update(
        com.liferay.portlet.messageboards.model.MBThread mbThread, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBThread updateImpl(
        com.liferay.portlet.messageboards.model.MBThread mbThread, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBThread findByPrimaryKey(
        long threadId)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread fetchByPrimaryKey(
        long threadId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByGroupId(
        long groupId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByGroupId(
        long groupId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByGroupId(
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBThread findByGroupId_First(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread findByGroupId_Last(
        long groupId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread[] findByGroupId_PrevAndNext(
        long threadId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByCategoryId(
        long categoryId) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByCategoryId(
        long categoryId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByCategoryId(
        long categoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBThread findByCategoryId_First(
        long categoryId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread findByCategoryId_Last(
        long categoryId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread[] findByCategoryId_PrevAndNext(
        long threadId, long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByC_L(
        long categoryId, java.util.Date lastPostDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByC_L(
        long categoryId, java.util.Date lastPostDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findByC_L(
        long categoryId, java.util.Date lastPostDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.liferay.portlet.messageboards.model.MBThread findByC_L_First(
        long categoryId, java.util.Date lastPostDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread findByC_L_Last(
        long categoryId, java.util.Date lastPostDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public com.liferay.portlet.messageboards.model.MBThread[] findByC_L_PrevAndNext(
        long threadId, long categoryId, java.util.Date lastPostDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.liferay.portlet.messageboards.NoSuchThreadException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.liferay.portlet.messageboards.model.MBThread> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public void removeByCategoryId(long categoryId)
        throws com.liferay.portal.SystemException;

    public void removeByC_L(long categoryId, java.util.Date lastPostDate)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByGroupId(long groupId)
        throws com.liferay.portal.SystemException;

    public int countByCategoryId(long categoryId)
        throws com.liferay.portal.SystemException;

    public int countByC_L(long categoryId, java.util.Date lastPostDate)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
