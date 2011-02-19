package com.sgs.portlet.loaivanbannoibo.service.persistence;

public class SoLoaiVanBanNoiBoUtil {
    private static SoLoaiVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo create(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK) {
        return getPersistence().create(soLoaiVanBanNoiBoPK);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo remove(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence().remove(soLoaiVanBanNoiBoPK);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo remove(
        com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(soLoaiVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(soLoaiVanBanNoiBo);
    }

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
    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(soLoaiVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo soLoaiVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(soLoaiVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo findByPrimaryKey(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchSoLoaiVanBanNoiBoException {
        return getPersistence().findByPrimaryKey(soLoaiVanBanNoiBoPK);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo fetchByPrimaryKey(
        com.sgs.portlet.loaivanbannoibo.service.persistence.SoLoaiVanBanNoiBoPK soLoaiVanBanNoiBoPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(soLoaiVanBanNoiBoPK);
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

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoLoaiVanBanNoiBo> findAll(
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

    public static SoLoaiVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(SoLoaiVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
