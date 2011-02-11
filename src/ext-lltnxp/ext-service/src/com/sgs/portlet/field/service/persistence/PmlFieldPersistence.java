package com.sgs.portlet.field.service.persistence;

public interface PmlFieldPersistence {
    public com.sgs.portlet.field.model.PmlField create(java.lang.String fieldId);

    public com.sgs.portlet.field.model.PmlField remove(java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField remove(
        com.sgs.portlet.field.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlField pmlField, boolean merge)</code>.
     */
    public com.sgs.portlet.field.model.PmlField update(
        com.sgs.portlet.field.model.PmlField pmlField)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlField the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlField is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.field.model.PmlField update(
        com.sgs.portlet.field.model.PmlField pmlField, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField updateImpl(
        com.sgs.portlet.field.model.PmlField pmlField, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField findByPrimaryKey(
        java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField fetchByPrimaryKey(
        java.lang.String fieldId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode(
        java.lang.String fieldCode) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode(
        java.lang.String fieldCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode(
        java.lang.String fieldCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField findByFieldCode_First(
        java.lang.String fieldCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField findByFieldCode_Last(
        java.lang.String fieldCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField[] findByFieldCode_PrevAndNext(
        java.lang.String fieldId, java.lang.String fieldCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldName(
        java.lang.String fieldName) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldName(
        java.lang.String fieldName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldName(
        java.lang.String fieldName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField findByFieldName_First(
        java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField findByFieldName_Last(
        java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField[] findByFieldName_PrevAndNext(
        java.lang.String fieldId, java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField[] findByDescription_PrevAndNext(
        java.lang.String fieldId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField[] findByDepartmentsId_PrevAndNext(
        java.lang.String fieldId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode_FieldName(
        java.lang.String fieldCode, java.lang.String fieldName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode_FieldName(
        java.lang.String fieldCode, java.lang.String fieldName, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode_FieldName(
        java.lang.String fieldCode, java.lang.String fieldName, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.field.model.PmlField findByFieldCode_FieldName_First(
        java.lang.String fieldCode, java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField findByFieldCode_FieldName_Last(
        java.lang.String fieldCode, java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public com.sgs.portlet.field.model.PmlField[] findByFieldCode_FieldName_PrevAndNext(
        java.lang.String fieldId, java.lang.String fieldCode,
        java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.field.model.PmlField> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFieldCode(java.lang.String fieldCode)
        throws com.liferay.portal.SystemException;

    public void removeByFieldName(java.lang.String fieldName)
        throws com.liferay.portal.SystemException;

    public void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public void removeByFieldCode_FieldName(java.lang.String fieldCode,
        java.lang.String fieldName) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFieldCode(java.lang.String fieldCode)
        throws com.liferay.portal.SystemException;

    public int countByFieldName(java.lang.String fieldName)
        throws com.liferay.portal.SystemException;

    public int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException;

    public int countByFieldCode_FieldName(java.lang.String fieldCode,
        java.lang.String fieldName) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
