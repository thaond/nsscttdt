package com.sgs.portlet.receivergroup.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil;


/**
 * <a href="ReceiverGroupServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a JSON utility for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil</code>
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
 * service utility returns a <code>com.sgs.portlet.receivergroup.model.ReceiverGroup</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONObject</code>. Methods that JSON
 * cannot safely use are skipped. The logic for the translation is encapsulated
 * in <code>com.sgs.portlet.receivergroup.service.http.ReceiverGroupJSONSerializer</code>.
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil
 * @see com.sgs.portlet.receivergroup.service.http.ReceiverGroupJSONSerializer
 *
 */
public class ReceiverGroupServiceJSON {
    public static void addReceiverToGroup(long groupPK, long receiverUserId,
        java.lang.String receiverUserName, int receiverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        ReceiverGroupServiceUtil.addReceiverToGroup(groupPK, receiverUserId,
            receiverUserName, receiverType);
    }

    public static void deleteReceiverGroup(long receiverGroupId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        ReceiverGroupServiceUtil.deleteReceiverGroup(receiverGroupId);
    }

    public static JSONArray getReceiverGroups(int type)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> returnValue =
            ReceiverGroupServiceUtil.getReceiverGroups(type);

        return ReceiverGroupJSONSerializer.toJSONArray(returnValue);
    }

    public static void removeReceiverFromGroup(long receiverGroupId,
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        ReceiverGroupServiceUtil.removeReceiverFromGroup(receiverGroupId,
            receiverUserId, receiverUserName, receiverType);
    }

    public static JSONObject updateReceiverGroup(long receiverGroupId,
        java.lang.String receiverGroupName, java.lang.String description,
        int type, boolean active)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.sgs.portlet.receivergroup.model.ReceiverGroup returnValue = ReceiverGroupServiceUtil.updateReceiverGroup(receiverGroupId,
                receiverGroupName, description, type, active);

        return ReceiverGroupJSONSerializer.toJSONObject(returnValue);
    }
}
