package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.nss.portlet.journal.service.JournalStructureServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="JournalStructureServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.nss.portlet.journal.service.JournalStructureServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.nss.portlet.journal.model.JournalStructureSoap</code>. If the method in the
 * service utility returns a <code>com.nss.portlet.journal.model.JournalStructure</code>,
 * that is translated to a <code>com.nss.portlet.journal.model.JournalStructureSoap</code>.
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
 * @see com.nss.portlet.journal.model.JournalStructureSoap
 * @see com.nss.portlet.journal.service.JournalStructureServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalStructureServiceHttp
 *
 */
public class JournalStructureServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(JournalStructureServiceSoap.class);

    public static com.nss.portlet.journal.model.JournalStructureSoap addStructure(
        long groupId, java.lang.String structureId, boolean autoStructureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalStructure returnValue = JournalStructureServiceUtil.addStructure(groupId,
                    structureId, autoStructureId, parentStructureId, name,
                    description, xsd, serviceContext);

            return com.nss.portlet.journal.model.JournalStructureSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalStructureSoap copyStructure(
        long groupId, java.lang.String oldStructureId,
        java.lang.String newStructureId, boolean autoStructureId)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalStructure returnValue = JournalStructureServiceUtil.copyStructure(groupId,
                    oldStructureId, newStructureId, autoStructureId);

            return com.nss.portlet.journal.model.JournalStructureSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteStructure(long groupId,
        java.lang.String structureId) throws RemoteException {
        try {
            JournalStructureServiceUtil.deleteStructure(groupId, structureId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalStructureSoap getStructure(
        long groupId, java.lang.String structureId) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalStructure returnValue = JournalStructureServiceUtil.getStructure(groupId,
                    structureId);

            return com.nss.portlet.journal.model.JournalStructureSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalStructureSoap updateStructure(
        long groupId, java.lang.String structureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalStructure returnValue = JournalStructureServiceUtil.updateStructure(groupId,
                    structureId, parentStructureId, name, description, xsd,
                    serviceContext);

            return com.nss.portlet.journal.model.JournalStructureSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
