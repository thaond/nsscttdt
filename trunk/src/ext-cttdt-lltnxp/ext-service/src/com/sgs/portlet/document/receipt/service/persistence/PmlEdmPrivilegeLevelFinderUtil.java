package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmPrivilegeLevelFinderUtil {
    private static PmlEdmPrivilegeLevelFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByPmlEdmPrivilegeLevel(
        java.lang.String[] pmlEdmPrivilegeLevelNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByPmlEdmPrivilegeLevel(pmlEdmPrivilegeLevelNames,
            andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findByPmlEdmPrivilegeLevel(
        java.lang.String[] pmlEdmPrivilegeLevelNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByPmlEdmPrivilegeLevel(pmlEdmPrivilegeLevelNames,
            andOperator, start, end, obc);
    }

    public static PmlEdmPrivilegeLevelFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmPrivilegeLevelFinder finder) {
        _finder = finder;
    }
}
