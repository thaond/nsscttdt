package com.sgs.portlet.report_registry_work.service.persistence;

public class DepartmentUtil {
    private static DepartmentPersistence _persistence;

    public static com.sgs.portlet.report_registry_work.model.Department create(
        long departmentId) {
        return getPersistence().create(departmentId);
    }

    public static com.sgs.portlet.report_registry_work.model.Department remove(
        long departmentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchDepartmentException {
        return getPersistence().remove(departmentId);
    }

    public static com.sgs.portlet.report_registry_work.model.Department remove(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(department);
    }

    /**
     * @deprecated Use <code>update(Department department, boolean merge)</code>.
     */
    public static com.sgs.portlet.report_registry_work.model.Department update(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(department);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                department the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when department is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.report_registry_work.model.Department update(
        com.sgs.portlet.report_registry_work.model.Department department,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(department, merge);
    }

    public static com.sgs.portlet.report_registry_work.model.Department updateImpl(
        com.sgs.portlet.report_registry_work.model.Department department,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(department, merge);
    }

    public static com.sgs.portlet.report_registry_work.model.Department findByPrimaryKey(
        long departmentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchDepartmentException {
        return getPersistence().findByPrimaryKey(departmentId);
    }

    public static com.sgs.portlet.report_registry_work.model.Department fetchByPrimaryKey(
        long departmentId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(departmentId);
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

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.Department> findAll(
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

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk) throws com.liferay.portal.SystemException {
        return getPersistence().getReportRegistries(pk);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().getReportRegistries(pk, start, end);
    }

    public static java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().getReportRegistries(pk, start, end, obc);
    }

    public static int getReportRegistriesSize(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().getReportRegistriesSize(pk);
    }

    public static boolean containsReportRegistry(long pk, long reportRegistryPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsReportRegistry(pk, reportRegistryPK);
    }

    public static boolean containsReportRegistries(long pk)
        throws com.liferay.portal.SystemException {
        return getPersistence().containsReportRegistries(pk);
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static DepartmentPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(DepartmentPersistence persistence) {
        _persistence = persistence;
    }
}
