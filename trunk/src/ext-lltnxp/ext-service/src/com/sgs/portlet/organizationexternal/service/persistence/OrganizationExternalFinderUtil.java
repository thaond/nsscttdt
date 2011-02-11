package com.sgs.portlet.organizationexternal.service.persistence;

public class OrganizationExternalFinderUtil {
    private static OrganizationExternalFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA_DONVILIENTHONG(java.lang.String code,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTEN_MA_DONVILIENTHONG(code, name, andOperator);
    }

    public static int countByTEN_MA_DONVILIENTHONG(java.lang.String[] codes,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByTEN_MA_DONVILIENTHONG(codes, names, andOperator);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findTEN_MA_DONVILIENTHONG(
        java.lang.String code, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_DONVILIENTHONG(code, name, andOperator, start,
            end, obc);
    }

    public static java.util.List<com.sgs.portlet.organizationexternal.model.OrganizationExternal> findTEN_MA_DONVILIENTHONG(
        java.lang.String[] codes, java.lang.String[] names,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findTEN_MA_DONVILIENTHONG(codes, names, andOperator, start,
            end, obc);
    }

    public static OrganizationExternalFinder getFinder() {
        return _finder;
    }

    public void setFinder(OrganizationExternalFinder finder) {
        _finder = finder;
    }
}
