package com.sgs.portlet.pml_do_quan_trong.service.persistence;

public interface PmlDoQuanTrongPersistence {
    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong create(
        long idDoQuanTrong);

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong remove(
        long idDoQuanTrong)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong remove(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDoQuanTrong pmlDoQuanTrong, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong update(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDoQuanTrong the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDoQuanTrong is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong update(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong updateImpl(
        com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong pmlDoQuanTrong,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong findByPrimaryKey(
        long idDoQuanTrong)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong fetchByPrimaryKey(
        long idDoQuanTrong) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByTenDoQuanTrong(
        java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByTenDoQuanTrong(
        java.lang.String tenDoQuanTrong, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findByTenDoQuanTrong(
        java.lang.String tenDoQuanTrong, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong findByTenDoQuanTrong_First(
        java.lang.String tenDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong findByTenDoQuanTrong_Last(
        java.lang.String tenDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException;

    public com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong[] findByTenDoQuanTrong_PrevAndNext(
        long idDoQuanTrong, java.lang.String tenDoQuanTrong,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_do_quan_trong.NoSuchPmlDoQuanTrongException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByTenDoQuanTrong(java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByTenDoQuanTrong(java.lang.String tenDoQuanTrong)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
