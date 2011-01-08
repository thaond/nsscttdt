package com.sgs.portlet.wardsmanagement.service.persistence;

public class WardsUtil {
    private static WardsPersistence _persistence;

    public static com.sgs.portlet.wardsmanagement.model.Wards create(
        java.lang.String wardsId) {
        return getPersistence().create(wardsId);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards remove(
        java.lang.String wardsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().remove(wardsId);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards remove(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(wards);
    }

    /**
     * @deprecated Use <code>update(Wards wards, boolean merge)</code>.
     */
    public static com.sgs.portlet.wardsmanagement.model.Wards update(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(wards);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                wards the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when wards is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.wardsmanagement.model.Wards update(
        com.sgs.portlet.wardsmanagement.model.Wards wards, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(wards, merge);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards updateImpl(
        com.sgs.portlet.wardsmanagement.model.Wards wards, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(wards, merge);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByPrimaryKey(
        java.lang.String wardsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByPrimaryKey(wardsId);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards fetchByPrimaryKey(
        java.lang.String wardsId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(wardsId);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByC_N_I_D(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_I_D(wardsCode, wardsName, districtId, description);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByC_N_I_D(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_I_D(wardsCode, wardsName, districtId,
            description, start, end);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByC_N_I_D(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_I_D(wardsCode, wardsName, districtId,
            description, start, end, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByC_N_I_D_First(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence()
                   .findByC_N_I_D_First(wardsCode, wardsName, districtId,
            description, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByC_N_I_D_Last(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence()
                   .findByC_N_I_D_Last(wardsCode, wardsName, districtId,
            description, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards[] findByC_N_I_D_PrevAndNext(
        java.lang.String wardsId, java.lang.String wardsCode,
        java.lang.String wardsName, java.lang.String districtId,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence()
                   .findByC_N_I_D_PrevAndNext(wardsId, wardsCode, wardsName,
            districtId, description, obc);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByCode(
        java.lang.String wardsCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(wardsCode);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByCode(
        java.lang.String wardsCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(wardsCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByCode(
        java.lang.String wardsCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(wardsCode, start, end, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByCode_First(
        java.lang.String wardsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByCode_First(wardsCode, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByCode_Last(
        java.lang.String wardsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByCode_Last(wardsCode, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards[] findByCode_PrevAndNext(
        java.lang.String wardsId, java.lang.String wardsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByCode_PrevAndNext(wardsId, wardsCode, obc);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByName(
        java.lang.String wardsName) throws com.liferay.portal.SystemException {
        return getPersistence().findByName(wardsName);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByName(
        java.lang.String wardsName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(wardsName, start, end);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByName(
        java.lang.String wardsName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(wardsName, start, end, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByName_First(
        java.lang.String wardsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByName_First(wardsName, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByName_Last(
        java.lang.String wardsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByName_Last(wardsName, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards[] findByName_PrevAndNext(
        java.lang.String wardsId, java.lang.String wardsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByName_PrevAndNext(wardsId, wardsName, obc);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDistrictId(
        java.lang.String districtId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDistrictId(districtId);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDistrictId(
        java.lang.String districtId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDistrictId(districtId, start, end);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDistrictId(
        java.lang.String districtId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDistrictId(districtId, start, end, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByDistrictId_First(
        java.lang.String districtId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByDistrictId_First(districtId, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByDistrictId_Last(
        java.lang.String districtId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByDistrictId_Last(districtId, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards[] findByDistrictId_PrevAndNext(
        java.lang.String wardsId, java.lang.String districtId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence()
                   .findByDistrictId_PrevAndNext(wardsId, districtId, obc);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.wardsmanagement.model.Wards[] findByDescription_PrevAndNext(
        java.lang.String wardsId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException {
        return getPersistence()
                   .findByDescription_PrevAndNext(wardsId, description, obc);
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

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByC_N_I_D(java.lang.String wardsCode,
        java.lang.String wardsName, java.lang.String districtId,
        java.lang.String description) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByC_N_I_D(wardsCode, wardsName, districtId, description);
    }

    public static void removeByCode(java.lang.String wardsCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCode(wardsCode);
    }

    public static void removeByName(java.lang.String wardsName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByName(wardsName);
    }

    public static void removeByDistrictId(java.lang.String districtId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDistrictId(districtId);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByC_N_I_D(java.lang.String wardsCode,
        java.lang.String wardsName, java.lang.String districtId,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByC_N_I_D(wardsCode, wardsName, districtId, description);
    }

    public static int countByCode(java.lang.String wardsCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCode(wardsCode);
    }

    public static int countByName(java.lang.String wardsName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByName(wardsName);
    }

    public static int countByDistrictId(java.lang.String districtId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDistrictId(districtId);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
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

    public static WardsPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(WardsPersistence persistence) {
        _persistence = persistence;
    }
}
