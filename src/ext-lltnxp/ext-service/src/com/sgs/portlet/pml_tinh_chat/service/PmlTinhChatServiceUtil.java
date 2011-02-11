package com.sgs.portlet.pml_tinh_chat.service;


/**
 * <a href="PmlTinhChatServiceUtil.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides static methods for the
 * <code>com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatService</code>
 * bean. The static methods of this class calls the same methods of the bean
 * instance. It's convenient to be able to just write one line to call a method
 * on a bean instead of writing a lookup call and a method call.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatService
 *
 */
public class PmlTinhChatServiceUtil {
    private static PmlTinhChatService _service;

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat addPmlTinhChat(
        java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().addPmlTinhChat(tenTinhChat);
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updatePmlTinhChat(
        long idTinhChat, java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException, java.rmi.RemoteException {
        return getService().updatePmlTinhChat(idTinhChat, tenTinhChat);
    }

    public static PmlTinhChatService getService() {
        if (_service == null) {
            throw new RuntimeException("PmlTinhChatService is not set");
        }

        return _service;
    }

    public void setService(PmlTinhChatService service) {
        _service = service;
    }
}
