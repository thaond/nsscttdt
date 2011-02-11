package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlFileStatusStateProcessPersistence {
    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess create(
        long id);

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess remove(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess remove(
        com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileStatusStateProcess pmlFileStatusStateProcess, boolean merge)</code>.
     */
    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess update(
        com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileStatusStateProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileStatusStateProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess update(
        com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess updateImpl(
        com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess findByFileStatusId_First(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess findByFileStatusId_Last(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess[] findByFileStatusId_PrevAndNext(
        long id, long fileStatusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess findByStateProcessId_First(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess findByStateProcessId_Last(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess[] findByStateProcessId_PrevAndNext(
        long id, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess findByFileStatus_StateProcess_First(
        long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess findByFileStatus_StateProcess_Last(
        long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess[] findByFileStatus_StateProcess_PrevAndNext(
        long id, long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlFileStatusStateProcessException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByFileStatus_StateProcess(long fileStatusId,
        long stateProcessId) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException;

    public int countByFileStatus_StateProcess(long fileStatusId,
        long stateProcessId) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
