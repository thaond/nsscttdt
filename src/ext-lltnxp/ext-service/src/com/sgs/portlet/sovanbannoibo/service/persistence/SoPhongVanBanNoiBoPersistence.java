package com.sgs.portlet.sovanbannoibo.service.persistence;

public interface SoPhongVanBanNoiBoPersistence {
    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo create(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK);

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(SoPhongVanBanNoiBo soPhongVanBanNoiBo, boolean merge)</code>.
     */
    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soPhongVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soPhongVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo soPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo fetchByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo(
        long soVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_First(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_Last(
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo[] findBySoVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK,
        long soVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findByPhongVanBanNoiBo(
        java.lang.String phongVanBanNoiBoId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findByPhongVanBanNoiBo_First(
        java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findByPhongVanBanNoiBo_Last(
        java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo[] findByPhongVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK,
        java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findBySoVanBanNoiBo_PhongVanBanNoiBo(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_PhongVanBanNoiBo_First(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo findBySoVanBanNoiBo_PhongVanBanNoiBo_Last(
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo[] findBySoVanBanNoiBo_PhongVanBanNoiBo_PrevAndNext(
        com.sgs.portlet.sovanbannoibo.service.persistence.SoPhongVanBanNoiBoPK soPhongVanBanNoiBoPK,
        long soVanBanNoiBoId, java.lang.String phongVanBanNoiBoId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchSoPhongVanBanNoiBoException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoPhongVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public void removeByPhongVanBanNoiBo(java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public void removeBySoVanBanNoiBo_PhongVanBanNoiBo(long soVanBanNoiBoId,
        java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countBySoVanBanNoiBo(long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public int countByPhongVanBanNoiBo(java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public int countBySoVanBanNoiBo_PhongVanBanNoiBo(long soVanBanNoiBoId,
        java.lang.String phongVanBanNoiBoId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
