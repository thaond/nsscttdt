package com.sgs.portlet.nation.service.persistence;

public class NationUtil {
    private static NationPersistence _persistence;

    public static com.sgs.portlet.nation.model.Nation create(
        java.lang.String nationId) {
        return getPersistence().create(nationId);
    }

    public static com.sgs.portlet.nation.model.Nation remove(
        java.lang.String nationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().remove(nationId);
    }

    public static com.sgs.portlet.nation.model.Nation remove(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(nation);
    }

    /**
     * @deprecated Use <code>update(Nation nation, boolean merge)</code>.
     */
    public static com.sgs.portlet.nation.model.Nation update(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(nation);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                nation the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when nation is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.nation.model.Nation update(
        com.sgs.portlet.nation.model.Nation nation, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(nation, merge);
    }

    public static com.sgs.portlet.nation.model.Nation updateImpl(
        com.sgs.portlet.nation.model.Nation nation, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(nation, merge);
    }

    public static com.sgs.portlet.nation.model.Nation findByPrimaryKey(
        java.lang.String nationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByPrimaryKey(nationId);
    }

    public static com.sgs.portlet.nation.model.Nation fetchByPrimaryKey(
        java.lang.String nationId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(nationId);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByNationCode(
        java.lang.String nationCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByNationCode(nationCode);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByNationCode(
        java.lang.String nationCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNationCode(nationCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByNationCode(
        java.lang.String nationCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNationCode(nationCode, start, end, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByNationCode_First(
        java.lang.String nationCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByNationCode_First(nationCode, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByNationCode_Last(
        java.lang.String nationCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByNationCode_Last(nationCode, obc);
    }

    public static com.sgs.portlet.nation.model.Nation[] findByNationCode_PrevAndNext(
        java.lang.String nationId, java.lang.String nationCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByNationCode_PrevAndNext(nationId, nationCode, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByNationName(
        java.lang.String nationName) throws com.liferay.portal.SystemException {
        return getPersistence().findByNationName(nationName);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByNationName(
        java.lang.String nationName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNationName(nationName, start, end);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByNationName(
        java.lang.String nationName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNationName(nationName, start, end, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByNationName_First(
        java.lang.String nationName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByNationName_First(nationName, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByNationName_Last(
        java.lang.String nationName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByNationName_Last(nationName, obc);
    }

    public static com.sgs.portlet.nation.model.Nation[] findByNationName_PrevAndNext(
        java.lang.String nationId, java.lang.String nationName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByNationName_PrevAndNext(nationId, nationName, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.nation.model.Nation[] findByDescription_PrevAndNext(
        java.lang.String nationId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByDescription_PrevAndNext(nationId, description, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByCountryId(
        java.lang.String countryId) throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryId(countryId);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByCountryId(
        java.lang.String countryId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryId(countryId, start, end);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByCountryId(
        java.lang.String countryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCountryId(countryId, start, end, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByCountryId_First(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByCountryId_First(countryId, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByCountryId_Last(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence().findByCountryId_Last(countryId, obc);
    }

    public static com.sgs.portlet.nation.model.Nation[] findByCountryId_PrevAndNext(
        java.lang.String nationId, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByCountryId_PrevAndNext(nationId, countryId, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByC_N_D(nationCode, nationName, description);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(nationCode, nationName, description, start, end);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D(nationCode, nationName, description, start,
            end, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByC_N_D_First(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByC_N_D_First(nationCode, nationName, description, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByC_N_D_Last(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByC_N_D_Last(nationCode, nationName, description, obc);
    }

    public static com.sgs.portlet.nation.model.Nation[] findByC_N_D_PrevAndNext(
        java.lang.String nationId, java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByC_N_D_PrevAndNext(nationId, nationCode, nationName,
            description, obc);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D_C(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D_C(nationCode, nationName, description, countryId);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D_C(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D_C(nationCode, nationName, description,
            countryId, start, end);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D_C(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByC_N_D_C(nationCode, nationName, description,
            countryId, start, end, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByC_N_D_C_First(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByC_N_D_C_First(nationCode, nationName, description,
            countryId, obc);
    }

    public static com.sgs.portlet.nation.model.Nation findByC_N_D_C_Last(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByC_N_D_C_Last(nationCode, nationName, description,
            countryId, obc);
    }

    public static com.sgs.portlet.nation.model.Nation[] findByC_N_D_C_PrevAndNext(
        java.lang.String nationId, java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException {
        return getPersistence()
                   .findByC_N_D_C_PrevAndNext(nationId, nationCode, nationName,
            description, countryId, obc);
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

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.nation.model.Nation> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByNationCode(java.lang.String nationCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNationCode(nationCode);
    }

    public static void removeByNationName(java.lang.String nationName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNationName(nationName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCountryId(countryId);
    }

    public static void removeByC_N_D(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByC_N_D(nationCode, nationName, description);
    }

    public static void removeByC_N_D_C(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        java.lang.String countryId) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByC_N_D_C(nationCode, nationName, description, countryId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByNationCode(java.lang.String nationCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNationCode(nationCode);
    }

    public static int countByNationName(java.lang.String nationName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNationName(nationName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCountryId(countryId);
    }

    public static int countByC_N_D(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByC_N_D(nationCode, nationName, description);
    }

    public static int countByC_N_D_C(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        java.lang.String countryId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByC_N_D_C(nationCode, nationName, description,
            countryId);
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

    public static NationPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(NationPersistence persistence) {
        _persistence = persistence;
    }
}
