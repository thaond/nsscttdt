package com.sgs.portlet.country.service.persistence;

public class CountryUtil {
    private static CountryPersistence _persistence;

    public static com.sgs.portlet.country.model.Country create(
        java.lang.String countryId) {
        return getPersistence().create(countryId);
    }

    public static com.sgs.portlet.country.model.Country remove(
        java.lang.String countryId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().remove(countryId);
    }

    public static com.sgs.portlet.country.model.Country remove(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(country);
    }

    /**
     * @deprecated Use <code>update(Country country, boolean merge)</code>.
     */
    public static com.sgs.portlet.country.model.Country update(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(country);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                country the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when country is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.country.model.Country update(
        com.sgs.portlet.country.model.Country country, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(country, merge);
    }

    public static com.sgs.portlet.country.model.Country updateImpl(
        com.sgs.portlet.country.model.Country country, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(country, merge);
    }

    public static com.sgs.portlet.country.model.Country findByPrimaryKey(
        java.lang.String countryId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByPrimaryKey(countryId);
    }

    public static com.sgs.portlet.country.model.Country fetchByPrimaryKey(
        java.lang.String countryId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(countryId);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryCode(countryCode);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryCode(countryCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryCode(countryCode, start, end, obc);
    }

    public static com.sgs.portlet.country.model.Country findByCountryCode_First(
        java.lang.String countryCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByCountryCode_First(countryCode, obc);
    }

    public static com.sgs.portlet.country.model.Country findByCountryCode_Last(
        java.lang.String countryCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByCountryCode_Last(countryCode, obc);
    }

    public static com.sgs.portlet.country.model.Country[] findByCountryCode_PrevAndNext(
        java.lang.String countryId, java.lang.String countryCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence()
                   .findByCountryCode_PrevAndNext(countryId, countryCode, obc);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName) throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryName(countryName);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryName(countryName, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryName(countryName, start, end, obc);
    }

    public static com.sgs.portlet.country.model.Country findByCountryName_First(
        java.lang.String countryName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByCountryName_First(countryName, obc);
    }

    public static com.sgs.portlet.country.model.Country findByCountryName_Last(
        java.lang.String countryName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByCountryName_Last(countryName, obc);
    }

    public static com.sgs.portlet.country.model.Country[] findByCountryName_PrevAndNext(
        java.lang.String countryId, java.lang.String countryName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence()
                   .findByCountryName_PrevAndNext(countryId, countryName, obc);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active) throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByActive(active, start, end, obc);
    }

    public static com.sgs.portlet.country.model.Country findByActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByActive_First(active, obc);
    }

    public static com.sgs.portlet.country.model.Country findByActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByActive_Last(active, obc);
    }

    public static com.sgs.portlet.country.model.Country[] findByActive_PrevAndNext(
        java.lang.String countryId, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByActive_PrevAndNext(countryId, active, obc);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.country.model.Country findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.country.model.Country findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.country.model.Country[] findByDescription_PrevAndNext(
        java.lang.String countryId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence()
                   .findByDescription_PrevAndNext(countryId, description, obc);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(countryCode, countryName, description);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(countryCode, countryName, description, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(countryCode, countryName, description, start,
            end, obc);
    }

    public static com.sgs.portlet.country.model.Country findByC_N_D_First(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence()
                   .findByC_N_D_First(countryCode, countryName, description, obc);
    }

    public static com.sgs.portlet.country.model.Country findByC_N_D_Last(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence()
                   .findByC_N_D_Last(countryCode, countryName, description, obc);
    }

    public static com.sgs.portlet.country.model.Country[] findByC_N_D_PrevAndNext(
        java.lang.String countryId, java.lang.String countryCode,
        java.lang.String countryName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(countryId, countryCode,
            countryName, description, obc);
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

    public static java.util.List<com.sgs.portlet.country.model.Country> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.country.model.Country> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByCountryCode(java.lang.String countryCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCountryCode(countryCode);
    }

    public static void removeByCountryName(java.lang.String countryName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCountryName(countryName);
    }

    public static void removeByActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByActive(active);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByC_N_D(java.lang.String countryCode,
        java.lang.String countryName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_N_D(countryCode, countryName, description);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByCountryCode(java.lang.String countryCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCountryCode(countryCode);
    }

    public static int countByCountryName(java.lang.String countryName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCountryName(countryName);
    }

    public static int countByActive(java.lang.String active)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByActive(active);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByC_N_D(java.lang.String countryCode,
        java.lang.String countryName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByC_N_D(countryCode, countryName, description);
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

    public static CountryPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(CountryPersistence persistence) {
        _persistence = persistence;
    }
}
