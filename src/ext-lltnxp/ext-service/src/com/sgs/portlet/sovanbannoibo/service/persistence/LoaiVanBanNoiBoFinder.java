package com.sgs.portlet.sovanbannoibo.service.persistence;

public interface LoaiVanBanNoiBoFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_loai_van_ban_noi_bo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int count_loai_van_ban_noi_bo(
        java.lang.String[] kyHieuLoaiVanBanNoiBos,
        java.lang.String[] tenLoaiVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo> find_loai_van_ban_noi_bo(
        java.lang.String kyHieuLoaiVanBanNoiBos,
        java.lang.String tenLoaiVanBanNoiBos, int start, int end,
        boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBo> find_loai_van_ban_noi_bo(
        java.lang.String[] kyHieuLoaiVanBanNoiBos,
        java.lang.String[] tenLoaiVanBanNoiBos, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
