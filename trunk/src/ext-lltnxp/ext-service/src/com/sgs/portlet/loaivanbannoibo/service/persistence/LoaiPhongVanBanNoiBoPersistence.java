package com.sgs.portlet.loaivanbannoibo.service.persistence;

public interface LoaiPhongVanBanNoiBoPersistence {
    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo create(
        com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK);

    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo remove(
        com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchLoaiPhongVanBanNoiBoException;

    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo remove(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo, boolean merge)</code>.
     */
    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiPhongVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiPhongVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo findByPrimaryKey(
        com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchLoaiPhongVanBanNoiBoException;

    public com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo fetchByPrimaryKey(
        com.sgs.portlet.loaivanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiPhongVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
