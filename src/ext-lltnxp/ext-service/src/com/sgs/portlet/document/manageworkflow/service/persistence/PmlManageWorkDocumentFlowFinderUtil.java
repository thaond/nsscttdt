package com.sgs.portlet.document.manageworkflow.service.persistence;

public class PmlManageWorkDocumentFlowFinderUtil {
    private static PmlManageWorkDocumentFlowFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByDocumentWorkflow(java.lang.String workflowName,
        java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByDocumentWorkflow(workflowName, description,
            andOperator);
    }

    public static int countByDocumentWorkflow(
        java.lang.String[] workflowNames, java.lang.String[] descriptions,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByDocumentWorkflow(workflowNames, descriptions,
            andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByDocumentWorkflow(
        java.lang.String workflowName, java.lang.String description,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByDocumentWorkflow(workflowName, description,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByDocumentWorkflow(
        java.lang.String[] workflowNames, java.lang.String[] descriptions,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByDocumentWorkflow(workflowNames, descriptions,
            andOperator, start, end, obc);
    }

    public static PmlManageWorkDocumentFlowFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlManageWorkDocumentFlowFinder finder) {
        _finder = finder;
    }
}
