package com.sgs.portlet.document.receipt.service.persistence;

public class PmlEdmConfidentialLevelUtil {
    private static PmlEdmConfidentialLevelPersistence _persistence;

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel create(
        java.lang.String confidentialLevelId) {
        return getPersistence().create(confidentialLevelId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel remove(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException {
        return getPersistence().remove(confidentialLevelId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel remove(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlEdmConfidentialLevel);
    }

    /**
     * @deprecated Use <code>update(PmlEdmConfidentialLevel pmlEdmConfidentialLevel, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel update(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmConfidentialLevel);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmConfidentialLevel the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmConfidentialLevel is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel update(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlEdmConfidentialLevel, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel updateImpl(
        com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel pmlEdmConfidentialLevel,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlEdmConfidentialLevel, merge);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel findByPrimaryKey(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException {
        return getPersistence().findByPrimaryKey(confidentialLevelId);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel fetchByPrimaryKey(
        java.lang.String confidentialLevelId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(confidentialLevelId);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByConfidentialLevelName(
        java.lang.String confidentialLevelName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelName(confidentialLevelName);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByConfidentialLevelName(
        java.lang.String confidentialLevelName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelName(confidentialLevelName, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findByConfidentialLevelName(
        java.lang.String confidentialLevelName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByConfidentialLevelName(confidentialLevelName, start,
            end, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel findByConfidentialLevelName_First(
        java.lang.String confidentialLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException {
        return getPersistence()
                   .findByConfidentialLevelName_First(confidentialLevelName, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel findByConfidentialLevelName_Last(
        java.lang.String confidentialLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException {
        return getPersistence()
                   .findByConfidentialLevelName_Last(confidentialLevelName, obc);
    }

    public static com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel[] findByConfidentialLevelName_PrevAndNext(
        java.lang.String confidentialLevelId,
        java.lang.String confidentialLevelName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.receipt.NoSuchPmlEdmConfidentialLevelException {
        return getPersistence()
                   .findByConfidentialLevelName_PrevAndNext(confidentialLevelId,
            confidentialLevelName, obc);
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

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByConfidentialLevelName(
        java.lang.String confidentialLevelName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByConfidentialLevelName(confidentialLevelName);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByConfidentialLevelName(
        java.lang.String confidentialLevelName)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByConfidentialLevelName(confidentialLevelName);
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

    public static PmlEdmConfidentialLevelPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlEdmConfidentialLevelPersistence persistence) {
        _persistence = persistence;
    }
}
