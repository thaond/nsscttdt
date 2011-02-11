package com.sgs.portlet.receivergroup.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="ReceiverGroupServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.sgs.portlet.receivergroup.model.ReceiverGroupSoap</code>. If the method in the
 * service utility returns a <code>com.sgs.portlet.receivergroup.model.ReceiverGroup</code>,
 * that is translated to a <code>com.sgs.portlet.receivergroup.model.ReceiverGroupSoap</code>.
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
 * @see com.sgs.portlet.receivergroup.model.ReceiverGroupSoap
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil
 * @see com.sgs.portlet.receivergroup.service.http.ReceiverGroupServiceHttp
 *
 */
public class ReceiverGroupServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(ReceiverGroupServiceSoap.class);

    public static void addReceiverToGroup(long groupPK, long receiverUserId,
        java.lang.String receiverUserName, int receiverType)
        throws RemoteException {
        try {
            ReceiverGroupServiceUtil.addReceiverToGroup(groupPK,
                receiverUserId, receiverUserName, receiverType);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteReceiverGroup(long receiverGroupId)
        throws RemoteException {
        try {
            ReceiverGroupServiceUtil.deleteReceiverGroup(receiverGroupId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroupSoap[] getReceiverGroups(
        int type) throws RemoteException {
        try {
            java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> returnValue =
                ReceiverGroupServiceUtil.getReceiverGroups(type);

            return com.sgs.portlet.receivergroup.model.ReceiverGroupSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void removeReceiverFromGroup(long receiverGroupId,
        long receiverUserId, java.lang.String receiverUserName, int receiverType)
        throws RemoteException {
        try {
            ReceiverGroupServiceUtil.removeReceiverFromGroup(receiverGroupId,
                receiverUserId, receiverUserName, receiverType);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sgs.portlet.receivergroup.model.ReceiverGroupSoap updateReceiverGroup(
        long receiverGroupId, java.lang.String receiverGroupName,
        java.lang.String description, int type, boolean active)
        throws RemoteException {
        try {
            com.sgs.portlet.receivergroup.model.ReceiverGroup returnValue = ReceiverGroupServiceUtil.updateReceiverGroup(receiverGroupId,
                    receiverGroupName, description, type, active);

            return com.sgs.portlet.receivergroup.model.ReceiverGroupSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
