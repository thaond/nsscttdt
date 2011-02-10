package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;


/**
 * <a href="RoomResourceServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a JSON utility for the
 * <code>com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil</code>
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
 * service utility returns a <code>com.ext.portlet.meetingcalendar.model.RoomResource</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONObject</code>. Methods that JSON
 * cannot safely use are skipped. The logic for the translation is encapsulated
 * in <code>com.ext.portlet.meetingcalendar.service.http.RoomResourceJSONSerializer</code>.
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
 * @see com.ext.portlet.meetingcalendar.service.RoomResourceServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.RoomResourceJSONSerializer
 *
 */
public class RoomResourceServiceJSON {
    public static JSONObject updateResource(int roomId,
        java.lang.String roomName, java.lang.String description)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.ext.portlet.meetingcalendar.model.RoomResource returnValue = RoomResourceServiceUtil.updateResource(roomId,
                roomName, description);

        return RoomResourceJSONSerializer.toJSONObject(returnValue);
    }

    public static JSONArray getRoomResources()
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        java.util.List<com.ext.portlet.meetingcalendar.model.RoomResource> returnValue =
            RoomResourceServiceUtil.getRoomResources();

        return RoomResourceJSONSerializer.toJSONArray(returnValue);
    }

    public static void deleteRoomResource(long roomId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        RoomResourceServiceUtil.deleteRoomResource(roomId);
    }
}
