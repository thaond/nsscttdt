package com.nss.portlet.digitalsignature.service.persistence;

public class SignatureUtil {
    private static SignaturePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.digitalsignature.model.Signature signature) {
        getPersistence().cacheResult(signature);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.digitalsignature.model.Signature> signatures) {
        getPersistence().cacheResult(signatures);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.digitalsignature.model.Signature create(
        long signatureId) {
        return getPersistence().create(signatureId);
    }

    public static com.nss.portlet.digitalsignature.model.Signature remove(
        long signatureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchSignatureException {
        return getPersistence().remove(signatureId);
    }

    public static com.nss.portlet.digitalsignature.model.Signature remove(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(signature);
    }

    /**
     * @deprecated Use <code>update(Signature signature, boolean merge)</code>.
     */
    public static com.nss.portlet.digitalsignature.model.Signature update(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(signature);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                signature the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when signature is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.digitalsignature.model.Signature update(
        com.nss.portlet.digitalsignature.model.Signature signature,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(signature, merge);
    }

    public static com.nss.portlet.digitalsignature.model.Signature updateImpl(
        com.nss.portlet.digitalsignature.model.Signature signature,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(signature, merge);
    }

    public static com.nss.portlet.digitalsignature.model.Signature findByPrimaryKey(
        long signatureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchSignatureException {
        return getPersistence().findByPrimaryKey(signatureId);
    }

    public static com.nss.portlet.digitalsignature.model.Signature fetchByPrimaryKey(
        long signatureId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(signatureId);
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

    public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
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

    public static SignaturePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(SignaturePersistence persistence) {
        _persistence = persistence;
    }
}
