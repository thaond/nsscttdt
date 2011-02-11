package com.sgs.portlet.document.service.persistence;

public interface PmlDocumentSendLogPersistence {
    public com.sgs.portlet.document.model.PmlDocumentSendLog create(
        long documentSendLogId);

    public com.sgs.portlet.document.model.PmlDocumentSendLog remove(
        long documentSendLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog remove(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDocumentSendLog pmlDocumentSendLog, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlDocumentSendLog update(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentSendLog the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentSendLog is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlDocumentSendLog update(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByPrimaryKey(
        long documentSendLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog fetchByPrimaryKey(
        long documentSendLogId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(
        long documentSendLogId, long processInstanceId,
        long stateProcessIdBefore, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(
        long documentSendLogId, long processInstanceId,
        long stateProcessIdAfter, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByNumDateProcess(
        int numDateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByNumDateProcess(
        int numDateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByNumDateProcess(
        int numDateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByNumDateProcess_First(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByNumDateProcess_Last(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByNumDateProcess_PrevAndNext(
        long documentSendLogId, int numDateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByExpiredDate(
        java.util.Date expiredDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByExpiredDate_First(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByExpiredDate_Last(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByExpiredDate_PrevAndNext(
        long documentSendLogId, java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Transition_First(
        long documentSendId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Transition_Last(
        long documentSendId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Transition_PrevAndNext(
        long documentSendLogId, long documentSendId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_First(
        long documentSendId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Last(
        long documentSendId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_StateProcessIdBefore_PrevAndNext(
        long documentSendLogId, long documentSendId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcesser(
        long processer) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcesser(
        long processer, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcesser(
        long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByProcesser_First(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByProcesser_Last(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByProcesser_PrevAndNext(
        long documentSendLogId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDateProcess(
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDateProcess_First(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDateProcess_Last(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDateProcess_PrevAndNext(
        long documentSendLogId, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByReceiver_PrevAndNext(
        long documentSendLogId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiveDate(
        java.util.Date receiveDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiveDate_First(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiveDate_Last(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByReceiveDate_PrevAndNext(
        long documentSendLogId, java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdBefore_First(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdBefore_Last(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByStateProcessIdBefore_PrevAndNext(
        long documentSendLogId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdAfter_First(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdAfter_Last(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByStateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId(
        long documentSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId(
        long documentSendId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId(
        long documentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_First(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Last(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_PrevAndNext(
        long documentSendLogId, long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Receiver_First(
        long documentSendId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Receiver_Last(
        long documentSendId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_StateProcessIdBefore_Receiver_PrevAndNext(
        long documentSendLogId, long documentSendId, long stateProcessIdBefore,
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Receiver_First(
        long documentSendId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Receiver_Last(
        long documentSendId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Receiver_PrevAndNext(
        long documentSendLogId, long documentSendId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_First(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_Last(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        java.util.Date receiveDate, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_StateProcessIdAfter_First(
        long documentSendId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_StateProcessIdAfter_Last(
        long documentSendId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_StateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_First(
        long documentSendId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Last(
        long documentSendId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Step_First(
        long documentSendId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Step_Last(
        long documentSendId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_Step_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findBySendDateBefore(
        java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findBySendDateBefore_First(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findBySendDateBefore_Last(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findBySendDateBefore_PrevAndNext(
        long documentSendLogId, java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentReceiveId_First(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentReceiveId_Last(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDepartmentReceiveId_PrevAndNext(
        long documentSendLogId, java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentProcessId_First(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentProcessId_Last(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDepartmentProcessId_PrevAndNext(
        long documentSendLogId, java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Step_First(
        long documentSendId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Step_Last(
        long documentSendId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Step_PrevAndNext(
        long documentSendLogId, long documentSendId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public void removeByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public void removeByNumDateProcess(int numDateProcess)
        throws com.liferay.portal.SystemException;

    public void removeByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_Transition(long documentSendId,
        int transition_) throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException;

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

    public void removeByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_Receiver(long documentSendId,
        long receiver) throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_Processor(long documentSendId,
        long processer) throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_Processor_Step(long documentSendId,
        long processer, int step) throws com.liferay.portal.SystemException;

    public void removeBySendDateBefore(java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentSendId_Step(long documentSendId, int step)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public int countByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public int countByNumDateProcess(int numDateProcess)
        throws com.liferay.portal.SystemException;

    public int countByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_Transition(long documentSendId,
        int transition_) throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_StateProcessIdBefore(long documentSendId,
        long stateProcessIdBefore) throws com.liferay.portal.SystemException;

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

    public int countByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_Receiver(long documentSendId, long receiver)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_Processor(long documentSendId,
        long processer) throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_Processor_Step(long documentSendId,
        long processer, int step) throws com.liferay.portal.SystemException;

    public int countBySendDateBefore(java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentReceiveId(java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentProcessId(java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentSendId_Step(long documentSendId, int step)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
