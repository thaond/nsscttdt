package com.sgs.portlet.sovanbannoibo.service.persistence;

public interface LoaiVanBanNoiBoCuaSoPersistence {
    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo create(
        long loaiVanBanNoiBoId);

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo remove(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchLoaiVanBanNoiBoCuaSoException;

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo remove(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo, boolean merge)</code>.
     */
    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo update(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiVanBanNoiBoCuaSo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiVanBanNoiBoCuaSo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo update(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo findByPrimaryKey(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchLoaiVanBanNoiBoCuaSoException;

    public com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo fetchByPrimaryKey(
        long loaiVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
