package com.sgs.portlet.sovanbannoibo.service.persistence;

public interface SoVanBanNoiBoPersistence {
    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo create(
        long soVanBanNoiBoId);

    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo remove(
        long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchException;

    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(SoVanBanNoiBo soVanBanNoiBo, boolean merge)</code>.
     */
    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo findByPrimaryKey(
        long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchException;

    public com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo fetchByPrimaryKey(
        long soVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
