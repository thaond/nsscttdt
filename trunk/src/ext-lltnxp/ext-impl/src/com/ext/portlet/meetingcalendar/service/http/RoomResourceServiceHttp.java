package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;


/**
 * <a href="RoomResourceServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil</code> service
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
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.RoomResourceServiceSoap
 *
 */
public class RoomResourceServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(RoomResourceServiceHttp.class);

    public static com.ext.portlet.meetingcalendar.model.RoomResource updateResource(
        HttpPrincipal httpPrincipal, int roomId, java.lang.String roomName,
        java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new IntegerWrapper(roomId);

            Object paramObj1 = roomName;

            if (roomName == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = description;

            if (description == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(RoomResourceServiceUtil.class.getName(),
                    "updateResource",
                    new Object[] { paramObj0, paramObj1, paramObj2 });

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

            return (com.ext.portlet.meetingcalendar.model.RoomResource) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> getRoomResources(
        HttpPrincipal httpPrincipal)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            MethodWrapper methodWrapper = new MethodWrapper(RoomResourceServiceUtil.class.getName(),
                    "getRoomResources", new Object[0]);

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

            return (java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource>) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteRoomResource(HttpPrincipal httpPrincipal,
        long roomId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(roomId);

            MethodWrapper methodWrapper = new MethodWrapper(RoomResourceServiceUtil.class.getName(),
                    "deleteRoomResource", new Object[] { paramObj0 });

            try {
                TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
