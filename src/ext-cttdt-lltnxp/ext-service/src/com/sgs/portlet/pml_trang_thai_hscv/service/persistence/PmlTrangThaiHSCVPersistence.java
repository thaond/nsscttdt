package com.sgs.portlet.pml_trang_thai_hscv.service.persistence;

public interface PmlTrangThaiHSCVPersistence {
    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV create(
        long idTrangThaiHSCV);

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV remove(
        long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV remove(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlTrangThaiHSCV pmlTrangThaiHSCV, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV update(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTrangThaiHSCV the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTrangThaiHSCV is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV update(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV updateImpl(
        com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV pmlTrangThaiHSCV,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV findByPrimaryKey(
        long idTrangThaiHSCV)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV fetchByPrimaryKey(
        long idTrangThaiHSCV) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findByTenTrangThaiHSCV(
        java.lang.String tenTrangThaiHSCV, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV findByTenTrangThaiHSCV_First(
        java.lang.String tenTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV findByTenTrangThaiHSCV_Last(
        java.lang.String tenTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException;

    public com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV[] findByTenTrangThaiHSCV_PrevAndNext(
        long idTrangThaiHSCV, java.lang.String tenTrangThaiHSCV,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_trang_thai_hscv.NoSuchPmlTrangThaiHSCVException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByTenTrangThaiHSCV(java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByTenTrangThaiHSCV(java.lang.String tenTrangThaiHSCV)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
