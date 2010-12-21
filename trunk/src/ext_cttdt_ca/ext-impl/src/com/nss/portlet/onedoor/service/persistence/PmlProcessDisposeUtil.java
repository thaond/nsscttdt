package com.nss.portlet.onedoor.service.persistence;

public class PmlProcessDisposeUtil {
    private static PmlProcessDisposePersistence _persistence;

    public static void cacheResult(
        com.nss.portlet.onedoor.model.PmlProcessDispose pmlProcessDispose) {
        getPersistence().cacheResult(pmlProcessDispose);
    }

    public static void cacheResult(
        java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> pmlProcessDisposes) {
        getPersistence().cacheResult(pmlProcessDisposes);
    }

    public static void clearCache() {
        getPersistence().clearCache();
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose create(
        long processDisposeId) {
        return getPersistence().create(processDisposeId);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose remove(
        long processDisposeId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().remove(processDisposeId);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose remove(
        com.nss.portlet.onedoor.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlProcessDispose);
    }

    /**
     * @deprecated Use <code>update(PmlProcessDispose pmlProcessDispose, boolean merge)</code>.
     */
    public static com.nss.portlet.onedoor.model.PmlProcessDispose update(
        com.nss.portlet.onedoor.model.PmlProcessDispose pmlProcessDispose)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlProcessDispose);
    }

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
    public static com.nss.portlet.onedoor.model.PmlProcessDispose update(
        com.nss.portlet.onedoor.model.PmlProcessDispose pmlProcessDispose,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlProcessDispose, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose updateImpl(
        com.nss.portlet.onedoor.model.PmlProcessDispose pmlProcessDispose,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlProcessDispose, merge);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByPrimaryKey(
        long processDisposeId)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByPrimaryKey(processDisposeId);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose fetchByPrimaryKey(
        long processDisposeId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(processDisposeId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findBySendDate(
        java.util.Date sendDate) throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDate(sendDate);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findBySendDate(
        java.util.Date sendDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDate(sendDate, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findBySendDate(
        java.util.Date sendDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findBySendDate(sendDate, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findBySendDate_First(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findBySendDate_First(sendDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findBySendDate_Last(
        java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findBySendDate_Last(sendDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findBySendDate_PrevAndNext(
        long processDisposeId, java.util.Date sendDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findBySendDate_PrevAndNext(processDisposeId, sendDate, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByTransition(
        int transition_) throws com.liferay.portal.SystemException {
        return getPersistence().findByTransition(transition_);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByTransition(
        int transition_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTransition(transition_, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByTransition(
        int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTransition(transition_, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByTransition_First(
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByTransition_First(transition_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByTransition_Last(
        int transition_, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByTransition_Last(transition_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByTransition_PrevAndNext(
        long processDisposeId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByTransition_PrevAndNext(processDisposeId, transition_,
            obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByDelegateUser(
        long delegateUser) throws com.liferay.portal.SystemException {
        return getPersistence().findByDelegateUser(delegateUser);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByDelegateUser(
        long delegateUser, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDelegateUser(delegateUser, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByDelegateUser(
        long delegateUser, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDelegateUser(delegateUser, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByDelegateUser_First(
        long delegateUser, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByDelegateUser_First(delegateUser, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByDelegateUser_Last(
        long delegateUser, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByDelegateUser_Last(delegateUser, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByDelegateUser_PrevAndNext(
        long processDisposeId, long delegateUser,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByDelegateUser_PrevAndNext(processDisposeId,
            delegateUser, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByExpiredDate(
        java.util.Date expiredDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByExpiredDate(
        java.util.Date expiredDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByExpiredDate(
        java.util.Date expiredDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByExpiredDate(expiredDate, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByExpiredDate_First(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByExpiredDate_First(expiredDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByExpiredDate_Last(
        java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByExpiredDate_Last(expiredDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByExpiredDate_PrevAndNext(
        long processDisposeId, java.util.Date expiredDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByExpiredDate_PrevAndNext(processDisposeId,
            expiredDate, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_Transition(
        java.lang.String fileId, int transition_)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId_Transition(fileId, transition_);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_Transition(
        java.lang.String fileId, int transition_, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_Transition(fileId, transition_, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_Transition(
        java.lang.String fileId, int transition_, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_Transition(fileId, transition_, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_Transition_First(
        java.lang.String fileId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_Transition_First(fileId, transition_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_Transition_Last(
        java.lang.String fileId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_Transition_Last(fileId, transition_, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByFileId_Transition_PrevAndNext(
        long processDisposeId, java.lang.String fileId, int transition_,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_Transition_PrevAndNext(processDisposeId,
            fileId, transition_, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_StateProcessIdBefore(fileId,
            stateProcessIdBefore);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_StateProcessIdBefore(fileId,
            stateProcessIdBefore, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_StateProcessIdBefore(fileId,
            stateProcessIdBefore, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_StateProcessIdBefore_First(
        java.lang.String fileId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_StateProcessIdBefore_First(fileId,
            stateProcessIdBefore, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_StateProcessIdBefore_Last(
        java.lang.String fileId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_StateProcessIdBefore_Last(fileId,
            stateProcessIdBefore, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByFileId_StateProcessIdBefore_PrevAndNext(
        long processDisposeId, java.lang.String fileId,
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_StateProcessIdBefore_PrevAndNext(processDisposeId,
            fileId, stateProcessIdBefore, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_StateProcessIdAfter(fileId, stateProcessIdAfter);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_StateProcessIdAfter(fileId,
            stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByFileId_StateProcessIdAfter(fileId,
            stateProcessIdAfter, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_StateProcessIdAfter_First(
        java.lang.String fileId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_StateProcessIdAfter_First(fileId,
            stateProcessIdAfter, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_StateProcessIdAfter_Last(
        java.lang.String fileId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_StateProcessIdAfter_Last(fileId,
            stateProcessIdAfter, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByFileId_StateProcessIdAfter_PrevAndNext(
        long processDisposeId, java.lang.String fileId,
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_StateProcessIdAfter_PrevAndNext(processDisposeId,
            fileId, stateProcessIdAfter, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByProcesser(
        long processer) throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByProcesser(
        long processer, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByProcesser(
        long processer, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByProcesser(processer, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByProcesser_First(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByProcesser_First(processer, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByProcesser_Last(
        long processer, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByProcesser_Last(processer, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByProcesser_PrevAndNext(
        long processDisposeId, long processer,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByProcesser_PrevAndNext(processDisposeId, processer, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByDateProcess(
        java.util.Date dateProcess) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByDateProcess(
        java.util.Date dateProcess, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByDateProcess(
        java.util.Date dateProcess, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateProcess(dateProcess, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByDateProcess_First(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByDateProcess_First(dateProcess, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByDateProcess_Last(
        java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByDateProcess_Last(dateProcess, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByDateProcess_PrevAndNext(
        long processDisposeId, java.util.Date dateProcess,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByDateProcess_PrevAndNext(processDisposeId,
            dateProcess, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByReceiver_First(receiver, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByReceiver_Last(receiver, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByReceiver_PrevAndNext(
        long processDisposeId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByReceiver_PrevAndNext(processDisposeId, receiver, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByReceiveDate(
        java.util.Date receiveDate) throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByReceiveDate(
        java.util.Date receiveDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByReceiveDate(
        java.util.Date receiveDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiveDate(receiveDate, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByReceiveDate_First(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByReceiveDate_First(receiveDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByReceiveDate_Last(
        java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByReceiveDate_Last(receiveDate, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByReceiveDate_PrevAndNext(
        long processDisposeId, java.util.Date receiveDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByReceiveDate_PrevAndNext(processDisposeId,
            receiveDate, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessIdBefore(stateProcessIdBefore);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdBefore(stateProcessIdBefore, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByStateProcessIdBefore(
        long stateProcessIdBefore, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdBefore(stateProcessIdBefore, start,
            end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByStateProcessIdBefore_First(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByStateProcessIdBefore_First(stateProcessIdBefore, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByStateProcessIdBefore_Last(
        long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByStateProcessIdBefore_Last(stateProcessIdBefore, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByStateProcessIdBefore_PrevAndNext(
        long processDisposeId, long stateProcessIdBefore,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByStateProcessIdBefore_PrevAndNext(processDisposeId,
            stateProcessIdBefore, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter) throws com.liferay.portal.SystemException {
        return getPersistence().findByStateProcessIdAfter(stateProcessIdAfter);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdAfter(stateProcessIdAfter, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByStateProcessIdAfter(
        long stateProcessIdAfter, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByStateProcessIdAfter(stateProcessIdAfter, start, end,
            obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByStateProcessIdAfter_First(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByStateProcessIdAfter_First(stateProcessIdAfter, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByStateProcessIdAfter_Last(
        long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByStateProcessIdAfter_Last(stateProcessIdAfter, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByStateProcessIdAfter_PrevAndNext(
        long processDisposeId, long stateProcessIdAfter,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByStateProcessIdAfter_PrevAndNext(processDisposeId,
            stateProcessIdAfter, obc);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId(
        java.lang.String fileId) throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId(
        java.lang.String fileId, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findByFileId(
        java.lang.String fileId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByFileId(fileId, start, end, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_First(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByFileId_First(fileId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose findByFileId_Last(
        java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence().findByFileId_Last(fileId, obc);
    }

    public static com.nss.portlet.onedoor.model.PmlProcessDispose[] findByFileId_PrevAndNext(
        long processDisposeId, java.lang.String fileId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.nss.portlet.onedoor.NoSuchPmlProcessDisposeException {
        return getPersistence()
                   .findByFileId_PrevAndNext(processDisposeId, fileId, obc);
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

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.nss.portlet.onedoor.model.PmlProcessDispose> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeBySendDate(sendDate);
    }

    public static void removeByTransition(int transition_)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTransition(transition_);
    }

    public static void removeByDelegateUser(long delegateUser)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDelegateUser(delegateUser);
    }

    public static void removeByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByExpiredDate(expiredDate);
    }

    public static void removeByFileId_Transition(java.lang.String fileId,
        int transition_) throws com.liferay.portal.SystemException {
        getPersistence().removeByFileId_Transition(fileId, transition_);
    }

    public static void removeByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByFileId_StateProcessIdBefore(fileId, stateProcessIdBefore);
    }

    public static void removeByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByFileId_StateProcessIdAfter(fileId, stateProcessIdAfter);
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

    public static void removeByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByFileId(fileId);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countBySendDate(java.util.Date sendDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countBySendDate(sendDate);
    }

    public static int countByTransition(int transition_)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTransition(transition_);
    }

    public static int countByDelegateUser(long delegateUser)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDelegateUser(delegateUser);
    }

    public static int countByExpiredDate(java.util.Date expiredDate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByExpiredDate(expiredDate);
    }

    public static int countByFileId_Transition(java.lang.String fileId,
        int transition_) throws com.liferay.portal.SystemException {
        return getPersistence().countByFileId_Transition(fileId, transition_);
    }

    public static int countByFileId_StateProcessIdBefore(
        java.lang.String fileId, long stateProcessIdBefore)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileId_StateProcessIdBefore(fileId,
            stateProcessIdBefore);
    }

    public static int countByFileId_StateProcessIdAfter(
        java.lang.String fileId, long stateProcessIdAfter)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByFileId_StateProcessIdAfter(fileId,
            stateProcessIdAfter);
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

    public static int countByFileId(java.lang.String fileId)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByFileId(fileId);
    }

    public static int countAll() throws com.liferay.portal.SystemException {
        return getPersistence().countAll();
    }

    public static PmlProcessDisposePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlProcessDisposePersistence persistence) {
        _persistence = persistence;
    }
}
