package com.sgs.portlet.pmlissuingplace.service.persistence;

public class PmlEdmIssuingPlaceUtil {
    private static PmlEdmIssuingPlacePersistence _persistence;

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace create(
        java.lang.String issuingPlaceId) {
        return getPersistence().create(issuingPlaceId);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace remove(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().remove(issuingPlaceId);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace remove(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmIssuingPlace);
    }

    /**
     * @deprecated Use <code>update(PmlEdmIssuingPlace pmlEdmIssuingPlace, boolean merge)</code>.
     */
    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace update(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmIssuingPlace);
    }

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
    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace update(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmIssuingPlace, merge);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace updateImpl(
        com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace pmlEdmIssuingPlace,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmIssuingPlace, merge);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByPrimaryKey(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByPrimaryKey(issuingPlaceId);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace fetchByPrimaryKey(
        java.lang.String issuingPlaceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(issuingPlaceId);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceCode(
        java.lang.String issuingPlaceCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceCode(issuingPlaceCode);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceCode(
        java.lang.String issuingPlaceCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingPlaceCode(issuingPlaceCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceCode(
        java.lang.String issuingPlaceCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingPlaceCode(issuingPlaceCode, start, end, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceCode_First(
        java.lang.String issuingPlaceCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByIssuingPlaceCode_First(issuingPlaceCode, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceCode_Last(
        java.lang.String issuingPlaceCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByIssuingPlaceCode_Last(issuingPlaceCode, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByIssuingPlaceCode_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByIssuingPlaceCode_PrevAndNext(issuingPlaceId,
            issuingPlaceCode, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceName(
        java.lang.String issuingPlaceName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIssuingPlaceName(issuingPlaceName);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceName(
        java.lang.String issuingPlaceName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingPlaceName(issuingPlaceName, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceName(
        java.lang.String issuingPlaceName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIssuingPlaceName(issuingPlaceName, start, end, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceName_First(
        java.lang.String issuingPlaceName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByIssuingPlaceName_First(issuingPlaceName, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByIssuingPlaceName_Last(
        java.lang.String issuingPlaceName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByIssuingPlaceName_Last(issuingPlaceName, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByIssuingPlaceName_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String issuingPlaceName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByIssuingPlaceName_PrevAndNext(issuingPlaceId,
            issuingPlaceName, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByTablePhone(
        java.lang.String tablePhone) throws com.liferay.portal.SystemException {
        return getPersistence().findByTablePhone(tablePhone);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByTablePhone(
        java.lang.String tablePhone, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTablePhone(tablePhone, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByTablePhone(
        java.lang.String tablePhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTablePhone(tablePhone, start, end, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByTablePhone_First(
        java.lang.String tablePhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByTablePhone_First(tablePhone, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByTablePhone_Last(
        java.lang.String tablePhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByTablePhone_Last(tablePhone, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByTablePhone_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String tablePhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByTablePhone_PrevAndNext(issuingPlaceId, tablePhone, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByHandPhone(
        java.lang.String handPhone) throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByHandPhone(
        java.lang.String handPhone, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByHandPhone(
        java.lang.String handPhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByHandPhone(handPhone, start, end, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByHandPhone_First(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByHandPhone_First(handPhone, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByHandPhone_Last(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByHandPhone_Last(handPhone, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByHandPhone_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByHandPhone_PrevAndNext(issuingPlaceId, handPhone, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByAddress(
        java.lang.String address) throws com.liferay.portal.SystemException {
        return getPersistence().findByAddress(address);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByAddress(
        java.lang.String address, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAddress(address, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByAddress(
        java.lang.String address, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAddress(address, start, end, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByAddress_First(
        java.lang.String address,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByAddress_First(address, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByAddress_Last(
        java.lang.String address,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByAddress_Last(address, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByAddress_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String address,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByAddress_PrevAndNext(issuingPlaceId, address, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByEmail(
        java.lang.String email) throws com.liferay.portal.SystemException {
        return getPersistence().findByEmail(email);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByEmail(email, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByEmail(email, start, end, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByEmail_First(email, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace findByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence().findByEmail_Last(email, obc);
    }

    public static com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace[] findByEmail_PrevAndNext(
        java.lang.String issuingPlaceId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmlissuingplace.NoSuchPmlEdmIssuingPlaceException {
        return getPersistence()
                   .findByEmail_PrevAndNext(issuingPlaceId, email, obc);
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

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByIssuingPlaceCode(
        java.lang.String issuingPlaceCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIssuingPlaceCode(issuingPlaceCode);
    }

    public static void removeByIssuingPlaceName(
        java.lang.String issuingPlaceName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIssuingPlaceName(issuingPlaceName);
    }

    public static void removeByTablePhone(java.lang.String tablePhone)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTablePhone(tablePhone);
    }

    public static void removeByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByHandPhone(handPhone);
    }

    public static void removeByAddress(java.lang.String address)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAddress(address);
    }

    public static void removeByEmail(java.lang.String email)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByEmail(email);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByIssuingPlaceCode(java.lang.String issuingPlaceCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIssuingPlaceCode(issuingPlaceCode);
    }

    public static int countByIssuingPlaceName(java.lang.String issuingPlaceName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIssuingPlaceName(issuingPlaceName);
    }

    public static int countByTablePhone(java.lang.String tablePhone)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTablePhone(tablePhone);
    }

    public static int countByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByHandPhone(handPhone);
    }

    public static int countByAddress(java.lang.String address)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAddress(address);
    }

    public static int countByEmail(java.lang.String email)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByEmail(email);
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

    public static PmlEdmIssuingPlacePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmIssuingPlacePersistence persistence) {
        _persistence = persistence;
    }
}
