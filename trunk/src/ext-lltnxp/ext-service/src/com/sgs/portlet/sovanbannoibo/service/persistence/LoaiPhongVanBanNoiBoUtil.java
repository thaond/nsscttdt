package com.sgs.portlet.sovanbannoibo.service.persistence;

public class LoaiPhongVanBanNoiBoUtil {
    private static LoaiPhongVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo create(
        com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK) {
        return getPersistence().create(loaiPhongVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchLoaiPhongVanBanNoiBoException {
        return getPersistence().remove(loaiPhongVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo remove(
        com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(loaiPhongVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiPhongVanBanNoiBo);
    }

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
    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo update(
        com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiPhongVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo loaiPhongVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(loaiPhongVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo findByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchLoaiPhongVanBanNoiBoException {
        return getPersistence().findByPrimaryKey(loaiPhongVanBanNoiBoPK);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo fetchByPrimaryKey(
        com.sgs.portlet.sovanbannoibo.service.persistence.LoaiPhongVanBanNoiBoPK loaiPhongVanBanNoiBoPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(loaiPhongVanBanNoiBoPK);
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

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiPhongVanBanNoiBo> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
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

    public static LoaiPhongVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LoaiPhongVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
