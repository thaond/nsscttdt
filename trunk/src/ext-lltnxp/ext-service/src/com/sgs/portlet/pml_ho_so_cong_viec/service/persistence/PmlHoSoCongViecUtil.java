package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public class PmlHoSoCongViecUtil {
    private static PmlHoSoCongViecPersistence _persistence;

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec create(
        long idHoSoCongViec) {
        return getPersistence().create(idHoSoCongViec);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec remove(
        long idHoSoCongViec)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().remove(idHoSoCongViec);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec remove(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlHoSoCongViec);
    }

    /**
     * @deprecated Use <code>update(PmlHoSoCongViec pmlHoSoCongViec, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlHoSoCongViec);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlHoSoCongViec the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlHoSoCongViec is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlHoSoCongViec, merge);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec updateImpl(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlHoSoCongViec, merge);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByPrimaryKey(
        long idHoSoCongViec)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByPrimaryKey(idHoSoCongViec);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec fetchByPrimaryKey(
        long idHoSoCongViec) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(idHoSoCongViec);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdHSCVCha(
        long idHSCVCha) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdHSCVCha(idHSCVCha);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdHSCVCha(
        long idHSCVCha, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdHSCVCha(idHSCVCha, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdHSCVCha(
        long idHSCVCha, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdHSCVCha(idHSCVCha, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdHSCVCha_First(
        long idHSCVCha, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdHSCVCha_First(idHSCVCha, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdHSCVCha_Last(
        long idHSCVCha, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdHSCVCha_Last(idHSCVCha, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdHSCVCha_PrevAndNext(
        long idHoSoCongViec, long idHSCVCha,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence()
                   .findByIdHSCVCha_PrevAndNext(idHoSoCongViec, idHSCVCha, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findBySoHieuHSCV(
        java.lang.String soHieuHSCV) throws com.liferay.portal.SystemException {
        return getPersistence().findBySoHieuHSCV(soHieuHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findBySoHieuHSCV(
        java.lang.String soHieuHSCV, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySoHieuHSCV(soHieuHSCV, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findBySoHieuHSCV(
        java.lang.String soHieuHSCV, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySoHieuHSCV(soHieuHSCV, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findBySoHieuHSCV_First(
        java.lang.String soHieuHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findBySoHieuHSCV_First(soHieuHSCV, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findBySoHieuHSCV_Last(
        java.lang.String soHieuHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findBySoHieuHSCV_Last(soHieuHSCV, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findBySoHieuHSCV_PrevAndNext(
        long idHoSoCongViec, java.lang.String soHieuHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence()
                   .findBySoHieuHSCV_PrevAndNext(idHoSoCongViec, soHieuHSCV, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdDoQuanTrong(idDoQuanTrong);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdDoQuanTrong(idDoQuanTrong, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIdDoQuanTrong(idDoQuanTrong, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdDoQuanTrong_First(
        long idDoQuanTrong, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdDoQuanTrong_First(idDoQuanTrong, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdDoQuanTrong_Last(
        long idDoQuanTrong, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdDoQuanTrong_Last(idDoQuanTrong, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdDoQuanTrong_PrevAndNext(
        long idHoSoCongViec, long idDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence()
                   .findByIdDoQuanTrong_PrevAndNext(idHoSoCongViec,
            idDoQuanTrong, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdTinhChat(idTinhChat);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdTinhChat(idTinhChat, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdTinhChat(idTinhChat, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTinhChat_First(
        long idTinhChat, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdTinhChat_First(idTinhChat, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTinhChat_Last(
        long idTinhChat, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdTinhChat_Last(idTinhChat, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdTinhChat_PrevAndNext(
        long idHoSoCongViec, long idTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence()
                   .findByIdTinhChat_PrevAndNext(idHoSoCongViec, idTinhChat, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIdTrangThaiHSCV(idTrangThaiHSCV, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByIdTrangThaiHSCV(idTrangThaiHSCV, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTrangThaiHSCV_First(
        long idTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdTrangThaiHSCV_First(idTrangThaiHSCV, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTrangThaiHSCV_Last(
        long idTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdTrangThaiHSCV_Last(idTrangThaiHSCV, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdTrangThaiHSCV_PrevAndNext(
        long idHoSoCongViec, long idTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence()
                   .findByIdTrangThaiHSCV_PrevAndNext(idHoSoCongViec,
            idTrangThaiHSCV, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdLinhVuc(
        java.lang.String idLinhVuc) throws com.liferay.portal.SystemException {
        return getPersistence().findByIdLinhVuc(idLinhVuc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdLinhVuc(
        java.lang.String idLinhVuc, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdLinhVuc(idLinhVuc, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdLinhVuc(
        java.lang.String idLinhVuc, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByIdLinhVuc(idLinhVuc, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdLinhVuc_First(
        java.lang.String idLinhVuc,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdLinhVuc_First(idLinhVuc, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdLinhVuc_Last(
        java.lang.String idLinhVuc,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByIdLinhVuc_Last(idLinhVuc, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdLinhVuc_PrevAndNext(
        long idHoSoCongViec, java.lang.String idLinhVuc,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence()
                   .findByIdLinhVuc_PrevAndNext(idHoSoCongViec, idLinhVuc, obc);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId(
        long userId) throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByUserId(userId, start, end, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByUserId_First(userId, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence().findByUserId_Last(userId, obc);
    }

    public static com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByUserId_PrevAndNext(
        long idHoSoCongViec, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException {
        return getPersistence()
                   .findByUserId_PrevAndNext(idHoSoCongViec, userId, obc);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByIdHSCVCha(long idHSCVCha)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdHSCVCha(idHSCVCha);
    }

    public static void removeBySoHieuHSCV(java.lang.String soHieuHSCV)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySoHieuHSCV(soHieuHSCV);
    }

    public static void removeByIdDoQuanTrong(long idDoQuanTrong)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdDoQuanTrong(idDoQuanTrong);
    }

    public static void removeByIdTinhChat(long idTinhChat)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdTinhChat(idTinhChat);
    }

    public static void removeByIdTrangThaiHSCV(long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static void removeByIdLinhVuc(java.lang.String idLinhVuc)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByIdLinhVuc(idLinhVuc);
    }

    public static void removeByUserId(long userId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByUserId(userId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByIdHSCVCha(long idHSCVCha)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdHSCVCha(idHSCVCha);
    }

    public static int countBySoHieuHSCV(java.lang.String soHieuHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySoHieuHSCV(soHieuHSCV);
    }

    public static int countByIdDoQuanTrong(long idDoQuanTrong)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdDoQuanTrong(idDoQuanTrong);
    }

    public static int countByIdTinhChat(long idTinhChat)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdTinhChat(idTinhChat);
    }

    public static int countByIdTrangThaiHSCV(long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdTrangThaiHSCV(idTrangThaiHSCV);
    }

    public static int countByIdLinhVuc(java.lang.String idLinhVuc)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByIdLinhVuc(idLinhVuc);
    }

    public static int countByUserId(long userId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByUserId(userId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static void registerListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().registerListener(listener);
    }

    public static void unregisterListener(
        com.liferay.portal.model.ModelListener listener) {
        getPersistence().unregisterListener(listener);
    }

    public static PmlHoSoCongViecPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlHoSoCongViecPersistence persistence) {
        _persistence = persistence;
    }
}
