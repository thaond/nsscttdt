package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public class PmlHoSoCongViecFinderUtil {
    private static PmlHoSoCongViecFinder _finder;

    public static int countByKeywords(java.lang.String keywords)
        throws com.liferay.portal.SystemException {
        return getFinder().countByKeywords(keywords);
    }

    public static int countByS_T_N_I_V_I_I_T_H(java.lang.String soHieuHSCV,
        java.lang.String tieuDe, java.util.Date ngayMoHSCV,
        java.lang.String idLinhVuc, java.lang.String vanDeLienQuan,
        long idDoQuanTrong, long idTrangThaiHSCV,
        java.lang.String tomTatNoiDung, java.lang.String hoatDong,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByS_T_N_I_V_I_I_T_H(soHieuHSCV, tieuDe, ngayMoHSCV,
            idLinhVuc, vanDeLienQuan, idDoQuanTrong, idTrangThaiHSCV,
            tomTatNoiDung, hoatDong, andOperator);
    }

    public static int countByS_T_N_I_V_I_I_T_H(java.lang.String[] soHieuHSCVs,
        java.lang.String[] tieuDes, java.util.Date ngayMoHSCV,
        java.lang.String idLinhVuc, java.lang.String[] vanDeLienQuans,
        long idDoQuanTrong, long idTrangThaiHSCV,
        java.lang.String[] tomTatNoiDungs, java.lang.String hoatDong,
        boolean andOperator) throws com.liferay.portal.SystemException {
        return getFinder()
                   .countByS_T_N_I_V_I_I_T_H(soHieuHSCVs, tieuDes, ngayMoHSCV,
            idLinhVuc, vanDeLienQuans, idDoQuanTrong, idTrangThaiHSCV,
            tomTatNoiDungs, hoatDong, andOperator);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByKeywords(
        java.lang.String keywords, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder().findByKeywords(keywords, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByS_T_N_I_V_I_I_T_H(
        java.lang.String soHieuHSCV, java.lang.String tieuDe,
        java.util.Date ngayMoHSCV, java.lang.String idLinhVuc,
        java.lang.String vanDeLienQuan, long idDoQuanTrong,
        long idTrangThaiHSCV, java.lang.String tomTatNoiDung,
        java.lang.String hoatDong, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByS_T_N_I_V_I_I_T_H(soHieuHSCV, tieuDe, ngayMoHSCV,
            idLinhVuc, vanDeLienQuan, idDoQuanTrong, idTrangThaiHSCV,
            tomTatNoiDung, hoatDong, andOperator, start, end, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByS_T_N_I_V_I_I_T_H(
        java.lang.String[] soHieuHSCVs, java.lang.String[] tieuDes,
        java.util.Date ngayMoHSCV, java.lang.String idLinhVuc,
        java.lang.String[] vanDeLienQuans, long idDoQuanTrong,
        long idTrangThaiHSCV, java.lang.String[] tomTatNoiDungs,
        java.lang.String hoatDong, boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getFinder()
                   .findByS_T_N_I_V_I_I_T_H(soHieuHSCVs, tieuDes, ngayMoHSCV,
            idLinhVuc, vanDeLienQuans, idDoQuanTrong, idTrangThaiHSCV,
            tomTatNoiDungs, hoatDong, andOperator, start, end, obc);
    }

    public static int countByI_S(long idHoSoCongViec,
        java.lang.String soHieuHSCV) throws com.liferay.portal.SystemException {
        return getFinder().countByI_S(idHoSoCongViec, soHieuHSCV);
    }

    public static int countByID_T_C(long[] idTinhChats)
        throws com.liferay.portal.SystemException {
        return getFinder().countByID_T_C(idTinhChats);
    }

    public static int countByID_T_T_HSCV(long[] idTrangThaiHSCVs)
        throws com.liferay.portal.SystemException {
        return getFinder().countByID_T_T_HSCV(idTrangThaiHSCVs);
    }

    public static int countByID_D_Q_T(long[] idDoQuanTrongs)
        throws com.liferay.portal.SystemException {
        return getFinder().countByID_D_Q_T(idDoQuanTrongs);
    }

    public static PmlHoSoCongViecFinder getFinder() {
        return _finder;
    }

    public void setFinder(PmlHoSoCongViecFinder finder) {
        _finder = finder;
    }
}
