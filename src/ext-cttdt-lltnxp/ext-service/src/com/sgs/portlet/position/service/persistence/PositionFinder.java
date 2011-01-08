package com.sgs.portlet.position.service.persistence;

public interface PositionFinder {
    public java.util.List<com.sgs.portlet.position.model.Position> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.position.model.Position> find_CODE_NAME_DESCRIPTION(
        java.lang.String code, java.lang.String name,
        java.lang.String description, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.position.model.Position> findPosition(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] descriptions, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_CODE_NAME_DESCRIPTION(java.lang.String code,
        java.lang.String name, java.lang.String description, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countTotalPosition(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] description,
        boolean andOperator) throws com.liferay.portal.SystemException;
}
