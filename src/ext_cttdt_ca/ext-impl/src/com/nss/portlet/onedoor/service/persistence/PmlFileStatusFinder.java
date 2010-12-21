package com.nss.portlet.onedoor.service.persistence;

public interface PmlFileStatusFinder {
    public int countByKeywordsMC(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByMA_TEN_MC(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByMA_TEN_MC(java.lang.String[] fileStatusCodes,
        java.lang.String[] fileStatusNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByKeywordsMC(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByMA_TEN_MC(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlFileStatus> findByMA_TEN_MC(
        java.lang.String[] fileStatusCodes, java.lang.String[] fileStatusNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
