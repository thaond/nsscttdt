package com.nss.portlet.image_signer.service.persistence;

public class ImageSignerUtil {
    private static ImageSignerPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner) {
        getPersistence().cacheResult(imageSigner);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.image_signer.model.ImageSigner> imageSigners) {
        getPersistence().cacheResult(imageSigners);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.image_signer.model.ImageSigner create(
        long imageSignerId) {
        return getPersistence().create(imageSignerId);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner remove(
        long imageSignerId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.image_signer.NoSuchImageSignerException {
        return getPersistence().remove(imageSignerId);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner remove(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(imageSigner);
    }

    /**
     * @deprecated Use <code>update(ImageSigner imageSigner, boolean merge)</code>.
     */
    public static com.nss.portlet.image_signer.model.ImageSigner update(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(imageSigner);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                imageSigner the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when imageSigner is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.image_signer.model.ImageSigner update(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(imageSigner, merge);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner updateImpl(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(imageSigner, merge);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner findByPrimaryKey(
        long imageSignerId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.image_signer.NoSuchImageSignerException {
        return getPersistence().findByPrimaryKey(imageSignerId);
    }

    public static com.nss.portlet.image_signer.model.ImageSigner fetchByPrimaryKey(
        long imageSignerId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(imageSignerId);
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

    public static java.util.List<com.nss.portlet.image_signer.model.ImageSigner> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.image_signer.model.ImageSigner> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.image_signer.model.ImageSigner> findAll(
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

    public static ImageSignerPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ImageSignerPersistence persistence) {
        _persistence = persistence;
    }
}
