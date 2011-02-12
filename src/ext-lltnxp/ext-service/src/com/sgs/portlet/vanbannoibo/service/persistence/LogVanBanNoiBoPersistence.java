package com.sgs.portlet.vanbannoibo.service.persistence;

public interface LogVanBanNoiBoPersistence {
    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo create(
        long logVanBanNoiBoId);

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo remove(
        long logVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchLogVanBanNoiBoException;

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo remove(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LogVanBanNoiBo logVanBanNoiBo, boolean merge)</code>.
     */
    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                logVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when logVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo findByPrimaryKey(
        long logVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchLogVanBanNoiBoException;

    public com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo fetchByPrimaryKey(
        long logVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
