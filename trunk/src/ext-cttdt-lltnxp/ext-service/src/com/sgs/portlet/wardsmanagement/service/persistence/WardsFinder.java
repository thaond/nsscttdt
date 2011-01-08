package com.sgs.portlet.wardsmanagement.service.persistence;

public interface WardsFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_PHUONG(java.lang.String code,
        java.lang.String name, java.lang.String des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByTEN_MA_MOTA_PHUONG(java.lang.String[] codes,
        java.lang.String[] names, java.lang.String[] des, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findTEN_MA_MOTA_PHUONG(
        java.lang.String code, java.lang.String name, java.lang.String des,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findTEN_MA_MOTA_PHUONG(
        java.lang.String[] codes, java.lang.String[] names,
        java.lang.String[] des, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countWardsByDistrictId(java.lang.String districtId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.wardsmanagement.model.Wards> findWardsByDistrictId(
        java.lang.String districtId, int start, int end)
        throws com.liferay.portal.SystemException;
}
