package com.sgs.portlet.document.service.persistence;

public interface PmlDocumentReceiptWFPersistence {
    public com.sgs.portlet.document.model.PmlDocumentReceiptWF create(
        long processId);

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF remove(
        long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF remove(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDocumentReceiptWF pmlDocumentReceiptWF, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlDocumentReceiptWF update(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentReceiptWF the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentReceiptWF is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlDocumentReceiptWF update(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF updateImpl(
        com.sgs.portlet.document.model.PmlDocumentReceiptWF pmlDocumentReceiptWF,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF findByPrimaryKey(
        long processId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF fetchByPrimaryKey(
        long processId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptId(
        long documentReceiptId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptId_First(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptId_Last(
        long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF[] findByDocumentReceiptId_PrevAndNext(
        long processId, long documentReceiptId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, java.lang.String isMain)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, java.lang.String isMain, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findByDocumentReceiptIdIsMain(
        long documentReceiptId, java.lang.String isMain, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptIdIsMain_First(
        long documentReceiptId, java.lang.String isMain,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF findByDocumentReceiptIdIsMain_Last(
        long documentReceiptId, java.lang.String isMain,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public com.sgs.portlet.document.model.PmlDocumentReceiptWF[] findByDocumentReceiptIdIsMain_PrevAndNext(
        long processId, long documentReceiptId, java.lang.String isMain,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchReceiptWFException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentReceiptWF> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public void removeByDocumentReceiptIdIsMain(long documentReceiptId,
        java.lang.String isMain) throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptId(long documentReceiptId)
        throws com.liferay.portal.SystemException;

    public int countByDocumentReceiptIdIsMain(long documentReceiptId,
        java.lang.String isMain) throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
