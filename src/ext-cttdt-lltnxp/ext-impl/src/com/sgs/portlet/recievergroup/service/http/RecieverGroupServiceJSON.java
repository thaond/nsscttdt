package com.sgs.portlet.recievergroup.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil;


/**
 * <a href="RecieverGroupServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a JSON utility for the
 * <code>com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil</code>
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
 * service utility returns a <code>com.sgs.portlet.recievergroup.model.RecieverGroup</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONObject</code>. Methods that JSON
 * cannot safely use are skipped. The logic for the translation is encapsulated
 * in <code>com.sgs.portlet.recievergroup.service.http.RecieverGroupJSONSerializer</code>.
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
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil
 * @see com.sgs.portlet.recievergroup.service.http.RecieverGroupJSONSerializer
 *
 */
public class RecieverGroupServiceJSON {
    public static void addRecieverToGroup(long groupPK, long recieverUserId,
        java.lang.String recieverUserName, int recieverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        RecieverGroupServiceUtil.addRecieverToGroup(groupPK, recieverUserId,
            recieverUserName, recieverType);
    }

    public static void deleteRecieverGroup(long recieverGroupId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        RecieverGroupServiceUtil.deleteRecieverGroup(recieverGroupId);
    }

    public static JSONArray getRecieverGroups(int type)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> returnValue =
            RecieverGroupServiceUtil.getRecieverGroups(type);

        return RecieverGroupJSONSerializer.toJSONArray(returnValue);
    }

    public static void removeRecieverFromGroup(long recieverGroupId,
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        RecieverGroupServiceUtil.removeRecieverFromGroup(recieverGroupId,
            recieverUserId, recieverUserName, recieverType);
    }

    public static JSONObject updateRecieverGroup(long recieverGroupId,
        java.lang.String recieverGroupName, java.lang.String description,
        int type, boolean active)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.sgs.portlet.recievergroup.model.RecieverGroup returnValue = RecieverGroupServiceUtil.updateRecieverGroup(recieverGroupId,
                recieverGroupName, description, type, active);

        return RecieverGroupJSONSerializer.toJSONObject(returnValue);
    }
}
