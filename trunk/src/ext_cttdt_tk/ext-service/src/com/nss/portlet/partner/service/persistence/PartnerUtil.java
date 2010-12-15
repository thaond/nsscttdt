package com.nss.portlet.partner.service.persistence;

public class PartnerUtil {
    private static PartnerPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.partner.model.Partner partner) {
        getPersistence().cacheResult(partner);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.partner.model.Partner> partners) {
        getPersistence().cacheResult(partners);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.partner.model.Partner create(long maPartner) {
        return getPersistence().create(maPartner);
    }

    public static com.nss.portlet.partner.model.Partner remove(long maPartner)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.partner.NoSuchPartnerException {
        return getPersistence().remove(maPartner);
    }

    public static com.nss.portlet.partner.model.Partner remove(
        com.nss.portlet.partner.model.Partner partner)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(partner);
    }

    /**
     * @deprecated Use <code>update(Partner partner, boolean merge)</code>.
     */
    public static com.nss.portlet.partner.model.Partner update(
        com.nss.portlet.partner.model.Partner partner)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(partner);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                partner the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when partner is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.partner.model.Partner update(
        com.nss.portlet.partner.model.Partner partner, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(partner, merge);
    }

    public static com.nss.portlet.partner.model.Partner updateImpl(
        com.nss.portlet.partner.model.Partner partner, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(partner, merge);
    }

    public static com.nss.portlet.partner.model.Partner findByPrimaryKey(
        long maPartner)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.partner.NoSuchPartnerException {
        return getPersistence().findByPrimaryKey(maPartner);
    }

    public static com.nss.portlet.partner.model.Partner fetchByPrimaryKey(
        long maPartner) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maPartner);
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

    public static java.util.List<com.nss.portlet.partner.model.Partner> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.partner.model.Partner> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.partner.model.Partner> findAll(
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

    public static PartnerPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PartnerPersistence persistence) {
        _persistence = persistence;
    }
}
