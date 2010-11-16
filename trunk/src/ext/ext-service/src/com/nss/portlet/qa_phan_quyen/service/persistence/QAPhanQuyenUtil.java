package com.nss.portlet.qa_phan_quyen.service.persistence;

public class QAPhanQuyenUtil {
    private static QAPhanQuyenPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen) {
        getPersistence().cacheResult(qaPhanQuyen);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> qaPhanQuyens) {
        getPersistence().cacheResult(qaPhanQuyens);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen create(
        long maPhanQuyen) {
        return getPersistence().create(maPhanQuyen);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen remove(
        long maPhanQuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence().remove(maPhanQuyen);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen remove(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(qaPhanQuyen);
    }

    /**
     * @deprecated Use <code>update(QAPhanQuyen qaPhanQuyen, boolean merge)</code>.
     */
    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen update(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(qaPhanQuyen);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                qaPhanQuyen the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when qaPhanQuyen is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen update(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(qaPhanQuyen, merge);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen updateImpl(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(qaPhanQuyen, merge);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByPrimaryKey(
        long maPhanQuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence().findByPrimaryKey(maPhanQuyen);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen fetchByPrimaryKey(
        long maPhanQuyen) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(maPhanQuyen);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaChuDeCauHoi(
        long maChuDeCauHoi) throws com.liferay.portal.SystemException {
        return getPersistence().findBymaChuDeCauHoi(maChuDeCauHoi);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBymaChuDeCauHoi(maChuDeCauHoi, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymaChuDeCauHoi(maChuDeCauHoi, start, end, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaChuDeCauHoi_First(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence().findBymaChuDeCauHoi_First(maChuDeCauHoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaChuDeCauHoi_Last(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence().findBymaChuDeCauHoi_Last(maChuDeCauHoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findBymaChuDeCauHoi_PrevAndNext(
        long maPhanQuyen, long maChuDeCauHoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findBymaChuDeCauHoi_PrevAndNext(maPhanQuyen, maChuDeCauHoi,
            obc);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaNguoiTraLoi(
        long maNguoiTraLoi) throws com.liferay.portal.SystemException {
        return getPersistence().findBymaNguoiTraLoi(maNguoiTraLoi);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaNguoiTraLoi(
        long maNguoiTraLoi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBymaNguoiTraLoi(maNguoiTraLoi, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaNguoiTraLoi(
        long maNguoiTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymaNguoiTraLoi(maNguoiTraLoi, start, end, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaNguoiTraLoi_First(
        long maNguoiTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence().findBymaNguoiTraLoi_First(maNguoiTraLoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaNguoiTraLoi_Last(
        long maNguoiTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence().findBymaNguoiTraLoi_Last(maNguoiTraLoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findBymaNguoiTraLoi_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findBymaNguoiTraLoi_PrevAndNext(maPhanQuyen, maNguoiTraLoi,
            obc);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
            maNguoiTraLoi);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
            maNguoiTraLoi, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
            maNguoiTraLoi, start, end, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi_First(
        long maChuDeCauHoi, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaChuDeCauHoi_MaNguoiTraLoi_First(maChuDeCauHoi,
            maNguoiTraLoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi_Last(
        long maChuDeCauHoi, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaChuDeCauHoi_MaNguoiTraLoi_Last(maChuDeCauHoi,
            maNguoiTraLoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaChuDeCauHoi_MaNguoiTraLoi_PrevAndNext(
        long maPhanQuyen, long maChuDeCauHoi, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaChuDeCauHoi_MaNguoiTraLoi_PrevAndNext(maPhanQuyen,
            maChuDeCauHoi, maNguoiTraLoi, obc);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi, boolean quyenXem)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi, boolean quyenXem, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem,
            start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi, boolean quyenXem, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem,
            start, end, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenXem_First(
        long maNguoiTraLoi, boolean quyenXem,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenXem_First(maNguoiTraLoi, quyenXem,
            obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenXem_Last(
        long maNguoiTraLoi, boolean quyenXem,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenXem_Last(maNguoiTraLoi, quyenXem,
            obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenXem_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenXem,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenXem_PrevAndNext(maPhanQuyen,
            maNguoiTraLoi, quyenXem, obc);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi, quyenCapNhat);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi,
            quyenCapNhat, start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi,
            quyenCapNhat, start, end, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenCapNhat_First(
        long maNguoiTraLoi, boolean quyenCapNhat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenCapNhat_First(maNguoiTraLoi,
            quyenCapNhat, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenCapNhat_Last(
        long maNguoiTraLoi, boolean quyenCapNhat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenCapNhat_Last(maNguoiTraLoi,
            quyenCapNhat, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenCapNhat_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenCapNhat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenCapNhat_PrevAndNext(maPhanQuyen,
            maNguoiTraLoi, quyenCapNhat, obc);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi,
            start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi,
            start, end, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenTraloi_First(
        long maNguoiTraLoi, boolean quyenTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenTraloi_First(maNguoiTraLoi,
            quyenTraLoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenTraloi_Last(
        long maNguoiTraLoi, boolean quyenTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenTraloi_Last(maNguoiTraLoi,
            quyenTraLoi, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenTraloi_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenTraloi_PrevAndNext(maPhanQuyen,
            maNguoiTraLoi, quyenTraLoi, obc);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet,
            start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet,
            start, end, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenDuyet_First(
        long maNguoiTraLoi, boolean quyenDuyet,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenDuyet_First(maNguoiTraLoi,
            quyenDuyet, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenDuyet_Last(
        long maNguoiTraLoi, boolean quyenDuyet,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenDuyet_Last(maNguoiTraLoi,
            quyenDuyet, obc);
    }

    public static com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenDuyet_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenDuyet,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException {
        return getPersistence()
                   .findByMaNguoiTraLoi_QuyenDuyet_PrevAndNext(maPhanQuyen,
            maNguoiTraLoi, quyenDuyet, obc);
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

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeBymaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBymaChuDeCauHoi(maChuDeCauHoi);
    }

    public static void removeBymaNguoiTraLoi(long maNguoiTraLoi)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBymaNguoiTraLoi(maNguoiTraLoi);
    }

    public static void removeByMaChuDeCauHoi_MaNguoiTraLoi(long maChuDeCauHoi,
        long maNguoiTraLoi) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi, maNguoiTraLoi);
    }

    public static void removeByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem) throws com.liferay.portal.SystemException {
        getPersistence().removeByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem);
    }

    public static void removeByMaNguoiTraLoi_QuyenCapNhat(long maNguoiTraLoi,
        boolean quyenCapNhat) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi, quyenCapNhat);
    }

    public static void removeByMaNguoiTraLoi_QuyenTraloi(long maNguoiTraLoi,
        boolean quyenTraLoi) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi);
    }

    public static void removeByMaNguoiTraLoi_QuyenDuyet(long maNguoiTraLoi,
        boolean quyenDuyet) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countBymaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBymaChuDeCauHoi(maChuDeCauHoi);
    }

    public static int countBymaNguoiTraLoi(long maNguoiTraLoi)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBymaNguoiTraLoi(maNguoiTraLoi);
    }

    public static int countByMaChuDeCauHoi_MaNguoiTraLoi(long maChuDeCauHoi,
        long maNguoiTraLoi) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaChuDeCauHoi_MaNguoiTraLoi(maChuDeCauHoi,
            maNguoiTraLoi);
    }

    public static int countByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaNguoiTraLoi_QuyenXem(maNguoiTraLoi, quyenXem);
    }

    public static int countByMaNguoiTraLoi_QuyenCapNhat(long maNguoiTraLoi,
        boolean quyenCapNhat) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaNguoiTraLoi_QuyenCapNhat(maNguoiTraLoi,
            quyenCapNhat);
    }

    public static int countByMaNguoiTraLoi_QuyenTraloi(long maNguoiTraLoi,
        boolean quyenTraLoi) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaNguoiTraLoi_QuyenTraloi(maNguoiTraLoi, quyenTraLoi);
    }

    public static int countByMaNguoiTraLoi_QuyenDuyet(long maNguoiTraLoi,
        boolean quyenDuyet) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByMaNguoiTraLoi_QuyenDuyet(maNguoiTraLoi, quyenDuyet);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static QAPhanQuyenPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(QAPhanQuyenPersistence persistence) {
        _persistence = persistence;
    }
}
