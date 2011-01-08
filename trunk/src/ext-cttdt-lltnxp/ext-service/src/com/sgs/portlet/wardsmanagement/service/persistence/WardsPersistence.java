package com.sgs.portlet.wardsmanagement.service.persistence;

public interface WardsPersistence {
    public com.sgs.portlet.wardsmanagement.model.Wards create(
        java.lang.String wardsId);

    public com.sgs.portlet.wardsmanagement.model.Wards remove(
        java.lang.String wardsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards remove(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Wards wards, boolean merge)</code>.
     */
    public com.sgs.portlet.wardsmanagement.model.Wards update(
        com.sgs.portlet.wardsmanagement.model.Wards wards)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.wardsmanagement.model.Wards update(
        com.sgs.portlet.wardsmanagement.model.Wards wards, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards updateImpl(
        com.sgs.portlet.wardsmanagement.model.Wards wards, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByPrimaryKey(
        java.lang.String wardsId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards fetchByPrimaryKey(
        java.lang.String wardsId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByC_N_I_D(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByC_N_I_D(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByC_N_I_D(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByC_N_I_D_First(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByC_N_I_D_Last(
        java.lang.String wardsCode, java.lang.String wardsName,
        java.lang.String districtId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards[] findByC_N_I_D_PrevAndNext(
        java.lang.String wardsId, java.lang.String wardsCode,
        java.lang.String wardsName, java.lang.String districtId,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByCode(
        java.lang.String wardsCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByCode(
        java.lang.String wardsCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByCode(
        java.lang.String wardsCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByCode_First(
        java.lang.String wardsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByCode_Last(
        java.lang.String wardsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards[] findByCode_PrevAndNext(
        java.lang.String wardsId, java.lang.String wardsCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByName(
        java.lang.String wardsName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByName(
        java.lang.String wardsName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByName(
        java.lang.String wardsName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByName_First(
        java.lang.String wardsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByName_Last(
        java.lang.String wardsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards[] findByName_PrevAndNext(
        java.lang.String wardsId, java.lang.String wardsName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDistrictId(
        java.lang.String districtId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDistrictId(
        java.lang.String districtId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDistrictId(
        java.lang.String districtId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByDistrictId_First(
        java.lang.String districtId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByDistrictId_Last(
        java.lang.String districtId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards[] findByDistrictId_PrevAndNext(
        java.lang.String wardsId, java.lang.String districtId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public com.sgs.portlet.wardsmanagement.model.Wards[] findByDescription_PrevAndNext(
        java.lang.String wardsId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.wardsmanagement.NoSuchWardsException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_I_D(java.lang.String wardsCode,
        java.lang.String wardsName, java.lang.String districtId,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public void removeByCode(java.lang.String wardsCode)
        throws com.liferay.portal.SystemException;

    public void removeByName(java.lang.String wardsName)
        throws com.liferay.portal.SystemException;

    public void removeByDistrictId(java.lang.String districtId)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByC_N_I_D(java.lang.String wardsCode,
        java.lang.String wardsName, java.lang.String districtId,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public int countByCode(java.lang.String wardsCode)
        throws com.liferay.portal.SystemException;

    public int countByName(java.lang.String wardsName)
        throws com.liferay.portal.SystemException;

    public int countByDistrictId(java.lang.String districtId)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
