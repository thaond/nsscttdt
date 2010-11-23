package com.nss.portlet.journalworkflow.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface JournalProcessDefinitionPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition);

    public void cacheResult(
        java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> journalProcessDefinitions);

    public void clearCache();

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition create(
        long journalProcessDefinitionId);

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition remove(
        long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchJournalProcessDefinitionException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition remove(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(JournalProcessDefinition journalProcessDefinition, boolean merge)</code>.
     */
    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition update(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                journalProcessDefinition the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when journalProcessDefinition is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition update(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition updateImpl(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition findByPrimaryKey(
        long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchJournalProcessDefinitionException;

    public com.nss.portlet.journalworkflow.model.JournalProcessDefinition fetchByPrimaryKey(
        long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
