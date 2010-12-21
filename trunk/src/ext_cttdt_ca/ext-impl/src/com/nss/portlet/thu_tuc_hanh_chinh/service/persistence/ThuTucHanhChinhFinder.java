package com.nss.portlet.thu_tuc_hanh_chinh.service.persistence;

public interface ThuTucHanhChinhFinder {
    public int countByTEN_LINHVUC_DONVI(java.lang.String name, long linhVuc,
        long capDonVi, long donVi, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByTEN_LINHVUC_DONVI(java.lang.String[] names, long linhVuc,
        long capDonVi, long donVi, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findTEN_LINHVUC_DONVI(
        java.lang.String name, long linhVuc, long capDonVi, long donVi,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.thu_tuc_hanh_chinh.model.ThuTucHanhChinh> findTEN_LINHVUC_DONVI(
        java.lang.String[] names, long linhVuc, long capDonVi, long donVi,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
