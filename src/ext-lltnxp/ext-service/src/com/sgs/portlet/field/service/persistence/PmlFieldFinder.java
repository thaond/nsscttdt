package com.sgs.portlet.field.service.persistence;

public interface PmlFieldFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByField(java.lang.String fieldCode,
        java.lang.String fieldName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByField(java.lang.String[] fieldCodes,
        java.lang.String[] fieldNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByField(
        java.lang.String fieldCode, java.lang.String fieldName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByField(
        java.lang.String[] fieldCodes, java.lang.String[] fieldNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
