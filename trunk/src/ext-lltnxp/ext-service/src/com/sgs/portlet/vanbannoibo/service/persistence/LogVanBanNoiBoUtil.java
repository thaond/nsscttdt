package com.sgs.portlet.vanbannoibo.service.persistence;

public class LogVanBanNoiBoUtil {
    private static LogVanBanNoiBoPersistence _persistence;

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo create(
        long logVanBanNoiBoId) {
        return getPersistence().create(logVanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo remove(
        long logVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchLogVanBanNoiBoException {
        return getPersistence().remove(logVanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo remove(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(logVanBanNoiBo);
    }

    /**
     * @deprecated Use <code>update(LogVanBanNoiBo logVanBanNoiBo, boolean merge)</code>.
     */
    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(logVanBanNoiBo);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                logVanBanNoiBo the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when logVanBanNoiBo is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo update(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(logVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo updateImpl(
        com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo logVanBanNoiBo,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(logVanBanNoiBo, merge);
    }

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo findByPrimaryKey(
        long logVanBanNoiBoId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.vanbannoibo.NoSuchLogVanBanNoiBoException {
        return getPersistence().findByPrimaryKey(logVanBanNoiBoId);
    }

    public static com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo fetchByPrimaryKey(
        long logVanBanNoiBoId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(logVanBanNoiBoId);
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

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.vanbannoibo.model.LogVanBanNoiBo> findAll(
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

    public static LogVanBanNoiBoPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(LogVanBanNoiBoPersistence persistence) {
        _persistence = persistence;
    }
}
