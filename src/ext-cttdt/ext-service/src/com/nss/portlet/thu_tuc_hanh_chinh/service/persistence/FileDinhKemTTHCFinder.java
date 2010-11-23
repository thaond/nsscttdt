package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

public interface FileDinhKemTTHCFinder {
    public int countFileDinhKem(long maThuTucHanhChinh)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.FileDinhKemTTHC> findFileDinhKem(
        long maThuTucHanhChinh, int start, int end)
        throws com.liferay.portal.SystemException;
}
