package com.liferay.portlet.messageboards.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portlet.messageboards.service.MBThreadServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="MBThreadServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.liferay.portlet.messageboards.service.MBThreadServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.portlet.messageboards.model.MBThreadSoap</code>. If the method in the
 * service utility returns a <code>com.liferay.portlet.messageboards.model.MBThread</code>,
 * that is translated to a <code>com.liferay.portlet.messageboards.model.MBThreadSoap</code>.
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
 * @see com.liferay.portlet.messageboards.model.MBThreadSoap
 * @see com.liferay.portlet.messageboards.service.MBThreadServiceUtil
 * @see com.liferay.portlet.messageboards.service.http.MBThreadServiceHttp
 *
 */
public class MBThreadServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(MBThreadServiceSoap.class);

    public static void deleteThread(long threadId) throws RemoteException {
        try {
            MBThreadServiceUtil.deleteThread(threadId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.messageboards.model.MBThreadSoap moveThread(
        long categoryId, long threadId) throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBThread returnValue = MBThreadServiceUtil.moveThread(categoryId,
                    threadId);

            return com.liferay.portlet.messageboards.model.MBThreadSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.messageboards.model.MBThreadSoap splitThread(
        long messageId, com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBThread returnValue = MBThreadServiceUtil.splitThread(messageId,
                    serviceContext);

            return com.liferay.portlet.messageboards.model.MBThreadSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
