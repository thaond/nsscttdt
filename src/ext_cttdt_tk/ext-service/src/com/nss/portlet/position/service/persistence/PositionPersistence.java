package com.nss.portlet.position.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PositionPersistence extends BasePersistence {
    public void cacheResult(com.nss.portlet.position.model.Position position);

    public void cacheResult(
        java.util.List<com.nss.portlet.position.model.Position> positions);

    public void clearCache();

    public com.nss.portlet.position.model.Position create(
        java.lang.String positionId);

    public com.nss.portlet.position.model.Position remove(
        java.lang.String positionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position remove(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(Position position, boolean merge)</code>.
     */
    public com.nss.portlet.position.model.Position update(
        com.nss.portlet.position.model.Position position)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                position the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when position is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.position.model.Position update(
        com.nss.portlet.position.model.Position position, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position updateImpl(
        com.nss.portlet.position.model.Position position, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position findByPrimaryKey(
        java.lang.String positionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position fetchByPrimaryKey(
        java.lang.String positionId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByPositionCode(
        java.lang.String positionCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByPositionCode(
        java.lang.String positionCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByPositionCode(
        java.lang.String positionCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position findByPositionCode_First(
        java.lang.String positionCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position findByPositionCode_Last(
        java.lang.String positionCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position[] findByPositionCode_PrevAndNext(
        java.lang.String positionId, java.lang.String positionCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public java.util.List<com.nss.portlet.position.model.Position> findByPositionName(
        java.lang.String positionName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByPositionName(
        java.lang.String positionName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByPositionName(
        java.lang.String positionName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position findByPositionName_First(
        java.lang.String positionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position findByPositionName_Last(
        java.lang.String positionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position[] findByPositionName_PrevAndNext(
        java.lang.String positionId, java.lang.String positionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public java.util.List<com.nss.portlet.position.model.Position> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position[] findByDescription_PrevAndNext(
        java.lang.String positionId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public java.util.List<com.nss.portlet.position.model.Position> findByAllfilter(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByAllfilter(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findByAllfilter(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.position.model.Position findByAllfilter_First(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position findByAllfilter_Last(
        java.lang.String positionCode, java.lang.String positionName,
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public com.nss.portlet.position.model.Position[] findByAllfilter_PrevAndNext(
        java.lang.String positionId, java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.position.NoSuchPositionException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.position.model.Position> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByPositionCode(java.lang.String positionCode)
        throws com.liferay.portal.SystemException;

    public void removeByPositionName(java.lang.String positionName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByAllfilter(java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByPositionCode(java.lang.String positionCode)
        throws com.liferay.portal.SystemException;

    public int countByPositionName(java.lang.String positionName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByAllfilter(java.lang.String positionCode,
        java.lang.String positionName, java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
