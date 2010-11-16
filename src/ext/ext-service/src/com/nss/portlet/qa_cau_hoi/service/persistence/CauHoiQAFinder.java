package com.nss.portlet.qa_cau_hoi.service.persistence;

public interface CauHoiQAFinder {
    public int countByTieuDe_ChuDe(long maChuDeCauHoi, java.lang.String name,
        boolean andOperator) throws com.liferay.portal.SystemException;

    public int countByTieuDe_ChuDe(long maChuDeCauHoi,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe(
        long maChuDeCauHoi, java.lang.String name, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe(
        long maChuDeCauHoi, java.lang.String[] names, boolean andOperator,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi,
        java.lang.String name, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public int countByTieuDe_ChuDe_PhanQuyen(long userId, long maChuDeCauHoi,
        java.lang.String[] names, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe_PhanQuyen(
        long userId, long maChuDeCauHoi, java.lang.String name,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_cau_hoi.model.CauHoiQA> findTieuDe_ChuDe_PhanQuyen(
        long userId, long maChuDeCauHoi, java.lang.String[] names,
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;
}
