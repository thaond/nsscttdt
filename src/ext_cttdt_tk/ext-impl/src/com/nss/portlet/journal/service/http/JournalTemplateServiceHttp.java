package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;

import com.nss.portlet.journal.service.JournalTemplateServiceUtil;


/**
 * <a href="JournalTemplateServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.nss.portlet.journal.service.JournalTemplateServiceUtil</code> service
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
 * @see com.nss.portlet.journal.service.JournalTemplateServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalTemplateServiceSoap
 *
 */
public class JournalTemplateServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(JournalTemplateServiceHttp.class);

    public static com.nss.portlet.journal.model.JournalTemplate addTemplate(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String templateId,
        boolean autoTemplateId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        java.lang.String xsl, boolean formatXsl, java.lang.String langType,
        boolean cacheable,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = templateId;

            if (templateId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new BooleanWrapper(autoTemplateId);

            Object paramObj3 = structureId;

            if (structureId == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = name;

            if (name == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = description;

            if (description == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = xsl;

            if (xsl == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = new BooleanWrapper(formatXsl);

            Object paramObj8 = langType;

            if (langType == null) {
                paramObj8 = new NullWrapper("java.lang.String");
            }

            Object paramObj9 = new BooleanWrapper(cacheable);

            Object paramObj10 = serviceContext;

            if (serviceContext == null) {
                paramObj10 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "addTemplate",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10
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

            return (com.nss.portlet.journal.model.JournalTemplate) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplate addTemplate(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String templateId,
        boolean autoTemplateId, java.lang.String structureId,
        java.lang.String name, java.lang.String description,
        java.lang.String xsl, boolean formatXsl, java.lang.String langType,
        boolean cacheable, boolean smallImage, java.lang.String smallImageURL,
        java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = templateId;

            if (templateId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new BooleanWrapper(autoTemplateId);

            Object paramObj3 = structureId;

            if (structureId == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = name;

            if (name == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = description;

            if (description == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = xsl;

            if (xsl == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = new BooleanWrapper(formatXsl);

            Object paramObj8 = langType;

            if (langType == null) {
                paramObj8 = new NullWrapper("java.lang.String");
            }

            Object paramObj9 = new BooleanWrapper(cacheable);

            Object paramObj10 = new BooleanWrapper(smallImage);

            Object paramObj11 = smallImageURL;

            if (smallImageURL == null) {
                paramObj11 = new NullWrapper("java.lang.String");
            }

            Object paramObj12 = smallFile;

            if (smallFile == null) {
                paramObj12 = new NullWrapper("java.io.File");
            }

            Object paramObj13 = serviceContext;

            if (serviceContext == null) {
                paramObj13 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "addTemplate",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12, paramObj13
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

            return (com.nss.portlet.journal.model.JournalTemplate) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplate copyTemplate(
        HttpPrincipal httpPrincipal, long groupId,
        java.lang.String oldTemplateId, java.lang.String newTemplateId,
        boolean autoTemplateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = oldTemplateId;

            if (oldTemplateId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = newTemplateId;

            if (newTemplateId == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new BooleanWrapper(autoTemplateId);

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "copyTemplate",
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

            return (com.nss.portlet.journal.model.JournalTemplate) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteTemplate(HttpPrincipal httpPrincipal,
        long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = templateId;

            if (templateId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "deleteTemplate", new Object[] { paramObj0, paramObj1 });

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

    public static java.util.List<com.nss.portlet.journal.model.JournalTemplate> getStructureTemplates(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = structureId;

            if (structureId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "getStructureTemplates",
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

            return (java.util.List<com.nss.portlet.journal.model.JournalTemplate>) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplate getTemplate(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String templateId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = templateId;

            if (templateId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "getTemplate", new Object[] { paramObj0, paramObj1 });

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

            return (com.nss.portlet.journal.model.JournalTemplate) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplate updateTemplate(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = templateId;

            if (templateId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = structureId;

            if (structureId == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = name;

            if (name == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = description;

            if (description == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = xsl;

            if (xsl == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = new BooleanWrapper(formatXsl);

            Object paramObj7 = langType;

            if (langType == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = new BooleanWrapper(cacheable);

            Object paramObj9 = serviceContext;

            if (serviceContext == null) {
                paramObj9 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "updateTemplate",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9
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

            return (com.nss.portlet.journal.model.JournalTemplate) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalTemplate updateTemplate(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String templateId,
        java.lang.String structureId, java.lang.String name,
        java.lang.String description, java.lang.String xsl, boolean formatXsl,
        java.lang.String langType, boolean cacheable, boolean smallImage,
        java.lang.String smallImageURL, java.io.File smallFile,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = templateId;

            if (templateId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = structureId;

            if (structureId == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = name;

            if (name == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            Object paramObj4 = description;

            if (description == null) {
                paramObj4 = new NullWrapper("java.lang.String");
            }

            Object paramObj5 = xsl;

            if (xsl == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = new BooleanWrapper(formatXsl);

            Object paramObj7 = langType;

            if (langType == null) {
                paramObj7 = new NullWrapper("java.lang.String");
            }

            Object paramObj8 = new BooleanWrapper(cacheable);

            Object paramObj9 = new BooleanWrapper(smallImage);

            Object paramObj10 = smallImageURL;

            if (smallImageURL == null) {
                paramObj10 = new NullWrapper("java.lang.String");
            }

            Object paramObj11 = smallFile;

            if (smallFile == null) {
                paramObj11 = new NullWrapper("java.io.File");
            }

            Object paramObj12 = serviceContext;

            if (serviceContext == null) {
                paramObj12 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalTemplateServiceUtil.class.getName(),
                    "updateTemplate",
                    new Object[] {
                        paramObj0, paramObj1, paramObj2, paramObj3, paramObj4,
                        paramObj5, paramObj6, paramObj7, paramObj8, paramObj9,
                        paramObj10, paramObj11, paramObj12
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

            return (com.nss.portlet.journal.model.JournalTemplate) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
