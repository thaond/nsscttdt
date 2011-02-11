package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmPrivilegeLevelPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel create(
        java.lang.String privilegeLevelId);

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel remove(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmPrivilegeLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel remove(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel update(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmPrivilegeLevel the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmPrivilegeLevel is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel update(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel findByPrimaryKey(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmPrivilegeLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel fetchByPrimaryKey(
        java.lang.String privilegeLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findByPrivilegeLevelName(
        java.lang.String privilegeLevelName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findByPrivilegeLevelName(
        java.lang.String privilegeLevelName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findByPrivilegeLevelName(
        java.lang.String privilegeLevelName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel findByPrivilegeLevelName_First(
        java.lang.String privilegeLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmPrivilegeLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel findByPrivilegeLevelName_Last(
        java.lang.String privilegeLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmPrivilegeLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel[] findByPrivilegeLevelName_PrevAndNext(
        java.lang.String privilegeLevelId, java.lang.String privilegeLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmPrivilegeLevelException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByPrivilegeLevelName(java.lang.String privilegeLevelName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByPrivilegeLevelName(java.lang.String privilegeLevelName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
