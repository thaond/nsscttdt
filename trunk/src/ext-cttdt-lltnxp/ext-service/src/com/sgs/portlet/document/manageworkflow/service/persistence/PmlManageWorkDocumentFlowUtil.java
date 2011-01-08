package com.sgs.portlet.document.manageworkflow.service.persistence;

public class PmlManageWorkDocumentFlowUtil {
    private static PmlManageWorkDocumentFlowPersistence _persistence;

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow create(
        long manageDocumentWorkFlowId) {
        return getPersistence().create(manageDocumentWorkFlowId);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow remove(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().remove(manageDocumentWorkFlowId);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow remove(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlManageWorkDocumentFlow);
    }

    /**
     * @deprecated Use <code>update(PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow update(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlManageWorkDocumentFlow);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlManageWorkDocumentFlow the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlManageWorkDocumentFlow is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow update(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlManageWorkDocumentFlow, merge);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow updateImpl(
        com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow pmlManageWorkDocumentFlow,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlManageWorkDocumentFlow, merge);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByPrimaryKey(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().findByPrimaryKey(manageDocumentWorkFlowId);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow fetchByPrimaryKey(
        long manageDocumentWorkFlowId)
        throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(manageDocumentWorkFlowId);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByWorkFlowName(
        java.lang.String workFlowName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkFlowName(workFlowName);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByWorkFlowName(
        java.lang.String workFlowName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkFlowName(workFlowName, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByWorkFlowName(
        java.lang.String workFlowName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByWorkFlowName(workFlowName, start, end, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByWorkFlowName_First(
        java.lang.String workFlowName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().findByWorkFlowName_First(workFlowName, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByWorkFlowName_Last(
        java.lang.String workFlowName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().findByWorkFlowName_Last(workFlowName, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow[] findByWorkFlowName_PrevAndNext(
        long manageDocumentWorkFlowId, java.lang.String workFlowName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence()
                   .findByWorkFlowName_PrevAndNext(manageDocumentWorkFlowId,
            workFlowName, obc);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByversion(
        int version) throws com.liferay.portal.SystemException {
        return getPersistence().findByversion(version);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByversion(
        int version, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByversion(version, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findByversion(
        int version, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByversion(version, start, end, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByversion_First(
        int version, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().findByversion_First(version, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findByversion_Last(
        int version, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().findByversion_Last(version, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow[] findByversion_PrevAndNext(
        long manageDocumentWorkFlowId, int version,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence()
                   .findByversion_PrevAndNext(manageDocumentWorkFlowId,
            version, obc);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findBytype(
        int type) throws com.liferay.portal.SystemException {
        return getPersistence().findBytype(type);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findBytype(
        int type, int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findBytype(type, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findBytype(
        int type, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBytype(type, start, end, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findBytype_First(
        int type, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().findBytype_First(type, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow findBytype_Last(
        int type, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence().findBytype_Last(type, obc);
    }

    public static com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow[] findBytype_PrevAndNext(
        long manageDocumentWorkFlowId, int type,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.manageworkflow.NoSuchException {
        return getPersistence()
                   .findBytype_PrevAndNext(manageDocumentWorkFlowId, type, obc);
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

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByWorkFlowName(java.lang.String workFlowName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByWorkFlowName(workFlowName);
    }

    public static void removeByversion(int version)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByversion(version);
    }

    public static void removeBytype(int type)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBytype(type);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByWorkFlowName(java.lang.String workFlowName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByWorkFlowName(workFlowName);
    }

    public static int countByversion(int version)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByversion(version);
    }

    public static int countBytype(int type)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBytype(type);
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

    public static PmlManageWorkDocumentFlowPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlManageWorkDocumentFlowPersistence persistence) {
        _persistence = persistence;
    }
}
