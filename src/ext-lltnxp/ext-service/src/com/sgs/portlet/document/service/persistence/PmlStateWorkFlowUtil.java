package com.sgs.portlet.document.service.persistence;

public class PmlStateWorkFlowUtil {
    private static PmlStateWorkFlowPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlStateWorkFlow create(
        long stateWfId) {
        return getPersistence().create(stateWfId);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow remove(
        long stateWfId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().remove(stateWfId);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow remove(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlStateWorkFlow);
    }

    /**
     * @deprecated Use <code>update(PmlStateWorkFlow pmlStateWorkFlow, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlStateWorkFlow update(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStateWorkFlow);
    }

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
    public static com.sgs.portlet.document.model.PmlStateWorkFlow update(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlStateWorkFlow, merge);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow updateImpl(
        com.sgs.portlet.document.model.PmlStateWorkFlow pmlStateWorkFlow,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlStateWorkFlow, merge);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByPrimaryKey(
        long stateWfId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().findByPrimaryKey(stateWfId);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow fetchByPrimaryKey(
        long stateWfId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(stateWfId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByWorkFlow_StateProcessId_Version(workflow,
            stateProcessId, version_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByWorkFlow_StateProcessId_Version(workflow,
            stateProcessId, version_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByWorkFlow_StateProcessId_Version(workflow,
            stateProcessId, version_, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByWorkFlow_StateProcessId_Version_First(
        java.lang.String workflow, long stateProcessId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByWorkFlow_StateProcessId_Version_First(workflow,
            stateProcessId, version_, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByWorkFlow_StateProcessId_Version_Last(
        java.lang.String workflow, long stateProcessId, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByWorkFlow_StateProcessId_Version_Last(workflow,
            stateProcessId, version_, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow[] findByWorkFlow_StateProcessId_Version_PrevAndNext(
        long stateWfId, java.lang.String workflow, long stateProcessId,
        int version_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByWorkFlow_StateProcessId_Version_PrevAndNext(stateWfId,
            workflow, stateProcessId, version_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findBySolvingTime(
        int solvingTime) throws com.liferay.portal.SystemException {
        return getPersistence().findBySolvingTime(solvingTime);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findBySolvingTime(
        int solvingTime, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySolvingTime(solvingTime, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findBySolvingTime(
        int solvingTime, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySolvingTime(solvingTime, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findBySolvingTime_First(
        int solvingTime, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().findBySolvingTime_First(solvingTime, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findBySolvingTime_Last(
        int solvingTime, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().findBySolvingTime_Last(solvingTime, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow[] findBySolvingTime_PrevAndNext(
        long stateWfId, int solvingTime,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findBySolvingTime_PrevAndNext(stateWfId, solvingTime, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkflow(
        java.lang.String workflow) throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkflow(workflow);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkflow(
        java.lang.String workflow, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkflow(workflow, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkflow(
        java.lang.String workflow, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkflow(workflow, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByWorkflow_First(
        java.lang.String workflow,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().findByWorkflow_First(workflow, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByWorkflow_Last(
        java.lang.String workflow,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().findByWorkflow_Last(workflow, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow[] findByWorkflow_PrevAndNext(
        long stateWfId, java.lang.String workflow,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByWorkflow_PrevAndNext(stateWfId, workflow, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByStateProcessId(
        long stateProcessId) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessId(stateProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByStateProcessId(
        long stateProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessId(stateProcessId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByStateProcessId(
        long stateProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessId(stateProcessId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByStateProcessId_First(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().findByStateProcessId_First(stateProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByStateProcessId_Last(
        long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence().findByStateProcessId_Last(stateProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow[] findByStateProcessId_PrevAndNext(
        long stateWfId, long stateProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByStateProcessId_PrevAndNext(stateWfId, stateProcessId,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkFlow_Version(
        java.lang.String workflow, int version_)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkFlow_Version(workflow, version_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByWorkFlow_Version(workflow, version_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findByWorkFlow_Version(
        java.lang.String workflow, int version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByWorkFlow_Version(workflow, version_, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByWorkFlow_Version_First(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByWorkFlow_Version_First(workflow, version_, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow findByWorkFlow_Version_Last(
        java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByWorkFlow_Version_Last(workflow, version_, obc);
    }

    public static com.sgs.portlet.document.model.PmlStateWorkFlow[] findByWorkFlow_Version_PrevAndNext(
        long stateWfId, java.lang.String workflow, int version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlStateWorkFlowException {
        return getPersistence()
                   .findByWorkFlow_Version_PrevAndNext(stateWfId, workflow,
            version_, obc);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlStateWorkFlow> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByWorkFlow_StateProcessId_Version(workflow, stateProcessId,
            version_);
    }

    public static void removeBySolvingTime(int solvingTime)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySolvingTime(solvingTime);
    }

    public static void removeByWorkflow(java.lang.String workflow)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByWorkflow(workflow);
    }

    public static void removeByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessId(stateProcessId);
    }

    public static void removeByWorkFlow_Version(java.lang.String workflow,
        int version_) throws com.liferay.portal.SystemException {
        getPersistence().removeByWorkFlow_Version(workflow, version_);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByWorkFlow_StateProcessId_Version(
        java.lang.String workflow, long stateProcessId, int version_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByWorkFlow_StateProcessId_Version(workflow,
            stateProcessId, version_);
    }

    public static int countBySolvingTime(int solvingTime)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySolvingTime(solvingTime);
    }

    public static int countByWorkflow(java.lang.String workflow)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByWorkflow(workflow);
    }

    public static int countByStateProcessId(long stateProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessId(stateProcessId);
    }

    public static int countByWorkFlow_Version(java.lang.String workflow,
        int version_) throws com.liferay.portal.SystemException {
        return getPersistence().countByWorkFlow_Version(workflow, version_);
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

    public static PmlStateWorkFlowPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlStateWorkFlowPersistence persistence) {
        _persistence = persistence;
    }
}
