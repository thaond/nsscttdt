package com.sgs.portlet.vanbannoibo.service.persistence;

public class VanBanNoiBoUtil {
    private static VanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo create(
        long vanBanNoiBoId) {
        return getPersistence().create(vanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo remove(
        long vanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchException {
        return getPersistence().remove(vanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo remove(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(vanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(VanBanNoiBo vanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(vanBanNoiBo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                vanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when vanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(vanBanNoiBo, merge);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.VanBanNoiBo vanBanNoiBo, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(vanBanNoiBo, merge);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo findByPrimaryKey(
        long vanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchException {
        return getPersistence().findByPrimaryKey(vanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.VanBanNoiBo fetchByPrimaryKey(
        long vanBanNoiBoId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(vanBanNoiBoId);
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

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.VanBanNoiBo> findAll(
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

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getFileDinhKemVanBanNoiBos(pk);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getFileDinhKemVanBanNoiBos(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getFileDinhKemVanBanNoiBos(pk, start, end, obc);
    }

    public static int getFileDinhKemVanBanNoiBosSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getFileDinhKemVanBanNoiBosSize(pk);
    }

    public static boolean containsFileDinhKemVanBanNoiBo(long pk,
        long fileDinhKemVanBanNoiBoPK)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .containsFileDinhKemVanBanNoiBo(pk, fileDinhKemVanBanNoiBoPK);
    }

    public static boolean containsFileDinhKemVanBanNoiBos(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsFileDinhKemVanBanNoiBos(pk);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static VanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(VanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
