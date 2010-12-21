package com.nss.portlet.onedoor.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PmlTransitionPersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition);

    public void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlTransition> pmlTransitions);

    public void clearCache();

    public com.nss.portlet.onedoor.model.PmlTransition create(long transitionId);

    public com.nss.portlet.onedoor.model.PmlTransition remove(long transitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition remove(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlTransition pmlTransition, boolean merge)</code>.
     */
    public com.nss.portlet.onedoor.model.PmlTransition update(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.onedoor.model.PmlTransition update(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition updateImpl(
        com.nss.portlet.onedoor.model.PmlTransition pmlTransition, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByPrimaryKey(
        long transitionId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition fetchByPrimaryKey(
        long transitionId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId_Version(
        java.lang.String fileTypeId, java.lang.String version_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId_Version(
        java.lang.String fileTypeId, java.lang.String version_, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId_Version(
        java.lang.String fileTypeId, java.lang.String version_, int start,
        int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_Version_First(
        java.lang.String fileTypeId, java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_Version_Last(
        java.lang.String fileTypeId, java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition[] findByFileTypeId_Version_PrevAndNext(
        long transitionId, java.lang.String fileTypeId,
        java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByVersion_(
        java.lang.String version_) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByVersion_(
        java.lang.String version_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByVersion_(
        java.lang.String version_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByVersion__First(
        java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition findByVersion__Last(
        java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition[] findByVersion__PrevAndNext(
        long transitionId, java.lang.String version_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByTransitionName(
        java.lang.String transitionName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByTransitionName(
        java.lang.String transitionName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByTransitionName(
        java.lang.String transitionName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByTransitionName_First(
        java.lang.String transitionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition findByTransitionName_Last(
        java.lang.String transitionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition[] findByTransitionName_PrevAndNext(
        long transitionId, java.lang.String transitionName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition[] findByFileTypeId_PrevAndNext(
        long transitionId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByNoTransition(
        int noTransition) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByNoTransition(
        int noTransition, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByNoTransition(
        int noTransition, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByNoTransition_First(
        int noTransition, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition findByNoTransition_Last(
        int noTransition, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition[] findByNoTransition_PrevAndNext(
        long transitionId, int noTransition,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessCurrent(
        long stateProcessCurrent, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByStateProcessCurrent_First(
        long stateProcessCurrent,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition findByStateProcessCurrent_Last(
        long stateProcessCurrent,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition[] findByStateProcessCurrent_PrevAndNext(
        long transitionId, long stateProcessCurrent,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessNext(
        long stateProcessNext) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessNext(
        long stateProcessNext, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findByStateProcessNext(
        long stateProcessNext, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.onedoor.model.PmlTransition findByStateProcessNext_First(
        long stateProcessNext,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition findByStateProcessNext_Last(
        long stateProcessNext,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public com.nss.portlet.onedoor.model.PmlTransition[] findByStateProcessNext_PrevAndNext(
        long transitionId, long stateProcessNext,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlTransitionException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.onedoor.model.PmlTransition> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId_Version(java.lang.String fileTypeId,
        java.lang.String version_) throws com.liferay.portal.SystemException;

    public void removeByVersion_(java.lang.String version_)
        throws com.liferay.portal.SystemException;

    public void removeByTransitionName(java.lang.String transitionName)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByNoTransition(int noTransition)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessCurrent(long stateProcessCurrent)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessNext(long stateProcessNext)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileTypeId_Version(java.lang.String fileTypeId,
        java.lang.String version_) throws com.liferay.portal.SystemException;

    public int countByVersion_(java.lang.String version_)
        throws com.liferay.portal.SystemException;

    public int countByTransitionName(java.lang.String transitionName)
        throws com.liferay.portal.SystemException;

    public int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByNoTransition(int noTransition)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessCurrent(long stateProcessCurrent)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessNext(long stateProcessNext)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
