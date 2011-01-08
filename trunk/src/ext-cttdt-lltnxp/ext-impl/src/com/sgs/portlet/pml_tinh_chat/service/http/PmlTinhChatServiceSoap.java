package com.sgs.portlet.pml_tinh_chat.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="PmlTinhChatServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap</code>. If the method in the
 * service utility returns a <code>com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat</code>,
 * that is translated to a <code>com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap</code>.
 * Methods that SOAP cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/tunnel-web/secure/axis. Set the property
 * <code>tunnel.servlet.hosts.allowed</code> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil
 * @see com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatServiceHttp
 *
 */
public class PmlTinhChatServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(PmlTinhChatServiceSoap.class);

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap addPmlTinhChat(
        java.lang.String tenTinhChat) throws RemoteException {
        try {
            com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat returnValue = PmlTinhChatServiceUtil.addPmlTinhChat(tenTinhChat);

            return com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap updatePmlTinhChat(
        long idTinhChat, java.lang.String tenTinhChat)
        throws RemoteException {
        try {
            com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat returnValue = PmlTinhChatServiceUtil.updatePmlTinhChat(idTinhChat,
                    tenTinhChat);

            return com.sgs.portlet.pml_tinh_chat.model.PmlTinhChatSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
