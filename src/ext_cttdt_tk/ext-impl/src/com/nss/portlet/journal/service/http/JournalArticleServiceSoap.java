package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.nss.portlet.journal.service.JournalArticleServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="JournalArticleServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.nss.portlet.journal.service.JournalArticleServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.nss.portlet.journal.model.JournalArticleSoap</code>. If the method in the
 * service utility returns a <code>com.nss.portlet.journal.model.JournalArticle</code>,
 * that is translated to a <code>com.nss.portlet.journal.model.JournalArticleSoap</code>.
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
 * @see com.nss.portlet.journal.model.JournalArticleSoap
 * @see com.nss.portlet.journal.service.JournalArticleServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalArticleServiceHttp
 *
 */
public class JournalArticleServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(JournalArticleServiceSoap.class);

    public static com.nss.portlet.journal.model.JournalArticleSoap addArticle(
        long groupId, java.lang.String articleId, boolean autoArticleId,
        java.lang.String title, java.lang.String description,
        java.lang.String content, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        int displayDateMonth, int displayDateDay, int displayDateYear,
        int displayDateHour, int displayDateMinute, int expirationDateMonth,
        int expirationDateDay, int expirationDateYear, int expirationDateHour,
        int expirationDateMinute, boolean neverExpire, int reviewDateMonth,
        int reviewDateDay, int reviewDateYear, int reviewDateHour,
        int reviewDateMinute, boolean neverReview, boolean indexable,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.addArticle(groupId,
                    articleId, autoArticleId, title, description, content,
                    type, structureId, templateId, displayDateMonth,
                    displayDateDay, displayDateYear, displayDateHour,
                    displayDateMinute, expirationDateMonth, expirationDateDay,
                    expirationDateYear, expirationDateHour,
                    expirationDateMinute, neverExpire, reviewDateMonth,
                    reviewDateDay, reviewDateYear, reviewDateHour,
                    reviewDateMinute, neverReview, indexable, articleURL,
                    serviceContext);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap approveArticle(
        long groupId, java.lang.String articleId, double version,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.approveArticle(groupId,
                    articleId, version, articleURL, serviceContext);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap copyArticle(
        long groupId, java.lang.String oldArticleId,
        java.lang.String newArticleId, boolean autoArticleId, double version)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.copyArticle(groupId,
                    oldArticleId, newArticleId, autoArticleId, version);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap getArticle(
        long groupId, java.lang.String articleId) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.getArticle(groupId,
                    articleId);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap getArticle(
        long groupId, java.lang.String articleId, double version)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.getArticle(groupId,
                    articleId, version);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap getArticleByUrlTitle(
        long groupId, java.lang.String urlTitle) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.getArticleByUrlTitle(groupId,
                    urlTitle);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            JournalArticleServiceUtil.deleteArticle(groupId, articleId,
                version, articleURL, serviceContext);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void expireArticle(long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            JournalArticleServiceUtil.expireArticle(groupId, articleId,
                version, articleURL, serviceContext);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void removeArticleLocale(long companyId,
        java.lang.String languageId) throws RemoteException {
        try {
            JournalArticleServiceUtil.removeArticleLocale(companyId, languageId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap removeArticleLocale(
        long groupId, java.lang.String articleId, double version,
        java.lang.String languageId) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.removeArticleLocale(groupId,
                    articleId, version, languageId);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap updateArticle(
        long groupId, java.lang.String articleId, double version,
        boolean incrementVersion, java.lang.String content)
        throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.updateArticle(groupId,
                    articleId, version, incrementVersion, content);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.nss.portlet.journal.model.JournalArticleSoap updateContent(
        long groupId, java.lang.String articleId, double version,
        java.lang.String content) throws RemoteException {
        try {
            com.nss.portlet.journal.model.JournalArticle returnValue = JournalArticleServiceUtil.updateContent(groupId,
                    articleId, version, content);

            return com.nss.portlet.journal.model.JournalArticleSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
