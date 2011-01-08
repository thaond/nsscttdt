package com.sgs.portlet.onedoor.service.persistence;

public interface PmlWfOnedoorProcessPersistence {
    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess create(
        java.lang.String fileId);

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess remove(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess remove(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlWfOnedoorProcess pmlWfOnedoorProcess, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess update(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlWfOnedoorProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlWfOnedoorProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess update(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess updateImpl(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByPrimaryKey(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess fetchByPrimaryKey(
        java.lang.String fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByNodeId(
        long nodeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByNodeId(
        long nodeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByNodeId(
        long nodeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByNodeId_First(
        long nodeId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByNodeId_Last(
        long nodeId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess[] findByNodeId_PrevAndNext(
        java.lang.String fileId, long nodeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByProcessId(
        long processId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByProcessId(
        long processId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByProcessId(
        long processId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByProcessId_First(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByProcessId_Last(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess[] findByProcessId_PrevAndNext(
        java.lang.String fileId, long processId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByNodeId(long nodeId)
        throws com.liferay.portal.SystemException;

    public void removeByProcessId(long processId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByNodeId(long nodeId)
        throws com.liferay.portal.SystemException;

    public int countByProcessId(long processId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
