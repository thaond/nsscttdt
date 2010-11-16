package com.nss.portlet.digitalsignature.service.persistence;

public class CertificateUtil {
    private static CertificatePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.digitalsignature.model.Certificate certificate) {
        getPersistence().cacheResult(certificate);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.digitalsignature.model.Certificate> certificates) {
        getPersistence().cacheResult(certificates);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.digitalsignature.model.Certificate create(
        long userId) {
        return getPersistence().create(userId);
    }

    public static com.nss.portlet.digitalsignature.model.Certificate remove(
        long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchCertificateException {
        return getPersistence().remove(userId);
    }

    public static com.nss.portlet.digitalsignature.model.Certificate remove(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(certificate);
    }

    /**
     * @deprecated Use <code>update(Certificate certificate, boolean merge)</code>.
     */
    public static com.nss.portlet.digitalsignature.model.Certificate update(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(certificate);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                certificate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when certificate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.digitalsignature.model.Certificate update(
        com.nss.portlet.digitalsignature.model.Certificate certificate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(certificate, merge);
    }

    public static com.nss.portlet.digitalsignature.model.Certificate updateImpl(
        com.nss.portlet.digitalsignature.model.Certificate certificate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(certificate, merge);
    }

    public static com.nss.portlet.digitalsignature.model.Certificate findByPrimaryKey(
        long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchCertificateException {
        return getPersistence().findByPrimaryKey(userId);
    }

    public static com.nss.portlet.digitalsignature.model.Certificate fetchByPrimaryKey(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(userId);
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

    public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll(
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

    public static CertificatePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CertificatePersistence persistence) {
        _persistence = persistence;
    }
}
