package com.nss.portlet.onedoor.service.persistence;

public class PmlFileStatusStateProcessUtil {
    private static PmlFileStatusStateProcessPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess) {
        getPersistence().cacheResult(pmlFileStatusStateProcess);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> pmlFileStatusStateProcesses) {
        getPersistence().cacheResult(pmlFileStatusStateProcesses);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess create(
        long id) {
        return getPersistence().create(id);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess remove(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence().remove(id);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess remove(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFileStatusStateProcess);
    }

    /**
     * @deprecated Use <code>update(PmlFileStatusStateProcess pmlFileStatusStateProcess, boolean merge)</code>.
     */
    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess update(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileStatusStateProcess);
    }

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
    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess update(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileStatusStateProcess, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess updateImpl(
        com.nss.portlet.onedoor.model.PmlFileStatusStateProcess pmlFileStatusStateProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFileStatusStateProcess, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByPrimaryKey(
        long id)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence().findByPrimaryKey(id);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess fetchByPrimaryKey(
        long id) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(id);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusId(fileStatusId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusId(fileStatusId, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusId(fileStatusId, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatusId_First(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence().findByFileStatusId_First(fileStatusId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatusId_Last(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence().findByFileStatusId_Last(fileStatusId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[] findByFileStatusId_PrevAndNext(
        long id, long fileStatusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence()
                   .findByFileStatusId_PrevAndNext(id, fileStatusId, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessId(stateProcessId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessId(stateProcessId, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByStateProcessId(
        long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessId(stateProcessId, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByStateProcessId_First(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence().findByStateProcessId_First(stateProcessId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByStateProcessId_Last(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence().findByStateProcessId_Last(stateProcessId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[] findByStateProcessId_PrevAndNext(
        long id, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence()
                   .findByStateProcessId_PrevAndNext(id, stateProcessId, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileStatus_StateProcess(fileStatusId, stateProcessId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileStatus_StateProcess(fileStatusId, stateProcessId,
            start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findByFileStatus_StateProcess(
        long fileStatusId, long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileStatus_StateProcess(fileStatusId, stateProcessId,
            start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatus_StateProcess_First(
        long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence()
                   .findByFileStatus_StateProcess_First(fileStatusId,
            stateProcessId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess findByFileStatus_StateProcess_Last(
        long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence()
                   .findByFileStatus_StateProcess_Last(fileStatusId,
            stateProcessId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlFileStatusStateProcess[] findByFileStatus_StateProcess_PrevAndNext(
        long id, long fileStatusId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlFileStatusStateProcessException {
        return getPersistence()
                   .findByFileStatus_StateProcess_PrevAndNext(id, fileStatusId,
            stateProcessId, obc);
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

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatusStateProcess> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileStatusId(fileStatusId);
    }

    public static void removeByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessId(stateProcessId);
    }

    public static void removeByFileStatus_StateProcess(long fileStatusId,
        long stateProcessId) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByFileStatus_StateProcess(fileStatusId, stateProcessId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileStatusId(fileStatusId);
    }

    public static int countByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessId(stateProcessId);
    }

    public static int countByFileStatus_StateProcess(long fileStatusId,
        long stateProcessId) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileStatus_StateProcess(fileStatusId, stateProcessId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlFileStatusStateProcessPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFileStatusStateProcessPersistence persistence) {
        _persistence = persistence;
    }
}
