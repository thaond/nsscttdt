package com.nss.portlet.filetype.service.persistence;

public interface PmlFileTypeFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByFileType(java.lang.String fileTypeCode,
        java.lang.String fileTypeName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByFileType(java.lang.String[] fileTypeCodes,
        java.lang.String[] fileTypeNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.filetype.model.PmlFileType> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.filetype.model.PmlFileType> findByFileType(
        java.lang.String fileTypeCode, java.lang.String fileTypeName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.filetype.model.PmlFileType> findByFileType(
        java.lang.String[] fileTypeCodes, java.lang.String[] fileTypeNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
