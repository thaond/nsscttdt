package com.sgs.portlet.sovanbannoibo.service.persistence;

public interface SoLoaiVanBanNoiBoPersistence {
    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo create(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK);

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo, boolean merge)</code>.
     */
    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soLoaiVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soLoaiVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo fetchByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_First(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_Last(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo[] findBySoVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK,
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findByLoaiVanBanNoiBo(
        long loaiVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findByLoaiVanBanNoiBo_First(
        long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findByLoaiVanBanNoiBo_Last(
        long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo[] findByLoaiVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK,
        long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findBySoVanBanNoiBo_LoaiVanBanNoiBo(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_LoaiVanBanNoiBo_First(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo findBySoVanBanNoiBo_LoaiVanBanNoiBo_Last(
        long soVanBanNoiBoId, long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo[] findBySoVanBanNoiBo_LoaiVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK,
        long soVanBanNoiBoId, long loaiVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoLoaiVanBanNoiBoException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public void removeByLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public void removeBySoVanBanNoiBo_LoaiVanBanNoiBo(long soVanBanNoiBoId,
        long loaiVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public int countByLoaiVanBanNoiBo(long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public int countBySoVanBanNoiBo_LoaiVanBanNoiBo(long soVanBanNoiBoId,
        long loaiVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
