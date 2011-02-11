package com.sgs.portlet.pml_tinh_chat.service;


/**
 * <a href="PmlTinhChatLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_tinh_chat.service.impl.PmlTinhChatLocalServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatLocalServiceUtil
 *
 */
public interface PmlTinhChatLocalService {
    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat addPmlTinhChat(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat createPmlTinhChat(
        long idTinhChat);

    public void deletePmlTinhChat(long idTinhChat)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlTinhChat(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat getPmlTinhChat(
        long idTinhChat)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> getPmlTinhChats(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlTinhChatsCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updatePmlTinhChat(
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat pmlTinhChat)
        throws com.liferay.portal.SystemException;

    public int searchCount(boolean andOperator)
        throws com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> search(
        boolean andOperator, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator obc)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat addPmlTinhChat(
        java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updatePmlTinhChat(
        long idTinhChat, java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public java.util.List<com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat> getAll()
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public void removePmlTinhChat(java.lang.String idTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
