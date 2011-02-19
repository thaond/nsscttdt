package com.sgs.portlet.citymanagement.service.persistence;

public interface CityFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_THANH_PHO(java.lang.String cityCode,
        java.lang.String cityName, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_THANH_PHO(java.lang.String[] cityCodes,
        java.lang.String[] cityNames, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByTEN_MA_THANH_PHO(
        java.lang.String cityCode, java.lang.String cityName,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.citymanagement.model.City> findByTEN_MA_THANH_PHO(
        java.lang.String[] cityCodes, java.lang.String[] cityNames,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
