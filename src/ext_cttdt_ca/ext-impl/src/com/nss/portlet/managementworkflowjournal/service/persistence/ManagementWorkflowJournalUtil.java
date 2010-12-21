package com.nss.portlet.managementworkflowjournal.service.persistence;

public class ManagementWorkflowJournalUtil {
    private static ManagementWorkflowJournalPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal) {
        getPersistence().cacheResult(managementWorkflowJournal);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> managementWorkflowJournals) {
        getPersistence().cacheResult(managementWorkflowJournals);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal create(
        long managementWorkflowJournalId) {
        return getPersistence().create(managementWorkflowJournalId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal remove(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException {
        return getPersistence().remove(managementWorkflowJournalId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal remove(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(managementWorkflowJournal);
    }

    /**
     * @deprecated Use <code>update(ManagementWorkflowJournal managementWorkflowJournal, boolean merge)</code>.
     */
    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal update(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(managementWorkflowJournal);
    }

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
    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal update(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(managementWorkflowJournal, merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal updateImpl(
        com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal managementWorkflowJournal,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(managementWorkflowJournal, merge);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal findByPrimaryKey(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException {
        return getPersistence().findByPrimaryKey(managementWorkflowJournalId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal fetchByPrimaryKey(
        long managementWorkflowJournalId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(managementWorkflowJournalId);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal findByWorkflowname_Version(
        java.lang.String workflowname, int version_)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException {
        return getPersistence()
                   .findByWorkflowname_Version(workflowname, version_);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal fetchByWorkflowname_Version(
        java.lang.String workflowname, int version_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByWorkflowname_Version(workflowname, version_);
    }

    public static com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal fetchByWorkflowname_Version(
        java.lang.String workflowname, int version_, boolean retrieveFromCache)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByWorkflowname_Version(workflowname, version_,
            retrieveFromCache);
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

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByWorkflowname_Version(
        java.lang.String workflowname, int version_)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.managementworkflowjournal.NoSuchManagementWorkflowJournalException {
        getPersistence().removeByWorkflowname_Version(workflowname, version_);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByWorkflowname_Version(
        java.lang.String workflowname, int version_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByWorkflowname_Version(workflowname, version_);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static ManagementWorkflowJournalPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ManagementWorkflowJournalPersistence persistence) {
        _persistence = persistence;
    }
}
