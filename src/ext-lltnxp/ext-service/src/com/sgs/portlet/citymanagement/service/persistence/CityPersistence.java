package com.sgs.portlet.citymanagement.service.persistence;

public interface CityPersistence {
    public com.sgs.portlet.citymanagement.model.City create(
        java.lang.String cityID);

    public com.sgs.portlet.citymanagement.model.City remove(
        java.lang.String cityID)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City remove(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(City city, boolean merge)</code>.
     */
    public com.sgs.portlet.citymanagement.model.City update(
        com.sgs.portlet.citymanagement.model.City city)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.citymanagement.model.City update(
        com.sgs.portlet.citymanagement.model.City city, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City updateImpl(
        com.sgs.portlet.citymanagement.model.City city, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City findByPrimaryKey(
        java.lang.String cityID)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City fetchByPrimaryKey(
        java.lang.String cityID) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCityActive(
        java.lang.String active) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCityActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCityActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City findByCityActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City findByCityActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City[] findByCityActive_PrevAndNext(
        java.lang.String cityID, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByC_N_D(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByC_N_D(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByC_N_D(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City findByC_N_D_First(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City findByC_N_D_Last(
        java.lang.String cityCode, java.lang.String cityName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City[] findByC_N_D_PrevAndNext(
        java.lang.String cityID, java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCode(
        java.lang.String cityCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCode(
        java.lang.String cityCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCode(
        java.lang.String cityCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City findByCode_First(
        java.lang.String cityCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City findByCode_Last(
        java.lang.String cityCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City[] findByCode_PrevAndNext(
        java.lang.String cityID, java.lang.String cityCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByName(
        java.lang.String cityName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByName(
        java.lang.String cityName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByName(
        java.lang.String cityName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City findByName_First(
        java.lang.String cityName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City findByName_Last(
        java.lang.String cityName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City[] findByName_PrevAndNext(
        java.lang.String cityID, java.lang.String cityName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City[] findByDescription_PrevAndNext(
        java.lang.String cityID, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCountryId(
        java.lang.String countryId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCountryId(
        java.lang.String countryId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByCountryId(
        java.lang.String countryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.citymanagement.model.City findByCountryId_First(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City findByCountryId_Last(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public com.sgs.portlet.citymanagement.model.City[] findByCountryId_PrevAndNext(
        java.lang.String cityID, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.citymanagement.NoSuchCityException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByCityActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByCode(java.lang.String cityCode)
        throws com.liferay.portal.SystemException;

    public void removeByName(java.lang.String cityName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByCityActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String cityCode,
        java.lang.String cityName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByCode(java.lang.String cityCode)
        throws com.liferay.portal.SystemException;

    public int countByName(java.lang.String cityName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
