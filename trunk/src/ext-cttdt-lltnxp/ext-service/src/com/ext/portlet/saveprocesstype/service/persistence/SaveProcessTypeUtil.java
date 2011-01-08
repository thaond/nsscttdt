package com.ext.portlet.saveprocesstype.service.persistence;

public class SaveProcessTypeUtil {
    private static SaveProcessTypePersistence _persistence;

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType create(
        long sptId) {
        return getPersistence().create(sptId);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType remove(
        long sptId)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(sptId);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType remove(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(saveProcessType);
    }

    /**
     * @deprecated Use <code>update(SaveProcessType saveProcessType, boolean merge)</code>.
     */
    public static com.ext.portlet.saveprocesstype.model.SaveProcessType update(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(saveProcessType);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                saveProcessType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when saveProcessType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.saveprocesstype.model.SaveProcessType update(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(saveProcessType, merge);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType updateImpl(
        com.ext.portlet.saveprocesstype.model.SaveProcessType saveProcessType,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(saveProcessType, merge);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType findByPrimaryKey(
        long sptId)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(sptId);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType fetchByPrimaryKey(
        long sptId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(sptId);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByDocId(
        long docId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocId(docId);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByDocId(
        long docId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocId(docId, start, end);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByDocId(
        long docId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocId(docId, start, end, obc);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType findByDocId_First(
        long docId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByDocId_First(docId, obc);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType findByDocId_Last(
        long docId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByDocId_Last(docId, obc);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType[] findByDocId_PrevAndNext(
        long sptId, long docId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByDocId_PrevAndNext(sptId, docId, obc);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByFlagProcessType(
        long flagProcessType) throws com.liferay.portal.SystemException {
        return getPersistence().findByFlagProcessType(flagProcessType);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByFlagProcessType(
        long flagProcessType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFlagProcessType(flagProcessType, start, end);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findByFlagProcessType(
        long flagProcessType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFlagProcessType(flagProcessType, start, end, obc);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType findByFlagProcessType_First(
        long flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByFlagProcessType_First(flagProcessType, obc);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType findByFlagProcessType_Last(
        long flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByFlagProcessType_Last(flagProcessType, obc);
    }

    public static com.ext.portlet.saveprocesstype.model.SaveProcessType[] findByFlagProcessType_PrevAndNext(
        long sptId, long flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.saveprocesstype.NoSuchSaveProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFlagProcessType_PrevAndNext(sptId, flagProcessType,
            obc);
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

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.saveprocesstype.model.SaveProcessType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByDocId(long docId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocId(docId);
    }

    public static void removeByFlagProcessType(long flagProcessType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFlagProcessType(flagProcessType);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByDocId(long docId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocId(docId);
    }

    public static int countByFlagProcessType(long flagProcessType)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFlagProcessType(flagProcessType);
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

    public static SaveProcessTypePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(SaveProcessTypePersistence persistence) {
        _persistence = persistence;
    }
}
