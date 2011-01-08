package com.sgs.portlet.report_registry_work.service.persistence;

public interface ReportRegistryPersistence {
    public com.sgs.portlet.report_registry_work.model.ReportRegistry create(
        ReportRegistryPK reportRegistryPK);

    public com.sgs.portlet.report_registry_work.model.ReportRegistry remove(
        ReportRegistryPK reportRegistryPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry remove(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ReportRegistry reportRegistry, boolean merge)</code>.
     */
    public com.sgs.portlet.report_registry_work.model.ReportRegistry update(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.report_registry_work.model.ReportRegistry update(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry updateImpl(
        com.sgs.portlet.report_registry_work.model.ReportRegistry reportRegistry,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry findByPrimaryKey(
        ReportRegistryPK reportRegistryPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry fetchByPrimaryKey(
        ReportRegistryPK reportRegistryPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByReportRegistryId(
        long reportRegistryId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByReportRegistryId(
        long reportRegistryId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findByReportRegistryId(
        long reportRegistryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry findByReportRegistryId_First(
        long reportRegistryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry findByReportRegistryId_Last(
        long reportRegistryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException;

    public com.sgs.portlet.report_registry_work.model.ReportRegistry[] findByReportRegistryId_PrevAndNext(
        ReportRegistryPK reportRegistryPK, long reportRegistryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchReportRegistryException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ReportRegistry> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByReportRegistryId(long reportRegistryId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByReportRegistryId(long reportRegistryId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
