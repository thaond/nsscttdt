package com.sgs.portlet.filetype.service.persistence;

public class PmlFileTypeFinderUtil {
    private static PmlFileTypeFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByFileType(java.lang.String fileTypeCode,
        java.lang.String fileTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByFileType(fileTypeCode, fileTypeName, andOperator);
    }

    public static int countByFileType(java.lang.String[] fileTypeCodes,
        java.lang.String[] fileTypeNames, boolean andOperator)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByFileType(fileTypeCodes, fileTypeNames, andOperator);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileType(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByFileType(fileTypeCode, fileTypeName, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findByFileType(
        java.lang.String[] fileTypeCodes, java.lang.String[] fileTypeNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByFileType(fileTypeCodes, fileTypeNames, andOperator,
            start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> getListFileTypeByFieldId(
        java.lang.String fieldId) throws com.liferay.portal.SystemException {
        return getFinder().getListFileTypeByFieldId(fieldId);
    }

    public static java.util.List<com.sgs.portlet.filetype.model.PmlFileType> findAllFileTypes(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findAllFileTypes(start, end, obc);
    }

    public static int countAllFileTypes()
        throws com.liferay.portal.SystemException {
        return getFinder().countAllFileTypes();
    }

    public static PmlFileTypeFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlFileTypeFinder finder) {
        _finder = finder;
    }
}
