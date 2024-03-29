package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.DoubleWrapper;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;

import com.nss.portlet.journal.service.JournalFeedServiceUtil;


/**
 * <a href="JournalFeedServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.nss.portlet.journal.service.JournalFeedServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it requires an
 * additional <code>com.liferay.portal.security.auth.HttpPrincipal</code>
 * parameter.
 * </p>
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <code>tunnel.servlet.hosts.allowed</code> in
 * portal.properties to configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.liferay.portal.security.auth.HttpPrincipal
 * @see com.nss.portlet.journal.service.JournalFeedServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalFeedServiceSoap
 *
 */
public class JournalFeedServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(JournalFeedServiceHttp.class);

    public static com.nss.portlet.journal.model.JournalFeed addFeed(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String feedId,
        boolean autoFeedId, java.lang.String name,
        java.lang.String description, java.lang.String type,
        java.lang.String structureId, java.lang.String templateId,
        java.lang.String rendererTemplateId, int delta,
        java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = feedId;

            if (feedId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new BooleanWrapper(autoFeedId);

            Object paramObj3 = name;

            if (name == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = description;

            if (description == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = type;

            if (type == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = structureId;

            if (structureId == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = templateId;

            if (templateId == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = rendererTemplateId;

            if (rendererTemplateId == null) {
                paramObj8 = new NullWrapper("java.lang.String");
            }

            Object paramObj9 = new IntegerWrapper(delta);

            Object paramObj10 = orderByCol;

            if (orderByCol == null) {
                paramObj10 = new NullWrapper("java.lang.String");
            }

            Object paramObj11 = orderByType;

            if (orderByType == null) {
                paramObj11 = new NullWrapper("java.lang.String");
            }

            Object paramObj12 = targetLayoutFriendlyUrl;

            if (targetLayoutFriendlyUrl == null) {
                paramObj12 = new NullWrapper("java.lang.String");
            }

            Object paramObj13 = targetPortletId;

            if (targetPortletId == null) {
                paramObj13 = new NullWrapper("java.lang.String");
            }

            Object paramObj14 = contentField;

            if (contentField == null) {
                paramObj14 = new NullWrapper("java.lang.String");
            }

            Object paramObj15 = feedType;

            if (feedType == null) {
                paramObj15 = new NullWrapper("java.lang.String");
            }

            Object paramObj16 = new DoubleWrapper(feedVersion);

            Object paramObj17 = serviceContext;

            if (serviceContext == null) {
                paramObj17 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalFeedServiceUtil.class.getName(),
                    "addFeed",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17
                    });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.nss.portlet.journal.model.JournalFeed) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteFeed(HttpPrincipal httpPrincipal, long groupId,
        long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = new LongWrapper(feedId);

            MethodWrapper methodWrapper = new MethodWrapper(JournalFeedServiceUtil.class.getName(),
                    "deleteFeed", new Object[] { paramObj0, paramObj1 });

            try {
                TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteFeed(HttpPrincipal httpPrincipal, long groupId,
        java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = feedId;

            if (feedId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalFeedServiceUtil.class.getName(),
                    "deleteFeed", new Object[] { paramObj0, paramObj1 });

            try {
                TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalFeed getFeed(
        HttpPrincipal httpPrincipal, long groupId, long feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = new LongWrapper(feedId);

            MethodWrapper methodWrapper = new MethodWrapper(JournalFeedServiceUtil.class.getName(),
                    "getFeed", new Object[] { paramObj0, paramObj1 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.nss.portlet.journal.model.JournalFeed) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalFeed getFeed(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String feedId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = feedId;

            if (feedId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalFeedServiceUtil.class.getName(),
                    "getFeed", new Object[] { paramObj0, paramObj1 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.nss.portlet.journal.model.JournalFeed) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalFeed updateFeed(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String feedId,
        java.lang.String name, java.lang.String description,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, java.lang.String rendererTemplateId,
        int delta, java.lang.String orderByCol, java.lang.String orderByType,
        java.lang.String targetLayoutFriendlyUrl,
        java.lang.String targetPortletId, java.lang.String contentField,
        java.lang.String feedType, double feedVersion,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = feedId;

            if (feedId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = name;

            if (name == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = description;

            if (description == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = type;

            if (type == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = structureId;

            if (structureId == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = templateId;

            if (templateId == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = rendererTemplateId;

            if (rendererTemplateId == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = new IntegerWrapper(delta);

            Object paramObj9 = orderByCol;

            if (orderByCol == null) {
                paramObj9 = new NullWrapper("java.lang.String");
            }

            Object paramObj10 = orderByType;

            if (orderByType == null) {
                paramObj10 = new NullWrapper("java.lang.String");
            }

            Object paramObj11 = targetLayoutFriendlyUrl;

            if (targetLayoutFriendlyUrl == null) {
                paramObj11 = new NullWrapper("java.lang.String");
            }

            Object paramObj12 = targetPortletId;

            if (targetPortletId == null) {
                paramObj12 = new NullWrapper("java.lang.String");
            }

            Object paramObj13 = contentField;

            if (contentField == null) {
                paramObj13 = new NullWrapper("java.lang.String");
            }

            Object paramObj14 = feedType;

            if (feedType == null) {
                paramObj14 = new NullWrapper("java.lang.String");
            }

            Object paramObj15 = new DoubleWrapper(feedVersion);

            Object paramObj16 = serviceContext;

            if (serviceContext == null) {
                paramObj16 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalFeedServiceUtil.class.getName(),
                    "updateFeed",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16
                    });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.PortalException) {
                    throw (com.liferay.portal.PortalException) e;
                }

                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return (com.nss.portlet.journal.model.JournalFeed) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
