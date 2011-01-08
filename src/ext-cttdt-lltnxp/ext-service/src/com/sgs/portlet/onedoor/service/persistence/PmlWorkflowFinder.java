package com.sgs.portlet.onedoor.service.persistence;

public interface PmlWorkflowFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByOneDoorWoorkflow(java.lang.String fileTypeName,
        java.lang.String workflowName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByOneDoorWoorkflow(java.lang.String[] fileTypeNames,
        java.lang.String[] workflowNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByOneDoorWoorkflow(
        java.lang.String fileTypeName, java.lang.String workflowName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.onedoor.model.PmlWorkflow> findByOneDoorWoorkflow(
        java.lang.String[] fileTypeNames, java.lang.String[] workflowNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
