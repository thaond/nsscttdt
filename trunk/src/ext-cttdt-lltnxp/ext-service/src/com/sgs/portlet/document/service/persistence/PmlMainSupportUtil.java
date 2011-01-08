package com.sgs.portlet.document.service.persistence;

public class PmlMainSupportUtil {
    private static PmlMainSupportPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlMainSupport create(
        long processId) {
        return getPersistence().create(processId);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport remove(
        long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence().remove(processId);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport remove(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlMainSupport);
    }

    /**
     * @deprecated Use <code>update(PmlMainSupport pmlMainSupport, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlMainSupport update(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlMainSupport);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlMainSupport the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlMainSupport is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.model.PmlMainSupport update(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlMainSupport, merge);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport updateImpl(
        com.sgs.portlet.document.model.PmlMainSupport pmlMainSupport,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlMainSupport, merge);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findByPrimaryKey(
        long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence().findByPrimaryKey(processId);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport fetchByPrimaryKey(
        long processId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(processId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByProcessIdMain(
        long processId_Main) throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessIdMain(processId_Main);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByProcessIdMain(
        long processId_Main, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessIdMain(processId_Main, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByProcessIdMain(
        long processId_Main, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessIdMain(processId_Main, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findByProcessIdMain_First(
        long processId_Main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence().findByProcessIdMain_First(processId_Main, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findByProcessIdMain_Last(
        long processId_Main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence().findByProcessIdMain_Last(processId_Main, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport[] findByProcessIdMain_PrevAndNext(
        long processId, long processId_Main,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence()
                   .findByProcessIdMain_PrevAndNext(processId, processId_Main,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByType(
        java.lang.String type_) throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByType(
        java.lang.String type_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByType(
        java.lang.String type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type_, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findByType_First(
        java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence().findByType_First(type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findByType_Last(
        java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence().findByType_Last(type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport[] findByType_PrevAndNext(
        long processId, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence().findByType_PrevAndNext(processId, type_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findBySupportInfomation(
        java.lang.String supportInfomation)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySupportInfomation(supportInfomation);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findBySupportInfomation(
        java.lang.String supportInfomation, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySupportInfomation(supportInfomation, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findBySupportInfomation(
        java.lang.String supportInfomation, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySupportInfomation(supportInfomation, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findBySupportInfomation_First(
        java.lang.String supportInfomation,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence()
                   .findBySupportInfomation_First(supportInfomation, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findBySupportInfomation_Last(
        java.lang.String supportInfomation,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence()
                   .findBySupportInfomation_Last(supportInfomation, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport[] findBySupportInfomation_PrevAndNext(
        long processId, java.lang.String supportInfomation,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence()
                   .findBySupportInfomation_PrevAndNext(processId,
            supportInfomation, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByprocessIdMain_Type(
        long processId_Main, java.lang.String type_)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByprocessIdMain_Type(processId_Main, type_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByprocessIdMain_Type(
        long processId_Main, java.lang.String type_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByprocessIdMain_Type(processId_Main, type_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findByprocessIdMain_Type(
        long processId_Main, java.lang.String type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByprocessIdMain_Type(processId_Main, type_, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findByprocessIdMain_Type_First(
        long processId_Main, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence()
                   .findByprocessIdMain_Type_First(processId_Main, type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport findByprocessIdMain_Type_Last(
        long processId_Main, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence()
                   .findByprocessIdMain_Type_Last(processId_Main, type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlMainSupport[] findByprocessIdMain_Type_PrevAndNext(
        long processId, long processId_Main, java.lang.String type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlMainSupportException {
        return getPersistence()
                   .findByprocessIdMain_Type_PrevAndNext(processId,
            processId_Main, type_, obc);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlMainSupport> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByProcessIdMain(long processId_Main)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByProcessIdMain(processId_Main);
    }

    public static void removeByType(java.lang.String type_)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByType(type_);
    }

    public static void removeBySupportInfomation(
        java.lang.String supportInfomation)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySupportInfomation(supportInfomation);
    }

    public static void removeByprocessIdMain_Type(long processId_Main,
        java.lang.String type_) throws com.liferay.portal.SystemException {
        getPersistence().removeByprocessIdMain_Type(processId_Main, type_);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByProcessIdMain(long processId_Main)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByProcessIdMain(processId_Main);
    }

    public static int countByType(java.lang.String type_)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByType(type_);
    }

    public static int countBySupportInfomation(
        java.lang.String supportInfomation)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySupportInfomation(supportInfomation);
    }

    public static int countByprocessIdMain_Type(long processId_Main,
        java.lang.String type_) throws com.liferay.portal.SystemException {
        return getPersistence().countByprocessIdMain_Type(processId_Main, type_);
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

    public static PmlMainSupportPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlMainSupportPersistence persistence) {
        _persistence = persistence;
    }
}
