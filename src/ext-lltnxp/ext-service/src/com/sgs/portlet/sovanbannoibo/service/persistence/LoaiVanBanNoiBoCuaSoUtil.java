package com.sgs.portlet.sovanbannoibo.service.persistence;

public class LoaiVanBanNoiBoCuaSoUtil {
    private static LoaiVanBanNoiBoCuaSoPersistence _persistence;

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo create(
        long loaiVanBanNoiBoId) {
        return getPersistence().create(loaiVanBanNoiBoId);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo remove(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchLoaiVanBanNoiBoCuaSoException {
        return getPersistence().remove(loaiVanBanNoiBoId);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo remove(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(loaiVanBanNoiBoCuaSo);
    }

    /**
     * @deprecated Use <code>update(LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo, boolean merge)</code>.
     */
    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo update(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiVanBanNoiBoCuaSo);
    }

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
    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo update(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiVanBanNoiBoCuaSo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo updateImpl(
        com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo loaiVanBanNoiBoCuaSo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(loaiVanBanNoiBoCuaSo, merge);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo findByPrimaryKey(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.sovanbannoibo.NoSuchLoaiVanBanNoiBoCuaSoException {
        return getPersistence().findByPrimaryKey(loaiVanBanNoiBoId);
    }

    public static com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo fetchByPrimaryKey(
        long loaiVanBanNoiBoId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(loaiVanBanNoiBoId);
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

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo> findAll(
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

    public static LoaiVanBanNoiBoCuaSoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LoaiVanBanNoiBoCuaSoPersistence persistence) {
        _persistence = persistence;
    }
}
