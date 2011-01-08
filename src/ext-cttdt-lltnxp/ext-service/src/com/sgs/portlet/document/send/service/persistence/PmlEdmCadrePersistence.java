package com.sgs.portlet.document.send.service.persistence;

public interface PmlEdmCadrePersistence {
    public com.sgs.portlet.document.send.model.PmlEdmCadre create(long userId);

    public com.sgs.portlet.document.send.model.PmlEdmCadre remove(long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre remove(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmCadre pmlEdmCadre, boolean merge)</code>.
     */
    public com.sgs.portlet.document.send.model.PmlEdmCadre update(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmCadre the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmCadre is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.send.model.PmlEdmCadre update(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre updateImpl(
        com.sgs.portlet.document.send.model.PmlEdmCadre pmlEdmCadre,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre findByPrimaryKey(
        long userId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre fetchByPrimaryKey(
        long userId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByPositionId(
        java.lang.String positionId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByPositionId(
        java.lang.String positionId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByPositionId(
        java.lang.String positionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre findByPositionId_First(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre findByPositionId_Last(
        java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre[] findByPositionId_PrevAndNext(
        long userId, java.lang.String positionId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre[] findByDepartmentsId_PrevAndNext(
        long userId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByHandPhone(
        java.lang.String handPhone) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByHandPhone(
        java.lang.String handPhone, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findByHandPhone(
        java.lang.String handPhone, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre findByHandPhone_First(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre findByHandPhone_Last(
        java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public com.sgs.portlet.document.send.model.PmlEdmCadre[] findByHandPhone_PrevAndNext(
        long userId, java.lang.String handPhone,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.send.NoSuchPmlEdmCadreException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.send.model.PmlEdmCadre> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByPositionId(java.lang.String positionId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByHandPhone(java.lang.String handPhone)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
