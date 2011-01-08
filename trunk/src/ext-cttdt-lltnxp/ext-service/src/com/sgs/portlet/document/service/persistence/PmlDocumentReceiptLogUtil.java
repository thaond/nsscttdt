package com.sgs.portlet.document.service.persistence;

public class PmlDocumentReceiptLogUtil {
    private static PmlDocumentReceiptLogPersistence _persistence;

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog create(
        long documentReceiptLogId) {
        return getPersistence().create(documentReceiptLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog remove(
        long documentReceiptLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().remove(documentReceiptLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog remove(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDocumentReceiptLog);
    }

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptLog pmlDocumentReceiptLog, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentReceiptLog);
    }

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
    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDocumentReceiptLog, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptLog pmlDocumentReceiptLog,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDocumentReceiptLog, merge);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByPrimaryKey(
        long documentReceiptLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByPrimaryKey(documentReceiptLogId);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog fetchByPrimaryKey(
        long documentReceiptLogId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(documentReceiptLogId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdBefore_DateProcess(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess(processInstanceId,
            stateProcessIdBefore, dateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess_First(processInstanceId,
            stateProcessIdBefore, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(
        long processInstanceId, long stateProcessIdBefore,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess_Last(processInstanceId,
            stateProcessIdBefore, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        long stateProcessIdBefore, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdBefore_DateProcess_PrevAndNext(documentReceiptLogId,
            processInstanceId, stateProcessIdBefore, dateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_StateProcessIdAfter_DateProcess(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess(processInstanceId,
            stateProcessIdAfter, dateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess_First(processInstanceId,
            stateProcessIdAfter, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(
        long processInstanceId, long stateProcessIdAfter,
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess_Last(processInstanceId,
            stateProcessIdAfter, dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        long stateProcessIdAfter, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_StateProcessIdAfter_DateProcess_PrevAndNext(documentReceiptLogId,
            processInstanceId, stateProcessIdAfter, dateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess) throws com.liferay.portal.SystemException {
        return getPersistence().findByNumDateProcess(numDateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByNumDateProcess(numDateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByNumDateProcess(
        int numDateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByNumDateProcess(numDateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByNumDateProcess_First(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByNumDateProcess_First(numDateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByNumDateProcess_Last(
        int numDateProcess, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByNumDateProcess_Last(numDateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByNumDateProcess_PrevAndNext(
        long documentReceiptLogId, int numDateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByNumDateProcess_PrevAndNext(documentReceiptLogId,
            numDateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByExpiredDate(
        java.util.Date expiredDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByExpiredDate(
        java.util.Date expiredDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByExpiredDate_First(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByExpiredDate_First(expiredDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByExpiredDate_Last(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByExpiredDate_Last(expiredDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByExpiredDate_PrevAndNext(
        long documentReceiptLogId, java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByExpiredDate_PrevAndNext(documentReceiptLogId,
            expiredDate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Transition(documentReceiptId,
            transition_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Transition(documentReceiptId,
            transition_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Transition(documentReceiptId,
            transition_, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Transition_First(
        long documentReceiptId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Transition_First(documentReceiptId,
            transition_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Transition_Last(
        long documentReceiptId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Transition_Last(documentReceiptId,
            transition_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Transition_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Transition_PrevAndNext(documentReceiptLogId,
            documentReceiptId, transition_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Step(documentReceiptId, step);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Step(documentReceiptId, step,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Step(
        long documentReceiptId, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Step(documentReceiptId, step,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Step_First(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Step_First(documentReceiptId, step,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Step_Last(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Step_Last(documentReceiptId, step,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Step_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Step_PrevAndNext(documentReceiptLogId,
            documentReceiptId, step, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Type(documentReceiptId, type_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Type(documentReceiptId, type_,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Type(
        long documentReceiptId, int type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Type(documentReceiptId, type_,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Type_First(
        long documentReceiptId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Type_First(documentReceiptId,
            type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Type_Last(
        long documentReceiptId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Type_Last(documentReceiptId, type_,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Type_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Type_PrevAndNext(documentReceiptLogId,
            documentReceiptId, type_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
            stateProcessIdBefore);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
            stateProcessIdBefore, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
            stateProcessIdBefore, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_First(
        long documentReceiptId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_First(documentReceiptId,
            stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Last(
        long documentReceiptId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Last(documentReceiptId,
            stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_PrevAndNext(documentReceiptLogId,
            documentReceiptId, stateProcessIdBefore, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcesser(
        long processer) throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcesser(
        long processer, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcesser(
        long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcesser_First(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByProcesser_First(processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcesser_Last(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByProcesser_Last(processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcesser_PrevAndNext(
        long documentReceiptLogId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcesser_PrevAndNext(documentReceiptLogId,
            processer, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDateProcess(
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDateProcess(
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDateProcess_First(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByDateProcess_First(dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDateProcess_Last(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByDateProcess_Last(dateProcess, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDateProcess_PrevAndNext(
        long documentReceiptLogId, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDateProcess_PrevAndNext(documentReceiptLogId,
            dateProcess, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByReceiver_First(receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByReceiver_Last(receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByReceiver_PrevAndNext(
        long documentReceiptLogId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByReceiver_PrevAndNext(documentReceiptLogId, receiver,
            obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiveDate(
        java.util.Date receiveDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByReceiveDate(
        java.util.Date receiveDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiveDate_First(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByReceiveDate_First(receiveDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByReceiveDate_Last(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByReceiveDate_Last(receiveDate, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByReceiveDate_PrevAndNext(
        long documentReceiptLogId, java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByReceiveDate_PrevAndNext(documentReceiptLogId,
            receiveDate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessIdBefore(stateProcessIdBefore);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdBefore(stateProcessIdBefore, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdBefore(stateProcessIdBefore, start,
            end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdBefore_First(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByStateProcessIdBefore_First(stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdBefore_Last(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByStateProcessIdBefore_Last(stateProcessIdBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByStateProcessIdBefore_PrevAndNext(
        long documentReceiptLogId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByStateProcessIdBefore_PrevAndNext(documentReceiptLogId,
            stateProcessIdBefore, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessIdAfter(stateProcessIdAfter);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdAfter(stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdAfter(stateProcessIdAfter, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdAfter_First(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByStateProcessIdAfter_First(stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByStateProcessIdAfter_Last(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByStateProcessIdAfter_Last(stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByStateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByStateProcessIdAfter_PrevAndNext(documentReceiptLogId,
            stateProcessIdAfter, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByType(
        int type_) throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByType(
        int type_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByType(
        int type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByType(type_, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByType_First(
        int type_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByType_First(type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByType_Last(
        int type_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findByType_Last(type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByType_PrevAndNext(
        long documentReceiptLogId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByType_PrevAndNext(documentReceiptLogId, type_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException {
        return getPersistence().findByDocumentReceiptId(documentReceiptId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId(documentReceiptId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_First(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Last(documentReceiptId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_PrevAndNext(documentReceiptLogId,
            documentReceiptId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
            stateProcessIdBefore, receiver);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
            stateProcessIdBefore, receiver, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
            stateProcessIdBefore, receiver, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Receiver_First(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Receiver_First(documentReceiptId,
            stateProcessIdBefore, receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Receiver_Last(
        long documentReceiptId, long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Receiver_Last(documentReceiptId,
            stateProcessIdBefore, receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_Receiver_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Receiver_PrevAndNext(documentReceiptLogId,
            documentReceiptId, stateProcessIdBefore, receiver, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
            stateProcessIdBefore, processer);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
            stateProcessIdBefore, processer, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
            stateProcessIdBefore, processer, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Processor_First(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Processor_First(documentReceiptId,
            stateProcessIdBefore, processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_StateProcessIdBefore_Processor_Last(
        long documentReceiptId, long stateProcessIdBefore, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Processor_Last(documentReceiptId,
            stateProcessIdBefore, processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_StateProcessIdBefore_Processor_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId,
        long stateProcessIdBefore, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_StateProcessIdBefore_Processor_PrevAndNext(documentReceiptLogId,
            documentReceiptId, stateProcessIdBefore, processer, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymainDepartmentProcessId(mainDepartmentProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymainDepartmentProcessId(mainDepartmentProcessId,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymainDepartmentProcessId(mainDepartmentProcessId,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainDepartmentProcessId_First(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findBymainDepartmentProcessId_First(mainDepartmentProcessId,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainDepartmentProcessId_Last(
        java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findBymainDepartmentProcessId_Last(mainDepartmentProcessId,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findBymainDepartmentProcessId_PrevAndNext(
        long documentReceiptLogId, java.lang.String mainDepartmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findBymainDepartmentProcessId_PrevAndNext(documentReceiptLogId,
            mainDepartmentProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId) throws com.liferay.portal.SystemException {
        return getPersistence().findBymainUserProcessId(mainUserProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymainUserProcessId(mainUserProcessId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBymainUserProcessId(
        long mainUserProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBymainUserProcessId(mainUserProcessId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainUserProcessId_First(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findBymainUserProcessId_First(mainUserProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findBymainUserProcessId_Last(
        long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findBymainUserProcessId_Last(mainUserProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findBymainUserProcessId_PrevAndNext(
        long documentReceiptLogId, long mainUserProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findBymainUserProcessId_PrevAndNext(documentReceiptLogId,
            mainUserProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_First(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_First(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_Last(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_Last(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        java.util.Date receiveDate, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter_PrevAndNext(documentReceiptLogId,
            documentReceiptId, processer, receiveDate, stateProcessIdAfter, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
            processer, stateProcessIdAfter);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
            processer, stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
            processer, stateProcessIdAfter, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_StateProcessIdAfter_First(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_StateProcessIdAfter_First(documentReceiptId,
            processer, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_StateProcessIdAfter_Last(
        long documentReceiptId, long processer, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_StateProcessIdAfter_Last(documentReceiptId,
            processer, stateProcessIdAfter, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_StateProcessIdAfter_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_StateProcessIdAfter_PrevAndNext(documentReceiptLogId,
            documentReceiptId, processer, stateProcessIdAfter, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor(documentReceiptId,
            processer);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor(documentReceiptId,
            processer, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor(
        long documentReceiptId, long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor(documentReceiptId,
            processer, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_First(
        long documentReceiptId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_First(documentReceiptId,
            processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Last(
        long documentReceiptId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Last(documentReceiptId,
            processer, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_PrevAndNext(documentReceiptLogId,
            documentReceiptId, processer, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Step(documentReceiptId,
            processer, step);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Step(documentReceiptId,
            processer, step, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Step(documentReceiptId,
            processer, step, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Step_First(
        long documentReceiptId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Step_First(documentReceiptId,
            processer, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Processor_Step_Last(
        long documentReceiptId, long processer, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Step_Last(documentReceiptId,
            processer, step, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Processor_Step_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long processer,
        int step, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Processor_Step_PrevAndNext(documentReceiptLogId,
            documentReceiptId, processer, step, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver(documentReceiptId, receiver);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver(documentReceiptId,
            receiver, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver(documentReceiptId,
            receiver, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_First(
        long documentReceiptId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_First(documentReceiptId,
            receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_Last(
        long documentReceiptId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_Last(documentReceiptId,
            receiver, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Receiver_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_PrevAndNext(documentReceiptLogId,
            documentReceiptId, receiver, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
            receiver, stateProcessIdAfter, transition_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
            receiver, stateProcessIdAfter, transition_, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
            receiver, stateProcessIdAfter, transition_, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_First(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_First(documentReceiptId,
            receiver, stateProcessIdAfter, transition_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_Last(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_Last(documentReceiptId,
            receiver, stateProcessIdAfter, transition_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_PrevAndNext(
        long documentReceiptLogId, long documentReceiptId, long receiver,
        long stateProcessIdAfter, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition_PrevAndNext(documentReceiptLogId,
            documentReceiptId, receiver, stateProcessIdAfter, transition_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBySendDateBefore(
        java.util.Date sendDateBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDateBefore(sendDateBefore);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDateBefore(sendDateBefore, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findBySendDateBefore(
        java.util.Date sendDateBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findBySendDateBefore(sendDateBefore, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findBySendDateBefore_First(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findBySendDateBefore_First(sendDateBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findBySendDateBefore_Last(
        java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence().findBySendDateBefore_Last(sendDateBefore, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findBySendDateBefore_PrevAndNext(
        long documentReceiptLogId, java.util.Date sendDateBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findBySendDateBefore_PrevAndNext(documentReceiptLogId,
            sendDateBefore, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentReceiveId(departmentReceiveId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentReceiveId(departmentReceiveId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentReceiveId(
        java.lang.String departmentReceiveId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentReceiveId(departmentReceiveId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentReceiveId_First(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDepartmentReceiveId_First(departmentReceiveId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentReceiveId_Last(
        java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDepartmentReceiveId_Last(departmentReceiveId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDepartmentReceiveId_PrevAndNext(
        long documentReceiptLogId, java.lang.String departmentReceiveId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDepartmentReceiveId_PrevAndNext(documentReceiptLogId,
            departmentReceiveId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDepartmentProcessId(departmentProcessId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentProcessId(departmentProcessId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByDepartmentProcessId(
        java.lang.String departmentProcessId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByDepartmentProcessId(departmentProcessId, start, end,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentProcessId_First(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDepartmentProcessId_First(departmentProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByDepartmentProcessId_Last(
        java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDepartmentProcessId_Last(departmentProcessId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByDepartmentProcessId_PrevAndNext(
        long documentReceiptLogId, java.lang.String departmentProcessId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByDepartmentProcessId_PrevAndNext(documentReceiptLogId,
            departmentProcessId, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_Type(processInstanceId, type_);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_Type(processInstanceId, type_,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId_Type(
        long processInstanceId, int type_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId_Type(processInstanceId, type_,
            start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_Type_First(
        long processInstanceId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_Type_First(processInstanceId,
            type_, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_Type_Last(
        long processInstanceId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_Type_Last(processInstanceId, type_,
            obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_Type_PrevAndNext(
        long documentReceiptLogId, long processInstanceId, int type_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_Type_PrevAndNext(documentReceiptLogId,
            processInstanceId, type_, obc);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId) throws com.liferay.portal.SystemException {
        return getPersistence().findByProcessInstanceId(processInstanceId);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId(processInstanceId, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findByProcessInstanceId(
        long processInstanceId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByProcessInstanceId(processInstanceId, start, end, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_First(
        long processInstanceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_First(processInstanceId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog findByProcessInstanceId_Last(
        long processInstanceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_Last(processInstanceId, obc);
    }

    public static com.sgs.portlet.document.model.PmlDocumentReceiptLog[] findByProcessInstanceId_PrevAndNext(
        long documentReceiptLogId, long processInstanceId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptLogException {
        return getPersistence()
                   .findByProcessInstanceId_PrevAndNext(documentReceiptLogId,
            processInstanceId, obc);
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

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptLog> findAll(
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

    public static void removeByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_Transition(documentReceiptId, transition_);
    }

    public static void removeByDocumentReceiptId_Step(long documentReceiptId,
        int step) throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReceiptId_Step(documentReceiptId, step);
    }

    public static void removeByDocumentReceiptId_Type(long documentReceiptId,
        int type_) throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReceiptId_Type(documentReceiptId, type_);
    }

    public static void removeByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
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

    public static void removeByType(int type_)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByType(type_);
    }

    public static void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDocumentReceiptId(documentReceiptId);
    }

    public static void removeByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
            stateProcessIdBefore, receiver);
    }

    public static void removeByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
            stateProcessIdBefore, processer);
    }

    public static void removeBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBymainDepartmentProcessId(mainDepartmentProcessId);
    }

    public static void removeBymainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBymainUserProcessId(mainUserProcessId);
    }

    public static void removeByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter);
    }

    public static void removeByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
            processer, stateProcessIdAfter);
    }

    public static void removeByDocumentReceiptId_Processor(
        long documentReceiptId, long processer)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_Processor(documentReceiptId, processer);
    }

    public static void removeByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_Processor_Step(documentReceiptId,
            processer, step);
    }

    public static void removeByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_Receiver(documentReceiptId, receiver);
    }

    public static void removeByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
            receiver, stateProcessIdAfter, transition_);
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

    public static void removeByProcessInstanceId_Type(long processInstanceId,
        int type_) throws com.liferay.portal.SystemException {
        getPersistence().removeByProcessInstanceId_Type(processInstanceId, type_);
    }

    public static void removeByProcessInstanceId(long processInstanceId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByProcessInstanceId(processInstanceId);
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

    public static int countByDocumentReceiptId_Transition(
        long documentReceiptId, int transition_)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Transition(documentReceiptId,
            transition_);
    }

    public static int countByDocumentReceiptId_Step(long documentReceiptId,
        int step) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Step(documentReceiptId, step);
    }

    public static int countByDocumentReceiptId_Type(long documentReceiptId,
        int type_) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Type(documentReceiptId, type_);
    }

    public static int countByDocumentReceiptId_StateProcessIdBefore(
        long documentReceiptId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_StateProcessIdBefore(documentReceiptId,
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

    public static int countByType(int type_)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByType(type_);
    }

    public static int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDocumentReceiptId(documentReceiptId);
    }

    public static int countByDocumentReceiptId_StateProcessIdBefore_Receiver(
        long documentReceiptId, long stateProcessIdBefore, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_StateProcessIdBefore_Receiver(documentReceiptId,
            stateProcessIdBefore, receiver);
    }

    public static int countByDocumentReceiptId_StateProcessIdBefore_Processor(
        long documentReceiptId, long stateProcessIdBefore, long processer)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_StateProcessIdBefore_Processor(documentReceiptId,
            stateProcessIdBefore, processer);
    }

    public static int countBymainDepartmentProcessId(
        java.lang.String mainDepartmentProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countBymainDepartmentProcessId(mainDepartmentProcessId);
    }

    public static int countBymainUserProcessId(long mainUserProcessId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBymainUserProcessId(mainUserProcessId);
    }

    public static int countByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(
        long documentReceiptId, long processer, java.util.Date receiveDate,
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Processor_Receivedate_StateProcessIdAfter(documentReceiptId,
            processer, receiveDate, stateProcessIdAfter);
    }

    public static int countByDocumentReceiptId_Processor_StateProcessIdAfter(
        long documentReceiptId, long processer, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Processor_StateProcessIdAfter(documentReceiptId,
            processer, stateProcessIdAfter);
    }

    public static int countByDocumentReceiptId_Processor(
        long documentReceiptId, long processer)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Processor(documentReceiptId,
            processer);
    }

    public static int countByDocumentReceiptId_Processor_Step(
        long documentReceiptId, long processer, int step)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Processor_Step(documentReceiptId,
            processer, step);
    }

    public static int countByDocumentReceiptId_Receiver(
        long documentReceiptId, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Receiver(documentReceiptId,
            receiver);
    }

    public static int countByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(
        long documentReceiptId, long receiver, long stateProcessIdAfter,
        int transition_) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByDocumentReceiptId_Receiver_StateProcessIdAfter_Transition(documentReceiptId,
            receiver, stateProcessIdAfter, transition_);
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

    public static int countByProcessInstanceId_Type(long processInstanceId,
        int type_) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByProcessInstanceId_Type(processInstanceId, type_);
    }

    public static int countByProcessInstanceId(long processInstanceId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByProcessInstanceId(processInstanceId);
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

    public static PmlDocumentReceiptLogPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDocumentReceiptLogPersistence persistence) {
        _persistence = persistence;
    }
}
