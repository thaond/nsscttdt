package com.nss.portlet.van_ban_phap_quy.service.persistence;

public interface VanBanPhapQuyFinder {
    public int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByVanBanPhapQuy(java.lang.String kyHieuVanBan,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByVanBanPhapQuy(java.lang.String[] kyHieuVanBans,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByVanBanPhapQuy(
        java.lang.String kyHieuVanBan, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.VanBanPhapQuy> findByVanBanPhapQuy(
        java.lang.String[] kyHieuVanBans, boolean andOperator, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
