package com.sgs.portlet.districtmanagement.service.persistence;

public class DistrictUtil {
    private static DistrictPersistence _persistence;

    public static com.sgs.portlet.districtmanagement.model.District create(
        java.lang.String districtId) {
        return getPersistence().create(districtId);
    }

    public static com.sgs.portlet.districtmanagement.model.District remove(
        java.lang.String districtId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().remove(districtId);
    }

    public static com.sgs.portlet.districtmanagement.model.District remove(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(district);
    }

    /**
     * @deprecated Use <code>update(District district, boolean merge)</code>.
     */
    public static com.sgs.portlet.districtmanagement.model.District update(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(district);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                district the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when district is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.districtmanagement.model.District update(
        com.sgs.portlet.districtmanagement.model.District district,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(district, merge);
    }

    public static com.sgs.portlet.districtmanagement.model.District updateImpl(
        com.sgs.portlet.districtmanagement.model.District district,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(district, merge);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByPrimaryKey(
        java.lang.String districtId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByPrimaryKey(districtId);
    }

    public static com.sgs.portlet.districtmanagement.model.District fetchByPrimaryKey(
        java.lang.String districtId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(districtId);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDistrictActive(
        java.lang.String active) throws com.liferay.portal.SystemException {
        return getPersistence().findByDistrictActive(active);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDistrictActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDistrictActive(active, start, end);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDistrictActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDistrictActive(active, start, end, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByDistrictActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByDistrictActive_First(active, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByDistrictActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByDistrictActive_Last(active, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District[] findByDistrictActive_PrevAndNext(
        java.lang.String districtId, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence()
                   .findByDistrictActive_PrevAndNext(districtId, active, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByC_N_I_D(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_I_D(districtCode, districtName, cityID,
            description);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByC_N_I_D(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_I_D(districtCode, districtName, cityID,
            description, start, end);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByC_N_I_D(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_I_D(districtCode, districtName, cityID,
            description, start, end, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByC_N_I_D_First(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence()
                   .findByC_N_I_D_First(districtCode, districtName, cityID,
            description, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByC_N_I_D_Last(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence()
                   .findByC_N_I_D_Last(districtCode, districtName, cityID,
            description, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District[] findByC_N_I_D_PrevAndNext(
        java.lang.String districtId, java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence()
                   .findByC_N_I_D_PrevAndNext(districtId, districtCode,
            districtName, cityID, description, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCode(
        java.lang.String districtCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(districtCode);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCode(
        java.lang.String districtCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(districtCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCode(
        java.lang.String districtCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(districtCode, start, end, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByCode_First(
        java.lang.String districtCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByCode_First(districtCode, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByCode_Last(
        java.lang.String districtCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByCode_Last(districtCode, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District[] findByCode_PrevAndNext(
        java.lang.String districtId, java.lang.String districtCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence()
                   .findByCode_PrevAndNext(districtId, districtCode, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByName(
        java.lang.String districtName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(districtName);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByName(
        java.lang.String districtName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(districtName, start, end);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByName(
        java.lang.String districtName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(districtName, start, end, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByName_First(
        java.lang.String districtName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByName_First(districtName, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByName_Last(
        java.lang.String districtName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByName_Last(districtName, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District[] findByName_PrevAndNext(
        java.lang.String districtId, java.lang.String districtName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence()
                   .findByName_PrevAndNext(districtId, districtName, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCityID(
        java.lang.String cityID) throws com.liferay.portal.SystemException {
        return getPersistence().findByCityID(cityID);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCityID(
        java.lang.String cityID, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCityID(cityID, start, end);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCityID(
        java.lang.String cityID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCityID(cityID, start, end, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByCityID_First(
        java.lang.String cityID,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByCityID_First(cityID, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByCityID_Last(
        java.lang.String cityID,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByCityID_Last(cityID, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District[] findByCityID_PrevAndNext(
        java.lang.String districtId, java.lang.String cityID,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByCityID_PrevAndNext(districtId, cityID, obc);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.districtmanagement.model.District[] findByDescription_PrevAndNext(
        java.lang.String districtId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException {
        return getPersistence()
                   .findByDescription_PrevAndNext(districtId, description, obc);
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

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.districtmanagement.model.District> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDistrictActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDistrictActive(active);
    }

    public static void removeByC_N_I_D(java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByC_N_I_D(districtCode, districtName, cityID, description);
    }

    public static void removeByCode(java.lang.String districtCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCode(districtCode);
    }

    public static void removeByName(java.lang.String districtName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByName(districtName);
    }

    public static void removeByCityID(java.lang.String cityID)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCityID(cityID);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDistrictActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDistrictActive(active);
    }

    public static int countByC_N_I_D(java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByC_N_I_D(districtCode, districtName, cityID,
            description);
    }

    public static int countByCode(java.lang.String districtCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCode(districtCode);
    }

    public static int countByName(java.lang.String districtName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByName(districtName);
    }

    public static int countByCityID(java.lang.String cityID)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCityID(cityID);
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

    public static DistrictPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(DistrictPersistence persistence) {
        _persistence = persistence;
    }
}
