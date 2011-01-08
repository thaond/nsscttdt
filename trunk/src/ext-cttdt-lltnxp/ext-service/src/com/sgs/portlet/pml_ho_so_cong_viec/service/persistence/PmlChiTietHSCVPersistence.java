package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public interface PmlChiTietHSCVPersistence {
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV create(
        long idChiTietHSCV);

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV remove(
        long idChiTietHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV remove(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlChiTietHSCV pmlChiTietHSCV, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlChiTietHSCV the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlChiTietHSCV is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV updateImpl(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByPrimaryKey(
        long idChiTietHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV fetchByPrimaryKey(
        long idChiTietHSCV) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdHoSoCongViec(
        long idHoSoCongViec) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdHoSoCongViec(
        long idHoSoCongViec, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdHoSoCongViec(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdHoSoCongViec_First(
        long idHoSoCongViec,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdHoSoCongViec_Last(
        long idHoSoCongViec,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV[] findByIdHoSoCongViec_PrevAndNext(
        long idChiTietHSCV, long idHoSoCongViec,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByH_DEN(
        long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV fetchByH_DEN(
        long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByH_DI(
        long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV fetchByH_DI(
        long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDen_First(
        long idCongVanDen, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDen_Last(
        long idCongVanDen, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV[] findByIdCongVanDen_PrevAndNext(
        long idChiTietHSCV, long idCongVanDen,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDi_First(
        long idCongVanDi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDi_Last(
        long idCongVanDi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV[] findByIdCongVanDi_PrevAndNext(
        long idChiTietHSCV, long idCongVanDi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByIdHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.SystemException;

    public void removeByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public void removeByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException;

    public void removeByIdCongVanDen(long idCongVanDen)
        throws com.liferay.portal.SystemException;

    public void removeByIdCongVanDi(long idCongVanDi)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByIdHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.SystemException;

    public int countByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException;

    public int countByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException;

    public int countByIdCongVanDen(long idCongVanDen)
        throws com.liferay.portal.SystemException;

    public int countByIdCongVanDi(long idCongVanDi)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
