package com.nss.portlet.digitalsignature.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface CertificatePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.digitalsignature.model.Certificate certificate);

    public void cacheResult(
        java.util.List<com.nss.portlet.digitalsignature.model.Certificate> certificates);

    public void clearCache();

    public com.nss.portlet.digitalsignature.model.Certificate create(
        long userId);

    public com.nss.portlet.digitalsignature.model.Certificate remove(
        long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchCertificateException;

    public com.nss.portlet.digitalsignature.model.Certificate remove(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Certificate certificate, boolean merge)</code>.
     */
    public com.nss.portlet.digitalsignature.model.Certificate update(
        com.nss.portlet.digitalsignature.model.Certificate certificate)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.digitalsignature.model.Certificate update(
        com.nss.portlet.digitalsignature.model.Certificate certificate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Certificate updateImpl(
        com.nss.portlet.digitalsignature.model.Certificate certificate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.digitalsignature.model.Certificate findByPrimaryKey(
        long userId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.digitalsignature.NoSuchCertificateException;

    public com.nss.portlet.digitalsignature.model.Certificate fetchByPrimaryKey(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.digitalsignature.model.Certificate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
