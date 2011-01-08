package com.sgs.portlet.documentdelegate.service.persistence;

public interface PmlDocumentDelegatePersistence {
    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate create(
        long documentDelegateId);

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate remove(
        long documentDelegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate remove(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlDocumentDelegate pmlDocumentDelegate, boolean merge)</code>.
     */
    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate update(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlDocumentDelegate the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlDocumentDelegate is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate update(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate updateImpl(
        com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate pmlDocumentDelegate,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate findByPrimaryKey(
        long documentDelegateId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate fetchByPrimaryKey(
        long documentDelegateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findByUserIsDelegateId(
        long userIsDelegateId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate findByUserIsDelegateId_First(
        long userIsDelegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate findByUserIsDelegateId_Last(
        long userIsDelegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException;

    public com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate[] findByUserIsDelegateId_PrevAndNext(
        long documentDelegateId, long userIsDelegateId,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.documentdelegate.NoSuchException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByUserIsDelegateId(long userIsDelegateId)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByUserIsDelegateId(long userIsDelegateId)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
