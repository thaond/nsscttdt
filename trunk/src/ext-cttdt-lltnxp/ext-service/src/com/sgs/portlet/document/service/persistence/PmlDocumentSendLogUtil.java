package com.sgs.portlet.document.service.persistence;

public class PmlDocumentSendLogUtil {
    private static PmlDocumentSendLogPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlDocumentSendLog create(
        long documentSendLogId) {
        return getPersistence().create(documentSendLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog remove(
        long documentSendLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().remove(documentSendLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog remove(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDocumentSendLog);
    }

    /**
     * @deprecated Use <code>update(PmlDocumentSendLog pmlDocumentSendLog, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlDocumentSendLog update(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentSendLog);
    }

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
    public static com.sgs.portlet.document.model.PmlDocumentSendLog update(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentSendLog, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentSendLog pmlDocumentSendLog,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDocumentSendLog, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByPrimaryKey(
        long documentSendLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByPrimaryKey(documentSendLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog fetchByPrimaryKey(
        long documentSendLogId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentSendLogId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(processInstanceId,
            stateProcessIdBefore, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(processInstanceId,
            stateProcessIdBefore, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(
        long documentSendLogId, long processInstanceId,
        long stateProcessIdBefore, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(documentSendLogId,
            processInstanceId, stateProcessIdBefore, dateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(processInstanceId,
            stateProcessIdAfter, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(processInstanceId,
            stateProcessIdAfter, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(
        long documentSendLogId, long processInstanceId,
        long stateProcessIdAfter, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(documentSendLogId,
            processInstanceId, stateProcessIdAfter, dateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByNumDateProcess(
        int numDateProcess) throws com.liferay.portal.SystemException {
        return getPersistence().findByNumDateProcess(numDateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByNumDateProcess(
        int numDateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumDateProcess(numDateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByNumDateProcess(
        int numDateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumDateProcess(numDateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByNumDateProcess_First(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByNumDateProcess_First(numDateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByNumDateProcess_Last(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByNumDateProcess_Last(numDateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByNumDateProcess_PrevAndNext(
        long documentSendLogId, int numDateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByNumDateProcess_PrevAndNext(documentSendLogId,
            numDateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByExpiredDate(
        java.util.Date expiredDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByExpiredDate_First(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByExpiredDate_First(expiredDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByExpiredDate_Last(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByExpiredDate_Last(expiredDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByExpiredDate_PrevAndNext(
        long documentSendLogId, java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByExpiredDate_PrevAndNext(documentSendLogId,
            expiredDate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Transition(documentSendId, transition_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Transition(documentSendId,
            transition_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Transition(
        long documentSendId, int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Transition(documentSendId,
            transition_, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Transition_First(
        long documentSendId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Transition_First(documentSendId,
            transition_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Transition_Last(
        long documentSendId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Transition_Last(documentSendId,
            transition_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Transition_PrevAndNext(
        long documentSendLogId, long documentSendId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Transition_PrevAndNext(documentSendLogId,
            documentSendId, transition_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore(documentSendId,
            stateProcessIdBefore);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore(documentSendId,
            stateProcessIdBefore, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore(documentSendId,
            stateProcessIdBefore, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_First(
        long documentSendId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_First(documentSendId,
            stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Last(
        long documentSendId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_Last(documentSendId,
            stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_StateProcessIdBefore_PrevAndNext(
        long documentSendLogId, long documentSendId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_PrevAndNext(documentSendLogId,
            documentSendId, stateProcessIdBefore, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcesser(
        long processer) throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcesser(
        long processer, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByProcesser(
        long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByProcesser_First(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByProcesser_First(processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByProcesser_Last(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByProcesser_Last(processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByProcesser_PrevAndNext(
        long documentSendLogId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByProcesser_PrevAndNext(documentSendLogId, processer,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDateProcess(
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDateProcess_First(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByDateProcess_First(dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDateProcess_Last(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByDateProcess_Last(dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDateProcess_PrevAndNext(
        long documentSendLogId, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDateProcess_PrevAndNext(documentSendLogId,
            dateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByReceiver_First(receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByReceiver_Last(receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByReceiver_PrevAndNext(
        long documentSendLogId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByReceiver_PrevAndNext(documentSendLogId, receiver, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiveDate(
        java.util.Date receiveDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiveDate_First(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByReceiveDate_First(receiveDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByReceiveDate_Last(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByReceiveDate_Last(receiveDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByReceiveDate_PrevAndNext(
        long documentSendLogId, java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByReceiveDate_PrevAndNext(documentSendLogId,
            receiveDate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessIdBefore(stateProcessIdBefore);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdBefore(stateProcessIdBefore, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdBefore(stateProcessIdBefore, start,
            end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdBefore_First(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByStateProcessIdBefore_First(stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdBefore_Last(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByStateProcessIdBefore_Last(stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByStateProcessIdBefore_PrevAndNext(
        long documentSendLogId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByStateProcessIdBefore_PrevAndNext(documentSendLogId,
            stateProcessIdBefore, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessIdAfter(stateProcessIdAfter);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdAfter(stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdAfter(stateProcessIdAfter, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdAfter_First(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByStateProcessIdAfter_First(stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByStateProcessIdAfter_Last(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByStateProcessIdAfter_Last(stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByStateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByStateProcessIdAfter_PrevAndNext(documentSendLogId,
            stateProcessIdAfter, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId(
        long documentSendId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendId(documentSendId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId(
        long documentSendId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendId(documentSendId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId(
        long documentSendId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId(documentSendId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_First(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByDocumentSendId_First(documentSendId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Last(
        long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findByDocumentSendId_Last(documentSendId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_PrevAndNext(
        long documentSendLogId, long documentSendId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_PrevAndNext(documentSendLogId,
            documentSendId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
            stateProcessIdBefore, receiver);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
            stateProcessIdBefore, receiver, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
            stateProcessIdBefore, receiver, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Receiver_First(
        long documentSendId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_Receiver_First(documentSendId,
            stateProcessIdBefore, receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_StateProcessIdBefore_Receiver_Last(
        long documentSendId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_Receiver_Last(documentSendId,
            stateProcessIdBefore, receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_StateProcessIdBefore_Receiver_PrevAndNext(
        long documentSendLogId, long documentSendId, long stateProcessIdBefore,
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_StateProcessIdBefore_Receiver_PrevAndNext(documentSendLogId,
            documentSendId, stateProcessIdBefore, receiver, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Receiver(documentSendId, receiver);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Receiver(documentSendId, receiver,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Receiver(
        long documentSendId, long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Receiver(documentSendId, receiver,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Receiver_First(
        long documentSendId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Receiver_First(documentSendId,
            receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Receiver_Last(
        long documentSendId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Receiver_Last(documentSendId,
            receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Receiver_PrevAndNext(
        long documentSendLogId, long documentSendId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Receiver_PrevAndNext(documentSendLogId,
            documentSendId, receiver, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
            processer, receiveDate, stateProcessIdAfter);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
            processer, receiveDate, stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
            processer, receiveDate, stateProcessIdAfter, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_First(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_First(documentSendId,
            processer, receiveDate, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_Last(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_Last(documentSendId,
            processer, receiveDate, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        java.util.Date receiveDate, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(documentSendLogId,
            documentSendId, processer, receiveDate, stateProcessIdAfter, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
            processer, stateProcessIdAfter);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
            processer, stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
            processer, stateProcessIdAfter, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_StateProcessIdAfter_First(
        long documentSendId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_StateProcessIdAfter_First(documentSendId,
            processer, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_StateProcessIdAfter_Last(
        long documentSendId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_StateProcessIdAfter_Last(documentSendId,
            processer, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_StateProcessIdAfter_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_StateProcessIdAfter_PrevAndNext(documentSendLogId,
            documentSendId, processer, stateProcessIdAfter, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor(documentSendId, processer);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor(documentSendId, processer,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor(
        long documentSendId, long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor(documentSendId, processer,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_First(
        long documentSendId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_First(documentSendId,
            processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Last(
        long documentSendId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Last(documentSendId,
            processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_PrevAndNext(documentSendLogId,
            documentSendId, processer, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Step(documentSendId,
            processer, step);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Step(documentSendId,
            processer, step, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Step(documentSendId,
            processer, step, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Step_First(
        long documentSendId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Step_First(documentSendId,
            processer, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Processor_Step_Last(
        long documentSendId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Step_Last(documentSendId,
            processer, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Processor_Step_PrevAndNext(
        long documentSendLogId, long documentSendId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Processor_Step_PrevAndNext(documentSendLogId,
            documentSendId, processer, step, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findBySendDateBefore(
        java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDateBefore(sendDateBefore);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDateBefore(sendDateBefore, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySendDateBefore(sendDateBefore, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findBySendDateBefore_First(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findBySendDateBefore_First(sendDateBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findBySendDateBefore_Last(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence().findBySendDateBefore_Last(sendDateBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findBySendDateBefore_PrevAndNext(
        long documentSendLogId, java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findBySendDateBefore_PrevAndNext(documentSendLogId,
            sendDateBefore, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentReceiveId(departmentReceiveId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentReceiveId(departmentReceiveId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentReceiveId(departmentReceiveId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentReceiveId_First(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDepartmentReceiveId_First(departmentReceiveId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentReceiveId_Last(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDepartmentReceiveId_Last(departmentReceiveId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDepartmentReceiveId_PrevAndNext(
        long documentSendLogId, java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDepartmentReceiveId_PrevAndNext(documentSendLogId,
            departmentReceiveId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentProcessId(departmentProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentProcessId(departmentProcessId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentProcessId(departmentProcessId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentProcessId_First(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDepartmentProcessId_First(departmentProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDepartmentProcessId_Last(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDepartmentProcessId_Last(departmentProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDepartmentProcessId_PrevAndNext(
        long documentSendLogId, java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDepartmentProcessId_PrevAndNext(documentSendLogId,
            departmentProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentSendId_Step(documentSendId, step);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Step(documentSendId, step, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findByDocumentSendId_Step(
        long documentSendId, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentSendId_Step(documentSendId, step, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Step_First(
        long documentSendId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Step_First(documentSendId, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog findByDocumentSendId_Step_Last(
        long documentSendId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Step_Last(documentSendId, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentSendLog[] findByDocumentSendId_Step_PrevAndNext(
        long documentSendLogId, long documentSendId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendLogException {
        return getPersistence()
                   .findByDocumentSendId_Step_PrevAndNext(documentSendLogId,
            documentSendId, step, obc);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentSendLog> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess);
    }

    public static void removeByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess);
    }

    public static void removeByNumDateProcess(int numDateProcess)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByNumDateProcess(numDateProcess);
    }

    public static void removeByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByExpiredDate(expiredDate);
    }

    public static void removeByDocumentSendId_Transition(long documentSendId,
        int transition_) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_Transition(documentSendId, transition_);
    }

    public static void removeByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_StateProcessIdBefore(documentSendId,
            stateProcessIdBefore);
    }

    public static void removeByProcesser(long processer)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByProcesser(processer);
    }

    public static void removeByDateProcess(java.util.Date dateProcess)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateProcess(dateProcess);
    }

    public static void removeByReceiver(long receiver)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByReceiver(receiver);
    }

    public static void removeByReceiveDate(java.util.Date receiveDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByReceiveDate(receiveDate);
    }

    public static void removeByStateProcessIdBefore(long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessIdBefore(stateProcessIdBefore);
    }

    public static void removeByStateProcessIdAfter(long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByStateProcessIdAfter(stateProcessIdAfter);
    }

    public static void removeByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentSendId(documentSendId);
    }

    public static void removeByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
            stateProcessIdBefore, receiver);
    }

    public static void removeByDocumentSendId_Receiver(long documentSendId,
        long receiver) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_Receiver(documentSendId, receiver);
    }

    public static void removeByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
            processer, receiveDate, stateProcessIdAfter);
    }

    public static void removeByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
            processer, stateProcessIdAfter);
    }

    public static void removeByDocumentSendId_Processor(long documentSendId,
        long processer) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_Processor(documentSendId, processer);
    }

    public static void removeByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentSendId_Processor_Step(documentSendId, processer,
            step);
    }

    public static void removeBySendDateBefore(java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySendDateBefore(sendDateBefore);
    }

    public static void removeByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentReceiveId(departmentReceiveId);
    }

    public static void removeByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDepartmentProcessId(departmentProcessId);
    }

    public static void removeByDocumentSendId_Step(long documentSendId, int step)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentSendId_Step(documentSendId, step);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess);
    }

    public static int countByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess);
    }

    public static int countByNumDateProcess(int numDateProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByNumDateProcess(numDateProcess);
    }

    public static int countByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByExpiredDate(expiredDate);
    }

    public static int countByDocumentSendId_Transition(long documentSendId,
        int transition_) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_Transition(documentSendId, transition_);
    }

    public static int countByDocumentSendId_StateProcessIdBefore(
        long documentSendId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_StateProcessIdBefore(documentSendId,
            stateProcessIdBefore);
    }

    public static int countByProcesser(long processer)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByProcesser(processer);
    }

    public static int countByDateProcess(java.util.Date dateProcess)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateProcess(dateProcess);
    }

    public static int countByReceiver(long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByReceiver(receiver);
    }

    public static int countByReceiveDate(java.util.Date receiveDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByReceiveDate(receiveDate);
    }

    public static int countByStateProcessIdBefore(long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessIdBefore(stateProcessIdBefore);
    }

    public static int countByStateProcessIdAfter(long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByStateProcessIdAfter(stateProcessIdAfter);
    }

    public static int countByDocumentSendId(long documentSendId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentSendId(documentSendId);
    }

    public static int countByDocumentSendId_StateProcessIdBefore_Receiver(
        long documentSendId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_StateProcessIdBefore_Receiver(documentSendId,
            stateProcessIdBefore, receiver);
    }

    public static int countByDocumentSendId_Receiver(long documentSendId,
        long receiver) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_Receiver(documentSendId, receiver);
    }

    public static int countByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(
        long documentSendId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_Processor_Receivedate_StateProcessIdAfter(documentSendId,
            processer, receiveDate, stateProcessIdAfter);
    }

    public static int countByDocumentSendId_Processor_StateProcessIdAfter(
        long documentSendId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_Processor_StateProcessIdAfter(documentSendId,
            processer, stateProcessIdAfter);
    }

    public static int countByDocumentSendId_Processor(long documentSendId,
        long processer) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_Processor(documentSendId, processer);
    }

    public static int countByDocumentSendId_Processor_Step(
        long documentSendId, long processer, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentSendId_Processor_Step(documentSendId,
            processer, step);
    }

    public static int countBySendDateBefore(java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySendDateBefore(sendDateBefore);
    }

    public static int countByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentReceiveId(departmentReceiveId);
    }

    public static int countByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDepartmentProcessId(departmentProcessId);
    }

    public static int countByDocumentSendId_Step(long documentSendId, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentSendId_Step(documentSendId, step);
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

    public static PmlDocumentSendLogPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDocumentSendLogPersistence persistence) {
        _persistence = persistence;
    }
}
