package com.sgs.portlet.districtmanagement.service.persistence;

public interface DistrictPersistence {
    public com.sgs.portlet.districtmanagement.model.District create(
        java.lang.String districtId);

    public com.sgs.portlet.districtmanagement.model.District remove(
        java.lang.String districtId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District remove(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(District district, boolean merge)</code>.
     */
    public com.sgs.portlet.districtmanagement.model.District update(
        com.sgs.portlet.districtmanagement.model.District district)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.districtmanagement.model.District update(
        com.sgs.portlet.districtmanagement.model.District district,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District updateImpl(
        com.sgs.portlet.districtmanagement.model.District district,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District findByPrimaryKey(
        java.lang.String districtId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District fetchByPrimaryKey(
        java.lang.String districtId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDistrictActive(
        java.lang.String active) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDistrictActive(
        java.lang.String active, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDistrictActive(
        java.lang.String active, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District findByDistrictActive_First(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District findByDistrictActive_Last(
        java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District[] findByDistrictActive_PrevAndNext(
        java.lang.String districtId, java.lang.String active,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByC_N_I_D(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByC_N_I_D(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByC_N_I_D(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District findByC_N_I_D_First(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District findByC_N_I_D_Last(
        java.lang.String districtCode, java.lang.String districtName,
        java.lang.String cityID, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District[] findByC_N_I_D_PrevAndNext(
        java.lang.String districtId, java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCode(
        java.lang.String districtCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCode(
        java.lang.String districtCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCode(
        java.lang.String districtCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District findByCode_First(
        java.lang.String districtCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District findByCode_Last(
        java.lang.String districtCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District[] findByCode_PrevAndNext(
        java.lang.String districtId, java.lang.String districtCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByName(
        java.lang.String districtName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByName(
        java.lang.String districtName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByName(
        java.lang.String districtName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District findByName_First(
        java.lang.String districtName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District findByName_Last(
        java.lang.String districtName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District[] findByName_PrevAndNext(
        java.lang.String districtId, java.lang.String districtName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCityID(
        java.lang.String cityID) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCityID(
        java.lang.String cityID, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByCityID(
        java.lang.String cityID, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District findByCityID_First(
        java.lang.String cityID,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District findByCityID_Last(
        java.lang.String cityID,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District[] findByCityID_PrevAndNext(
        java.lang.String districtId, java.lang.String cityID,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.districtmanagement.model.District findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public com.sgs.portlet.districtmanagement.model.District[] findByDescription_PrevAndNext(
        java.lang.String districtId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.districtmanagement.NoSuchDistrictException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDistrictActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public void removeByC_N_I_D(java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public void removeByCode(java.lang.String districtCode)
        throws com.liferay.portal.SystemException;

    public void removeByName(java.lang.String districtName)
        throws com.liferay.portal.SystemException;

    public void removeByCityID(java.lang.String cityID)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDistrictActive(java.lang.String active)
        throws com.liferay.portal.SystemException;

    public int countByC_N_I_D(java.lang.String districtCode,
        java.lang.String districtName, java.lang.String cityID,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public int countByCode(java.lang.String districtCode)
        throws com.liferay.portal.SystemException;

    public int countByName(java.lang.String districtName)
        throws com.liferay.portal.SystemException;

    public int countByCityID(java.lang.String cityID)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
