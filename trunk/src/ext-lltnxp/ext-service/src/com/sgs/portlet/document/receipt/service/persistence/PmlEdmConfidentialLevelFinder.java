package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmConfidentialLevelFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmConfidentialLevel(
        java.lang.String[] pmlEdmConfidentialLevelNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByPmlEdmConfidentialLevel(
        java.lang.String[] pmlEdmConfidentialLevelNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
