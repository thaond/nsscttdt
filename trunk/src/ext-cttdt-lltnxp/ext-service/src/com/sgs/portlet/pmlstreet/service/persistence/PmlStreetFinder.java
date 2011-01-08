package com.sgs.portlet.pmlstreet.service.persistence;

public interface PmlStreetFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByPmlEdmConfidentialLevel(java.lang.String[] names,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmlstreet.model.PmlStreet> findByPmlEdmConfidentialLevel(
        java.lang.String[] names, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
