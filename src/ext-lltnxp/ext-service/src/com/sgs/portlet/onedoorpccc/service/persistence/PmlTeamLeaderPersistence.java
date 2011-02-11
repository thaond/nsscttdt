package com.sgs.portlet.onedoorpccc.service.persistence;

public interface PmlTeamLeaderPersistence {
    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader create(long teamId);

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader remove(long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException;

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader remove(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlTeamLeader pmlTeamLeader, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader update(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTeamLeader the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTeamLeader is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader update(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader updateImpl(
        com.sgs.portlet.onedoorpccc.model.PmlTeamLeader pmlTeamLeader,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader findByPrimaryKey(
        long teamId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException;

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader fetchByPrimaryKey(
        long teamId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException;

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException;

    public com.sgs.portlet.onedoorpccc.model.PmlTeamLeader[] findByUserId_PrevAndNext(
        long teamId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoorpccc.NoSuchPmlTeamLeaderException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoorpccc.model.PmlTeamLeader> findAll(
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
