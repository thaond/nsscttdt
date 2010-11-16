package com.nss.portlet.digitalsignature.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface SignaturePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.digitalsignature.model.Signature signature);

    public void cacheResult(
        java.util.List<com.nss.portlet.digitalsignature.model.Signature> signatures);

    public void clearCache();

    public com.nss.portlet.digitalsignature.model.Signature create(
        long signatureId);

    public com.nss.portlet.digitalsignature.model.Signature remove(
        long signatureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchSignatureException;

    public com.nss.portlet.digitalsignature.model.Signature remove(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Signature signature, boolean merge)</code>.
     */
    public com.nss.portlet.digitalsignature.model.Signature update(
        com.nss.portlet.digitalsignature.model.Signature signature)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.digitalsignature.model.Signature update(
        com.nss.portlet.digitalsignature.model.Signature signature,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Signature updateImpl(
        com.nss.portlet.digitalsignature.model.Signature signature,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Signature findByPrimaryKey(
        long signatureId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchSignatureException;

    public com.nss.portlet.digitalsignature.model.Signature fetchByPrimaryKey(
        long signatureId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.digitalsignature.model.Signature> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
