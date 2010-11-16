package com.nss.portlet.qa_chu_de.service.persistence;

public class QAChuDeCauHoiUtil {
    private static QAChuDeCauHoiPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi) {
        getPersistence().cacheResult(qaChuDeCauHoi);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> qaChuDeCauHois) {
        getPersistence().cacheResult(qaChuDeCauHois);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi create(
        long maChuDeCauHoi) {
        return getPersistence().create(maChuDeCauHoi);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi remove(
        long maChuDeCauHoi)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException {
        return getPersistence().remove(maChuDeCauHoi);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi remove(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(qaChuDeCauHoi);
    }

    /**
     * @deprecated Use <code>update(QAChuDeCauHoi qaChuDeCauHoi, boolean merge)</code>.
     */
    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi update(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(qaChuDeCauHoi);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                qaChuDeCauHoi the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when qaChuDeCauHoi is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi update(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(qaChuDeCauHoi, merge);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi updateImpl(
        com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi qaChuDeCauHoi,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(qaChuDeCauHoi, merge);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi findByPrimaryKey(
        long maChuDeCauHoi)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException {
        return getPersistence().findByPrimaryKey(maChuDeCauHoi);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi fetchByPrimaryKey(
        long maChuDeCauHoi) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maChuDeCauHoi);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findByActive(
        int active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findByActive(
        int active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findByActive(
        int active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi findByActive_First(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi findByActive_Last(
        int active, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi[] findByActive_PrevAndNext(
        long maChuDeCauHoi, int active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_chu_de.NoSuchQAChuDeCauHoiException {
        return getPersistence()
                   .findByActive_PrevAndNext(maChuDeCauHoi, active, obc);
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

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByActive(int active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByActive(int active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static QAChuDeCauHoiPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(QAChuDeCauHoiPersistence persistence) {
        _persistence = persistence;
    }
}
