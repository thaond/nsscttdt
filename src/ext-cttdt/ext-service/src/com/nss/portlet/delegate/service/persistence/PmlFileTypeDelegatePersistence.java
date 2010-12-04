package com.nss.portlet.delegate.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PmlFileTypeDelegatePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate);

    public void cacheResult(
        java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> pmlFileTypeDelegates);

    public void clearCache();

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate create(
        long fileTypeDelegateId);

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate remove(
        long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate remove(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlFileTypeDelegate pmlFileTypeDelegate, boolean merge)</code>.
     */
    public com.nss.portlet.delegate.model.PmlFileTypeDelegate update(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate)
        throws com.liferay.portal.SystemException;

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
    public com.nss.portlet.delegate.model.PmlFileTypeDelegate update(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate updateImpl(
        com.nss.portlet.delegate.model.PmlFileTypeDelegate pmlFileTypeDelegate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate findByPrimaryKey(
        long fileTypeDelegateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate fetchByPrimaryKey(
        long fileTypeDelegateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByFileTypeId_DelegateId(
        java.lang.String fileTypeId, long delegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate findByFileTypeId_DelegateId_First(
        java.lang.String fileTypeId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate findByFileTypeId_DelegateId_Last(
        java.lang.String fileTypeId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate[] findByFileTypeId_DelegateId_PrevAndNext(
        long fileTypeDelegateId, java.lang.String fileTypeId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByFileTypeId(
        java.lang.String fileTypeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByFileTypeId(
        java.lang.String fileTypeId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate findByFileTypeId_First(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate findByFileTypeId_Last(
        java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate[] findByFileTypeId_PrevAndNext(
        long fileTypeDelegateId, java.lang.String fileTypeId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByDelegateId(
        long delegateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByDelegateId(
        long delegateId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findByDelegateId(
        long delegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate findByDelegateId_First(
        long delegateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate findByDelegateId_Last(
        long delegateId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public com.nss.portlet.delegate.model.PmlFileTypeDelegate[] findByDelegateId_PrevAndNext(
        long fileTypeDelegateId, long delegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlFileTypeDelegateException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlFileTypeDelegate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByFileTypeId_DelegateId(java.lang.String fileTypeId,
        long delegateId) throws com.liferay.portal.SystemException;

    public void removeByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public void removeByDelegateId(long delegateId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByFileTypeId_DelegateId(java.lang.String fileTypeId,
        long delegateId) throws com.liferay.portal.SystemException;

    public int countByFileTypeId(java.lang.String fileTypeId)
        throws com.liferay.portal.SystemException;

    public int countByDelegateId(long delegateId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
