package com.sgs.portlet.loaivanbannoibo.service.persistence;

public class SoVanBanNoiBoUtil {
    private static SoVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo create(
        long soVanBanNoiBoId) {
        return getPersistence().create(soVanBanNoiBoId);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo remove(
        long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchSoVanBanNoiBoException {
        return getPersistence().remove(soVanBanNoiBoId);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo remove(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(soVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(SoVanBanNoiBo soVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(soVanBanNoiBo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                soVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when soVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo update(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(soVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo updateImpl(
        com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo soVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(soVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo findByPrimaryKey(
        long soVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.loaivanbannoibo.NoSuchSoVanBanNoiBoException {
        return getPersistence().findByPrimaryKey(soVanBanNoiBoId);
    }

    public static com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo fetchByPrimaryKey(
        long soVanBanNoiBoId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(soVanBanNoiBoId);
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

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.loaivanbannoibo.model.SoVanBanNoiBo> findAll(
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

    public static SoVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(SoVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
