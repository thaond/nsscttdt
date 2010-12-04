package com.nss.portlet.attachedfile.service.persistence;

public class AttachedFileFinderUtil {
    private static AttachedFileFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByTEN_MA(java.lang.String code,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTEN_MA(code, name, andOperator);
    }

    public static int countByTEN_MA(java.lang.String[] codes,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countByTEN_MA(codes, names, andOperator);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findTEN_MA(
        java.lang.String code, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findTEN_MA(code, name, andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.attachedfile.model.AttachedFile> findTEN_MA(
        java.lang.String[] codes, java.lang.String[] names,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findTEN_MA(codes, names, andOperator, start, end, obc);
    }

    public static AttachedFileFinder getFinder() {
        return _finder;
    }

    public void setFinder(AttachedFileFinder finder) {
        _finder = finder;
    }
}
