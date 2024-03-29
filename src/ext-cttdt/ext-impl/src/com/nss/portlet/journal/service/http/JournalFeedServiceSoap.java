package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.nss.portlet.journal.service.JournalFeedServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="JournalFeedServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.nss.portlet.journal.service.JournalFeedServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.nss.portlet.journal.model.JournalFeedSoap</code>. If the method in the
 * service utility returns a <code>com.nss.portlet.journal.model.JournalFeed</code>,
 * that is translated to a <code>com.nss.portlet.journal.model.JournalFeedSoap</code>.
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
 * @see com.nss.portlet.journal.model.JournalFeedSoap
 * @see com.nss.portlet.journal.service.JournalFeedServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalFeedServiceHttp
 *
 */
public class JournalFeedServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(JournalFeedServiceSoap.class);

    public static com.nss.portlet.journal.model.JournalFeedSoap addFeed(
        long groupId, java.lang.String feedId, boolean autoFeedId,
        java.lang.String name, java.lang.String description,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.lang.String rendererTemplateId,
        int delta, java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalFeed returnValue = JournalFeedServiceUtil.addFeed(groupId,
                    feedId, autoFeedId, name, description, type, structureId,
                    templateId, rendererTemplateId, delta, orderByCol,
                    orderByType, targetLayoutFriendlyUrl, targetPortletId,
                    contentField, feedType, feedVersion, serviceContext);

            return com.nss.portlet.journal.model.JournalFeedSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteFeed(long groupId, long feedId)
        throws RemoteException {
        try {
            JournalFeedServiceUtil.deleteFeed(groupId, feedId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteFeed(long groupId, java.lang.String feedId)
        throws RemoteException {
        try {
            JournalFeedServiceUtil.deleteFeed(groupId, feedId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalFeedSoap getFeed(
        long groupId, long feedId) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalFeed returnValue = JournalFeedServiceUtil.getFeed(groupId,
                    feedId);

            return com.nss.portlet.journal.model.JournalFeedSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalFeedSoap getFeed(
        long groupId, java.lang.String feedId) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalFeed returnValue = JournalFeedServiceUtil.getFeed(groupId,
                    feedId);

            return com.nss.portlet.journal.model.JournalFeedSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalFeedSoap updateFeed(
        long groupId, java.lang.String feedId, java.lang.String name,
        java.lang.String description, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.lang.String rendererTemplateId, int delta,
        java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalFeed returnValue = JournalFeedServiceUtil.updateFeed(groupId,
                    feedId, name, description, type, structureId, templateId,
                    rendererTemplateId, delta, orderByCol, orderByType,
                    targetLayoutFriendlyUrl, targetPortletId, contentField,
                    feedType, feedVersion, serviceContext);

            return com.nss.portlet.journal.model.JournalFeedSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
