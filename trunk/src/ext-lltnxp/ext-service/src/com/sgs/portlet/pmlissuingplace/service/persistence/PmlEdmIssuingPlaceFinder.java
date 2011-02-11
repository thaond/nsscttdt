package com.sgs.portlet.pmlissuingplace.service.persistence;

public interface PmlEdmIssuingPlaceFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countIssuingPlace(java.lang.String codes,
        java.lang.String names, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countIssuingPlace(java.lang.String[] codes,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByIssuingPlaceIds(
        java.util.List<String> issuingPlaceIds) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findByKeywords2(
        java.lang.String keywords) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findIssuingPlace(
        java.lang.String codes, java.lang.String names, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> findIssuingPlace(
        java.lang.String[] codes, java.lang.String[] names,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(
        int levelSendId) throws java.lang.Exception;
}
