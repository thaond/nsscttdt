package com.sgs.portlet.report_registry_work.service.persistence;

public interface ResultProgramPersistence {
    public com.sgs.portlet.report_registry_work.model.ResultProgram create(
        long resultProgramId);

    public com.sgs.portlet.report_registry_work.model.ResultProgram remove(
        long resultProgramId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchResultProgramException;

    public com.sgs.portlet.report_registry_work.model.ResultProgram remove(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ResultProgram resultProgram, boolean merge)</code>.
     */
    public com.sgs.portlet.report_registry_work.model.ResultProgram update(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                resultProgram the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when resultProgram is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.report_registry_work.model.ResultProgram update(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ResultProgram updateImpl(
        com.sgs.portlet.report_registry_work.model.ResultProgram resultProgram,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.report_registry_work.model.ResultProgram findByPrimaryKey(
        long resultProgramId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.report_registry_work.NoSuchResultProgramException;

    public com.sgs.portlet.report_registry_work.model.ResultProgram fetchByPrimaryKey(
        long resultProgramId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ResultProgram> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ResultProgram> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.report_registry_work.model.ResultProgram> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
