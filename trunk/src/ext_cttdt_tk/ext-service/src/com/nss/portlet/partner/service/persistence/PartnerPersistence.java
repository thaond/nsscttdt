package com.nss.portlet.partner.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PartnerPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.partner.model.Partner partner);

    public void cacheResult(
        java.util.List<com.nss.portlet.partner.model.Partner> partners);

    public void clearCache();

    public com.nss.portlet.partner.model.Partner create(long maPartner);

    public com.nss.portlet.partner.model.Partner remove(long maPartner)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.partner.NoSuchPartnerException;

    public com.nss.portlet.partner.model.Partner remove(
        com.nss.portlet.partner.model.Partner partner)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Partner partner, boolean merge)</code>.
     */
    public com.nss.portlet.partner.model.Partner update(
        com.nss.portlet.partner.model.Partner partner)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.partner.model.Partner update(
        com.nss.portlet.partner.model.Partner partner, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.partner.model.Partner updateImpl(
        com.nss.portlet.partner.model.Partner partner, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.partner.model.Partner findByPrimaryKey(
        long maPartner)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.partner.NoSuchPartnerException;

    public com.nss.portlet.partner.model.Partner fetchByPrimaryKey(
        long maPartner) throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.partner.model.Partner> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.partner.model.Partner> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.partner.model.Partner> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
