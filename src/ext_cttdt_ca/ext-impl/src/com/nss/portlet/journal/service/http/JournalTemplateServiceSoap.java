package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.nss.portlet.journal.service.JournalTemplateServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="JournalTemplateServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.nss.portlet.journal.service.JournalTemplateServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.nss.portlet.journal.model.JournalTemplateSoap</code>. If the method in the
 * service utility returns a <code>com.nss.portlet.journal.model.JournalTemplate</code>,
 * that is translated to a <code>com.nss.portlet.journal.model.JournalTemplateSoap</code>.
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
 * @see com.nss.portlet.journal.model.JournalTemplateSoap
 * @see com.nss.portlet.journal.service.JournalTemplateServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalTemplateServiceHttp
 *
 */
public class JournalTemplateServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(JournalTemplateServiceSoap.class);

    public static com.nss.portlet.journal.model.JournalTemplateSoap addTemplate(
        long groupId, java.lang.String templateId, boolean autoTemplateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalTemplate returnValue = JournalTemplateServiceUtil.addTemplate(groupId,
                    templateId, autoTemplateId, structureId, name, description,
                    xsl, formatXsl, langType, cacheable, serviceContext);

            return com.nss.portlet.journal.model.JournalTemplateSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplateSoap copyTemplate(
        long groupId, java.lang.String oldTemplateId,
        java.lang.String newTemplateId, boolean autoTemplateId)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalTemplate returnValue = JournalTemplateServiceUtil.copyTemplate(groupId,
                    oldTemplateId, newTemplateId, autoTemplateId);

            return com.nss.portlet.journal.model.JournalTemplateSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteTemplate(long groupId, java.lang.String templateId)
        throws RemoteException {
        try {
            JournalTemplateServiceUtil.deleteTemplate(groupId, templateId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplateSoap[] getStructureTemplates(
        long groupId, java.lang.String structureId) throws RemoteException {
        try {
            java.util.List<com.nss.portlet.journal.model.JournalTemplate> returnValue =
                JournalTemplateServiceUtil.getStructureTemplates(groupId,
                    structureId);

            return com.nss.portlet.journal.model.JournalTemplateSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplateSoap getTemplate(
        long groupId, java.lang.String templateId) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalTemplate returnValue = JournalTemplateServiceUtil.getTemplate(groupId,
                    templateId);

            return com.nss.portlet.journal.model.JournalTemplateSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplateSoap updateTemplate(
        long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalTemplate returnValue = JournalTemplateServiceUtil.updateTemplate(groupId,
                    templateId, structureId, name, description, xsl, formatXsl,
                    langType, cacheable, serviceContext);

            return com.nss.portlet.journal.model.JournalTemplateSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
