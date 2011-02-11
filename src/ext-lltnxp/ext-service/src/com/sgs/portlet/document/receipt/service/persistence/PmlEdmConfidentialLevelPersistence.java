package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmConfidentialLevelPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel create(
        java.lang.String confidentialLevelId);

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel remove(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel remove(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmConfidentialLevel pmlEdmConfidentialLevel, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel update(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmConfidentialLevel the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmConfidentialLevel is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel update(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel findByPrimaryKey(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel fetchByPrimaryKey(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByConfidentialLevelName(
        java.lang.String confidentialLevelName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByConfidentialLevelName(
        java.lang.String confidentialLevelName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByConfidentialLevelName(
        java.lang.String confidentialLevelName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel findByConfidentialLevelName_First(
        java.lang.String confidentialLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel findByConfidentialLevelName_Last(
        java.lang.String confidentialLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException;

    public com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel[] findByConfidentialLevelName_PrevAndNext(
        java.lang.String confidentialLevelId,
        java.lang.String confidentialLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByConfidentialLevelName(
        java.lang.String confidentialLevelName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByConfidentialLevelName(
        java.lang.String confidentialLevelName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
