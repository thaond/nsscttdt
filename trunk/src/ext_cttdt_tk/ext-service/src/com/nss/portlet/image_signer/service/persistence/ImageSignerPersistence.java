package com.nss.portlet.image_signer.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface ImageSignerPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner);

    public void cacheResult(
        java.util.List<com.nss.portlet.image_signer.model.ImageSigner> imageSigners);

    public void clearCache();

    public com.nss.portlet.image_signer.model.ImageSigner create(
        long imageSignerId);

    public com.nss.portlet.image_signer.model.ImageSigner remove(
        long imageSignerId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.image_signer.NoSuchImageSignerException;

    public com.nss.portlet.image_signer.model.ImageSigner remove(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(ImageSigner imageSigner, boolean merge)</code>.
     */
    public com.nss.portlet.image_signer.model.ImageSigner update(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.image_signer.model.ImageSigner update(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.image_signer.model.ImageSigner updateImpl(
        com.nss.portlet.image_signer.model.ImageSigner imageSigner,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.image_signer.model.ImageSigner findByPrimaryKey(
        long imageSignerId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.image_signer.NoSuchImageSignerException;

    public com.nss.portlet.image_signer.model.ImageSigner fetchByPrimaryKey(
        long imageSignerId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.image_signer.model.ImageSigner> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.image_signer.model.ImageSigner> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.image_signer.model.ImageSigner> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
