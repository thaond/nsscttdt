package com.sgs.portlet.pml_tinh_chat.service.http;

import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil;


/**
 * <a href="PmlTinhChatServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a JSON utility for the
 * <code>com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil</code>
 * service utility. The static methods of this class calls the same methods of
 * the service utility. However, the signatures are different because it is
 * difficult for JSON to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONArray</code>. If the method in the
 * service utility returns a <code>com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONObject</code>. Methods that JSON
 * cannot safely use are skipped. The logic for the translation is encapsulated
 * in <code>com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatJSONSerializer</code>.
 * </p>
 *
 * <p>
 * This allows you to call the the backend services directly from JavaScript.
 * See <code>portal-web/docroot/html/portlet/tags_admin/unpacked.js</code> for a
 * reference of how that portlet uses the generated JavaScript in
 * <code>portal-web/docroot/html/js/service.js</code> to call the backend
 * services directly from JavaScript.
 * </p>
 *
 * <p>
 * The JSON utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil
 * @see com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatJSONSerializer
 *
 */
public class PmlTinhChatServiceJSON {
    public static JSONObject addPmlTinhChat(java.lang.String tenTinhChat)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat returnValue = PmlTinhChatServiceUtil.addPmlTinhChat(tenTinhChat);

        return PmlTinhChatJSONSerializer.toJSONObject(returnValue);
    }

    public static JSONObject updatePmlTinhChat(long idTinhChat,
        java.lang.String tenTinhChat)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat returnValue = PmlTinhChatServiceUtil.updatePmlTinhChat(idTinhChat,
                tenTinhChat);

        return PmlTinhChatJSONSerializer.toJSONObject(returnValue);
    }
}
