package com.nss.portlet.onedoor.service.persistence;

public class PmlTransitionUtil {
    private static PmlTransitionPersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition) {
        getPersistence().cacheResult(pmlTransition);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlTransition> pmlTransitions) {
        getPersistence().cacheResult(pmlTransitions);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.onedoor.model.PmlTransition create(
        long transitionId) {
        return getPersistence().create(transitionId);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition remove(
        long transitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().remove(transitionId);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition remove(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlTransition);
    }

    /**
     * @deprecated Use <code>update(PmlTransition pmlTransition, boolean merge)</code>.
     */
    public static com.nss.portlet.onedoor.model.PmlTransition update(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTransition);
    }

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTransition the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTransition is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public static com.nss.portlet.onedoor.model.PmlTransition update(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTransition, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition updateImpl(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition, boolean merge)
        throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlTransition, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByPrimaryKey(
        long transitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByPrimaryKey(transitionId);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition fetchByPrimaryKey(
        long transitionId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(transitionId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId_Version(
        java.lang.String fileTypeId, java.lang.String version_)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId_Version(fileTypeId, version_);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId_Version(
        java.lang.String fileTypeId, java.lang.String version_, int start,
        int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_Version(fileTypeId, version_, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId_Version(
        java.lang.String fileTypeId, java.lang.String version_, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileTypeId_Version(fileTypeId, version_, start, end,
            obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_Version_First(
        java.lang.String fileTypeId, java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByFileTypeId_Version_First(fileTypeId, version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_Version_Last(
        java.lang.String fileTypeId, java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByFileTypeId_Version_Last(fileTypeId, version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition[] findByFileTypeId_Version_PrevAndNext(
        long transitionId, java.lang.String fileTypeId,
        java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByFileTypeId_Version_PrevAndNext(transitionId,
            fileTypeId, version_, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByVersion_(
        java.lang.String version_) throws com.liferay.portal.SystemException {
        return getPersistence().findByVersion_(version_);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByVersion_(
        java.lang.String version_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByVersion_(version_, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByVersion_(
        java.lang.String version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByVersion_(version_, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByVersion__First(
        java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByVersion__First(version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByVersion__Last(
        java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByVersion__Last(version_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition[] findByVersion__PrevAndNext(
        long transitionId, java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByVersion__PrevAndNext(transitionId, version_, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByTransitionName(
        java.lang.String transitionName)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTransitionName(transitionName);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByTransitionName(
        java.lang.String transitionName, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTransitionName(transitionName, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByTransitionName(
        java.lang.String transitionName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByTransitionName(transitionName, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByTransitionName_First(
        java.lang.String transitionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByTransitionName_First(transitionName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByTransitionName_Last(
        java.lang.String transitionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByTransitionName_Last(transitionName, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition[] findByTransitionName_PrevAndNext(
        long transitionId, java.lang.String transitionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByTransitionName_PrevAndNext(transitionId,
            transitionName, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileTypeId(fileTypeId, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByFileTypeId_First(fileTypeId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByFileTypeId_Last(fileTypeId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition[] findByFileTypeId_PrevAndNext(
        long transitionId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByFileTypeId_PrevAndNext(transitionId, fileTypeId, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByNoTransition(
        int noTransition) throws com.liferay.portal.SystemException {
        return getPersistence().findByNoTransition(noTransition);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByNoTransition(
        int noTransition, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNoTransition(noTransition, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByNoTransition(
        int noTransition, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNoTransition(noTransition, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByNoTransition_First(
        int noTransition, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByNoTransition_First(noTransition, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByNoTransition_Last(
        int noTransition, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence().findByNoTransition_Last(noTransition, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition[] findByNoTransition_PrevAndNext(
        long transitionId, int noTransition,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByNoTransition_PrevAndNext(transitionId, noTransition,
            obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessCurrent(stateProcessCurrent);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessCurrent(stateProcessCurrent, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessCurrent(stateProcessCurrent, start, end,
            obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByStateProcessCurrent_First(
        long stateProcessCurrent,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByStateProcessCurrent_First(stateProcessCurrent, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByStateProcessCurrent_Last(
        long stateProcessCurrent,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByStateProcessCurrent_Last(stateProcessCurrent, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition[] findByStateProcessCurrent_PrevAndNext(
        long transitionId, long stateProcessCurrent,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByStateProcessCurrent_PrevAndNext(transitionId,
            stateProcessCurrent, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessNext(
        long stateProcessNext) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessNext(stateProcessNext);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessNext(
        long stateProcessNext, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessNext(stateProcessNext, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessNext(
        long stateProcessNext, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessNext(stateProcessNext, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByStateProcessNext_First(
        long stateProcessNext,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByStateProcessNext_First(stateProcessNext, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition findByStateProcessNext_Last(
        long stateProcessNext,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByStateProcessNext_Last(stateProcessNext, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlTransition[] findByStateProcessNext_PrevAndNext(
        long transitionId, long stateProcessNext,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException {
        return getPersistence()
                   .findByStateProcessNext_PrevAndNext(transitionId,
            stateProcessNext, obc);
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

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByFileTypeId_Version(java.lang.String fileTypeId,
        java.lang.String version_) throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId_Version(fileTypeId, version_);
    }

    public static void removeByVersion_(java.lang.String version_)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByVersion_(version_);
    }

    public static void removeByTransitionName(java.lang.String transitionName)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTransitionName(transitionName);
    }

    public static void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileTypeId(fileTypeId);
    }

    public static void removeByNoTransition(int noTransition)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNoTransition(noTransition);
    }

    public static void removeByStateProcessCurrent(long stateProcessCurrent)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessCurrent(stateProcessCurrent);
    }

    public static void removeByStateProcessNext(long stateProcessNext)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessNext(stateProcessNext);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByFileTypeId_Version(java.lang.String fileTypeId,
        java.lang.String version_) throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId_Version(fileTypeId, version_);
    }

    public static int countByVersion_(java.lang.String version_)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByVersion_(version_);
    }

    public static int countByTransitionName(java.lang.String transitionName)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTransitionName(transitionName);
    }

    public static int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileTypeId(fileTypeId);
    }

    public static int countByNoTransition(int noTransition)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNoTransition(noTransition);
    }

    public static int countByStateProcessCurrent(long stateProcessCurrent)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessCurrent(stateProcessCurrent);
    }

    public static int countByStateProcessNext(long stateProcessNext)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessNext(stateProcessNext);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlTransitionPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlTransitionPersistence persistence) {
        _persistence = persistence;
    }
}
