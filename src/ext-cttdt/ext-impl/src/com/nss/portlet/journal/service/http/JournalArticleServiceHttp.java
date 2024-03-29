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

import com.nss.portlet.journal.service.JournalArticleServiceUtil;


/**
 * <a href="JournalArticleServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.nss.portlet.journal.service.JournalArticleServiceUtil</code> service
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
 * @see com.nss.portlet.journal.service.JournalArticleServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalArticleServiceSoap
 *
 */
public class JournalArticleServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(JournalArticleServiceHttp.class);

    public static com.nss.portlet.journal.model.JournalArticle addArticle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        boolean autoArticleId, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, int displayDateMonth, int displayDateDay,
        int displayDateYear, int displayDateHour, int displayDateMinute,
        int expirationDateMonth, int expirationDateDay, int expirationDateYear,
        int expirationDateHour, int expirationDateMinute, boolean neverExpire,
        int reviewDateMonth, int reviewDateDay, int reviewDateYear,
        int reviewDateHour, int reviewDateMinute, boolean neverReview,
        boolean indexable, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new BooleanWrapper(autoArticleId);

            Object paramObj3 = title;

            if (title == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = description;

            if (description == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = content;

            if (content == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = type;

            if (type == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = structureId;

            if (structureId == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = templateId;

            if (templateId == null) {
                paramObj8 = new NullWrapper("java.lang.String");
            }

            Object paramObj9 = new IntegerWrapper(displayDateMonth);

            Object paramObj10 = new IntegerWrapper(displayDateDay);

            Object paramObj11 = new IntegerWrapper(displayDateYear);

            Object paramObj12 = new IntegerWrapper(displayDateHour);

            Object paramObj13 = new IntegerWrapper(displayDateMinute);

            Object paramObj14 = new IntegerWrapper(expirationDateMonth);

            Object paramObj15 = new IntegerWrapper(expirationDateDay);

            Object paramObj16 = new IntegerWrapper(expirationDateYear);

            Object paramObj17 = new IntegerWrapper(expirationDateHour);

            Object paramObj18 = new IntegerWrapper(expirationDateMinute);

            Object paramObj19 = new BooleanWrapper(neverExpire);

            Object paramObj20 = new IntegerWrapper(reviewDateMonth);

            Object paramObj21 = new IntegerWrapper(reviewDateDay);

            Object paramObj22 = new IntegerWrapper(reviewDateYear);

            Object paramObj23 = new IntegerWrapper(reviewDateHour);

            Object paramObj24 = new IntegerWrapper(reviewDateMinute);

            Object paramObj25 = new BooleanWrapper(neverReview);

            Object paramObj26 = new BooleanWrapper(indexable);

            Object paramObj27 = articleURL;

            if (articleURL == null) {
                paramObj27 = new NullWrapper("java.lang.String");
            }

            Object paramObj28 = serviceContext;

            if (serviceContext == null) {
                paramObj28 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "addArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17,
                        paramObj18, paramObj19, paramObj20, paramObj21,
                        paramObj22, paramObj23, paramObj24, paramObj25,
                        paramObj26, paramObj27, paramObj28
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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle addArticle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        boolean autoArticleId, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, int displayDateMonth, int displayDateDay,
        int displayDateYear, int displayDateHour, int displayDateMinute,
        int expirationDateMonth, int expirationDateDay, int expirationDateYear,
        int expirationDateHour, int expirationDateMinute, boolean neverExpire,
        int reviewDateMonth, int reviewDateDay, int reviewDateYear,
        int reviewDateHour, int reviewDateMinute, boolean neverReview,
        boolean indexable, boolean smallImage, java.lang.String smallImageURL,
        java.io.File smallFile, java.util.Map<String, byte[]> images,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new BooleanWrapper(autoArticleId);

            Object paramObj3 = title;

            if (title == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = description;

            if (description == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = content;

            if (content == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = type;

            if (type == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = structureId;

            if (structureId == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = templateId;

            if (templateId == null) {
                paramObj8 = new NullWrapper("java.lang.String");
            }

            Object paramObj9 = new IntegerWrapper(displayDateMonth);

            Object paramObj10 = new IntegerWrapper(displayDateDay);

            Object paramObj11 = new IntegerWrapper(displayDateYear);

            Object paramObj12 = new IntegerWrapper(displayDateHour);

            Object paramObj13 = new IntegerWrapper(displayDateMinute);

            Object paramObj14 = new IntegerWrapper(expirationDateMonth);

            Object paramObj15 = new IntegerWrapper(expirationDateDay);

            Object paramObj16 = new IntegerWrapper(expirationDateYear);

            Object paramObj17 = new IntegerWrapper(expirationDateHour);

            Object paramObj18 = new IntegerWrapper(expirationDateMinute);

            Object paramObj19 = new BooleanWrapper(neverExpire);

            Object paramObj20 = new IntegerWrapper(reviewDateMonth);

            Object paramObj21 = new IntegerWrapper(reviewDateDay);

            Object paramObj22 = new IntegerWrapper(reviewDateYear);

            Object paramObj23 = new IntegerWrapper(reviewDateHour);

            Object paramObj24 = new IntegerWrapper(reviewDateMinute);

            Object paramObj25 = new BooleanWrapper(neverReview);

            Object paramObj26 = new BooleanWrapper(indexable);

            Object paramObj27 = new BooleanWrapper(smallImage);

            Object paramObj28 = smallImageURL;

            if (smallImageURL == null) {
                paramObj28 = new NullWrapper("java.lang.String");
            }

            Object paramObj29 = smallFile;

            if (smallFile == null) {
                paramObj29 = new NullWrapper("java.io.File");
            }

            Object paramObj30 = images;

            if (images == null) {
                paramObj30 = new NullWrapper("java.util.Map");
            }

            Object paramObj31 = articleURL;

            if (articleURL == null) {
                paramObj31 = new NullWrapper("java.lang.String");
            }

            Object paramObj32 = serviceContext;

            if (serviceContext == null) {
                paramObj32 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "addArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17,
                        paramObj18, paramObj19, paramObj20, paramObj21,
                        paramObj22, paramObj23, paramObj24, paramObj25,
                        paramObj26, paramObj27, paramObj28, paramObj29,
                        paramObj30, paramObj31, paramObj32
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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle approveArticle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        double version, java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = articleURL;

            if (articleURL == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = serviceContext;

            if (serviceContext == null) {
                paramObj4 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "approveArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle copyArticle(
        HttpPrincipal httpPrincipal, long groupId,
        java.lang.String oldArticleId, java.lang.String newArticleId,
        boolean autoArticleId, double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = oldArticleId;

            if (oldArticleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = newArticleId;

            if (newArticleId == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new BooleanWrapper(autoArticleId);

            Object paramObj4 = new DoubleWrapper(version);

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "copyArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle getArticle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "getArticle", new Object[] { paramObj0, paramObj1 });

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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle getArticle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        double version)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "getArticle",
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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle getArticleByUrlTitle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String urlTitle)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = urlTitle;

            if (urlTitle == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "getArticleByUrlTitle",
                    new Object[] { paramObj0, paramObj1 });

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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.lang.String getArticleContent(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = languageId;

            if (languageId == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = themeDisplay;

            if (themeDisplay == null) {
                paramObj3 = new NullWrapper(
                        "com.liferay.portal.theme.ThemeDisplay");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "getArticleContent",
                    new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });

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

    public static java.lang.String getArticleContent(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        double version, java.lang.String languageId,
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = languageId;

            if (languageId == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = themeDisplay;

            if (themeDisplay == null) {
                paramObj4 = new NullWrapper(
                        "com.liferay.portal.theme.ThemeDisplay");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "getArticleContent",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
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

    public static void deleteArticle(HttpPrincipal httpPrincipal, long groupId,
        java.lang.String articleId, double version,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = articleURL;

            if (articleURL == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = serviceContext;

            if (serviceContext == null) {
                paramObj4 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "deleteArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
                    });

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

    public static void expireArticle(HttpPrincipal httpPrincipal, long groupId,
        java.lang.String articleId, double version,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = articleURL;

            if (articleURL == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = serviceContext;

            if (serviceContext == null) {
                paramObj4 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "expireArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
                    });

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

    public static void removeArticleLocale(HttpPrincipal httpPrincipal,
        long companyId, java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(companyId);

            Object paramObj1 = languageId;

            if (languageId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "removeArticleLocale", new Object[] { paramObj0, paramObj1 });

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

    public static com.nss.portlet.journal.model.JournalArticle removeArticleLocale(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        double version, java.lang.String languageId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = languageId;

            if (languageId == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "removeArticleLocale",
                    new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });

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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle updateArticle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        double version, boolean incrementVersion, java.lang.String content)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = new BooleanWrapper(incrementVersion);

            Object paramObj4 = content;

            if (content == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "updateArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4
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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle updateArticle(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        double version, boolean incrementVersion, java.lang.String title,
        java.lang.String description, java.lang.String content,
        java.lang.String type, java.lang.String structureId,
        java.lang.String templateId, int displayDateMonth, int displayDateDay,
        int displayDateYear, int displayDateHour, int displayDateMinute,
        int expirationDateMonth, int expirationDateDay, int expirationDateYear,
        int expirationDateHour, int expirationDateMinute, boolean neverExpire,
        int reviewDateMonth, int reviewDateDay, int reviewDateYear,
        int reviewDateHour, int reviewDateMinute, boolean neverReview,
        boolean indexable, boolean smallImage, java.lang.String smallImageURL,
        java.io.File smallFile, java.util.Map<String, byte[]> images,
        java.lang.String articleURL,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = new BooleanWrapper(incrementVersion);

            Object paramObj4 = title;

            if (title == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = description;

            if (description == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = content;

            if (content == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = type;

            if (type == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = structureId;

            if (structureId == null) {
                paramObj8 = new NullWrapper("java.lang.String");
            }

            Object paramObj9 = templateId;

            if (templateId == null) {
                paramObj9 = new NullWrapper("java.lang.String");
            }

            Object paramObj10 = new IntegerWrapper(displayDateMonth);

            Object paramObj11 = new IntegerWrapper(displayDateDay);

            Object paramObj12 = new IntegerWrapper(displayDateYear);

            Object paramObj13 = new IntegerWrapper(displayDateHour);

            Object paramObj14 = new IntegerWrapper(displayDateMinute);

            Object paramObj15 = new IntegerWrapper(expirationDateMonth);

            Object paramObj16 = new IntegerWrapper(expirationDateDay);

            Object paramObj17 = new IntegerWrapper(expirationDateYear);

            Object paramObj18 = new IntegerWrapper(expirationDateHour);

            Object paramObj19 = new IntegerWrapper(expirationDateMinute);

            Object paramObj20 = new BooleanWrapper(neverExpire);

            Object paramObj21 = new IntegerWrapper(reviewDateMonth);

            Object paramObj22 = new IntegerWrapper(reviewDateDay);

            Object paramObj23 = new IntegerWrapper(reviewDateYear);

            Object paramObj24 = new IntegerWrapper(reviewDateHour);

            Object paramObj25 = new IntegerWrapper(reviewDateMinute);

            Object paramObj26 = new BooleanWrapper(neverReview);

            Object paramObj27 = new BooleanWrapper(indexable);

            Object paramObj28 = new BooleanWrapper(smallImage);

            Object paramObj29 = smallImageURL;

            if (smallImageURL == null) {
                paramObj29 = new NullWrapper("java.lang.String");
            }

            Object paramObj30 = smallFile;

            if (smallFile == null) {
                paramObj30 = new NullWrapper("java.io.File");
            }

            Object paramObj31 = images;

            if (images == null) {
                paramObj31 = new NullWrapper("java.util.Map");
            }

            Object paramObj32 = articleURL;

            if (articleURL == null) {
                paramObj32 = new NullWrapper("java.lang.String");
            }

            Object paramObj33 = serviceContext;

            if (serviceContext == null) {
                paramObj33 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "updateArticle",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13,
                        paramObj14, paramObj15, paramObj16, paramObj17,
                        paramObj18, paramObj19, paramObj20, paramObj21,
                        paramObj22, paramObj23, paramObj24, paramObj25,
                        paramObj26, paramObj27, paramObj28, paramObj29,
                        paramObj30, paramObj31, paramObj32, paramObj33
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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalArticle updateContent(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String articleId,
        double version, java.lang.String content)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = articleId;

            if (articleId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new DoubleWrapper(version);

            Object paramObj3 = content;

            if (content == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalArticleServiceUtil.class.getName(),
                    "updateContent",
                    new Object[] { paramObj0, paramObj1, paramObj2, paramObj3 });

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

            return (com.nss.portlet.journal.model.JournalArticle) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
