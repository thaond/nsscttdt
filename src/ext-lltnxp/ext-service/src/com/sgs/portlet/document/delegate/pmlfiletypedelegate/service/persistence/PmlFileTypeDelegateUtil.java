package com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence;

public class PmlFileTypeDelegateUtil {
    private static PmlFileTypeDelegatePersistence _persistence;

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate create(
        long fileTypeDelegateId) {
        return getPersistence().create(fileTypeDelegateId);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate remove(
        long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence().remove(fileTypeDelegateId);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate remove(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlFileTypeDelegate);
    }

    /**
     * @deprecated Use <code>update(PmlFileTypeDelegate pmlFileTypeDelegate, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate update(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileTypeDelegate);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlFileTypeDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlFileTypeDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate update(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlFileTypeDelegate, merge);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate updateImpl(
        com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlFileTypeDelegate, merge);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate findByPrimaryKey(
        long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence().findByPrimaryKey(fileTypeDelegateId);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate fetchByPrimaryKey(
        long fileTypeDelegateId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(fileTypeDelegateId);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_DelegateId(fileTypeId, delegateId);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_DelegateId(fileTypeId, delegateId, start,
            end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_DelegateId(fileTypeId, delegateId, start,
            end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate findByFileTypeId_DelegateId_First(
        java.lang.String fileTypeId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence()
                   .findByFileTypeId_DelegateId_First(fileTypeId, delegateId,
            obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate findByFileTypeId_DelegateId_Last(
        java.lang.String fileTypeId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence()
                   .findByFileTypeId_DelegateId_Last(fileTypeId, delegateId, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate[] findByFileTypeId_DelegateId_PrevAndNext(
        long fileTypeDelegateId, java.lang.String fileTypeId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence()
                   .findByFileTypeId_DelegateId_PrevAndNext(fileTypeDelegateId,
            fileTypeId, delegateId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence().findByFileTypeId_First(fileTypeId, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence().findByFileTypeId_Last(fileTypeId, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate[] findByFileTypeId_PrevAndNext(
        long fileTypeDelegateId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence()
                   .findByFileTypeId_PrevAndNext(fileTypeDelegateId,
            fileTypeId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByDelegateId(
        long delegateId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDelegateId(delegateId);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByDelegateId(
        long delegateId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDelegateId(delegateId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findByDelegateId(
        long delegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDelegateId(delegateId, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate findByDelegateId_First(
        long delegateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence().findByDelegateId_First(delegateId, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate findByDelegateId_Last(
        long delegateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence().findByDelegateId_Last(delegateId, obc);
    }

    public static com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate[] findByDelegateId_PrevAndNext(
        long fileTypeDelegateId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmlfiletypedelegate.NoSuchException {
        return getPersistence()
                   .findByDelegateId_PrevAndNext(fileTypeDelegateId,
            delegateId, obc);
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

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId_DelegateId(fileTypeId, delegateId);
    }

    public static void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId(fileTypeId);
    }

    public static void removeByDelegateId(long delegateId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDelegateId(delegateId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileTypeId_DelegateId(fileTypeId, delegateId);
    }

    public static int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId(fileTypeId);
    }

    public static int countByDelegateId(long delegateId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDelegateId(delegateId);
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

    public static PmlFileTypeDelegatePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlFileTypeDelegatePersistence persistence) {
        _persistence = persistence;
    }
}
