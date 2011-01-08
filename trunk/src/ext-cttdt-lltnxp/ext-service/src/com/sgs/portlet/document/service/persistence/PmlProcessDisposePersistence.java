package com.sgs.portlet.document.service.persistence;

public interface PmlProcessDisposePersistence {
    public com.sgs.portlet.document.model.PmlProcessDispose create(
        long processDisposeId);

    public com.sgs.portlet.document.model.PmlProcessDispose remove(
        long processDisposeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose remove(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlProcessDispose pmlProcessDispose, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlProcessDispose update(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlProcessDispose the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlProcessDispose is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlProcessDispose update(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose updateImpl(
        com.sgs.portlet.document.model.PmlProcessDispose pmlProcessDispose,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByPrimaryKey(
        long processDisposeId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose fetchByPrimaryKey(
        long processDisposeId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findBySendDate(
        java.util.Date sendDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findBySendDate(
        java.util.Date sendDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findBySendDate(
        java.util.Date sendDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findBySendDate_First(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findBySendDate_Last(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findBySendDate_PrevAndNext(
        long processDisposeId, java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByTransition(
        int transition_) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByTransition(
        int transition_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByTransition(
        int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByTransition_First(
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByTransition_Last(
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByTransition_PrevAndNext(
        long processDisposeId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByDelegateUser(
        long delegateUser) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByDelegateUser(
        long delegateUser, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByDelegateUser(
        long delegateUser, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByDelegateUser_First(
        long delegateUser, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByDelegateUser_Last(
        long delegateUser, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByDelegateUser_PrevAndNext(
        long processDisposeId, long delegateUser,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByExpiredDate(
        java.util.Date expiredDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByExpiredDate(
        java.util.Date expiredDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByExpiredDate(
        java.util.Date expiredDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByExpiredDate_First(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByExpiredDate_Last(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByExpiredDate_PrevAndNext(
        long processDisposeId, java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_Transition(
        java.lang.String fileId, int transition_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_Transition(
        java.lang.String fileId, int transition_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_Transition(
        java.lang.String fileId, int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_Transition_First(
        java.lang.String fileId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_Transition_Last(
        java.lang.String fileId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByFileId_Transition_PrevAndNext(
        long processDisposeId, java.lang.String fileId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_StateProcessIdBefore_First(
        java.lang.String fileId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_StateProcessIdBefore_Last(
        java.lang.String fileId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByFileId_StateProcessIdBefore_PrevAndNext(
        long processDisposeId, java.lang.String fileId,
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_StateProcessIdAfter_First(
        java.lang.String fileId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_StateProcessIdAfter_Last(
        java.lang.String fileId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByFileId_StateProcessIdAfter_PrevAndNext(
        long processDisposeId, java.lang.String fileId,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByProcesser(
        long processer) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByProcesser(
        long processer, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByProcesser(
        long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByProcesser_First(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByProcesser_Last(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByProcesser_PrevAndNext(
        long processDisposeId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByDateProcess(
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByDateProcess(
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByDateProcess(
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByDateProcess_First(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByDateProcess_Last(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByDateProcess_PrevAndNext(
        long processDisposeId, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByReceiver_PrevAndNext(
        long processDisposeId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByReceiveDate(
        java.util.Date receiveDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByReceiveDate(
        java.util.Date receiveDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByReceiveDate(
        java.util.Date receiveDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByReceiveDate_First(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByReceiveDate_Last(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByReceiveDate_PrevAndNext(
        long processDisposeId, java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByStateProcessIdBefore_First(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByStateProcessIdBefore_Last(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByStateProcessIdBefore_PrevAndNext(
        long processDisposeId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByStateProcessIdAfter_First(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByStateProcessIdAfter_Last(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByStateProcessIdAfter_PrevAndNext(
        long processDisposeId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public com.sgs.portlet.document.model.PmlProcessDispose[] findByFileId_PrevAndNext(
        long processDisposeId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchPmlProcessDisposeException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlProcessDispose> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException;

    public void removeByTransition(int transition_)
        throws com.liferay.portal.SystemException;

    public void removeByDelegateUser(long delegateUser)
        throws com.liferay.portal.SystemException;

    public void removeByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException;

    public void removeByFileId_Transition(java.lang.String fileId,
        int transition_) throws com.liferay.portal.SystemException;

    public void removeByFileId_StateProcessIdBefore(java.lang.String fileId,
        long stateProcessIdBefore) throws com.liferay.portal.SystemException;

    public void removeByFileId_StateProcessIdAfter(java.lang.String fileId,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public void removeByProcesser(long processer)
        throws com.liferay.portal.SystemException;

    public void removeByDateProcess(java.util.Date dateProcess)
        throws com.liferay.portal.SystemException;

    public void removeByReceiver(long receiver)
        throws com.liferay.portal.SystemException;

    public void removeByReceiveDate(java.util.Date receiveDate)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessIdBefore(long stateProcessIdBefore)
        throws com.liferay.portal.SystemException;

    public void removeByStateProcessIdAfter(long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException;

    public int countByTransition(int transition_)
        throws com.liferay.portal.SystemException;

    public int countByDelegateUser(long delegateUser)
        throws com.liferay.portal.SystemException;

    public int countByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException;

    public int countByFileId_Transition(java.lang.String fileId, int transition_)
        throws com.liferay.portal.SystemException;

    public int countByFileId_StateProcessIdBefore(java.lang.String fileId,
        long stateProcessIdBefore) throws com.liferay.portal.SystemException;

    public int countByFileId_StateProcessIdAfter(java.lang.String fileId,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public int countByProcesser(long processer)
        throws com.liferay.portal.SystemException;

    public int countByDateProcess(java.util.Date dateProcess)
        throws com.liferay.portal.SystemException;

    public int countByReceiver(long receiver)
        throws com.liferay.portal.SystemException;

    public int countByReceiveDate(java.util.Date receiveDate)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessIdBefore(long stateProcessIdBefore)
        throws com.liferay.portal.SystemException;

    public int countByStateProcessIdAfter(long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
