package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmLevelSendDetailUtil {
    private static PmlEdmLevelSendDetailPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail create(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK) {
        return getPersistence().create(pmlEdmLevelSendDetailPK);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail remove(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence().remove(pmlEdmLevelSendDetailPK);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail remove(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmLevelSendDetail);
    }

    /**
     * @deprecated Use <code>update(PmlEdmLevelSendDetail pmlEdmLevelSendDetail, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmLevelSendDetail);
    }

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
    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail update(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmLevelSendDetail, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail pmlEdmLevelSendDetail,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmLevelSendDetail, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence().findByPrimaryKey(pmlEdmLevelSendDetailPK);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail fetchByPrimaryKey(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(pmlEdmLevelSendDetailPK);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByLevelSendId(
        int levelSendId) throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByLevelSendId(
        int levelSendId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByLevelSendId(
        int levelSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendId(levelSendId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByLevelSendId_First(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence().findByLevelSendId_First(levelSendId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByLevelSendId_Last(
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence().findByLevelSendId_Last(levelSendId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail[] findByLevelSendId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK,
        int levelSendId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence()
                   .findByLevelSendId_PrevAndNext(pmlEdmLevelSendDetailPK,
            levelSendId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByIssuingPlaceId(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceId(issuingPlaceId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceId(issuingPlaceId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findByIssuingPlaceId(
        java.lang.String issuingPlaceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingPlaceId(issuingPlaceId, start, end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByIssuingPlaceId_First(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence().findByIssuingPlaceId_First(issuingPlaceId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByIssuingPlaceId_Last(
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence().findByIssuingPlaceId_Last(issuingPlaceId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail[] findByIssuingPlaceId_PrevAndNext(
        com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailPK pmlEdmLevelSendDetailPK,
        java.lang.String issuingPlaceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence()
                   .findByIssuingPlaceId_PrevAndNext(pmlEdmLevelSendDetailPK,
            issuingPlaceId, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail findByLevelSendId_IssuingPlaceId(
        int levelSendId, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        return getPersistence()
                   .findByLevelSendId_IssuingPlaceId(levelSendId, issuingPlaceId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail fetchByLevelSendId_IssuingPlaceId(
        int levelSendId, java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .fetchByLevelSendId_IssuingPlaceId(levelSendId,
            issuingPlaceId);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLevelSendId(levelSendId);
    }

    public static void removeByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIssuingPlaceId(issuingPlaceId);
    }

    public static void removeByLevelSendId_IssuingPlaceId(int levelSendId,
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmLevelSendDetailException {
        getPersistence()
            .removeByLevelSendId_IssuingPlaceId(levelSendId, issuingPlaceId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByLevelSendId(int levelSendId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLevelSendId(levelSendId);
    }

    public static int countByIssuingPlaceId(java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIssuingPlaceId(issuingPlaceId);
    }

    public static int countByLevelSendId_IssuingPlaceId(int levelSendId,
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByLevelSendId_IssuingPlaceId(levelSendId,
            issuingPlaceId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlEdmLevelSendDetailPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmLevelSendDetailPersistence persistence) {
        _persistence = persistence;
    }
}
