package com.sgs.portlet.message_note.service;


/**
 * <a href="PmlMessageLocalService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.message_note.service.impl.PmlMessageLocalServiceImpl</code>.
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
 * @see com.sgs.portlet.message_note.service.PmlMessageLocalServiceUtil
 *
 */
public interface PmlMessageLocalService {
    public com.sgs.portlet.message_note.model.PmlMessage addPmlMessage(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage createPmlMessage(
        long messageId);

    public void deletePmlMessage(long messageId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public void deletePmlMessage(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException;

    public java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage getPmlMessage(
        long messageId)
        throws com.liferay.portal.SystemException,
            com.liferay.portal.PortalException;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> getPmlMessages(
        int start, int end) throws com.liferay.portal.SystemException;

    public int getPmlMessagesCount() throws com.liferay.portal.SystemException;

    public com.sgs.portlet.message_note.model.PmlMessage updatePmlMessage(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException;

    public void deletePmlMessageList(
        java.util.List<com.sgs.portlet.message_note.model.PmlMessage> messageList)
        throws java.lang.Exception;

    public int getTotalDocumentByUser(java.util.List<Long> fromUserList,
        long toUserId) throws java.lang.Exception;

    public java.util.List<com.sgs.portlet.message_note.model.PmlMessage> getDocumentListByUser(
        long fromUserId, long toUserId, java.lang.Class clazz)
        throws java.lang.Exception;
}
