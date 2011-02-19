package com.sgs.portlet.loaivanbannoibo.service.persistence;

public class LoaiVanBanNoiBoUtil {
    private static LoaiVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo create(
        long loaiVanBanNoiBoId) {
        return getPersistence().create(loaiVanBanNoiBoId);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo remove(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchException {
        return getPersistence().remove(loaiVanBanNoiBoId);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo remove(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(loaiVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(LoaiVanBanNoiBo loaiVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiVanBanNoiBo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                loaiVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when loaiVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(loaiVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo loaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(loaiVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo findByPrimaryKey(
        long loaiVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchException {
        return getPersistence().findByPrimaryKey(loaiVanBanNoiBoId);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo fetchByPrimaryKey(
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

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo> findAll(
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

    public static LoaiVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LoaiVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
