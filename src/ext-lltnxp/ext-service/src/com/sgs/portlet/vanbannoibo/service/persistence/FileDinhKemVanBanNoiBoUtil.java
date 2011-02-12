package com.sgs.portlet.vanbannoibo.service.persistence;

public class FileDinhKemVanBanNoiBoUtil {
    private static FileDinhKemVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo create(
        long fileDinhKemVanBanNoiBoId) {
        return getPersistence().create(fileDinhKemVanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo remove(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchFileDinhKemVanBanNoiBoException {
        return getPersistence().remove(fileDinhKemVanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo remove(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(fileDinhKemVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKemVanBanNoiBo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                fileDinhKemVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when fileDinhKemVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(fileDinhKemVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fileDinhKemVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(fileDinhKemVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo findByPrimaryKey(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchFileDinhKemVanBanNoiBoException {
        return getPersistence().findByPrimaryKey(fileDinhKemVanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo fetchByPrimaryKey(
        long fileDinhKemVanBanNoiBoId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileDinhKemVanBanNoiBoId);
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

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo> findAll(
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

    public static FileDinhKemVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(FileDinhKemVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
