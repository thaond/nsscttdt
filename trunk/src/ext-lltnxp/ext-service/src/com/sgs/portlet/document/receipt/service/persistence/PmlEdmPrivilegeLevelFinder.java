package com.sgs.portlet.document.receipt.service.persistence;

public interface PmlEdmPrivilegeLevelFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmPrivilegeLevel(
        java.lang.String[] pmlEdmPrivilegeLevelNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel> findByPmlEdmPrivilegeLevel(
        java.lang.String[] pmlEdmPrivilegeLevelNames, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
