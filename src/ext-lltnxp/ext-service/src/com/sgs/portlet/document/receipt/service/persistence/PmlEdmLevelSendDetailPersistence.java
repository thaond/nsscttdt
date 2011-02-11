package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmLevelSendDetailPersistence {
    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail create(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK);

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail remove(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail remove(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmLevelSendDetail pmlEdmLevelSendDetail, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmLevelSendDetail the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmLevelSendDetail is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail fetchByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByLevelSendId(
        int levelSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByLevelSendId(
        int levelSendId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByLevelSendId(
        int levelSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByLevelSendId_First(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByLevelSendId_Last(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail[] findByLevelSendId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK,
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByIssuingPlaceId(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByIssuingPlaceId_First(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByIssuingPlaceId_Last(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail[] findByIssuingPlaceId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK,
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByLevelSendId_IssuingPlaceId(
        int levelSendId, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail fetchByLevelSendId_IssuingPlaceId(
        int levelSendId, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException;

    public void removeByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public void removeByLevelSendId_IssuingPlaceId(int levelSendId,
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException;

    public int countByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public int countByLevelSendId_IssuingPlaceId(int levelSendId,
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
