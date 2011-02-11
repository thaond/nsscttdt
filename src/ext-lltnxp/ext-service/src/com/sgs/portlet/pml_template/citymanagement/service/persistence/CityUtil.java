package com.sgs.portlet.citymanagement.service.persistence;

public class CityUtil {
    private static CityPersistence _persistence;

    public static com.sgs.portlet.citymanagement.model.City create(
        java.lang.String cityID) {
        return getPersistence().create(cityID);
    }

    public static com.sgs.portlet.citymanagement.model.City remove(
        java.lang.String cityID)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().remove(cityID);
    }

    public static com.sgs.portlet.citymanagement.model.City remove(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(city);
    }

    /**
     * @deprecated Use <code>update(City city, boolean merge)</code>.
     */
    public static com.sgs.portlet.citymanagement.model.City update(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(city);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                city the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when city is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.citymanagement.model.City update(
        com.sgs.portlet.citymanagement.model.City city, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(city, merge);
    }

    public static com.sgs.portlet.citymanagement.model.City updateImpl(
        com.sgs.portlet.citymanagement.model.City city, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(city, merge);
    }

    public static com.sgs.portlet.citymanagement.model.City findByPrimaryKey(
        java.lang.String cityID)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByPrimaryKey(cityID);
    }

    public static com.sgs.portlet.citymanagement.model.City fetchByPrimaryKey(
        java.lang.String cityID) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(cityID);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCityActive(
        java.lang.String active) throws com.liferay.portal.SystemException {
        return getPersistence().findByCityActive(active);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCityActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCityActive(active, start, end);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCityActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCityActive(active, start, end, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByCityActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCityActive_First(active, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByCityActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCityActive_Last(active, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City[] findByCityActive_PrevAndNext(
        java.lang.String cityID, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCityActive_PrevAndNext(cityID, active, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByC_N_D(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByC_N_D(cityCode, cityName, description);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByC_N_D(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(cityCode, cityName, description, start, end);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByC_N_D(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(cityCode, cityName, description, start, end, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByC_N_D_First(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence()
                   .findByC_N_D_First(cityCode, cityName, description, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByC_N_D_Last(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence()
                   .findByC_N_D_Last(cityCode, cityName, description, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City[] findByC_N_D_PrevAndNext(
        java.lang.String cityID, java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(cityID, cityCode, cityName,
            description, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCode(
        java.lang.String cityCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(cityCode);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCode(
        java.lang.String cityCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(cityCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCode(
        java.lang.String cityCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCode(cityCode, start, end, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByCode_First(
        java.lang.String cityCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCode_First(cityCode, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByCode_Last(
        java.lang.String cityCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCode_Last(cityCode, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City[] findByCode_PrevAndNext(
        java.lang.String cityID, java.lang.String cityCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCode_PrevAndNext(cityID, cityCode, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByName(
        java.lang.String cityName) throws com.liferay.portal.SystemException {
        return getPersistence().findByName(cityName);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByName(
        java.lang.String cityName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(cityName, start, end);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByName(
        java.lang.String cityName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(cityName, start, end, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByName_First(
        java.lang.String cityName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByName_First(cityName, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByName_Last(
        java.lang.String cityName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByName_Last(cityName, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City[] findByName_PrevAndNext(
        java.lang.String cityID, java.lang.String cityName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByName_PrevAndNext(cityID, cityName, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City[] findByDescription_PrevAndNext(
        java.lang.String cityID, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence()
                   .findByDescription_PrevAndNext(cityID, description, obc);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCountryId(
        java.lang.String countryId) throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryId(countryId);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCountryId(
        java.lang.String countryId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryId(countryId, start, end);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findByCountryId(
        java.lang.String countryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryId(countryId, start, end, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByCountryId_First(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCountryId_First(countryId, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City findByCountryId_Last(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence().findByCountryId_Last(countryId, obc);
    }

    public static com.sgs.portlet.citymanagement.model.City[] findByCountryId_PrevAndNext(
        java.lang.String cityID, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException {
        return getPersistence()
                   .findByCountryId_PrevAndNext(cityID, countryId, obc);
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

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.citymanagement.model.City> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByCityActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCityActive(active);
    }

    public static void removeByC_N_D(java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_N_D(cityCode, cityName, description);
    }

    public static void removeByCode(java.lang.String cityCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCode(cityCode);
    }

    public static void removeByName(java.lang.String cityName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByName(cityName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCountryId(countryId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByCityActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCityActive(active);
    }

    public static int countByC_N_D(java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_N_D(cityCode, cityName, description);
    }

    public static int countByCode(java.lang.String cityCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCode(cityCode);
    }

    public static int countByName(java.lang.String cityName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByName(cityName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCountryId(countryId);
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

    public static CityPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CityPersistence persistence) {
        _persistence = persistence;
    }
}
