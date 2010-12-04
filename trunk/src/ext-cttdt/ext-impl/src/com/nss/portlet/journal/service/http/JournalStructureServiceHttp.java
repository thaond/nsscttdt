package com.nss.portlet.journal.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;

import com.nss.portlet.journal.service.JournalStructureServiceUtil;


/**
 * <a href="JournalStructureServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.nss.portlet.journal.service.JournalStructureServiceUtil</code> service
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
 * @see com.nss.portlet.journal.service.JournalStructureServiceUtil
 * @see com.nss.portlet.journal.service.http.JournalStructureServiceSoap
 *
 */
public class JournalStructureServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(JournalStructureServiceHttp.class);

    public static com.nss.portlet.journal.model.JournalStructure addStructure(
        HttpPrincipal httpPrincipal, long groupId,
        java.lang.String structureId, boolean autoStructureId,
        java.lang.String parentStructureId, java.lang.String name,
        java.lang.String description, java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = structureId;

            if (structureId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new BooleanWrapper(autoStructureId);

            Object paramObj3 = parentStructureId;

            if (parentStructureId == null) {
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

            Object paramObj6 = xsd;

            if (xsd == null) {
                paramObj6 = new NullWrapper("java.lang.String");
            }

            Object paramObj7 = serviceContext;

            if (serviceContext == null) {
                paramObj7 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalStructureServiceUtil.class.getName(),
                    "addStructure",
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

            return (com.nss.portlet.journal.model.JournalStructure) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalStructure copyStructure(
        HttpPrincipal httpPrincipal, long groupId,
        java.lang.String oldStructureId, java.lang.String newStructureId,
        boolean autoStructureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = oldStructureId;

            if (oldStructureId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = newStructureId;

            if (newStructureId == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new BooleanWrapper(autoStructureId);

            MethodWrapper methodWrapper = new MethodWrapper(JournalStructureServiceUtil.class.getName(),
                    "copyStructure",
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

            return (com.nss.portlet.journal.model.JournalStructure) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteStructure(HttpPrincipal httpPrincipal,
        long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = structureId;

            if (structureId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalStructureServiceUtil.class.getName(),
                    "deleteStructure", new Object[] { paramObj0, paramObj1 });

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

    public static com.nss.portlet.journal.model.JournalStructure getStructure(
        HttpPrincipal httpPrincipal, long groupId, java.lang.String structureId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = structureId;

            if (structureId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalStructureServiceUtil.class.getName(),
                    "getStructure", new Object[] { paramObj0, paramObj1 });

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

            return (com.nss.portlet.journal.model.JournalStructure) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.nss.portlet.journal.model.JournalStructure updateStructure(
        HttpPrincipal httpPrincipal, long groupId,
        java.lang.String structureId, java.lang.String parentStructureId,
        java.lang.String name, java.lang.String description,
        java.lang.String xsd,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupId);

            Object paramObj1 = structureId;

            if (structureId == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = parentStructureId;

            if (parentStructureId == null) {
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

            Object paramObj5 = xsd;

            if (xsd == null) {
                paramObj5 = new NullWrapper("java.lang.String");
            }

            Object paramObj6 = serviceContext;

            if (serviceContext == null) {
                paramObj6 = new NullWrapper(
                        "com.liferay.portal.service.ServiceContext");
            }

            MethodWrapper methodWrapper = new MethodWrapper(JournalStructureServiceUtil.class.getName(),
                    "updateStructure",
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

            return (com.nss.portlet.journal.model.JournalStructure) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
