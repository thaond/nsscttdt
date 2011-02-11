package com.sgs.portlet.document.service.persistence;

public interface PmlDocumentSendWFPersistence {
    public com.sgs.portlet.document.model.PmlDocumentSendWF create(
        long documentSendId);

    public com.sgs.portlet.document.model.PmlDocumentSendWF remove(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF remove(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDocumentSendWF pmlDocumentSendWF, boolean merge)</code>.
     */
    public com.sgs.portlet.document.model.PmlDocumentSendWF update(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentSendWF the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentSendWF is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.document.model.PmlDocumentSendWF update(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF updateImpl(
        com.sgs.portlet.document.model.PmlDocumentSendWF pmlDocumentSendWF,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF findByPrimaryKey(
        long documentSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF fetchByPrimaryKey(
        long documentSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findByProcessId(
        long processId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findByProcessId(
        long processId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findByProcessId(
        long processId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF findByProcessId_First(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF findByProcessId_Last(
        long processId, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException;

    public com.sgs.portlet.document.model.PmlDocumentSendWF[] findByProcessId_PrevAndNext(
        long documentSendId, long processId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.document.NoSuchSendWFException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.document.model.PmlDocumentSendWF> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByProcessId(long processId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByProcessId(long processId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
