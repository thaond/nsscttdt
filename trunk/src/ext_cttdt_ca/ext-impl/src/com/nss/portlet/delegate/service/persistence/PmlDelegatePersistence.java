package com.nss.portlet.delegate.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;


public interface PmlDelegatePersistence extends BasePersistence {
    public void cacheResult(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate);

    public void cacheResult(
        java.util.List<com.nss.portlet.delegate.model.PmlDelegate> pmlDelegates);

    public void clearCache();

    public com.nss.portlet.delegate.model.PmlDelegate create(long delegateId);

    public com.nss.portlet.delegate.model.PmlDelegate remove(long delegateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate remove(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDelegate pmlDelegate, boolean merge)</code>.
     */
    public com.nss.portlet.delegate.model.PmlDelegate update(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.nss.portlet.delegate.model.PmlDelegate update(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate updateImpl(
        com.nss.portlet.delegate.model.PmlDelegate pmlDelegate, boolean merge)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByPrimaryKey(
        long delegateId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate fetchByPrimaryKey(
        long delegateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceive_StartDate_CancelDate_CancelDelegate_First(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceive_StartDate_CancelDate_CancelDelegate_Last(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByReceive_StartDate_CancelDate_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, java.util.Date startDate,
        java.util.Date cancelDate, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceive_StartDate_EndDate_CancelDelegate_First(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceive_StartDate_EndDate_CancelDelegate_Last(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByReceive_StartDate_EndDate_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, java.util.Date startDate,
        java.util.Date endDate, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceive_StartDate_EndDate_First(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceive_StartDate_EndDate_Last(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByReceive_StartDate_EndDate_PrevAndNext(
        long delegateId, long receiver, java.util.Date startDate,
        java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByDateCreated_PrevAndNext(
        long delegateId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByCancelDelegate(
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByCancelDelegate(
        java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByCancelDelegate(
        java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByCancelDelegate_First(
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByCancelDelegate_Last(
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByCancelDelegate_PrevAndNext(
        long delegateId, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByAssigner_Receiver_StartDate_EndDate_First(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByAssigner_Receiver_StartDate_EndDate_Last(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByAssigner_Receiver_StartDate_EndDate_PrevAndNext(
        long delegateId, long assigner, long receiver,
        java.util.Date startDate, java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner(
        long assigner) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner(
        long assigner, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner(
        long assigner, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByAssigner_First(
        long assigner, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByAssigner_Last(
        long assigner, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByAssigner_PrevAndNext(
        long delegateId, long assigner,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByReceiver_PrevAndNext(
        long delegateId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner_Receiver(
        long assigner, long receiver) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner_Receiver(
        long assigner, long receiver, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByAssigner_Receiver(
        long assigner, long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByAssigner_Receiver_First(
        long assigner, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByAssigner_Receiver_Last(
        long assigner, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByAssigner_Receiver_PrevAndNext(
        long delegateId, long assigner, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceiver_CancelDelegate(
        long receiver, java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceiver_CancelDelegate(
        long receiver, java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findByReceiver_CancelDelegate(
        long receiver, java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceiver_CancelDelegate_First(
        long receiver, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate findByReceiver_CancelDelegate_Last(
        long receiver, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public com.nss.portlet.delegate.model.PmlDelegate[] findByReceiver_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.delegate.NoSuchPmlDelegateException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.nss.portlet.delegate.model.PmlDelegate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public void removeByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public void removeByReceive_StartDate_EndDate(long receiver,
        java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException;

    public void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public void removeByCancelDelegate(java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public void removeByAssigner_Receiver_StartDate_EndDate(long assigner,
        long receiver, java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException;

    public void removeByAssigner(long assigner)
        throws com.liferay.portal.SystemException;

    public void removeByReceiver(long receiver)
        throws com.liferay.portal.SystemException;

    public void removeByAssigner_Receiver(long assigner, long receiver)
        throws com.liferay.portal.SystemException;

    public void removeByReceiver_CancelDelegate(long receiver,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public int countByReceive_StartDate_EndDate_CancelDelegate(long receiver,
        java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public int countByReceive_StartDate_EndDate(long receiver,
        java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException;

    public int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException;

    public int countByCancelDelegate(java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public int countByAssigner_Receiver_StartDate_EndDate(long assigner,
        long receiver, java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException;

    public int countByAssigner(long assigner)
        throws com.liferay.portal.SystemException;

    public int countByReceiver(long receiver)
        throws com.liferay.portal.SystemException;

    public int countByAssigner_Receiver(long assigner, long receiver)
        throws com.liferay.portal.SystemException;

    public int countByReceiver_CancelDelegate(long receiver,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;
}
