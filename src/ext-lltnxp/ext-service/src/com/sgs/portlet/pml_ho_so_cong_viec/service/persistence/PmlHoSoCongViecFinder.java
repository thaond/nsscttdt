package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public interface PmlHoSoCongViecFinder {
    public int countByKeywords(long userId, java.lang.String keywords)
        throws com.liferay.portal.SystemException;

    public int countByS_T_N_I_V_I_I_T_U_H(long userId,
        java.lang.String soHieuHSCV, java.lang.String tieuDe,
        java.util.Date ngayMoHSCV, java.lang.String idLinhVuc,
        java.lang.String vanDeLienQuan, long idDoQuanTrong,
        long idTrangThaiHSCV, java.lang.String tomTatNoiDung,
        java.lang.String hoatDong, boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByKeywords(
        long userId, java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByS_T_N_I_V_I_I_T_U_H(
        long userId, java.lang.String soHieuHSCV, java.lang.String tieuDe,
        java.util.Date ngayMoHSCV, java.lang.String idLinhVuc,
        java.lang.String vanDeLienQuan, long idDoQuanTrong,
        long idTrangThaiHSCV, java.lang.String tomTatNoiDung,
        java.lang.String hoatDong, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public int countByI_S(long idHoSoCongViec, java.lang.String soHieuHSCV)
        throws com.liferay.portal.SystemException;

    public int countByID_T_C(long[] idTinhChats)
        throws com.liferay.portal.SystemException;

    public int countByID_T_T_HSCV(long[] idTrangThaiHSCVs)
        throws com.liferay.portal.SystemException;

    public int countByID_D_Q_T(long[] idDoQuanTrongs)
        throws com.liferay.portal.SystemException;
}
