package com.sgs.portlet.organizationexternal.service.persistence;

public interface OrganizationExternalPersistence {
    public com.sgs.portlet.organizationexternal.model.OrganizationExternal create(
        long orgExternalId);

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal remove(
        long orgExternalId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal remove(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(OrganizationExternal organizationExternal, boolean merge)</code>.
     */
    public com.sgs.portlet.organizationexternal.model.OrganizationExternal update(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.organizationexternal.model.OrganizationExternal update(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal updateImpl(
        com.sgs.portlet.organizationexternal.model.OrganizationExternal organizationExternal,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal findByPrimaryKey(
        long orgExternalId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal fetchByPrimaryKey(
        long orgExternalId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalCode(
        java.lang.String orgExternalCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalCode(
        java.lang.String orgExternalCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalCode(
        java.lang.String orgExternalCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalCode_First(
        java.lang.String orgExternalCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalCode_Last(
        java.lang.String orgExternalCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal[] findByOrgExternalCode_PrevAndNext(
        long orgExternalId, java.lang.String orgExternalCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalName(
        java.lang.String orgExternalName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalName(
        java.lang.String orgExternalName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByOrgExternalName(
        java.lang.String orgExternalName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalName_First(
        java.lang.String orgExternalName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal findByOrgExternalName_Last(
        java.lang.String orgExternalName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal[] findByOrgExternalName_PrevAndNext(
        long orgExternalId, java.lang.String orgExternalName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByIsOwnerOrg(
        boolean isOwnerOrg) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByIsOwnerOrg(
        boolean isOwnerOrg, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByIsOwnerOrg(
        boolean isOwnerOrg, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal findByIsOwnerOrg_First(
        boolean isOwnerOrg, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal findByIsOwnerOrg_Last(
        boolean isOwnerOrg, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public com.sgs.portlet.organizationexternal.model.OrganizationExternal[] findByIsOwnerOrg_PrevAndNext(
        long orgExternalId, boolean isOwnerOrg,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.organizationexternal.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByOrgExternalCode(java.lang.String orgExternalCode)
        throws com.liferay.portal.SystemException;

    public void removeByOrgExternalName(java.lang.String orgExternalName)
        throws com.liferay.portal.SystemException;

    public void removeByIsOwnerOrg(boolean isOwnerOrg)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByOrgExternalCode(java.lang.String orgExternalCode)
        throws com.liferay.portal.SystemException;

    public int countByOrgExternalName(java.lang.String orgExternalName)
        throws com.liferay.portal.SystemException;

    public int countByIsOwnerOrg(boolean isOwnerOrg)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
