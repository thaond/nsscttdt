package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentRecordToFinderUtil {
    private static PmlEdmDocumentRecordToFinder _finder;

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToAgency(
        java.lang.String loaiSoCVs, java.lang.String so, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findDocumentRecordToAgency(loaiSoCVs, so, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToAgency(
        java.lang.String[] loaiSoCVs, java.lang.String[] so,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findDocumentRecordToAgency(loaiSoCVs, so, andOperator,
            start, end, obc);
    }

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countDocumentRecordToAgency(java.lang.String loaiSoCVs,
        java.lang.String so, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countDocumentRecordToAgency(loaiSoCVs, so, andOperator);
    }

    public static int countDocumentRecordToAgency(
        java.lang.String[] loaiSoCVs, java.lang.String[] so, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countDocumentRecordToAgency(loaiSoCVs, so, andOperator);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findByKeywordsPB(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywordsPB(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToDepartment(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findDocumentRecordToDepartment(loaiSoCVs, phongBan,
            andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo> findDocumentRecordToDepartment(
        java.lang.String[] loaiSoCVs, java.lang.String[] phongBan,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findDocumentRecordToDepartment(loaiSoCVs, phongBan,
            andOperator, start, end, obc);
    }

    public static int countByKeywordsPB(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywordsPB(keywords);
    }

    public static int countDocumentRecordToDepartment(
        java.lang.String loaiSoCVs, java.lang.String phongBan,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countDocumentRecordToDepartment(loaiSoCVs, phongBan,
            andOperator);
    }

    public static int countDocumentRecordToDepartment(
        java.lang.String[] loaiSoCVs, java.lang.String[] phongBan,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countDocumentRecordToDepartment(loaiSoCVs, phongBan,
            andOperator);
    }

    public static PmlEdmDocumentRecordToFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlEdmDocumentRecordToFinder finder) {
        _finder = finder;
    }
}
