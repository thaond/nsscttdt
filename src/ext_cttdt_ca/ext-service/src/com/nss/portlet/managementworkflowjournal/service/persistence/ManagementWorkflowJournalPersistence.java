package com.nss.portlet.managementworkflowjournal.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface ManagementWorkflowJournalPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal);

    public void cacheResult(
        java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> managementWorkflowJournals);

    public void clearCache();

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal create(
        long managementWorkflowJournalId);

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal remove(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal remove(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ManagementWorkflowJournal managementWorkflowJournal, boolean merge)</code>.
     */
    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal update(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                managementWorkflowJournal the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when managementWorkflowJournal is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal update(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal updateImpl(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal findByPrimaryKey(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal fetchByPrimaryKey(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal findByWorkflowname_Version(
        java.lang.String workflowname, int version_)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal fetchByWorkflowname_Version(
        java.lang.String workflowname, int version_)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal fetchByWorkflowname_Version(
        java.lang.String workflowname, int version_, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByWorkflowname_Version(java.lang.String workflowname,
        int version_)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByWorkflowname_Version(java.lang.String workflowname,
        int version_) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
