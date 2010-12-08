package com.nss.portlet.onedoor.service.persistence;

public class PmlWorkflowFinderUtil {
    private static PmlWorkflowFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByOneDoorWoorkflow(java.lang.String fileTypeName,
        java.lang.String workflowName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByOneDoorWoorkflow(fileTypeName, workflowName,
            andOperator);
    }

    public static int countByOneDoorWoorkflow(
        java.lang.String[] fileTypeNames, java.lang.String[] workflowNames,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByOneDoorWoorkflow(fileTypeNames, workflowNames,
            andOperator);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByOneDoorWoorkflow(
        java.lang.String fileTypeName, java.lang.String workflowName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByOneDoorWoorkflow(fileTypeName, workflowName,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlWorkflow> findByOneDoorWoorkflow(
        java.lang.String[] fileTypeNames, java.lang.String[] workflowNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByOneDoorWoorkflow(fileTypeNames, workflowNames,
            andOperator, start, end, obc);
    }

    public static PmlWorkflowFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlWorkflowFinder finder) {
        _finder = finder;
    }
}
