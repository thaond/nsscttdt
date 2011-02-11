package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmDocumentRecordTypeUtil {
    private static PmlEdmDocumentRecordTypePersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType create(
        int documentRecordTypeId) {
        return getPersistence().create(documentRecordTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType remove(
        int documentRecordTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence().remove(documentRecordTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType remove(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmDocumentRecordType);
    }

    /**
     * @deprecated Use <code>update(PmlEdmDocumentRecordType pmlEdmDocumentRecordType, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentRecordType);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmDocumentRecordType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmDocumentRecordType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType update(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmDocumentRecordType, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType pmlEdmDocumentRecordType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmDocumentRecordType, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByPrimaryKey(
        int documentRecordTypeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence().findByPrimaryKey(documentRecordTypeId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType fetchByPrimaryKey(
        int documentRecordTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentRecordTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeCode(documentRecordTypeCode);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeCode(documentRecordTypeCode, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeCode(documentRecordTypeCode, start,
            end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeCode_First(
        java.lang.String documentRecordTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeCode_First(documentRecordTypeCode,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeCode_Last(
        java.lang.String documentRecordTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeCode_Last(documentRecordTypeCode,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType[] findByDocumentRecordTypeCode_PrevAndNext(
        int documentRecordTypeId, java.lang.String documentRecordTypeCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeCode_PrevAndNext(documentRecordTypeId,
            documentRecordTypeCode, obc);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeName(documentRecordTypeName);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeName(documentRecordTypeName, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentRecordTypeName(documentRecordTypeName, start,
            end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeName_First(
        java.lang.String documentRecordTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeName_First(documentRecordTypeName,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType findByDocumentRecordTypeName_Last(
        java.lang.String documentRecordTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeName_Last(documentRecordTypeName,
            obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType[] findByDocumentRecordTypeName_PrevAndNext(
        int documentRecordTypeId, java.lang.String documentRecordTypeName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentRecordTypeException {
        return getPersistence()
                   .findByDocumentRecordTypeName_PrevAndNext(documentRecordTypeId,
            documentRecordTypeName, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentRecordTypeCode(documentRecordTypeCode);
    }

    public static void removeByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentRecordTypeName(documentRecordTypeName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocumentRecordTypeCode(
        java.lang.String documentRecordTypeCode)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentRecordTypeCode(documentRecordTypeCode);
    }

    public static int countByDocumentRecordTypeName(
        java.lang.String documentRecordTypeName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentRecordTypeName(documentRecordTypeName);
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

    public static PmlEdmDocumentRecordTypePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmDocumentRecordTypePersistence persistence) {
        _persistence = persistence;
    }
}
