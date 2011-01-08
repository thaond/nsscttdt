package com.sgs.portlet.recievergroup.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="RecieverGroupServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.sgs.portlet.recievergroup.model.RecieverGroupSoap</code>. If the method in the
 * service utility returns a <code>com.sgs.portlet.recievergroup.model.RecieverGroup</code>,
 * that is translated to a <code>com.sgs.portlet.recievergroup.model.RecieverGroupSoap</code>.
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
 * @see com.sgs.portlet.recievergroup.model.RecieverGroupSoap
 * @see com.sgs.portlet.recievergroup.service.RecieverGroupServiceUtil
 * @see com.sgs.portlet.recievergroup.service.http.RecieverGroupServiceHttp
 *
 */
public class RecieverGroupServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(RecieverGroupServiceSoap.class);

    public static void addRecieverToGroup(long groupPK, long recieverUserId,
        java.lang.String recieverUserName, int recieverType)
        throws RemoteException {
        try {
            RecieverGroupServiceUtil.addRecieverToGroup(groupPK,
                recieverUserId, recieverUserName, recieverType);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteRecieverGroup(long recieverGroupId)
        throws RemoteException {
        try {
            RecieverGroupServiceUtil.deleteRecieverGroup(recieverGroupId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroupSoap[] getRecieverGroups(
        int type) throws RemoteException {
        try {
            java.util.List<com.sgs.portlet.recievergroup.model.RecieverGroup> returnValue =
                RecieverGroupServiceUtil.getRecieverGroups(type);

            return com.sgs.portlet.recievergroup.model.RecieverGroupSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void removeRecieverFromGroup(long recieverGroupId,
        long recieverUserId, java.lang.String recieverUserName, int recieverType)
        throws RemoteException {
        try {
            RecieverGroupServiceUtil.removeRecieverFromGroup(recieverGroupId,
                recieverUserId, recieverUserName, recieverType);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.sgs.portlet.recievergroup.model.RecieverGroupSoap updateRecieverGroup(
        long recieverGroupId, java.lang.String recieverGroupName,
        java.lang.String description, int type, boolean active)
        throws RemoteException {
        try {
            com.sgs.portlet.recievergroup.model.RecieverGroup returnValue = RecieverGroupServiceUtil.updateRecieverGroup(recieverGroupId,
                    recieverGroupName, description, type, active);

            return com.sgs.portlet.recievergroup.model.RecieverGroupSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
