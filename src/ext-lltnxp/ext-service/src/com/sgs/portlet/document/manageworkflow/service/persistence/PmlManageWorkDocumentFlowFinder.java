package com.sgs.portlet.document.manageworkflow.service.persistence;

public interface PmlManageWorkDocumentFlowFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByDocumentWorkflow(java.lang.String workflowName,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByDocumentWorkflow(java.lang.String[] workflowNames,
        java.lang.String[] descriptions, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByDocumentWorkflow(
        java.lang.String workflowName, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByDocumentWorkflow(
        java.lang.String[] workflowNames, java.lang.String[] descriptions,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
