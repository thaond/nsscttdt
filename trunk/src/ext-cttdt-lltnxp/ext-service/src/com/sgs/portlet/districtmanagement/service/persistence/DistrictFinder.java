package com.sgs.portlet.districtmanagement.service.persistence;

public interface DistrictFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_QUAN(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_QUAN(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findTEN_MA_MOTA_QUAN(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findTEN_MA_MOTA_QUAN(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] des, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countDistrictByCityId(java.lang.String cityId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.districtmanagement.model.District> findDistrictByCityId(
        java.lang.String cityId, int start, int end)
        throws com.liferay.portal.SystemException;
}
