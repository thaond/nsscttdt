package com.nss.portlet.agency.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface AgencyPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.agency.model.Agency agency);

    public void cacheResult(
        java.util.List<com.nss.portlet.agency.model.Agency> agencies);

    public void clearCache();

    public com.nss.portlet.agency.model.Agency create(java.lang.String agencyId);

    public com.nss.portlet.agency.model.Agency remove(java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency remove(
        com.nss.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Agency agency, boolean merge)</code>.
     */
    public com.nss.portlet.agency.model.Agency update(
        com.nss.portlet.agency.model.Agency agency)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.agency.model.Agency update(
        com.nss.portlet.agency.model.Agency agency, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.agency.model.Agency updateImpl(
        com.nss.portlet.agency.model.Agency agency, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.agency.model.Agency findByPrimaryKey(
        java.lang.String agencyId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency fetchByPrimaryKey(
        java.lang.String agencyId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyCode(
        java.lang.String agencyCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyCode(
        java.lang.String agencyCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyCode(
        java.lang.String agencyCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.agency.model.Agency findByAgencyCode_First(
        java.lang.String agencyCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency findByAgencyCode_Last(
        java.lang.String agencyCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency[] findByAgencyCode_PrevAndNext(
        java.lang.String agencyId, java.lang.String agencyCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyName(
        java.lang.String agencyName) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyName(
        java.lang.String agencyName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByAgencyName(
        java.lang.String agencyName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.agency.model.Agency findByAgencyName_First(
        java.lang.String agencyName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency findByAgencyName_Last(
        java.lang.String agencyName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency[] findByAgencyName_PrevAndNext(
        java.lang.String agencyId, java.lang.String agencyName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.agency.model.Agency findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency[] findByDescription_PrevAndNext(
        java.lang.String agencyId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByC_N_D(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByC_N_D(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByC_N_D(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.agency.model.Agency findByC_N_D_First(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency findByC_N_D_Last(
        java.lang.String agencyCode, java.lang.String agencyName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public com.nss.portlet.agency.model.Agency[] findByC_N_D_PrevAndNext(
        java.lang.String agencyId, java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.agency.NoSuchAgencyException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByAgencyCode(java.lang.String agencyCode)
        throws com.liferay.portal.SystemException;

    public void removeByAgencyName(java.lang.String agencyName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByAgencyCode(java.lang.String agencyCode)
        throws com.liferay.portal.SystemException;

    public int countByAgencyName(java.lang.String agencyName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String agencyCode,
        java.lang.String agencyName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
