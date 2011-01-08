package com.sgs.portlet.pml_tinh_chat.service.persistence;

public interface PmlTinhChatPersistence {
    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat create(
        long idTinhChat);

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat remove(
        long idTinhChat)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat remove(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException;

    /**
     * @deprecated Use <code>update(PmlTinhChat pmlTinhChat, boolean merge)</code>.
     */
    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat update(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException;

    /**
     * Add, update, or merge, the entity. This method also calls the model
     * listeners to trigger the proper events associated with adding, deleting,
     * or updating an entity.
     *
     * @param                pmlTinhChat the entity to add, update, or merge
     * @param                merge boolean value for whether to merge the entity. The
     *                                default value is false. Setting merge to true is more
     *                                expensive and should only be true when pmlTinhChat is
     *                                transient. See LEP-5473 for a detailed discussion of this
     *                                method.
     * @return                true if the portlet can be displayed via Ajax
     */
    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat update(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updateImpl(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat,
        boolean merge) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat findByPrimaryKey(
        long idTinhChat)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat fetchByPrimaryKey(
        long idTinhChat) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByTenTinhChat(
        java.lang.String tenTinhChat) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByTenTinhChat(
        java.lang.String tenTinhChat, int start, int end)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByTenTinhChat(
        java.lang.String tenTinhChat, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat findByTenTinhChat_First(
        java.lang.String tenTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat findByTenTinhChat_Last(
        java.lang.String tenTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat[] findByTenTinhChat_PrevAndNext(
        long idTinhChat, java.lang.String tenTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> findWithDynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findAll()
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findAll(
        int start, int end) throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public void removeByTenTinhChat(java.lang.String tenTinhChat)
        throws com.liferay.portal.SystemException;

    public void removeAll() throws com.liferay.portal.SystemException;

    public int countByTenTinhChat(java.lang.String tenTinhChat)
        throws com.liferay.portal.SystemException;

    public int countAll() throws com.liferay.portal.SystemException;

    public void registerListener(
        com.liferay.portal.model.ModelListener listener);

    public void unregisterListener(
        com.liferay.portal.model.ModelListener listener);
}
