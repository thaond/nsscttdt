package com.sgs.portlet.pmllevelsend.service.persistence;

public class PmlEdmLevelSendUtil {
    private static PmlEdmLevelSendPersistence _persistence;

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend create(
        int levelSendId) {
        return getPersistence().create(levelSendId);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend remove(
        int levelSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence().remove(levelSendId);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend remove(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmLevelSend);
    }

    /**
     * @deprecated Use <code>update(PmlEdmLevelSend pmlEdmLevelSend, boolean merge)</code>.
     */
    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend update(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmLevelSend);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmLevelSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmLevelSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend update(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmLevelSend, merge);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend updateImpl(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmLevelSend, merge);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByPrimaryKey(
        int levelSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence().findByPrimaryKey(levelSendId);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend fetchByPrimaryKey(
        int levelSendId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(levelSendId);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendCode(
        java.lang.String levelSendCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendCode(levelSendCode);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendCode(
        java.lang.String levelSendCode, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendCode(levelSendCode, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendCode(
        java.lang.String levelSendCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByLevelSendCode(levelSendCode, start, end, obc);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendCode_First(
        java.lang.String levelSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence().findByLevelSendCode_First(levelSendCode, obc);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendCode_Last(
        java.lang.String levelSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence().findByLevelSendCode_Last(levelSendCode, obc);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend[] findByLevelSendCode_PrevAndNext(
        int levelSendId, java.lang.String levelSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence()
                   .findByLevelSendCode_PrevAndNext(levelSendId, levelSendCode,
            obc);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendName(
        java.lang.String levelSendName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendName(levelSendName);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendName(
        java.lang.String levelSendName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByLevelSendName(levelSendName, start, end);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendName(
        java.lang.String levelSendName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByLevelSendName(levelSendName, start, end, obc);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendName_First(
        java.lang.String levelSendName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence().findByLevelSendName_First(levelSendName, obc);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendName_Last(
        java.lang.String levelSendName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence().findByLevelSendName_Last(levelSendName, obc);
    }

    public static com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend[] findByLevelSendName_PrevAndNext(
        int levelSendId, java.lang.String levelSendName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException {
        return getPersistence()
                   .findByLevelSendName_PrevAndNext(levelSendId, levelSendName,
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

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByLevelSendCode(java.lang.String levelSendCode)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLevelSendCode(levelSendCode);
    }

    public static void removeByLevelSendName(java.lang.String levelSendName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByLevelSendName(levelSendName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByLevelSendCode(java.lang.String levelSendCode)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLevelSendCode(levelSendCode);
    }

    public static int countByLevelSendName(java.lang.String levelSendName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByLevelSendName(levelSendName);
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

    public static PmlEdmLevelSendPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmLevelSendPersistence persistence) {
        _persistence = persistence;
    }
}
