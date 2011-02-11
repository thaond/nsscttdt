package com.sgs.portlet.document.delegate.pmldelegate.service.persistence;

public class PmlDelegateUtil {
    private static PmlDelegatePersistence _persistence;

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate create(
        long delegateId) {
        return getPersistence().create(delegateId);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate remove(
        long delegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().remove(delegateId);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate remove(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlDelegate);
    }

    /**
     * @deprecated Use <code>update(PmlDelegate pmlDelegate, boolean merge)</code>.
     */
    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate update(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDelegate);
    }

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
    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate update(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlDelegate, merge);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate updateImpl(
        com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate pmlDelegate,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlDelegate, merge);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByPrimaryKey(
        long delegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByPrimaryKey(delegateId);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate fetchByPrimaryKey(
        long delegateId) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(delegateId);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_CancelDate_CancelDelegate(receiver,
            startDate, cancelDate, cancelDelegate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_CancelDate_CancelDelegate(receiver,
            startDate, cancelDate, cancelDelegate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_CancelDate_CancelDelegate(receiver,
            startDate, cancelDate, cancelDelegate, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceive_StartDate_CancelDate_CancelDelegate_First(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_CancelDate_CancelDelegate_First(receiver,
            startDate, cancelDate, cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceive_StartDate_CancelDate_CancelDelegate_Last(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_CancelDate_CancelDelegate_Last(receiver,
            startDate, cancelDate, cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByReceive_StartDate_CancelDate_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, java.util.Date startDate,
        java.util.Date cancelDate, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_CancelDate_CancelDelegate_PrevAndNext(delegateId,
            receiver, startDate, cancelDate, cancelDelegate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_CancelDelegate(receiver,
            startDate, endDate, cancelDelegate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_CancelDelegate(receiver,
            startDate, endDate, cancelDelegate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_CancelDelegate(receiver,
            startDate, endDate, cancelDelegate, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceive_StartDate_EndDate_CancelDelegate_First(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_CancelDelegate_First(receiver,
            startDate, endDate, cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceive_StartDate_EndDate_CancelDelegate_Last(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_CancelDelegate_Last(receiver,
            startDate, endDate, cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByReceive_StartDate_EndDate_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, java.util.Date startDate,
        java.util.Date endDate, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_CancelDelegate_PrevAndNext(delegateId,
            receiver, startDate, endDate, cancelDelegate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate(receiver, startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate(receiver, startDate,
            endDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceive_StartDate_EndDate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate(receiver, startDate,
            endDate, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceive_StartDate_EndDate_First(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_First(receiver, startDate,
            endDate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceive_StartDate_EndDate_Last(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_Last(receiver, startDate,
            endDate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByReceive_StartDate_EndDate_PrevAndNext(
        long delegateId, long receiver, java.util.Date startDate,
        java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceive_StartDate_EndDate_PrevAndNext(delegateId,
            receiver, startDate, endDate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByDateCreated(
        java.util.Date dateCreated) throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByDateCreated(
        java.util.Date dateCreated, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByDateCreated(
        java.util.Date dateCreated, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByDateCreated(dateCreated, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByDateCreated_First(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByDateCreated_First(dateCreated, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByDateCreated_Last(
        java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByDateCreated_Last(dateCreated, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByDateCreated_PrevAndNext(
        long delegateId, java.util.Date dateCreated,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByDateCreated_PrevAndNext(delegateId, dateCreated, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByCancelDelegate(
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCancelDelegate(cancelDelegate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByCancelDelegate(
        java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByCancelDelegate(cancelDelegate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByCancelDelegate(
        java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByCancelDelegate(cancelDelegate, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByCancelDelegate_First(
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByCancelDelegate_First(cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByCancelDelegate_Last(
        java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByCancelDelegate_Last(cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByCancelDelegate_PrevAndNext(
        long delegateId, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByCancelDelegate_PrevAndNext(delegateId,
            cancelDelegate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAssigner_Receiver_StartDate_EndDate(assigner,
            receiver, startDate, endDate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAssigner_Receiver_StartDate_EndDate(assigner,
            receiver, startDate, endDate, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAssigner_Receiver_StartDate_EndDate(assigner,
            receiver, startDate, endDate, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByAssigner_Receiver_StartDate_EndDate_First(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByAssigner_Receiver_StartDate_EndDate_First(assigner,
            receiver, startDate, endDate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByAssigner_Receiver_StartDate_EndDate_Last(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByAssigner_Receiver_StartDate_EndDate_Last(assigner,
            receiver, startDate, endDate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByAssigner_Receiver_StartDate_EndDate_PrevAndNext(
        long delegateId, long assigner, long receiver,
        java.util.Date startDate, java.util.Date endDate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByAssigner_Receiver_StartDate_EndDate_PrevAndNext(delegateId,
            assigner, receiver, startDate, endDate, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner(
        long assigner) throws com.liferay.portal.SystemException {
        return getPersistence().findByAssigner(assigner);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner(
        long assigner, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAssigner(assigner, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner(
        long assigner, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByAssigner(assigner, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByAssigner_First(
        long assigner, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByAssigner_First(assigner, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByAssigner_Last(
        long assigner, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByAssigner_Last(assigner, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByAssigner_PrevAndNext(
        long delegateId, long assigner,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByAssigner_PrevAndNext(delegateId, assigner, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceiver(
        long receiver) throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceiver(
        long receiver, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceiver(
        long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByReceiver(receiver, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceiver_First(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByReceiver_First(receiver, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceiver_Last(
        long receiver, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence().findByReceiver_Last(receiver, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByReceiver_PrevAndNext(
        long delegateId, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceiver_PrevAndNext(delegateId, receiver, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner_Receiver(
        long assigner, long receiver) throws com.liferay.portal.SystemException {
        return getPersistence().findByAssigner_Receiver(assigner, receiver);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner_Receiver(
        long assigner, long receiver, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAssigner_Receiver(assigner, receiver, start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByAssigner_Receiver(
        long assigner, long receiver, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByAssigner_Receiver(assigner, receiver, start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByAssigner_Receiver_First(
        long assigner, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByAssigner_Receiver_First(assigner, receiver, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByAssigner_Receiver_Last(
        long assigner, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByAssigner_Receiver_Last(assigner, receiver, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByAssigner_Receiver_PrevAndNext(
        long delegateId, long assigner, long receiver,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByAssigner_Receiver_PrevAndNext(delegateId, assigner,
            receiver, obc);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceiver_CancelDelegate(
        long receiver, java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiver_CancelDelegate(receiver, cancelDelegate);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceiver_CancelDelegate(
        long receiver, java.lang.String cancelDelegate, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiver_CancelDelegate(receiver, cancelDelegate,
            start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findByReceiver_CancelDelegate(
        long receiver, java.lang.String cancelDelegate, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .findByReceiver_CancelDelegate(receiver, cancelDelegate,
            start, end, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceiver_CancelDelegate_First(
        long receiver, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceiver_CancelDelegate_First(receiver,
            cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate findByReceiver_CancelDelegate_Last(
        long receiver, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceiver_CancelDelegate_Last(receiver,
            cancelDelegate, obc);
    }

    public static com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate[] findByReceiver_CancelDelegate_PrevAndNext(
        long delegateId, long receiver, java.lang.String cancelDelegate,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.delegate.pmldelegate.NoSuchException {
        return getPersistence()
                   .findByReceiver_CancelDelegate_PrevAndNext(delegateId,
            receiver, cancelDelegate, obc);
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

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByReceive_StartDate_CancelDate_CancelDelegate(receiver,
            startDate, cancelDate, cancelDelegate);
    }

    public static void removeByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByReceive_StartDate_EndDate_CancelDelegate(receiver,
            startDate, endDate, cancelDelegate);
    }

    public static void removeByReceive_StartDate_EndDate(long receiver,
        java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByReceive_StartDate_EndDate(receiver, startDate, endDate);
    }

    public static void removeByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByDateCreated(dateCreated);
    }

    public static void removeByCancelDelegate(java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByCancelDelegate(cancelDelegate);
    }

    public static void removeByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate) throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByAssigner_Receiver_StartDate_EndDate(assigner, receiver,
            startDate, endDate);
    }

    public static void removeByAssigner(long assigner)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAssigner(assigner);
    }

    public static void removeByReceiver(long receiver)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByReceiver(receiver);
    }

    public static void removeByAssigner_Receiver(long assigner, long receiver)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByAssigner_Receiver(assigner, receiver);
    }

    public static void removeByReceiver_CancelDelegate(long receiver,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        getPersistence()
            .removeByReceiver_CancelDelegate(receiver, cancelDelegate);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByReceive_StartDate_CancelDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date cancelDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByReceive_StartDate_CancelDate_CancelDelegate(receiver,
            startDate, cancelDate, cancelDelegate);
    }

    public static int countByReceive_StartDate_EndDate_CancelDelegate(
        long receiver, java.util.Date startDate, java.util.Date endDate,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByReceive_StartDate_EndDate_CancelDelegate(receiver,
            startDate, endDate, cancelDelegate);
    }

    public static int countByReceive_StartDate_EndDate(long receiver,
        java.util.Date startDate, java.util.Date endDate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByReceive_StartDate_EndDate(receiver, startDate,
            endDate);
    }

    public static int countByDateCreated(java.util.Date dateCreated)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByDateCreated(dateCreated);
    }

    public static int countByCancelDelegate(java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByCancelDelegate(cancelDelegate);
    }

    public static int countByAssigner_Receiver_StartDate_EndDate(
        long assigner, long receiver, java.util.Date startDate,
        java.util.Date endDate) throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByAssigner_Receiver_StartDate_EndDate(assigner,
            receiver, startDate, endDate);
    }

    public static int countByAssigner(long assigner)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAssigner(assigner);
    }

    public static int countByReceiver(long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByReceiver(receiver);
    }

    public static int countByAssigner_Receiver(long assigner, long receiver)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByAssigner_Receiver(assigner, receiver);
    }

    public static int countByReceiver_CancelDelegate(long receiver,
        java.lang.String cancelDelegate)
        throws com.liferay.portal.SystemException {
        return getPersistence()
                   .countByReceiver_CancelDelegate(receiver, cancelDelegate);
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

    public static PmlDelegatePersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlDelegatePersistence persistence) {
        _persistence = persistence;
    }
}
