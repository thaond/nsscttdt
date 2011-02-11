package com.sgs.portlet.field.service.persistence;

public class PmlFieldUtil {
    private static PmlFieldPersistence _persistence;

    public static com.sgs.portlet.field.model.PmlField create(
        java.lang.String fieldId) {
        return getPersistence().create(fieldId);
    }

    public static com.sgs.portlet.field.model.PmlField remove(
        java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().remove(fieldId);
    }

    public static com.sgs.portlet.field.model.PmlField remove(
        com.sgs.portlet.field.model.PmlField pmlField)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlField);
    }

    /**
     * @deprecated Use <code>update(PmlField pmlField, boolean merge)</code>.
     */
    public static com.sgs.portlet.field.model.PmlField update(
        com.sgs.portlet.field.model.PmlField pmlField)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlField);
    }

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
    public static com.sgs.portlet.field.model.PmlField update(
        com.sgs.portlet.field.model.PmlField pmlField, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlField, merge);
    }

    public static com.sgs.portlet.field.model.PmlField updateImpl(
        com.sgs.portlet.field.model.PmlField pmlField, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlField, merge);
    }

    public static com.sgs.portlet.field.model.PmlField findByPrimaryKey(
        java.lang.String fieldId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByPrimaryKey(fieldId);
    }

    public static com.sgs.portlet.field.model.PmlField fetchByPrimaryKey(
        java.lang.String fieldId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fieldId);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode(
        java.lang.String fieldCode) throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldCode(fieldCode);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode(
        java.lang.String fieldCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldCode(fieldCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode(
        java.lang.String fieldCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldCode(fieldCode, start, end, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByFieldCode_First(
        java.lang.String fieldCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByFieldCode_First(fieldCode, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByFieldCode_Last(
        java.lang.String fieldCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByFieldCode_Last(fieldCode, obc);
    }

    public static com.sgs.portlet.field.model.PmlField[] findByFieldCode_PrevAndNext(
        java.lang.String fieldId, java.lang.String fieldCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence()
                   .findByFieldCode_PrevAndNext(fieldId, fieldCode, obc);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldName(
        java.lang.String fieldName) throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldName(fieldName);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldName(
        java.lang.String fieldName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldName(fieldName, start, end);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldName(
        java.lang.String fieldName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldName(fieldName, start, end, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByFieldName_First(
        java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByFieldName_First(fieldName, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByFieldName_Last(
        java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByFieldName_Last(fieldName, obc);
    }

    public static com.sgs.portlet.field.model.PmlField[] findByFieldName_PrevAndNext(
        java.lang.String fieldId, java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence()
                   .findByFieldName_PrevAndNext(fieldId, fieldName, obc);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByDescription(
        java.lang.String description) throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByDescription(
        java.lang.String description, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByDescription(
        java.lang.String description, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDescription(description, start, end, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByDescription_First(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByDescription_First(description, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByDescription_Last(
        java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByDescription_Last(description, obc);
    }

    public static com.sgs.portlet.field.model.PmlField[] findByDescription_PrevAndNext(
        java.lang.String fieldId, java.lang.String description,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence()
                   .findByDescription_PrevAndNext(fieldId, description, obc);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentsId(departmentsId, start, end);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByDepartmentsId(
        java.lang.String departmentsId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentsId(departmentsId, start, end, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByDepartmentsId_First(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByDepartmentsId_First(departmentsId, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByDepartmentsId_Last(
        java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence().findByDepartmentsId_Last(departmentsId, obc);
    }

    public static com.sgs.portlet.field.model.PmlField[] findByDepartmentsId_PrevAndNext(
        java.lang.String fieldId, java.lang.String departmentsId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence()
                   .findByDepartmentsId_PrevAndNext(fieldId, departmentsId, obc);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode_FieldName(
        java.lang.String fieldCode, java.lang.String fieldName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFieldCode_FieldName(fieldCode, fieldName);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode_FieldName(
        java.lang.String fieldCode, java.lang.String fieldName, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFieldCode_FieldName(fieldCode, fieldName, start, end);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findByFieldCode_FieldName(
        java.lang.String fieldCode, java.lang.String fieldName, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFieldCode_FieldName(fieldCode, fieldName, start, end,
            obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByFieldCode_FieldName_First(
        java.lang.String fieldCode, java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence()
                   .findByFieldCode_FieldName_First(fieldCode, fieldName, obc);
    }

    public static com.sgs.portlet.field.model.PmlField findByFieldCode_FieldName_Last(
        java.lang.String fieldCode, java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence()
                   .findByFieldCode_FieldName_Last(fieldCode, fieldName, obc);
    }

    public static com.sgs.portlet.field.model.PmlField[] findByFieldCode_FieldName_PrevAndNext(
        java.lang.String fieldId, java.lang.String fieldCode,
        java.lang.String fieldName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.field.NoSuchPmlFieldException {
        return getPersistence()
                   .findByFieldCode_FieldName_PrevAndNext(fieldId, fieldCode,
            fieldName, obc);
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

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.field.model.PmlField> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFieldCode(java.lang.String fieldCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFieldCode(fieldCode);
    }

    public static void removeByFieldName(java.lang.String fieldName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFieldName(fieldName);
    }

    public static void removeByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDescription(description);
    }

    public static void removeByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentsId(departmentsId);
    }

    public static void removeByFieldCode_FieldName(java.lang.String fieldCode,
        java.lang.String fieldName) throws com.liferay.portal.SystemException {
        getPersistence().removeByFieldCode_FieldName(fieldCode, fieldName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFieldCode(java.lang.String fieldCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFieldCode(fieldCode);
    }

    public static int countByFieldName(java.lang.String fieldName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFieldName(fieldName);
    }

    public static int countByDescription(java.lang.String description)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDescription(description);
    }

    public static int countByDepartmentsId(java.lang.String departmentsId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentsId(departmentsId);
    }

    public static int countByFieldCode_FieldName(java.lang.String fieldCode,
        java.lang.String fieldName) throws com.liferay.portal.SystemException {
        return getPersistence().countByFieldCode_FieldName(fieldCode, fieldName);
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

    public static PmlFieldPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFieldPersistence persistence) {
        _persistence = persistence;
    }
}
