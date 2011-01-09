package com.sgs.portlet.report_registry_work.service.persistence;

public interface DepartmentPersistence {
    public com.sgs.portlet.report_registry_work.model.Department create(
        long departmentId);

    public com.sgs.portlet.report_registry_work.model.Department remove(
        long departmentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchDepartmentException;

    public com.sgs.portlet.report_registry_work.model.Department remove(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Department department, boolean merge)</code>.
     */
    public com.sgs.portlet.report_registry_work.model.Department update(
        com.sgs.portlet.report_registry_work.model.Department department)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.report_registry_work.model.Department update(
        com.sgs.portlet.report_registry_work.model.Department department,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.Department updateImpl(
        com.sgs.portlet.report_registry_work.model.Department department,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.Department findByPrimaryKey(
        long departmentId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchDepartmentException;

    public com.sgs.portlet.report_registry_work.model.Department fetchByPrimaryKey(
        long departmentId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.Department> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.Department> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.Department> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> getReportRegistries(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int getReportRegistriesSize(long pk)
        throws com.liferay.portal.SystemException;

    public boolean containsReportRegistry(long pk, long reportRegistryPK)
        throws com.liferay.portal.SystemException;

    public boolean containsReportRegistries(long pk)
        throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
