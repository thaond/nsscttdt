package com.sgs.portlet.pml_tinh_chat.service.persistence;

public class PmlTinhChatUtil {
    private static PmlTinhChatPersistence _persistence;

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat create(
        long idTinhChat) {
        return getPersistence().create(idTinhChat);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat remove(
        long idTinhChat)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException {
        return getPersistence().remove(idTinhChat);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat remove(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException {
        return getPersistence().remove(pmlTinhChat);
    }

    /**
     * @deprecated Use <code>update(PmlTinhChat pmlTinhChat, boolean merge)</code>.
     */
    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat update(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTinhChat);
    }

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
    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat update(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().update(pmlTinhChat, merge);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updateImpl(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat,
        boolean merge) throws com.liferay.portal.SystemException {
        return getPersistence().updateImpl(pmlTinhChat, merge);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat findByPrimaryKey(
        long idTinhChat)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException {
        return getPersistence().findByPrimaryKey(idTinhChat);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat fetchByPrimaryKey(
        long idTinhChat) throws com.liferay.portal.SystemException {
        return getPersistence().fetchByPrimaryKey(idTinhChat);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByTenTinhChat(
        java.lang.String tenTinhChat) throws com.liferay.portal.SystemException {
        return getPersistence().findByTenTinhChat(tenTinhChat);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByTenTinhChat(
        java.lang.String tenTinhChat, int start, int end)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTenTinhChat(tenTinhChat, start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findByTenTinhChat(
        java.lang.String tenTinhChat, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findByTenTinhChat(tenTinhChat, start, end, obc);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat findByTenTinhChat_First(
        java.lang.String tenTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException {
        return getPersistence().findByTenTinhChat_First(tenTinhChat, obc);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat findByTenTinhChat_Last(
        java.lang.String tenTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException {
        return getPersistence().findByTenTinhChat_Last(tenTinhChat, obc);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat[] findByTenTinhChat_PrevAndNext(
        long idTinhChat, java.lang.String tenTinhChat,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException,
            com.sgs.portlet.pml_tinh_chat.NoSuchPmlTinhChatException {
        return getPersistence()
                   .findByTenTinhChat_PrevAndNext(idTinhChat, tenTinhChat, obc);
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

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findAll()
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll();
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findAll(
        int start, int end) throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end);
    }

    public static java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> findAll(
        int start, int end, com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException {
        return getPersistence().findAll(start, end, obc);
    }

    public static void removeByTenTinhChat(java.lang.String tenTinhChat)
        throws com.liferay.portal.SystemException {
        getPersistence().removeByTenTinhChat(tenTinhChat);
    }

    public static void removeAll() throws com.liferay.portal.SystemException {
        getPersistence().removeAll();
    }

    public static int countByTenTinhChat(java.lang.String tenTinhChat)
        throws com.liferay.portal.SystemException {
        return getPersistence().countByTenTinhChat(tenTinhChat);
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

    public static PmlTinhChatPersistence getPersistence() {
        return _persistence;
    }

    public void setPersistence(PmlTinhChatPersistence persistence) {
        _persistence = persistence;
    }
}
