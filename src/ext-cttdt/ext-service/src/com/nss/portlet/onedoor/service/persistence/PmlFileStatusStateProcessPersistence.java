package com.nss.portlet.onedoor.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PmlFileStatusStateProcessPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess);

    public void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> pmlFileStatusStateProcesses);

    public void clearCache();

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess create(
        long id);

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess remove(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess remove(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileStatusStateProcess pmlFileStatusStateProcess, boolean merge)</code>.
     */
    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess update(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
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
    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess update(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess updateImpl(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatusId_First(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatusId_Last(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[] findByFileStatusId_PrevAndNext(
        long id, long fileStatusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByStateProcessId_First(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByStateProcessId_Last(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[] findByStateProcessId_PrevAndNext(
        long id, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatus_StateProcess_First(
        long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatus_StateProcess_Last(
        long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[] findByFileStatus_StateProcess_PrevAndNext(
        long id, long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findAll(
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
}
