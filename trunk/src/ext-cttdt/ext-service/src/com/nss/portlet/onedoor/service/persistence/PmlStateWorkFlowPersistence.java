package com.nss.portlet.onedoor.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PmlStateWorkFlowPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow);

    public void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> pmlStateWorkFlows);

    public void clearCache();

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow create(long stateWfId);

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow remove(long stateWfId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow remove(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlStateWorkFlow pmlStateWorkFlow, boolean merge)</code>.
     */
    public com.nss.portlet.onedoor.model.PmlStateWorkFlow update(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlStateWorkFlow the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlStateWorkFlow is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.onedoor.model.PmlStateWorkFlow update(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow updateImpl(
        com.nss.portlet.onedoor.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByPrimaryKey(
        long stateWfId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow fetchByPrimaryKey(
        long stateWfId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByWorkFlow_StateProcessId_Version_First(
        java.lang.String workflow, long stateProcessId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByWorkFlow_StateProcessId_Version_Last(
        java.lang.String workflow, long stateProcessId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow[] findByWorkFlow_StateProcessId_Version_PrevAndNext(
        long stateWfId, java.lang.String workflow, long stateProcessId,
        int version_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findBySolvingTime(
        int solvingTime) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findBySolvingTime(
        int solvingTime, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findBySolvingTime(
        int solvingTime, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findBySolvingTime_First(
        int solvingTime, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findBySolvingTime_Last(
        int solvingTime, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow[] findBySolvingTime_PrevAndNext(
        long stateWfId, int solvingTime,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkflow(
        java.lang.String workflow) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkflow(
        java.lang.String workflow, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkflow(
        java.lang.String workflow, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByWorkflow_First(
        java.lang.String workflow,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByWorkflow_Last(
        java.lang.String workflow,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow[] findByWorkflow_PrevAndNext(
        long stateWfId, java.lang.String workflow,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByStateProcessId(
        long stateProcessId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByStateProcessId(
        long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByStateProcessId(
        long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByStateProcessId_First(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByStateProcessId_Last(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow[] findByStateProcessId_PrevAndNext(
        long stateWfId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_Version(
        java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByWorkFlow_Version_First(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow findByWorkFlow_Version_Last(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public com.nss.portlet.onedoor.model.PmlStateWorkFlow[] findByWorkFlow_Version_PrevAndNext(
        long stateWfId, java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlStateWorkFlowException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlStateWorkFlow> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_)
        throws com.liferay.portal.SystemException;

    public void removeBySolvingTime(int solvingTime)
        throws com.liferay.portal.SystemException;

    public void removeByWorkflow(java.lang.String workflow)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByWorkFlow_Version(java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_)
        throws com.liferay.portal.SystemException;

    public int countBySolvingTime(int solvingTime)
        throws com.liferay.portal.SystemException;

    public int countByWorkflow(java.lang.String workflow)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException;

    public int countByWorkFlow_Version(java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
