package com.sgs.portlet.pml_trang_thai_hscv.service.persistence;

public class PmlTrangThaiHSCVUtil {
    private static PmlTrangThaiHSCVPersistence _persistence;

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV create(
        long idTrangThaiHSCV) {
        return getPersistence().create(idTrangThaiHSCV);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV remove(
        long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException {
        return getPersistence().remove(idTrangThaiHSCV);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV remove(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlTrangThaiHSCV);
    }

    /**
     * @deprecated Use <code>update(PmlTrangThaiHSCV pmlTrangThaiHSCV, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV update(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTrangThaiHSCV);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTrangThaiHSCV the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTrangThaiHSCV is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV update(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTrangThaiHSCV, merge);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV updateImpl(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlTrangThaiHSCV, merge);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV findByPrimaryKey(
        long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException {
        return getPersistence().findByPrimaryKey(idTrangThaiHSCV);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV fetchByPrimaryKey(
        long idTrangThaiHSCV) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(idTrangThaiHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTenTrangThaiHSCV(tenTrangThaiHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByTenTrangThaiHSCV(tenTrangThaiHSCV, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByTenTrangThaiHSCV(tenTrangThaiHSCV, start, end, obc);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV findByTenTrangThaiHSCV_First(
        java.lang.String tenTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException {
        return getPersistence()
                   .findByTenTrangThaiHSCV_First(tenTrangThaiHSCV, obc);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV findByTenTrangThaiHSCV_Last(
        java.lang.String tenTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException {
        return getPersistence()
                   .findByTenTrangThaiHSCV_Last(tenTrangThaiHSCV, obc);
    }

    public static com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV[] findByTenTrangThaiHSCV_PrevAndNext(
        long idTrangThaiHSCV, java.lang.String tenTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException {
        return getPersistence()
                   .findByTenTrangThaiHSCV_PrevAndNext(idTrangThaiHSCV,
            tenTrangThaiHSCV, obc);
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

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByTenTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTenTrangThaiHSCV(tenTrangThaiHSCV);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByTenTrangThaiHSCV(java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTenTrangThaiHSCV(tenTrangThaiHSCV);
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

    public static PmlTrangThaiHSCVPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlTrangThaiHSCVPersistence persistence) {
        _persistence = persistence;
    }
}
