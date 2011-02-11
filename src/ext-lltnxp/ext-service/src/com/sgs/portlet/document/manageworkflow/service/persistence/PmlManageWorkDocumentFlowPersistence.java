package com.sgs.portlet.document.manageworkflow.service.persistence;

public interface PmlManageWorkDocumentFlowPersistence {
    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow create(
        long manageDocumentWorkFlowId);

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow remove(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow remove(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow, boolean merge)</code>.
     */
    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow update(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlManageWorkDocumentFlow the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlManageWorkDocumentFlow is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow update(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow updateImpl(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByPrimaryKey(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow fetchByPrimaryKey(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByWorkFlowName(
        java.lang.String workFlowName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByWorkFlowName(
        java.lang.String workFlowName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByWorkFlowName(
        java.lang.String workFlowName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByWorkFlowName_First(
        java.lang.String workFlowName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByWorkFlowName_Last(
        java.lang.String workFlowName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow[] findByWorkFlowName_PrevAndNext(
        long manageDocumentWorkFlowId, java.lang.String workFlowName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByversion(
        int version) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByversion(
        int version, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByversion(
        int version, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByversion_First(
        int version, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByversion_Last(
        int version, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow[] findByversion_PrevAndNext(
        long manageDocumentWorkFlowId, int version,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findBytype(
        int type) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findBytype(
        int type, int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findBytype(
        int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findBytype_First(
        int type, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findBytype_Last(
        int type, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow[] findBytype_PrevAndNext(
        long manageDocumentWorkFlowId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByWorkFlowName(java.lang.String workFlowName)
        throws com.liferay.portal.SystemException;

    public void removeByversion(int version)
        throws com.liferay.portal.SystemException;

    public void removeBytype(int type)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByWorkFlowName(java.lang.String workFlowName)
        throws com.liferay.portal.SystemException;

    public int countByversion(int version)
        throws com.liferay.portal.SystemException;

    public int countBytype(int type) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
