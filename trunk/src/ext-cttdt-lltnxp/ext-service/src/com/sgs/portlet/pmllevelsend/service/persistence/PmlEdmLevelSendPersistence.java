package com.sgs.portlet.pmllevelsend.service.persistence;

public interface PmlEdmLevelSendPersistence {
    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend create(
        int levelSendId);

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend remove(
        int levelSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend remove(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlEdmLevelSend pmlEdmLevelSend, boolean merge)</code>.
     */
    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend update(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlEdmLevelSend the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlEdmLevelSend is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend update(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend updateImpl(
        com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend pmlEdmLevelSend,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByPrimaryKey(
        int levelSendId)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend fetchByPrimaryKey(
        int levelSendId) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendCode(
        java.lang.String levelSendCode)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendCode(
        java.lang.String levelSendCode, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendCode(
        java.lang.String levelSendCode, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendCode_First(
        java.lang.String levelSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendCode_Last(
        java.lang.String levelSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend[] findByLevelSendCode_PrevAndNext(
        int levelSendId, java.lang.String levelSendCode,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendName(
        java.lang.String levelSendName)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendName(
        java.lang.String levelSendName, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findByLevelSendName(
        java.lang.String levelSendName, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendName_First(
        java.lang.String levelSendName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend findByLevelSendName_Last(
        java.lang.String levelSendName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend[] findByLevelSendName_PrevAndNext(
        int levelSendId, java.lang.String levelSendName,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pmllevelsend.NoSuchPmlEdmLevelSendException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByLevelSendCode(java.lang.String levelSendCode)
        throws com.liferay.portal.SystemException;

    public void removeByLevelSendName(java.lang.String levelSendName)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByLevelSendCode(java.lang.String levelSendCode)
        throws com.liferay.portal.SystemException;

    public int countByLevelSendName(java.lang.String levelSendName)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
