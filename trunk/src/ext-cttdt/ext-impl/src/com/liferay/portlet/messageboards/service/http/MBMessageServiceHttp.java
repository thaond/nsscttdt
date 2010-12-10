package com.liferay.portlet.messageboards.service.http;

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

import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;


/**
 * <a href="MBMessageServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.liferay.portlet.messageboards.service.MBMessageServiceUtil</code> service
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
 * @see com.liferay.portlet.messageboards.service.MBMessageServiceUtil
 * @see com.liferay.portlet.messageboards.service.http.MBMessageServiceSoap
 *
 */
public class MBMessageServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(MBMessageServiceHttp.class);

    public static com.liferay.portlet.messageboards.model.MBMessage addDiscussionMessage(
        HttpPrincipal httpPrincipal, java.lang.String className, long classPK,
        long threadId, long parentMessageId, java.lang.String subject,
        java.lang.String body,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = className;

            if (className == null) {
                paramObj0 = new NullWrapper("java.lang.String");
            }

            Object paramObj1 = new LongWrapper(classPK);

            Object paramObj2 = new LongWrapper(threadId);

            Object paramObj3 = new LongWrapper(parentMessageId);

            Object paramObj4 = subject;

            if (subject == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = body;

            if (body == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = serviceContext;

            if (serviceContext == null) {
                paramObj6 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "addDiscussionMessage",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6
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

            return (com.liferay.portlet.messageboards.model.MBMessage) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.messageboards.model.MBMessage addMessage(
        HttpPrincipal httpPrincipal, long categoryId, java.lang.String subject,
        java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        boolean anonymous, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(categoryId);

            Object paramObj1 = subject;

            if (subject == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = body;

            if (body == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = files;

            if (files == null) {
                paramObj3 = new NullWrapper("java.util.List");
            }

            Object paramObj4 = new BooleanWrapper(anonymous);

            Object paramObj5 = new DoubleWrapper(priority);

            Object paramObj6 = serviceContext;

            if (serviceContext == null) {
                paramObj6 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "addMessage",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6
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

            return (com.liferay.portlet.messageboards.model.MBMessage) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.messageboards.model.MBMessage addMessage(
        HttpPrincipal httpPrincipal, long categoryId, long threadId,
        long parentMessageId, java.lang.String subject, java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        boolean anonymous, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(categoryId);

            Object paramObj1 = new LongWrapper(threadId);

            Object paramObj2 = new LongWrapper(parentMessageId);

            Object paramObj3 = subject;

            if (subject == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = body;

            if (body == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = files;

            if (files == null) {
                paramObj5 = new NullWrapper("java.util.List");
            }

            Object paramObj6 = new BooleanWrapper(anonymous);

            Object paramObj7 = new DoubleWrapper(priority);

            Object paramObj8 = serviceContext;

            if (serviceContext == null) {
                paramObj8 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "addMessage",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8
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

            return (com.liferay.portlet.messageboards.model.MBMessage) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteDiscussionMessage(HttpPrincipal httpPrincipal,
        long groupId, java.lang.String className, long classPK, long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = className;

            if (className == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new LongWrapper(classPK);

            Object paramObj3 = new LongWrapper(messageId);

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "deleteDiscussionMessage",
                    new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });

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

    public static void deleteMessage(HttpPrincipal httpPrincipal, long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(messageId);

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "deleteMessage", new Object[] { paramObj0 });

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

    public static java.util.List<com.liferay.portlet.messageboards.model.MBMessage> getCategoryMessages(
        HttpPrincipal httpPrincipal, long categoryId, int start, int end)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(categoryId);

            Object paramObj1 = new IntegerWrapper(start);

            Object paramObj2 = new IntegerWrapper(end);

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getCategoryMessages",
                    new Object[] { paramObj0, paramObj1, paramObj2 });

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

            return (java.util.List<com.liferay.portlet.messageboards.model.MBMessage>) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static int getCategoryMessagesCount(HttpPrincipal httpPrincipal,
        long categoryId) throws com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(categoryId);

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getCategoryMessagesCount", new Object[] { paramObj0 });

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                if (e instanceof com.liferay.portal.SystemException) {
                    throw (com.liferay.portal.SystemException) e;
                }

                throw new com.liferay.portal.SystemException(e);
            }

            return ((Integer) returnObj).intValue();
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String getCategoryMessagesRSS(
        HttpPrincipal httpPrincipal, long categoryId, int max,
        java.lang.String type, double version, java.lang.String displayStyle,
        java.lang.String feedURL, java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(categoryId);

            Object paramObj1 = new IntegerWrapper(max);

            Object paramObj2 = type;

            if (type == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new DoubleWrapper(version);

            Object paramObj4 = displayStyle;

            if (displayStyle == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = feedURL;

            if (feedURL == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = entryURL;

            if (entryURL == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = themeDisplay;

            if (themeDisplay == null) {
                paramObj7 = new NullWrapper(
                        "com.liferay.portal.theme.ThemeDisplay");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getCategoryMessagesRSS",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7
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

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String getCompanyMessagesRSS(
        HttpPrincipal httpPrincipal, long companyId, int max,
        java.lang.String type, double version, java.lang.String displayStyle,
        java.lang.String feedURL, java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(companyId);

            Object paramObj1 = new IntegerWrapper(max);

            Object paramObj2 = type;

            if (type == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new DoubleWrapper(version);

            Object paramObj4 = displayStyle;

            if (displayStyle == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = feedURL;

            if (feedURL == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = entryURL;

            if (entryURL == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = themeDisplay;

            if (themeDisplay == null) {
                paramObj7 = new NullWrapper(
                        "com.liferay.portal.theme.ThemeDisplay");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getCompanyMessagesRSS",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7
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

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String getGroupMessagesRSS(
        HttpPrincipal httpPrincipal, long groupId, int max,
        java.lang.String type, double version, java.lang.String displayStyle,
        java.lang.String feedURL, java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = new IntegerWrapper(max);

            Object paramObj2 = type;

            if (type == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new DoubleWrapper(version);

            Object paramObj4 = displayStyle;

            if (displayStyle == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = feedURL;

            if (feedURL == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = entryURL;

            if (entryURL == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = themeDisplay;

            if (themeDisplay == null) {
                paramObj7 = new NullWrapper(
                        "com.liferay.portal.theme.ThemeDisplay");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getGroupMessagesRSS",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7
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

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String getGroupMessagesRSS(
        HttpPrincipal httpPrincipal, long groupId, long userId, int max,
        java.lang.String type, double version, java.lang.String displayStyle,
        java.lang.String feedURL, java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = new LongWrapper(userId);

            Object paramObj2 = new IntegerWrapper(max);

            Object paramObj3 = type;

            if (type == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = new DoubleWrapper(version);

            Object paramObj5 = displayStyle;

            if (displayStyle == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = feedURL;

            if (feedURL == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = entryURL;

            if (entryURL == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = themeDisplay;

            if (themeDisplay == null) {
                paramObj8 = new NullWrapper(
                        "com.liferay.portal.theme.ThemeDisplay");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getGroupMessagesRSS",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8
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

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.messageboards.model.MBMessage getMessage(
        HttpPrincipal httpPrincipal, long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(messageId);

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getMessage", new Object[] { paramObj0 });

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

            return (com.liferay.portlet.messageboards.model.MBMessage) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.messageboards.model.MBMessageDisplay getMessageDisplay(
        HttpPrincipal httpPrincipal, long messageId, java.lang.String threadView)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(messageId);

            Object paramObj1 = threadView;

            if (threadView == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getMessageDisplay", new Object[] { paramObj0, paramObj1 });

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

            return (com.liferay.portlet.messageboards.model.MBMessageDisplay) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String getThreadMessagesRSS(
        HttpPrincipal httpPrincipal, long threadId, int max,
        java.lang.String type, double version, java.lang.String displayStyle,
        java.lang.String feedURL, java.lang.String entryURL,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(threadId);

            Object paramObj1 = new IntegerWrapper(max);

            Object paramObj2 = type;

            if (type == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new DoubleWrapper(version);

            Object paramObj4 = displayStyle;

            if (displayStyle == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = feedURL;

            if (feedURL == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = entryURL;

            if (entryURL == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = themeDisplay;

            if (themeDisplay == null) {
                paramObj7 = new NullWrapper(
                        "com.liferay.portal.theme.ThemeDisplay");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "getThreadMessagesRSS",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7
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

            return (java.lang.String) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void subscribeMessage(HttpPrincipal httpPrincipal,
        long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(messageId);

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "subscribeMessage", new Object[] { paramObj0 });

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

    public static void unsubscribeMessage(HttpPrincipal httpPrincipal,
        long messageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(messageId);

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "unsubscribeMessage", new Object[] { paramObj0 });

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

    public static com.liferay.portlet.messageboards.model.MBMessage updateDiscussionMessage(
        HttpPrincipal httpPrincipal, java.lang.String className, long classPK,
        long messageId, java.lang.String subject, java.lang.String body,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = className;

            if (className == null) {
                paramObj0 = new NullWrapper("java.lang.String");
            }

            Object paramObj1 = new LongWrapper(classPK);

            Object paramObj2 = new LongWrapper(messageId);

            Object paramObj3 = subject;

            if (subject == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = body;

            if (body == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = serviceContext;

            if (serviceContext == null) {
                paramObj5 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "updateDiscussionMessage",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5
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

            return (com.liferay.portlet.messageboards.model.MBMessage) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.liferay.portlet.messageboards.model.MBMessage updateMessage(
        HttpPrincipal httpPrincipal, long messageId, java.lang.String subject,
        java.lang.String body,
        java.util.List<com.liferay.portal.kernel.util.ObjectValuePair<String, byte[]>> files,
        java.util.List<String> existingFiles, double priority,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(messageId);

            Object paramObj1 = subject;

            if (subject == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = body;

            if (body == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = files;

            if (files == null) {
                paramObj3 = new NullWrapper("java.util.List");
            }

            Object paramObj4 = existingFiles;

            if (existingFiles == null) {
                paramObj4 = new NullWrapper("java.util.List");
            }

            Object paramObj5 = new DoubleWrapper(priority);

            Object paramObj6 = serviceContext;

            if (serviceContext == null) {
                paramObj6 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(MBMessageServiceUtil.class.getName(),
                    "updateMessage",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6
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

            return (com.liferay.portlet.messageboards.model.MBMessage) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}