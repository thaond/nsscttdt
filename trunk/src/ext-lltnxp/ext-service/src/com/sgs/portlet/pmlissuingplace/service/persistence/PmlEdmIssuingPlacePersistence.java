package com.sgs.portlet.pmlissuingplace.service.persistence;

public interface PmlEdmIssuingPlacePersistence {
    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace create(
        java.lang.String issuingPlaceId);

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace remove(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace remove(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmIssuingPlace pmlEdmIssuingPlace, boolean merge)</code>.
     */
    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace update(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmIssuingPlace the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmIssuingPlace is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace update(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace updateImpl(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByPrimaryKey(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace fetchByPrimaryKey(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceCode(
        java.lang.String issuingPlaceCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceCode(
        java.lang.String issuingPlaceCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceCode(
        java.lang.String issuingPlaceCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceCode_First(
        java.lang.String issuingPlaceCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceCode_Last(
        java.lang.String issuingPlaceCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByIssuingPlaceCode_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceName(
        java.lang.String issuingPlaceName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceName(
        java.lang.String issuingPlaceName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceName(
        java.lang.String issuingPlaceName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceName_First(
        java.lang.String issuingPlaceName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceName_Last(
        java.lang.String issuingPlaceName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByIssuingPlaceName_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByTablePhone(
        java.lang.String tablePhone) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByTablePhone(
        java.lang.String tablePhone, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByTablePhone(
        java.lang.String tablePhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByTablePhone_First(
        java.lang.String tablePhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByTablePhone_Last(
        java.lang.String tablePhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByTablePhone_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String tablePhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByHandPhone(
        java.lang.String handPhone) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByHandPhone(
        java.lang.String handPhone, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByHandPhone(
        java.lang.String handPhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByHandPhone_First(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByHandPhone_Last(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByHandPhone_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByAddress(
        java.lang.String address) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByAddress(
        java.lang.String address, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByAddress(
        java.lang.String address, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByAddress_First(
        java.lang.String address,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByAddress_Last(
        java.lang.String address,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByAddress_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String address,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByEmail(
        java.lang.String email) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByEmail_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByIssuingPlaceCode(java.lang.String issuingPlaceCode)
        throws com.liferay.portal.SystemException;

    public void removeByIssuingPlaceName(java.lang.String issuingPlaceName)
        throws com.liferay.portal.SystemException;

    public void removeByTablePhone(java.lang.String tablePhone)
        throws com.liferay.portal.SystemException;

    public void removeByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException;

    public void removeByAddress(java.lang.String address)
        throws com.liferay.portal.SystemException;

    public void removeByEmail(java.lang.String email)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByIssuingPlaceCode(java.lang.String issuingPlaceCode)
        throws com.liferay.portal.SystemException;

    public int countByIssuingPlaceName(java.lang.String issuingPlaceName)
        throws com.liferay.portal.SystemException;

    public int countByTablePhone(java.lang.String tablePhone)
        throws com.liferay.portal.SystemException;

    public int countByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException;

    public int countByAddress(java.lang.String address)
        throws com.liferay.portal.SystemException;

    public int countByEmail(java.lang.String email)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
