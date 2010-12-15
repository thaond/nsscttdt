package com.nss.portlet.onedoor.service.persistence;

public class PmlStateProcessUtil {
    private static PmlStateProcessPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess) {
        getPersistence().cacheResult(pmlStateProcess);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> pmlStateProcesses) {
        getPersistence().cacheResult(pmlStateProcesses);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess create(
        long stateProcessId) {
        return getPersistence().create(stateProcessId);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess remove(
        long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence().remove(stateProcessId);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess remove(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlStateProcess);
    }

    /**
     * @deprecated Use <code>update(PmlStateProcess pmlStateProcess, boolean merge)</code>.
     */
    public static com.nss.portlet.onedoor.model.PmlStateProcess update(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStateProcess);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateProcess the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateProcess is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.onedoor.model.PmlStateProcess update(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStateProcess, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess updateImpl(
        com.nss.portlet.onedoor.model.PmlStateProcess pmlStateProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlStateProcess, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByPrimaryKey(
        long stateProcessId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence().findByPrimaryKey(stateProcessId);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess fetchByPrimaryKey(
        long stateProcessId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(stateProcessId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessCode(stateProcessCode);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessCode(stateProcessCode, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode(
        java.lang.String stateProcessCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessCode(stateProcessCode, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByStateProcessCode_First(
        java.lang.String stateProcessCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessCode_First(stateProcessCode, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByStateProcessCode_Last(
        java.lang.String stateProcessCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessCode_Last(stateProcessCode, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess[] findByStateProcessCode_PrevAndNext(
        long stateProcessId, java.lang.String stateProcessCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessCode_PrevAndNext(stateProcessId,
            stateProcessCode, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessName(
        java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessName(stateProcessName);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessName(
        java.lang.String stateProcessName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessName(stateProcessName, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessName(
        java.lang.String stateProcessName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessName(stateProcessName, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByStateProcessName_First(
        java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessName_First(stateProcessName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByStateProcessName_Last(
        java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessName_Last(stateProcessName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess[] findByStateProcessName_PrevAndNext(
        long stateProcessId, java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessName_PrevAndNext(stateProcessId,
            stateProcessName, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess[] findByDescription_PrevAndNext(
        long stateProcessId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByDescription_PrevAndNext(stateProcessId, description,
            obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusId(fileStatusId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusId(fileStatusId, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByFileStatusId(
        long fileStatusId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileStatusId(fileStatusId, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByFileStatusId_First(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence().findByFileStatusId_First(fileStatusId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByFileStatusId_Last(
        long fileStatusId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence().findByFileStatusId_Last(fileStatusId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess[] findByFileStatusId_PrevAndNext(
        long stateProcessId, long fileStatusId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByFileStatusId_PrevAndNext(stateProcessId,
            fileStatusId, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode_Name(
        java.lang.String stateProcessCode, java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessCode_Name(stateProcessCode,
            stateProcessName);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode_Name(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessCode_Name(stateProcessCode,
            stateProcessName, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findByStateProcessCode_Name(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessCode_Name(stateProcessCode,
            stateProcessName, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByStateProcessCode_Name_First(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessCode_Name_First(stateProcessCode,
            stateProcessName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess findByStateProcessCode_Name_Last(
        java.lang.String stateProcessCode, java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessCode_Name_Last(stateProcessCode,
            stateProcessName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlStateProcess[] findByStateProcessCode_Name_PrevAndNext(
        long stateProcessId, java.lang.String stateProcessCode,
        java.lang.String stateProcessName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateProcessException {
        return getPersistence()
                   .findByStateProcessCode_Name_PrevAndNext(stateProcessId,
            stateProcessCode, stateProcessName, obc);
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

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlStateProcess> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByStateProcessCode(
        java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessCode(stateProcessCode);
    }

    public static void removeByStateProcessName(
        java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessName(stateProcessName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileStatusId(fileStatusId);
    }

    public static void removeByStateProcessCode_Name(
        java.lang.String stateProcessCode, java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByStateProcessCode_Name(stateProcessCode, stateProcessName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByStateProcessCode(java.lang.String stateProcessCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessCode(stateProcessCode);
    }

    public static int countByStateProcessName(java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessName(stateProcessName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByFileStatusId(long fileStatusId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileStatusId(fileStatusId);
    }

    public static int countByStateProcessCode_Name(
        java.lang.String stateProcessCode, java.lang.String stateProcessName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByStateProcessCode_Name(stateProcessCode,
            stateProcessName);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlStateProcessPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlStateProcessPersistence persistence) {
        _persistence = persistence;
    }
}
