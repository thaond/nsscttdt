package com.ext.portlet.processtype.service.persistence;

public class ProcessTypeUtil {
    private static ProcessTypePersistence _persistence;

    public static com.ext.portlet.processtype.model.ProcessType create(
        long processTypeId) {
        return getPersistence().create(processTypeId);
    }

    public static com.ext.portlet.processtype.model.ProcessType remove(
        long processTypeId)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().remove(processTypeId);
    }

    public static com.ext.portlet.processtype.model.ProcessType remove(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(processType);
    }

    /**
     * @deprecated Use <code>update(ProcessType processType, boolean merge)</code>.
     */
    public static com.ext.portlet.processtype.model.ProcessType update(
        com.ext.portlet.processtype.model.ProcessType processType)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(processType);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                processType the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when processType is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.ext.portlet.processtype.model.ProcessType update(
        com.ext.portlet.processtype.model.ProcessType processType, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(processType, merge);
    }

    public static com.ext.portlet.processtype.model.ProcessType updateImpl(
        com.ext.portlet.processtype.model.ProcessType processType, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(processType, merge);
    }

    public static com.ext.portlet.processtype.model.ProcessType findByPrimaryKey(
        long processTypeId)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByPrimaryKey(processTypeId);
    }

    public static com.ext.portlet.processtype.model.ProcessType fetchByPrimaryKey(
        long processTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(processTypeId);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findByName(
        java.lang.String name) throws com.liferay.portal.SystemException {
        return getPersistence().findByName(name);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findByName(
        java.lang.String name, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(name, start, end);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findByName(
        java.lang.String name, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByName(name, start, end, obc);
    }

    public static com.ext.portlet.processtype.model.ProcessType findByName_First(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByName_First(name, obc);
    }

    public static com.ext.portlet.processtype.model.ProcessType findByName_Last(
        java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByName_Last(name, obc);
    }

    public static com.ext.portlet.processtype.model.ProcessType[] findByName_PrevAndNext(
        long processTypeId, java.lang.String name,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByName_PrevAndNext(processTypeId, name, obc);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findByFlagProcessType(
        int flagProcessType) throws com.liferay.portal.SystemException {
        return getPersistence().findByFlagProcessType(flagProcessType);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findByFlagProcessType(
        int flagProcessType, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFlagProcessType(flagProcessType, start, end);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findByFlagProcessType(
        int flagProcessType, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFlagProcessType(flagProcessType, start, end, obc);
    }

    public static com.ext.portlet.processtype.model.ProcessType findByFlagProcessType_First(
        int flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByFlagProcessType_First(flagProcessType, obc);
    }

    public static com.ext.portlet.processtype.model.ProcessType findByFlagProcessType_Last(
        int flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence().findByFlagProcessType_Last(flagProcessType, obc);
    }

    public static com.ext.portlet.processtype.model.ProcessType[] findByFlagProcessType_PrevAndNext(
        long processTypeId, int flagProcessType,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.ext.portlet.processtype.NoSuchProcessTypeException,
            com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFlagProcessType_PrevAndNext(processTypeId,
            flagProcessType, obc);
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

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.ext.portlet.processtype.model.ProcessType> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByName(java.lang.String name)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByName(name);
    }

    public static void removeByFlagProcessType(int flagProcessType)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFlagProcessType(flagProcessType);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByName(java.lang.String name)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByName(name);
    }

    public static int countByFlagProcessType(int flagProcessType)
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

    public static ProcessTypePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(ProcessTypePersistence persistence) {
        _persistence = persistence;
    }
}
