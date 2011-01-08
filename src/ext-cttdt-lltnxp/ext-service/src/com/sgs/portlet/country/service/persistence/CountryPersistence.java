package com.sgs.portlet.country.service.persistence;

public interface CountryPersistence {
    public com.sgs.portlet.country.model.Country create(
        java.lang.String countryId);

    public com.sgs.portlet.country.model.Country remove(
        java.lang.String countryId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country remove(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Country country, boolean merge)</code>.
     */
    public com.sgs.portlet.country.model.Country update(
        com.sgs.portlet.country.model.Country country)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.country.model.Country update(
        com.sgs.portlet.country.model.Country country, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country updateImpl(
        com.sgs.portlet.country.model.Country country, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country findByPrimaryKey(
        java.lang.String countryId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country fetchByPrimaryKey(
        java.lang.String countryId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryCode(
        java.lang.String countryCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country findByCountryCode_First(
        java.lang.String countryCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country findByCountryCode_Last(
        java.lang.String countryCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country[] findByCountryCode_PrevAndNext(
        java.lang.String countryId, java.lang.String countryCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByCountryName(
        java.lang.String countryName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country findByCountryName_First(
        java.lang.String countryName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country findByCountryName_Last(
        java.lang.String countryName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country[] findByCountryName_PrevAndNext(
        java.lang.String countryId, java.lang.String countryName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country findByActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country findByActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country[] findByActive_PrevAndNext(
        java.lang.String countryId, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country[] findByDescription_PrevAndNext(
        java.lang.String countryId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findByC_N_D(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.country.model.Country findByC_N_D_First(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country findByC_N_D_Last(
        java.lang.String countryCode, java.lang.String countryName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public com.sgs.portlet.country.model.Country[] findByC_N_D_PrevAndNext(
        java.lang.String countryId, java.lang.String countryCode,
        java.lang.String countryName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.country.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.country.model.Country> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByCountryCode(java.lang.String countryCode)
        throws com.liferay.portal.SystemException;

    public void removeByCountryName(java.lang.String countryName)
        throws com.liferay.portal.SystemException;

    public void removeByActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String countryCode,
        java.lang.String countryName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByCountryCode(java.lang.String countryCode)
        throws com.liferay.portal.SystemException;

    public int countByCountryName(java.lang.String countryName)
        throws com.liferay.portal.SystemException;

    public int countByActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String countryCode,
        java.lang.String countryName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
