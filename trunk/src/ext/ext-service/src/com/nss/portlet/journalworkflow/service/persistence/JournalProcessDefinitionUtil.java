package com.nss.portlet.journalworkflow.service.persistence;

public class JournalProcessDefinitionUtil {
    private static JournalProcessDefinitionPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition) {
        getPersistence().cacheResult(journalProcessDefinition);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> journalProcessDefinitions) {
        getPersistence().cacheResult(journalProcessDefinitions);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition create(
        long journalProcessDefinitionId) {
        return getPersistence().create(journalProcessDefinitionId);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition remove(
        long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchJournalProcessDefinitionException {
        return getPersistence().remove(journalProcessDefinitionId);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition remove(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(journalProcessDefinition);
    }

    /**
     * @deprecated Use <code>update(JournalProcessDefinition journalProcessDefinition, boolean merge)</code>.
     */
    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition update(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(journalProcessDefinition);
    }

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
    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition update(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(journalProcessDefinition, merge);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition updateImpl(
        com.nss.portlet.journalworkflow.model.JournalProcessDefinition journalProcessDefinition,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(journalProcessDefinition, merge);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition findByPrimaryKey(
        long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.journalworkflow.NoSuchJournalProcessDefinitionException {
        return getPersistence().findByPrimaryKey(journalProcessDefinitionId);
    }

    public static com.nss.portlet.journalworkflow.model.JournalProcessDefinition fetchByPrimaryKey(
        long journalProcessDefinitionId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(journalProcessDefinitionId);
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

    public static java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.journalworkflow.model.JournalProcessDefinition> findAll(
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

    public static JournalProcessDefinitionPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(JournalProcessDefinitionPersistence persistence) {
        _persistence = persistence;
    }
}
