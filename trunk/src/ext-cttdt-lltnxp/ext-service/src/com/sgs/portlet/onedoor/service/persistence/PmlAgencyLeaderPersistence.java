package com.sgs.portlet.onedoor.service.persistence;

public interface PmlAgencyLeaderPersistence {
    public com.sgs.portlet.onedoor.model.PmlAgencyLeader create(
        java.lang.String agencyId);

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader remove(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader remove(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlAgencyLeader pmlAgencyLeader, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlAgencyLeader update(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlAgencyLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlAgencyLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.onedoor.model.PmlAgencyLeader update(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader updateImpl(
        com.sgs.portlet.onedoor.model.PmlAgencyLeader pmlAgencyLeader,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader findByPrimaryKey(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader fetchByPrimaryKey(
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException;

    public com.sgs.portlet.onedoor.model.PmlAgencyLeader[] findByUserId_PrevAndNext(
        java.lang.String agencyId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlAgencyLeaderException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlAgencyLeader> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
