package com.sgs.portlet.pml_ho_so_cong_viec.service.persistence;

public interface PmlHoSoCongViecPersistence {
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec create(
        long idHoSoCongViec);

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec remove(
        long idHoSoCongViec)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec remove(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlHoSoCongViec pmlHoSoCongViec, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec)
        throws com.liferay.portal.SystemException;

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
    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec update(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec updateImpl(
        com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec pmlHoSoCongViec,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByPrimaryKey(
        long idHoSoCongViec)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec fetchByPrimaryKey(
        long idHoSoCongViec) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdHSCVCha(
        long idHSCVCha) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdHSCVCha(
        long idHSCVCha, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdHSCVCha(
        long idHSCVCha, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdHSCVCha_First(
        long idHSCVCha, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdHSCVCha_Last(
        long idHSCVCha, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdHSCVCha_PrevAndNext(
        long idHoSoCongViec, long idHSCVCha,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findBySoHieuHSCV(
        java.lang.String soHieuHSCV) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findBySoHieuHSCV(
        java.lang.String soHieuHSCV, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findBySoHieuHSCV(
        java.lang.String soHieuHSCV, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findBySoHieuHSCV_First(
        java.lang.String soHieuHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findBySoHieuHSCV_Last(
        java.lang.String soHieuHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findBySoHieuHSCV_PrevAndNext(
        long idHoSoCongViec, java.lang.String soHieuHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdDoQuanTrong(
        long idDoQuanTrong, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdDoQuanTrong_First(
        long idDoQuanTrong, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdDoQuanTrong_Last(
        long idDoQuanTrong, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdDoQuanTrong_PrevAndNext(
        long idHoSoCongViec, long idDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTinhChat(
        long idTinhChat, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTinhChat_First(
        long idTinhChat, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTinhChat_Last(
        long idTinhChat, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdTinhChat_PrevAndNext(
        long idHoSoCongViec, long idTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdTrangThaiHSCV(
        long idTrangThaiHSCV, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTrangThaiHSCV_First(
        long idTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdTrangThaiHSCV_Last(
        long idTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdTrangThaiHSCV_PrevAndNext(
        long idHoSoCongViec, long idTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdLinhVuc(
        java.lang.String idLinhVuc) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdLinhVuc(
        java.lang.String idLinhVuc, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByIdLinhVuc(
        java.lang.String idLinhVuc, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdLinhVuc_First(
        java.lang.String idLinhVuc,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByIdLinhVuc_Last(
        java.lang.String idLinhVuc,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByIdLinhVuc_PrevAndNext(
        long idHoSoCongViec, java.lang.String idLinhVuc,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByUserId_First(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByUserId_Last(
        long userId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByUserId_PrevAndNext(
        long idHoSoCongViec, long userId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId_HoatDong(
        long userId, java.lang.String hoatDong)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId_HoatDong(
        long userId, java.lang.String hoatDong, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findByUserId_HoatDong(
        long userId, java.lang.String hoatDong, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByUserId_HoatDong_First(
        long userId, java.lang.String hoatDong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec findByUserId_HoatDong_Last(
        long userId, java.lang.String hoatDong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec[] findByUserId_HoatDong_PrevAndNext(
        long idHoSoCongViec, long userId, java.lang.String hoatDong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_ho_so_cong_viec.NoSuchPmlHoSoCongViecException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByIdHSCVCha(long idHSCVCha)
        throws com.liferay.portal.SystemException;

    public void removeBySoHieuHSCV(java.lang.String soHieuHSCV)
        throws com.liferay.portal.SystemException;

    public void removeByIdDoQuanTrong(long idDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public void removeByIdTinhChat(long idTinhChat)
        throws com.liferay.portal.SystemException;

    public void removeByIdTrangThaiHSCV(long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public void removeByIdLinhVuc(java.lang.String idLinhVuc)
        throws com.liferay.portal.SystemException;

    public void removeByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public void removeByUserId_HoatDong(long userId, java.lang.String hoatDong)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByIdHSCVCha(long idHSCVCha)
        throws com.liferay.portal.SystemException;

    public int countBySoHieuHSCV(java.lang.String soHieuHSCV)
        throws com.liferay.portal.SystemException;

    public int countByIdDoQuanTrong(long idDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public int countByIdTinhChat(long idTinhChat)
        throws com.liferay.portal.SystemException;

    public int countByIdTrangThaiHSCV(long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public int countByIdLinhVuc(java.lang.String idLinhVuc)
        throws com.liferay.portal.SystemException;

    public int countByUserId(long userId)
        throws com.liferay.portal.SystemException;

    public int countByUserId_HoatDong(long userId, java.lang.String hoatDong)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
