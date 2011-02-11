package com.sgs.portlet.document.service.persistence;

public interface PmlFileStatusFinder {
    public int countByKeywordsCV(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByMA_TEN_CV(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByMA_TEN_CV(java.lang.String[] fileStatusCodes,
        java.lang.String[] fileStatusNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByKeywordsMC(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByMA_TEN_MC(java.lang.String fileStatusCode,
        java.lang.String fileStatusName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByMA_TEN_MC(java.lang.String[] fileStatusCodes,
        java.lang.String[] fileStatusNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByKeywordsCV(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByMA_TEN_CV(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByMA_TEN_CV(
        java.lang.String[] fileStatusCodes, java.lang.String[] fileStatusNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByKeywordsMC(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByMA_TEN_MC(
        java.lang.String fileStatusCode, java.lang.String fileStatusName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlFileStatus> findByMA_TEN_MC(
        java.lang.String[] fileStatusCodes, java.lang.String[] fileStatusNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
