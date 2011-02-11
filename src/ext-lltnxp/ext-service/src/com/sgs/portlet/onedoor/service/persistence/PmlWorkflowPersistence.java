package com.sgs.portlet.onedoor.service.persistence;

public interface PmlWorkflowPersistence {
    public com.sgs.portlet.onedoor.model.PmlWorkflow create(long workflowId);

    public com.sgs.portlet.onedoor.model.PmlWorkflow remove(long workflowId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow remove(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlWorkflow pmlWorkflow, boolean merge)</code>.
     */
    public com.sgs.portlet.onedoor.model.PmlWorkflow update(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.onedoor.model.PmlWorkflow update(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow updateImpl(
        com.sgs.portlet.onedoor.model.PmlWorkflow pmlWorkflow, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByPrimaryKey(
        long workflowId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow fetchByPrimaryKey(
        long workflowId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow[] findByFileTypeId_PrevAndNext(
        long workflowId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_StartDate(
        java.lang.String fileTypeId, java.util.Date startDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_StartDate(
        java.lang.String fileTypeId, java.util.Date startDate, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_StartDate(
        java.lang.String fileTypeId, java.util.Date startDate, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByFileTypeId_StartDate_First(
        java.lang.String fileTypeId, java.util.Date startDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByFileTypeId_StartDate_Last(
        java.lang.String fileTypeId, java.util.Date startDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow[] findByFileTypeId_StartDate_PrevAndNext(
        long workflowId, java.lang.String fileTypeId, java.util.Date startDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByWorkFlow_Version(
        java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByWorkFlow_Version_First(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByWorkFlow_Version_Last(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow[] findByWorkFlow_Version_PrevAndNext(
        long workflowId, java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_Version(
        java.lang.String fileTypeId, int version_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_Version(
        java.lang.String fileTypeId, int version_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByFileTypeId_Version(
        java.lang.String fileTypeId, int version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByFileTypeId_Version_First(
        java.lang.String fileTypeId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow findByFileTypeId_Version_Last(
        java.lang.String fileTypeId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public com.sgs.portlet.onedoor.model.PmlWorkflow[] findByFileTypeId_Version_PrevAndNext(
        long workflowId, java.lang.String fileTypeId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.onedoor.NoSuchPmlWorkflowException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId_StartDate(java.lang.String fileTypeId,
        java.util.Date startDate) throws com.liferay.portal.SystemException;

    public void removeByWorkFlow_Version(java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId_Version(java.lang.String fileTypeId,
        int version_) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeId_StartDate(java.lang.String fileTypeId,
        java.util.Date startDate) throws com.liferay.portal.SystemException;

    public int countByWorkFlow_Version(java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeId_Version(java.lang.String fileTypeId,
        int version_) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
