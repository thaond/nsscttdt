package com.sgs.portlet.nation.service.persistence;

public interface NationPersistence {
    public com.sgs.portlet.nation.model.Nation create(java.lang.String nationId);

    public com.sgs.portlet.nation.model.Nation remove(java.lang.String nationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation remove(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Nation nation, boolean merge)</code>.
     */
    public com.sgs.portlet.nation.model.Nation update(
        com.sgs.portlet.nation.model.Nation nation)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.nation.model.Nation update(
        com.sgs.portlet.nation.model.Nation nation, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation updateImpl(
        com.sgs.portlet.nation.model.Nation nation, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation findByPrimaryKey(
        java.lang.String nationId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation fetchByPrimaryKey(
        java.lang.String nationId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByNationCode(
        java.lang.String nationCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByNationCode(
        java.lang.String nationCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByNationCode(
        java.lang.String nationCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation findByNationCode_First(
        java.lang.String nationCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation findByNationCode_Last(
        java.lang.String nationCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation[] findByNationCode_PrevAndNext(
        java.lang.String nationId, java.lang.String nationCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByNationName(
        java.lang.String nationName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByNationName(
        java.lang.String nationName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByNationName(
        java.lang.String nationName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation findByNationName_First(
        java.lang.String nationName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation findByNationName_Last(
        java.lang.String nationName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation[] findByNationName_PrevAndNext(
        java.lang.String nationId, java.lang.String nationName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation[] findByDescription_PrevAndNext(
        java.lang.String nationId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByCountryId(
        java.lang.String countryId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByCountryId(
        java.lang.String countryId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByCountryId(
        java.lang.String countryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation findByCountryId_First(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation findByCountryId_Last(
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation[] findByCountryId_PrevAndNext(
        java.lang.String nationId, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation findByC_N_D_First(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation findByC_N_D_Last(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation[] findByC_N_D_PrevAndNext(
        java.lang.String nationId, java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D_C(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D_C(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findByC_N_D_C(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.nation.model.Nation findByC_N_D_C_First(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation findByC_N_D_C_Last(
        java.lang.String nationCode, java.lang.String nationName,
        java.lang.String description, java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public com.sgs.portlet.nation.model.Nation[] findByC_N_D_C_PrevAndNext(
        java.lang.String nationId, java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        java.lang.String countryId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.nation.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.nation.model.Nation> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByNationCode(java.lang.String nationCode)
        throws com.liferay.portal.SystemException;

    public void removeByNationName(java.lang.String nationName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_D_C(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        java.lang.String countryId) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByNationCode(java.lang.String nationCode)
        throws com.liferay.portal.SystemException;

    public int countByNationName(java.lang.String nationName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByCountryId(java.lang.String countryId)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByC_N_D_C(java.lang.String nationCode,
        java.lang.String nationName, java.lang.String description,
        java.lang.String countryId) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
