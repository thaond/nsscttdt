package com.sgs.portlet.message_note.service;


/**
 * <a href="PmlMessageLocalServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.message_note.service.PmlMessageLocalService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.message_note.service.PmlMessageLocalService
 *
 */
public class PmlMessageLocalServiceUtil {
    private static PmlMessageLocalService _service;

    public static com.sgs.portlet.message_note.model.PmlMessage addPmlMessage(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException {
        return getService().addPmlMessage(pmlMessage);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage createPmlMessage(
        long messageId) {
        return getService().createPmlMessage(messageId);
    }

    public static void deletePmlMessage(long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        getService().deletePmlMessage(messageId);
    }

    public static void deletePmlMessage(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException {
        getService().deletePmlMessage(pmlMessage);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    public static java.util.List<Object> dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    public static com.sgs.portlet.message_note.model.PmlMessage getPmlMessage(
        long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        return getService().getPmlMessage(messageId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> getPmlMessages(
        int start, int end) throws com.liferay.portal.SystemException {
        return getService().getPmlMessages(start, end);
    }

    public static int getPmlMessagesCount()
        throws com.liferay.portal.SystemException {
        return getService().getPmlMessagesCount();
    }

    public static com.sgs.portlet.message_note.model.PmlMessage updatePmlMessage(
        com.sgs.portlet.message_note.model.PmlMessage pmlMessage)
        throws com.liferay.portal.SystemException {
        return getService().updatePmlMessage(pmlMessage);
    }

    public static void deletePmlMessageList(
        java.util.List<com.sgs.portlet.message_note.model.PmlMessage> messageList)
        throws java.lang.Exception {
        getService().deletePmlMessageList(messageList);
    }

    public static int getTotalDocumentByUser(
        java.util.List<Long> fromUserList, long toUserId)
        throws java.lang.Exception {
        return getService().getTotalDocumentByUser(fromUserList, toUserId);
    }

    public static java.util.List<com.sgs.portlet.message_note.model.PmlMessage> getDocumentListByUser(
        long fromUserId, long toUserId, java.lang.Class clazz)
        throws java.lang.Exception {
        return getService().getDocumentListByUser(fromUserId, toUserId, clazz);
    }

    public static PmlMessageLocalService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlMessageLocalService is not set");
        }

        return _service;
    }

    public void setService(PmlMessageLocalService service) {
        _service = service;
    }
}
