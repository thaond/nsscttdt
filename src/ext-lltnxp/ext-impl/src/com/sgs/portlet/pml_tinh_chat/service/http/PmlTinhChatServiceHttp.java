package com.sgs.portlet.pml_tinh_chat.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;

import com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil;


/**
 * <a href="PmlTinhChatServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it requires an
 * additional <code>com.liferay.portal.security.auth.HttpPrincipal</code>
 * parameter.
 * </p>
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <code>tunnel.servlet.hosts.allowed</code> in
 * portal.properties to configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portal.security.auth.HttpPrincipal
 * @see com.sgs.portlet.pml_tinh_chat.service.PmlTinhChatServiceUtil
 * @see com.sgs.portlet.pml_tinh_chat.service.http.PmlTinhChatServiceSoap
 *
 */
public class PmlTinhChatServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(PmlTinhChatServiceHttp.class);

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat addPmlTinhChat(
        HttpPrincipal httpPrincipal, java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = tenTinhChat;

            if (tenTinhChat == null) {
                paramObj0 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(PmlTinhChatServiceUtil.class.getName(),
                    "addPmlTinhChat", new Object[] { paramObj0 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat updatePmlTinhChat(
        HttpPrincipal httpPrincipal, long idTinhChat,
        java.lang.String tenTinhChat)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(idTinhChat);

            Object paramObj1 = tenTinhChat;

            if (tenTinhChat == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(PmlTinhChatServiceUtil.class.getName(),
                    "updatePmlTinhChat", new Object[] { paramObj0, paramObj1 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
