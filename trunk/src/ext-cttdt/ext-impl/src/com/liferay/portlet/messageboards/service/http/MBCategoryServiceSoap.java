package com.liferay.portlet.messageboards.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.liferay.portlet.messageboards.service.MBCategoryServiceUtil;

import java.rmi.RemoteException;


/**
 * <a href="MBCategoryServiceSoap.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a SOAP utility for the
 * <code>com.liferay.portlet.messageboards.service.MBCategoryServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.portlet.messageboards.model.MBCategorySoap</code>. If the method in the
 * service utility returns a <code>com.liferay.portlet.messageboards.model.MBCategory</code>,
 * that is translated to a <code>com.liferay.portlet.messageboards.model.MBCategorySoap</code>.
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
 * @see com.liferay.portlet.messageboards.model.MBCategorySoap
 * @see com.liferay.portlet.messageboards.service.MBCategoryServiceUtil
 * @see com.liferay.portlet.messageboards.service.http.MBCategoryServiceHttp
 *
 */
public class MBCategoryServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(MBCategoryServiceSoap.class);

    public static com.liferay.portlet.messageboards.model.MBCategorySoap addCategory(
        long parentCategoryId, java.lang.String name,
        java.lang.String description, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean mailingListActive,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBCategory returnValue = MBCategoryServiceUtil.addCategory(parentCategoryId,
                    name, description, emailAddress, inProtocol, inServerName,
                    inServerPort, inUseSSL, inUserName, inPassword,
                    inReadInterval, outEmailAddress, outCustom, outServerName,
                    outServerPort, outUseSSL, outUserName, outPassword,
                    mailingListActive, serviceContext);

            return com.liferay.portlet.messageboards.model.MBCategorySoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.messageboards.model.MBCategorySoap updateCategory(
        long categoryId, long parentCategoryId, java.lang.String name,
        java.lang.String description, int order, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean mailingListActive, boolean mergeWithParentCategory)
        throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBCategory returnValue = MBCategoryServiceUtil.updateCategory(categoryId,
                    parentCategoryId, name, description, order, emailAddress,
                    inProtocol, inServerName, inServerPort, inUseSSL,
                    inUserName, inPassword, inReadInterval, outEmailAddress,
                    outCustom, outServerName, outServerPort, outUseSSL,
                    outUserName, outPassword, mailingListActive,
                    mergeWithParentCategory);

            return com.liferay.portlet.messageboards.model.MBCategorySoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void deleteCategory(long categoryId)
        throws RemoteException {
        try {
            MBCategoryServiceUtil.deleteCategory(categoryId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.messageboards.model.MBCategorySoap getCategory(
        long categoryId) throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBCategory returnValue = MBCategoryServiceUtil.getCategory(categoryId);

            return com.liferay.portlet.messageboards.model.MBCategorySoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.messageboards.model.MBCategorySoap[] getCategories(
        long groupId, long parentCategoryId, int start, int end)
        throws RemoteException {
        try {
            java.util.List<com.liferay.portlet.messageboards.model.MBCategory> returnValue =
                MBCategoryServiceUtil.getCategories(groupId, parentCategoryId,
                    start, end);

            return com.liferay.portlet.messageboards.model.MBCategorySoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static int getCategoriesCount(long groupId, long parentCategoryId)
        throws RemoteException {
        try {
            int returnValue = MBCategoryServiceUtil.getCategoriesCount(groupId,
                    parentCategoryId);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void subscribeCategory(long categoryId)
        throws RemoteException {
        try {
            MBCategoryServiceUtil.subscribeCategory(categoryId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static void unsubscribeCategory(long categoryId)
        throws RemoteException {
        try {
            MBCategoryServiceUtil.unsubscribeCategory(categoryId);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.portlet.messageboards.model.MBCategorySoap updateCategory(
        long categoryId, long parentCategoryId, java.lang.String name,
        java.lang.String description, java.lang.String emailAddress,
        java.lang.String inProtocol, java.lang.String inServerName,
        int inServerPort, boolean inUseSSL, java.lang.String inUserName,
        java.lang.String inPassword, int inReadInterval,
        java.lang.String outEmailAddress, boolean outCustom,
        java.lang.String outServerName, int outServerPort, boolean outUseSSL,
        java.lang.String outUserName, java.lang.String outPassword,
        boolean mailingListActive, boolean mergeWithParentCategory)
        throws RemoteException {
        try {
            com.liferay.portlet.messageboards.model.MBCategory returnValue = MBCategoryServiceUtil.updateCategory(categoryId,
                    parentCategoryId, name, description, emailAddress,
                    inProtocol, inServerName, inServerPort, inUseSSL,
                    inUserName, inPassword, inReadInterval, outEmailAddress,
                    outCustom, outServerName, outServerPort, outUseSSL,
                    outUserName, outPassword, mailingListActive,
                    mergeWithParentCategory);

            return com.liferay.portlet.messageboards.model.MBCategorySoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}