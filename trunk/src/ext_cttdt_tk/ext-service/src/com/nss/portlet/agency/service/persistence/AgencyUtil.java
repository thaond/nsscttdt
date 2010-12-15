package com.nss.portlet.agency.service.persistence;

public class AgencyUtil {
    private static AgencyPersistence _persistence;

    public static void cacheResult(com.nss.portlet.agency.model.Agency agency) {
        getPersistence().cacheResult(agency);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.agency.model.Agency> agencies) {
        getPersistence().cacheResult(agencies);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.agency.model.Agency create(
        java.lang.String agencyId) {
        return getPersistence().create(agencyId);
    }

    public static com.nss.portlet.agency.model.Agency remove(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().remove(agencyId);
    }

    public static com.nss.portlet.agency.model.Agency remove(
        com.nss.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(agency);
    }

    /**
     * @deprecated Use <code>update(Agency agency, boolean merge)</code>.
     */
    public static com.nss.portlet.agency.model.Agency update(
        com.nss.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(agency);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                agency the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when agency is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.agency.model.Agency update(
        com.nss.portlet.agency.model.Agency agency, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(agency, merge);
    }

    public static com.nss.portlet.agency.model.Agency updateImpl(
        com.nss.portlet.agency.model.Agency agency, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(agency, merge);
    }

    public static com.nss.portlet.agency.model.Agency findByPrimaryKey(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().findByPrimaryKey(agencyId);
    }

    public static com.nss.portlet.agency.model.Agency fetchByPrimaryKey(
        java.lang.String agencyId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(agencyId);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyCode(
        java.lang.String agencyCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyCode(agencyCode);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyCode(
        java.lang.String agencyCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyCode(agencyCode, start, end);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyCode(
        java.lang.String agencyCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyCode(agencyCode, start, end, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByAgencyCode_First(
        java.lang.String agencyCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().findByAgencyCode_First(agencyCode, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByAgencyCode_Last(
        java.lang.String agencyCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().findByAgencyCode_Last(agencyCode, obc);
    }

    public static com.nss.portlet.agency.model.Agency[] findByAgencyCode_PrevAndNext(
        java.lang.String agencyId, java.lang.String agencyCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence()
                   .findByAgencyCode_PrevAndNext(agencyId, agencyCode, obc);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyName(
        java.lang.String agencyName) throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyName(agencyName);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyName(
        java.lang.String agencyName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyName(agencyName, start, end);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyName(
        java.lang.String agencyName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAgencyName(agencyName, start, end, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByAgencyName_First(
        java.lang.String agencyName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().findByAgencyName_First(agencyName, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByAgencyName_Last(
        java.lang.String agencyName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().findByAgencyName_Last(agencyName, obc);
    }

    public static com.nss.portlet.agency.model.Agency[] findByAgencyName_PrevAndNext(
        java.lang.String agencyId, java.lang.String agencyName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence()
                   .findByAgencyName_PrevAndNext(agencyId, agencyName, obc);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.nss.portlet.agency.model.Agency[] findByDescription_PrevAndNext(
        java.lang.String agencyId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence()
                   .findByDescription_PrevAndNext(agencyId, description, obc);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByC_N_D(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByC_N_D(agencyCode, agencyName, description);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByC_N_D(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(agencyCode, agencyName, description, start, end);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findByC_N_D(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(agencyCode, agencyName, description, start,
            end, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByC_N_D_First(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence()
                   .findByC_N_D_First(agencyCode, agencyName, description, obc);
    }

    public static com.nss.portlet.agency.model.Agency findByC_N_D_Last(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence()
                   .findByC_N_D_Last(agencyCode, agencyName, description, obc);
    }

    public static com.nss.portlet.agency.model.Agency[] findByC_N_D_PrevAndNext(
        java.lang.String agencyId, java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(agencyId, agencyCode, agencyName,
            description, obc);
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

    public static java.util.List<com.nss.portlet.agency.model.Agency> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.agency.model.Agency> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByAgencyCode(java.lang.String agencyCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAgencyCode(agencyCode);
    }

    public static void removeByAgencyName(java.lang.String agencyName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAgencyName(agencyName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByC_N_D(java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_N_D(agencyCode, agencyName, description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByAgencyCode(java.lang.String agencyCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAgencyCode(agencyCode);
    }

    public static int countByAgencyName(java.lang.String agencyName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAgencyName(agencyName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByC_N_D(java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_N_D(agencyCode, agencyName, description);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static AgencyPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(AgencyPersistence persistence) {
        _persistence = persistence;
    }
}
