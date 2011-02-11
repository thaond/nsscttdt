package com.sgs.portlet.onedoor.service.persistence;

public class PmlWfOnedoorProcessUtil {
    private static PmlWfOnedoorProcessPersistence _persistence;

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess create(
        java.lang.String fileId) {
        return getPersistence().create(fileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess remove(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence().remove(fileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess remove(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlWfOnedoorProcess);
    }

    /**
     * @deprecated Use <code>update(PmlWfOnedoorProcess pmlWfOnedoorProcess, boolean merge)</code>.
     */
    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess update(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlWfOnedoorProcess);
    }

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
    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess update(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlWfOnedoorProcess, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess updateImpl(
        com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess pmlWfOnedoorProcess,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlWfOnedoorProcess, merge);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByPrimaryKey(
        java.lang.String fileId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence().findByPrimaryKey(fileId);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess fetchByPrimaryKey(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByNodeId(
        long nodeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByNodeId(nodeId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByNodeId(
        long nodeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNodeId(nodeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByNodeId(
        long nodeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNodeId(nodeId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByNodeId_First(
        long nodeId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence().findByNodeId_First(nodeId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByNodeId_Last(
        long nodeId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence().findByNodeId_Last(nodeId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess[] findByNodeId_PrevAndNext(
        java.lang.String fileId, long nodeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence().findByNodeId_PrevAndNext(fileId, nodeId, obc);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByProcessId(
        long processId) throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessId(processId);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByProcessId(
        long processId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessId(processId, start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findByProcessId(
        long processId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessId(processId, start, end, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByProcessId_First(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence().findByProcessId_First(processId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess findByProcessId_Last(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence().findByProcessId_Last(processId, obc);
    }

    public static com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess[] findByProcessId_PrevAndNext(
        java.lang.String fileId, long processId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWfOnedoorProcessException {
        return getPersistence()
                   .findByProcessId_PrevAndNext(fileId, processId, obc);
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

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.onedoor.model.PmlWfOnedoorProcess> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByNodeId(long nodeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNodeId(nodeId);
    }

    public static void removeByProcessId(long processId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByProcessId(processId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByNodeId(long nodeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNodeId(nodeId);
    }

    public static int countByProcessId(long processId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByProcessId(processId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlWfOnedoorProcessPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlWfOnedoorProcessPersistence persistence) {
        _persistence = persistence;
    }
}
