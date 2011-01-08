package com.sgs.portlet.document.service.persistence;

public interface PmlDocumentReceiptLogPersistence {
    public com.sgs.portlet.document.model.PmlDocumentReceiptLog create(
        long documentReceiptLogId);

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog remove(
        long documentReceiptLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog remove(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptLog pmlDocumentReceiptLog, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlDocumentReceiptLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptLog the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptLog is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlDocumentReceiptLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByPrimaryKey(
        long documentReceiptLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog fetchByPrimaryKey(
        long documentReceiptLogId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        long stateProcessIdBefore, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        long stateProcessIdAfter, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByNumDateProcess_First(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByNumDateProcess_Last(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByNumDateProcess_PrevAndNext(
        long documentReceiptLogId, int numDateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByExpiredDate(
        java.util.Date expiredDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByExpiredDate_First(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByExpiredDate_Last(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByExpiredDate_PrevAndNext(
        long documentReceiptLogId, java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Transition_First(
        long documentReceiptId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Transition_Last(
        long documentReceiptId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Transition_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Step_First(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Step_Last(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Step_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Type_First(
        long documentReceiptId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Type_Last(
        long documentReceiptId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Type_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_First(
        long documentReceiptId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Last(
        long documentReceiptId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcesser(
        long processer) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcesser(
        long processer, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcesser(
        long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcesser_First(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcesser_Last(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcesser_PrevAndNext(
        long documentReceiptLogId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDateProcess(
        java.util.Date dateProcess) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDateProcess_First(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDateProcess_Last(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDateProcess_PrevAndNext(
        long documentReceiptLogId, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByReceiver_PrevAndNext(
        long documentReceiptLogId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiveDate(
        java.util.Date receiveDate) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiveDate_First(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiveDate_Last(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByReceiveDate_PrevAndNext(
        long documentReceiptLogId, java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdBefore_First(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdBefore_Last(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByStateProcessIdBefore_PrevAndNext(
        long documentReceiptLogId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdAfter_First(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdAfter_Last(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByStateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByType(
        int type_) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByType(
        int type_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByType(
        int type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByType_First(
        int type_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByType_Last(
        int type_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByType_PrevAndNext(
        long documentReceiptLogId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Receiver_First(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Receiver_Last(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_Receiver_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Processor_First(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Processor_Last(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_Processor_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainDepartmentProcessId_First(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainDepartmentProcessId_Last(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findBymainDepartmentProcessId_PrevAndNext(
        long documentReceiptLogId, java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainUserProcessId_First(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainUserProcessId_Last(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findBymainUserProcessId_PrevAndNext(
        long documentReceiptLogId, long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_First(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_Last(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        java.util.Date receiveDate, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_StateProcessIdAfter_First(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_StateProcessIdAfter_Last(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_StateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_First(
        long documentReceiptId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Last(
        long documentReceiptId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Step_First(
        long documentReceiptId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Step_Last(
        long documentReceiptId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_Step_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        int step, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_First(
        long documentReceiptId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_Last(
        long documentReceiptId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Receiver_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_First(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_Last(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long receiver,
        long stateProcessIdAfter, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBySendDateBefore(
        java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findBySendDateBefore_First(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findBySendDateBefore_Last(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findBySendDateBefore_PrevAndNext(
        long documentReceiptLogId, java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentReceiveId_First(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentReceiveId_Last(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDepartmentReceiveId_PrevAndNext(
        long documentReceiptLogId, java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentProcessId_First(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentProcessId_Last(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDepartmentProcessId_PrevAndNext(
        long documentReceiptLogId, java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_Type_First(
        long processInstanceId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_Type_Last(
        long processInstanceId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_Type_PrevAndNext(
        long documentReceiptLogId, long processInstanceId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_First(
        long processInstanceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_Last(
        long processInstanceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAll(
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

    public void removeByDocumentReceiptId_Transition(long documentReceiptId,
        int transition_) throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Step(long documentReceiptId, int step)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Type(long documentReceiptId, int type_)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
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

    public void removeByType(int type_)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws com.liferay.portal.SystemException;

    public void removeBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public void removeBymainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Processor(long documentReceiptId,
        long processer) throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Receiver(long documentReceiptId,
        long receiver) throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws com.liferay.portal.SystemException;

    public void removeBySendDateBefore(java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException;

    public void removeByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException;

    public void removeByProcessInstanceId_Type(long processInstanceId, int type_)
        throws com.liferay.portal.SystemException;

    public void removeByProcessInstanceId(long processInstanceId)
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

    public int countByDocumentReceiptId_Transition(long documentReceiptId,
        int transition_) throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Step(long documentReceiptId, int step)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Type(long documentReceiptId, int type_)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException;

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

    public int countByType(int type_) throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws com.liferay.portal.SystemException;

    public int countBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException;

    public int countBymainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Processor(long documentReceiptId,
        long processer) throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Processor_Step(long documentReceiptId,
        long processer, int step) throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Receiver(long documentReceiptId,
        long receiver) throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws com.liferay.portal.SystemException;

    public int countBySendDateBefore(java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentReceiveId(java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException;

    public int countByDepartmentProcessId(java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException;

    public int countByProcessInstanceId_Type(long processInstanceId, int type_)
        throws com.liferay.portal.SystemException;

    public int countByProcessInstanceId(long processInstanceId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
