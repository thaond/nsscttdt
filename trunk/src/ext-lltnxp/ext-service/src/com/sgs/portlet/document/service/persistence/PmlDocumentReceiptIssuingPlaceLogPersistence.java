package com.sgs.portlet.document.service.persistence;

public interface PmlDocumentReceiptIssuingPlaceLogPersistence {
    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog create(
        long documentReceiptIssuingPlaceLogId);

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog remove(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog remove(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptIssuingPlaceLog the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptIssuingPlaceLog is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog update(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog pmlDocumentReceiptIssuingPlaceLog,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByPrimaryKey(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog fetchByPrimaryKey(
        long documentReceiptIssuingPlaceLogId)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Proc_Step(
        long documentReceiptId, long processor, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Proc_Step_First(
        long documentReceiptId, long processor, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Proc_Step_Last(
        long documentReceiptId, long processor, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog[] findByDoc_Proc_Step_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        long processor, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDoc_Step(
        long documentReceiptId, int step, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Step_First(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDoc_Step_Last(
        long documentReceiptId, int step,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog[] findByDoc_Step_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        int step, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findByDocId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDocId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog findByDocId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog[] findByDocId_PrevAndNext(
        long documentReceiptIssuingPlaceLogId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptIssuingPlaceLogException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptIssuingPlaceLog> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDoc_Proc_Step(long documentReceiptId, long processor,
        int step) throws com.liferay.portal.SystemException;

    public void removeByDoc_Step(long documentReceiptId, int step)
        throws com.liferay.portal.SystemException;

    public void removeByDocId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDoc_Proc_Step(long documentReceiptId, long processor,
        int step) throws com.liferay.portal.SystemException;

    public int countByDoc_Step(long documentReceiptId, int step)
        throws com.liferay.portal.SystemException;

    public int countByDocId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
