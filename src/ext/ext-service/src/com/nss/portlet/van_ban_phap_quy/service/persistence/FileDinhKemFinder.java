package com.nss.portlet.van_ban_phap_quy.service.persistence;

public interface FileDinhKemFinder {
    public int countFileDinhKem(long maVanBanPhapQuy)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.van_ban_phap_quy.model.FileDinhKem> findFileDinhKem(
        long maVanBanPhapQuy, int start, int end)
        throws com.liferay.portal.SystemException;
}
