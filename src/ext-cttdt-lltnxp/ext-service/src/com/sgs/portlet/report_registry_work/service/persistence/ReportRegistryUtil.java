package com.sgs.portlet.report_registry_work.service.persistence;

public class ReportRegistryUtil {
    private static ReportRegistryPersistence _persistence;

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry create(
        ReportRegistryPK reportRegistryPK) {
        return getPersistence().create(reportRegistryPK);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry remove(
        ReportRegistryPK reportRegistryPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException {
        return getPersistence().remove(reportRegistryPK);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry remove(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(reportRegistry);
    }

    /**
     * @deprecated Use <code>update(ReportRegistry reportRegistry, boolean merge)</code>.
     */
    public static com.sgs.portlet.report_registry_work.model.ReportRegistry update(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(reportRegistry);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                reportRegistry the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when reportRegistry is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.report_registry_work.model.ReportRegistry update(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(reportRegistry, merge);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry updateImpl(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(reportRegistry, merge);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry findByPrimaryKey(
        ReportRegistryPK reportRegistryPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException {
        return getPersistence().findByPrimaryKey(reportRegistryPK);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry fetchByPrimaryKey(
        ReportRegistryPK reportRegistryPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(reportRegistryPK);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByReportRegistryId(
        long reportRegistryId) throws com.liferay.portal.SystemException {
        return getPersistence().findByReportRegistryId(reportRegistryId);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByReportRegistryId(
        long reportRegistryId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReportRegistryId(reportRegistryId, start, end);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByReportRegistryId(
        long reportRegistryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReportRegistryId(reportRegistryId, start, end, obc);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry findByReportRegistryId_First(
        long reportRegistryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException {
        return getPersistence()
                   .findByReportRegistryId_First(reportRegistryId, obc);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry findByReportRegistryId_Last(
        long reportRegistryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException {
        return getPersistence()
                   .findByReportRegistryId_Last(reportRegistryId, obc);
    }

    public static com.sgs.portlet.report_registry_work.model.ReportRegistry[] findByReportRegistryId_PrevAndNext(
        ReportRegistryPK reportRegistryPK, long reportRegistryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException {
        return getPersistence()
                   .findByReportRegistryId_PrevAndNext(reportRegistryPK,
            reportRegistryId, obc);
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

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByReportRegistryId(long reportRegistryId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByReportRegistryId(reportRegistryId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByReportRegistryId(long reportRegistryId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByReportRegistryId(reportRegistryId);
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

    public static ReportRegistryPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ReportRegistryPersistence persistence) {
        _persistence = persistence;
    }
}