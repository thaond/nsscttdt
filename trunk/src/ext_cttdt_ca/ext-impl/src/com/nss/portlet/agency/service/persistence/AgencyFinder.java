package com.nss.portlet.agency.service.persistence;

public interface AgencyFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_COQUAN(java.lang.String leaderLastNames,
        java.lang.String leaderFirstNames, java.lang.String agencyCode,
        java.lang.String agencyName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_COQUAN(java.lang.String[] leaderLastNames,
        java.lang.String[] leaderFirstNames, java.lang.String[] agencyCodes,
        java.lang.String[] agencyNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findTEN_MA_COQUAN(
        java.lang.String leaderLastNames, java.lang.String leaderFirstNames,
        java.lang.String agencyCode, java.lang.String agencyName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.agency.model.Agency> findTEN_MA_COQUAN(
        java.lang.String[] leaderLastNames,
        java.lang.String[] leaderFirstNames, java.lang.String[] agencyCodes,
        java.lang.String[] agencyNames, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
