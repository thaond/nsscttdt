package com.sgs.portlet.pmlissuingplace.service.persistence;

public class PmlEdmIssuingPlaceFinderUtil {
    private static PmlEdmIssuingPlaceFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countIssuingPlace(java.lang.String codes,
        java.lang.String names, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countIssuingPlace(codes, names, andOperator);
    }

    public static int countIssuingPlace(java.lang.String[] codes,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder().countIssuingPlace(codes, names, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceIds(
        java.util.List<String> issuingPlaceIds) throws java.lang.Exception {
        return getFinder().findByIssuingPlaceIds(issuingPlaceIds);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByKeywords2(
        java.lang.String keywords) throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords2(keywords);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findIssuingPlace(
        java.lang.String codes, java.lang.String names, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findIssuingPlace(codes, names, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findIssuingPlace(
        java.lang.String[] codes, java.lang.String[] names,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findIssuingPlace(codes, names, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
        int levelSendId) throws java.lang.Exception {
        return getFinder().getPmlEdmIssuingPlacesWithPmlEdmLevelSend(levelSendId);
    }

    public static PmlEdmIssuingPlaceFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmIssuingPlaceFinder finder) {
        _finder = finder;
    }
}
