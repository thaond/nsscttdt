package com.nss.portlet.qa_phan_quyen.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface QAPhanQuyenPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen);

    public void cacheResult(
        java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> qaPhanQuyens);

    public void clearCache();

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen create(
        long maPhanQuyen);

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen remove(
        long maPhanQuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen remove(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(QAPhanQuyen qaPhanQuyen, boolean merge)</code>.
     */
    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen update(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen update(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen updateImpl(
        com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen qaPhanQuyen,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByPrimaryKey(
        long maPhanQuyen)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen fetchByPrimaryKey(
        long maPhanQuyen) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaChuDeCauHoi(
        long maChuDeCauHoi) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaChuDeCauHoi(
        long maChuDeCauHoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaChuDeCauHoi_First(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaChuDeCauHoi_Last(
        long maChuDeCauHoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findBymaChuDeCauHoi_PrevAndNext(
        long maPhanQuyen, long maChuDeCauHoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaNguoiTraLoi(
        long maNguoiTraLoi) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaNguoiTraLoi(
        long maNguoiTraLoi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findBymaNguoiTraLoi(
        long maNguoiTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaNguoiTraLoi_First(
        long maNguoiTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findBymaNguoiTraLoi_Last(
        long maNguoiTraLoi, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findBymaNguoiTraLoi_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaChuDeCauHoi_MaNguoiTraLoi(
        long maChuDeCauHoi, long maNguoiTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi_First(
        long maChuDeCauHoi, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaChuDeCauHoi_MaNguoiTraLoi_Last(
        long maChuDeCauHoi, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaChuDeCauHoi_MaNguoiTraLoi_PrevAndNext(
        long maPhanQuyen, long maChuDeCauHoi, long maNguoiTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi, boolean quyenXem)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi, boolean quyenXem, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenXem(
        long maNguoiTraLoi, boolean quyenXem, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenXem_First(
        long maNguoiTraLoi, boolean quyenXem,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenXem_Last(
        long maNguoiTraLoi, boolean quyenXem,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenXem_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenXem,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenCapNhat(
        long maNguoiTraLoi, boolean quyenCapNhat, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenCapNhat_First(
        long maNguoiTraLoi, boolean quyenCapNhat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenCapNhat_Last(
        long maNguoiTraLoi, boolean quyenCapNhat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenCapNhat_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenCapNhat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenTraloi(
        long maNguoiTraLoi, boolean quyenTraLoi, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenTraloi_First(
        long maNguoiTraLoi, boolean quyenTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenTraloi_Last(
        long maNguoiTraLoi, boolean quyenTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenTraloi_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenTraLoi,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findByMaNguoiTraLoi_QuyenDuyet(
        long maNguoiTraLoi, boolean quyenDuyet, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenDuyet_First(
        long maNguoiTraLoi, boolean quyenDuyet,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen findByMaNguoiTraLoi_QuyenDuyet_Last(
        long maNguoiTraLoi, boolean quyenDuyet,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen[] findByMaNguoiTraLoi_QuyenDuyet_PrevAndNext(
        long maPhanQuyen, long maNguoiTraLoi, boolean quyenDuyet,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.qa_phan_quyen.NoSuchQAPhanQuyenException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.qa_phan_quyen.model.QAPhanQuyen> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeBymaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    public void removeBymaNguoiTraLoi(long maNguoiTraLoi)
        throws com.liferay.portal.SystemException;

    public void removeByMaChuDeCauHoi_MaNguoiTraLoi(long maChuDeCauHoi,
        long maNguoiTraLoi) throws com.liferay.portal.SystemException;

    public void removeByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem) throws com.liferay.portal.SystemException;

    public void removeByMaNguoiTraLoi_QuyenCapNhat(long maNguoiTraLoi,
        boolean quyenCapNhat) throws com.liferay.portal.SystemException;

    public void removeByMaNguoiTraLoi_QuyenTraloi(long maNguoiTraLoi,
        boolean quyenTraLoi) throws com.liferay.portal.SystemException;

    public void removeByMaNguoiTraLoi_QuyenDuyet(long maNguoiTraLoi,
        boolean quyenDuyet) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countBymaChuDeCauHoi(long maChuDeCauHoi)
        throws com.liferay.portal.SystemException;

    public int countBymaNguoiTraLoi(long maNguoiTraLoi)
        throws com.liferay.portal.SystemException;

    public int countByMaChuDeCauHoi_MaNguoiTraLoi(long maChuDeCauHoi,
        long maNguoiTraLoi) throws com.liferay.portal.SystemException;

    public int countByMaNguoiTraLoi_QuyenXem(long maNguoiTraLoi,
        boolean quyenXem) throws com.liferay.portal.SystemException;

    public int countByMaNguoiTraLoi_QuyenCapNhat(long maNguoiTraLoi,
        boolean quyenCapNhat) throws com.liferay.portal.SystemException;

    public int countByMaNguoiTraLoi_QuyenTraloi(long maNguoiTraLoi,
        boolean quyenTraLoi) throws com.liferay.portal.SystemException;

    public int countByMaNguoiTraLoi_QuyenDuyet(long maNguoiTraLoi,
        boolean quyenDuyet) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
