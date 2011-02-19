package com.sgs.portlet.sovanbannoibo.service.persistence;

public interface SoVanBanNoiBoFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int count_so_van_ban_noi_bo(java.lang.String maSoVanBanNoiBos,
        java.lang.String tenSoVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int count_so_van_ban_noi_bo(java.lang.String[] maSoVanBanNoiBos,
        java.lang.String[] tenSoVanBanNoiBos, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> find_so_van_ban_noi_bo(
        java.lang.String maSoVanBanNoiBos, java.lang.String tenSoVanBanNoiBos,
        int start, int end, boolean andOperator,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo> find_so_van_ban_noi_bo(
        java.lang.String[] maSoVanBanNoiBos,
        java.lang.String[] tenSoVanBanNoiBos, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
