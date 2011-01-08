package com.sgs.portlet.pmllevelsend.service.persistence;

public class PmlEdmLevelSendFinderUtil {
    private static PmlEdmLevelSendFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlEdmLevelSend(
        java.lang.String[] pmlEdmLevelSendNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlEdmLevelSend(pmlEdmLevelSendNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByPmlEdmLevelSend(
        java.lang.String[] pmlEdmLevelSendNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmLevelSend(pmlEdmLevelSendNames, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendIds(
        java.util.List<Integer> levelSendIds) throws java.lang.Exception {
        return getFinder().findByLevelSendIds(levelSendIds);
    }

    public static PmlEdmLevelSendFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmLevelSendFinder finder) {
        _finder = finder;
    }
}
