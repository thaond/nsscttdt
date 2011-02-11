package com.sgs.portlet.pml_tinh_chat.service;


/**
 * <a href="PmlTinhChatService.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This interface defines the service. The default implementation is
 * <code>com.sgs.portlet.pml_tinh_chat.service.impl.PmlTinhChatServiceImpl</code>.
 * Modify methods in that class and rerun ServiceBuilder to populate this class
 * and all other generated classes.
 * </p>
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil
 *
 */
public interface PmlTinhChatService {
    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat addPmlTinhChat(
        java.lang.String tenTinhChat)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;

    public com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updatePmlTinhChat(
        long idTinhChat, java.lang.String tenTinhChat)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException;
}
