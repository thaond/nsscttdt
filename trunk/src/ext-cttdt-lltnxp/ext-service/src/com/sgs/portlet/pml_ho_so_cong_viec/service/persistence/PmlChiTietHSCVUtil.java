package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public class PmlChiTietHSCVUtil {
    private static PmlChiTietHSCVPersistence _persistence;

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV create(
        long idChiTietHSCV) {
        return getPersistence().create(idChiTietHSCV);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV remove(
        long idChiTietHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().remove(idChiTietHSCV);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV remove(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlChiTietHSCV);
    }

    /**
     * @deprecated Use <code>update(PmlChiTietHSCV pmlChiTietHSCV, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlChiTietHSCV);
    }

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
    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlChiTietHSCV, merge);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV updateImpl(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV pmlChiTietHSCV,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlChiTietHSCV, merge);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByPrimaryKey(
        long idChiTietHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByPrimaryKey(idChiTietHSCV);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV fetchByPrimaryKey(
        long idChiTietHSCV) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(idChiTietHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdHoSoCongViec(
        long idHoSoCongViec) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdHoSoCongViec(idHoSoCongViec);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdHoSoCongViec(
        long idHoSoCongViec, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdHoSoCongViec(idHoSoCongViec, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdHoSoCongViec(
        long idHoSoCongViec, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIdHoSoCongViec(idHoSoCongViec, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdHoSoCongViec_First(
        long idHoSoCongViec,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByIdHoSoCongViec_First(idHoSoCongViec, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdHoSoCongViec_Last(
        long idHoSoCongViec,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByIdHoSoCongViec_Last(idHoSoCongViec, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV[] findByIdHoSoCongViec_PrevAndNext(
        long idChiTietHSCV, long idHoSoCongViec,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence()
                   .findByIdHoSoCongViec_PrevAndNext(idChiTietHSCV,
            idHoSoCongViec, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByH_DEN(
        long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByH_DEN(idHoSoCongViec, idCongVanDen);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV fetchByH_DEN(
        long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByH_DEN(idHoSoCongViec, idCongVanDen);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByH_DI(
        long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByH_DI(idHoSoCongViec, idCongVanDi);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV fetchByH_DI(
        long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByH_DI(idHoSoCongViec, idCongVanDi);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdCongVanDen(idCongVanDen);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdCongVanDen(idCongVanDen, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDen(
        long idCongVanDen, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdCongVanDen(idCongVanDen, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDen_First(
        long idCongVanDen, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByIdCongVanDen_First(idCongVanDen, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDen_Last(
        long idCongVanDen, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByIdCongVanDen_Last(idCongVanDen, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV[] findByIdCongVanDen_PrevAndNext(
        long idChiTietHSCV, long idCongVanDen,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence()
                   .findByIdCongVanDen_PrevAndNext(idChiTietHSCV, idCongVanDen,
            obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdCongVanDi(idCongVanDi);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdCongVanDi(idCongVanDi, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findByIdCongVanDi(
        long idCongVanDi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdCongVanDi(idCongVanDi, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDi_First(
        long idCongVanDi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByIdCongVanDi_First(idCongVanDi, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV findByIdCongVanDi_Last(
        long idCongVanDi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence().findByIdCongVanDi_Last(idCongVanDi, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV[] findByIdCongVanDi_PrevAndNext(
        long idChiTietHSCV, long idCongVanDi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        return getPersistence()
                   .findByIdCongVanDi_PrevAndNext(idChiTietHSCV, idCongVanDi,
            obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlChiTietHSCV> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByIdHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdHoSoCongViec(idHoSoCongViec);
    }

    public static void removeByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        getPersistence().removeByH_DEN(idHoSoCongViec, idCongVanDen);
    }

    public static void removeByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlChiTietHSCVException {
        getPersistence().removeByH_DI(idHoSoCongViec, idCongVanDi);
    }

    public static void removeByIdCongVanDen(long idCongVanDen)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdCongVanDen(idCongVanDen);
    }

    public static void removeByIdCongVanDi(long idCongVanDi)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdCongVanDi(idCongVanDi);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByIdHoSoCongViec(long idHoSoCongViec)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdHoSoCongViec(idHoSoCongViec);
    }

    public static int countByH_DEN(long idHoSoCongViec, long idCongVanDen)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByH_DEN(idHoSoCongViec, idCongVanDen);
    }

    public static int countByH_DI(long idHoSoCongViec, long idCongVanDi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByH_DI(idHoSoCongViec, idCongVanDi);
    }

    public static int countByIdCongVanDen(long idCongVanDen)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdCongVanDen(idCongVanDen);
    }

    public static int countByIdCongVanDi(long idCongVanDi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdCongVanDi(idCongVanDi);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlChiTietHSCVPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlChiTietHSCVPersistence persistence) {
        _persistence = persistence;
    }
}
