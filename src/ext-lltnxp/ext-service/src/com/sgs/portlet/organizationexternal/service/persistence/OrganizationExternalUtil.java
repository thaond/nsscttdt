package com.sgs.portlet.organizationexternal.service.persistence;

public class OrganizationExternalUtil {
    private static OrganizationExternalPersistence _persistence;

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal create(
        long orgExternalId) {
        return getPersistence().create(orgExternalId);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal remove(
        long orgExternalId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().remove(orgExternalId);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal remove(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(organizationExternal);
    }

    /**
     * @deprecated Use <code>update(OrganizationExternal organizationExternal, boolean merge)</code>.
     */
    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal update(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(organizationExternal);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                organizationExternal the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when organizationExternal is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal update(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(organizationExternal, merge);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal updateImpl(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(organizationExternal, merge);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal findByPrimaryKey(
        long orgExternalId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().findByPrimaryKey(orgExternalId);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal fetchByPrimaryKey(
        long orgExternalId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(orgExternalId);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalCode(
        java.lang.String orgExternalCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalCode(orgExternalCode);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalCode(
        java.lang.String orgExternalCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrgExternalCode(orgExternalCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalCode(
        java.lang.String orgExternalCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrgExternalCode(orgExternalCode, start, end, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalCode_First(
        java.lang.String orgExternalCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().findByOrgExternalCode_First(orgExternalCode, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalCode_Last(
        java.lang.String orgExternalCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().findByOrgExternalCode_Last(orgExternalCode, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal[] findByOrgExternalCode_PrevAndNext(
        long orgExternalId, java.lang.String orgExternalCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence()
                   .findByOrgExternalCode_PrevAndNext(orgExternalId,
            orgExternalCode, obc);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalName(
        java.lang.String orgExternalName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByOrgExternalName(orgExternalName);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalName(
        java.lang.String orgExternalName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrgExternalName(orgExternalName, start, end);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalName(
        java.lang.String orgExternalName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByOrgExternalName(orgExternalName, start, end, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalName_First(
        java.lang.String orgExternalName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().findByOrgExternalName_First(orgExternalName, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalName_Last(
        java.lang.String orgExternalName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().findByOrgExternalName_Last(orgExternalName, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal[] findByOrgExternalName_PrevAndNext(
        long orgExternalId, java.lang.String orgExternalName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence()
                   .findByOrgExternalName_PrevAndNext(orgExternalId,
            orgExternalName, obc);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByIsOwnerOrg(
        boolean isOwnerOrg) throws com.liferay.portal.SystemException {
        return getPersistence().findByIsOwnerOrg(isOwnerOrg);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByIsOwnerOrg(
        boolean isOwnerOrg, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIsOwnerOrg(isOwnerOrg, start, end);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByIsOwnerOrg(
        boolean isOwnerOrg, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIsOwnerOrg(isOwnerOrg, start, end, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal findByIsOwnerOrg_First(
        boolean isOwnerOrg, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().findByIsOwnerOrg_First(isOwnerOrg, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal findByIsOwnerOrg_Last(
        boolean isOwnerOrg, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence().findByIsOwnerOrg_Last(isOwnerOrg, obc);
    }

    public static com.sgs.portlet.organizationexternal.model.OrganizationExternal[] findByIsOwnerOrg_PrevAndNext(
        long orgExternalId, boolean isOwnerOrg,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException {
        return getPersistence()
                   .findByIsOwnerOrg_PrevAndNext(orgExternalId, isOwnerOrg, obc);
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

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByOrgExternalCode(java.lang.String orgExternalCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOrgExternalCode(orgExternalCode);
    }

    public static void removeByOrgExternalName(java.lang.String orgExternalName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByOrgExternalName(orgExternalName);
    }

    public static void removeByIsOwnerOrg(boolean isOwnerOrg)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIsOwnerOrg(isOwnerOrg);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByOrgExternalCode(java.lang.String orgExternalCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOrgExternalCode(orgExternalCode);
    }

    public static int countByOrgExternalName(java.lang.String orgExternalName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByOrgExternalName(orgExternalName);
    }

    public static int countByIsOwnerOrg(boolean isOwnerOrg)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIsOwnerOrg(isOwnerOrg);
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

    public static OrganizationExternalPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(OrganizationExternalPersistence persistence) {
        _persistence = persistence;
    }
}
