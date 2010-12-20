package com.nss.portlet.onedoor.service.persistence;

public class PmlWorkflowUtil {
    private static PmlWorkflowPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow) {
        getPersistence().cacheResult(pmlWorkflow);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> pmlWorkflows) {
        getPersistence().cacheResult(pmlWorkflows);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow create(
        long workflowId) {
        return getPersistence().create(workflowId);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow remove(
        long workflowId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence().remove(workflowId);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow remove(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlWorkflow);
    }

    /**
     * @deprecated Use <code>update(PmlWorkflow pmlWorkflow, boolean merge)</code>.
     */
    public static com.nss.portlet.onedoor.model.PmlWorkflow update(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlWorkflow);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlWorkflow the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlWorkflow is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.onedoor.model.PmlWorkflow update(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlWorkflow, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow updateImpl(
        com.nss.portlet.onedoor.model.PmlWorkflow pmlWorkflow, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlWorkflow, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByPrimaryKey(
        long workflowId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence().findByPrimaryKey(workflowId);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow fetchByPrimaryKey(
        long workflowId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(workflowId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence().findByFileTypeId_First(fileTypeId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence().findByFileTypeId_Last(fileTypeId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow[] findByFileTypeId_PrevAndNext(
        long workflowId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByFileTypeId_PrevAndNext(workflowId, fileTypeId, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_StartDate(
        java.lang.String fileTypeId, java.util.Date startDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId_StartDate(fileTypeId, startDate);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_StartDate(
        java.lang.String fileTypeId, java.util.Date startDate, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_StartDate(fileTypeId, startDate, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_StartDate(
        java.lang.String fileTypeId, java.util.Date startDate, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_StartDate(fileTypeId, startDate, start,
            end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByFileTypeId_StartDate_First(
        java.lang.String fileTypeId, java.util.Date startDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByFileTypeId_StartDate_First(fileTypeId, startDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByFileTypeId_StartDate_Last(
        java.lang.String fileTypeId, java.util.Date startDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByFileTypeId_StartDate_Last(fileTypeId, startDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow[] findByFileTypeId_StartDate_PrevAndNext(
        long workflowId, java.lang.String fileTypeId, java.util.Date startDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByFileTypeId_StartDate_PrevAndNext(workflowId,
            fileTypeId, startDate, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByWorkFlow_Version(
        java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkFlow_Version(workflow, version_);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByWorkFlow_Version(workflow, version_, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByWorkFlow_Version(workflow, version_, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByWorkFlow_Version_First(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByWorkFlow_Version_First(workflow, version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByWorkFlow_Version_Last(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByWorkFlow_Version_Last(workflow, version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow[] findByWorkFlow_Version_PrevAndNext(
        long workflowId, java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByWorkFlow_Version_PrevAndNext(workflowId, workflow,
            version_, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_Version(
        java.lang.String fileTypeId, int version_)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId_Version(fileTypeId, version_);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_Version(
        java.lang.String fileTypeId, int version_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_Version(fileTypeId, version_, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_Version(
        java.lang.String fileTypeId, int version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_Version(fileTypeId, version_, start, end,
            obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByFileTypeId_Version_First(
        java.lang.String fileTypeId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByFileTypeId_Version_First(fileTypeId, version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow findByFileTypeId_Version_Last(
        java.lang.String fileTypeId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByFileTypeId_Version_Last(fileTypeId, version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlWorkflow[] findByFileTypeId_Version_PrevAndNext(
        long workflowId, java.lang.String fileTypeId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlWorkflowException {
        return getPersistence()
                   .findByFileTypeId_Version_PrevAndNext(workflowId,
            fileTypeId, version_, obc);
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

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId(fileTypeId);
    }

    public static void removeByFileTypeId_StartDate(
        java.lang.String fileTypeId, java.util.Date startDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId_StartDate(fileTypeId, startDate);
    }

    public static void removeByWorkFlow_Version(java.lang.String workflow,
        int version_) throws com.liferay.portal.SystemException {
        getPersistence().removeByWorkFlow_Version(workflow, version_);
    }

    public static void removeByFileTypeId_Version(java.lang.String fileTypeId,
        int version_) throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId_Version(fileTypeId, version_);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId(fileTypeId);
    }

    public static int countByFileTypeId_StartDate(java.lang.String fileTypeId,
        java.util.Date startDate) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileTypeId_StartDate(fileTypeId, startDate);
    }

    public static int countByWorkFlow_Version(java.lang.String workflow,
        int version_) throws com.liferay.portal.SystemException {
        return getPersistence().countByWorkFlow_Version(workflow, version_);
    }

    public static int countByFileTypeId_Version(java.lang.String fileTypeId,
        int version_) throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId_Version(fileTypeId, version_);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlWorkflowPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlWorkflowPersistence persistence) {
        _persistence = persistence;
    }
}
