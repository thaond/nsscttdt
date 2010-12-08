package com.nss.portlet.onedoor.service.persistence;

public class PmlFileStatusFinderUtil {
    private static PmlFileStatusFinder _finder;

    public static int countByKeywordsMC(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywordsMC(keywords);
    }

    public static int countByMA_TEN_MC(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByMA_TEN_MC(fileStatusCode, fileStatusName, andOperator);
    }

    public static int countByMA_TEN_MC(java.lang.String[] fileStatusCodes,
        java.lang.String[] fileStatusNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByMA_TEN_MC(fileStatusCodes, fileStatusNames,
            andOperator);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByKeywordsMC(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywordsMC(keywords, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByMA_TEN_MC(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByMA_TEN_MC(fileStatusCode, fileStatusName,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByMA_TEN_MC(
        java.lang.String[] fileStatusCodes, java.lang.String[] fileStatusNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByMA_TEN_MC(fileStatusCodes, fileStatusNames,
            andOperator, start, end, obc);
    }

    public static PmlFileStatusFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlFileStatusFinder finder) {
        _finder = finder;
    }
}
