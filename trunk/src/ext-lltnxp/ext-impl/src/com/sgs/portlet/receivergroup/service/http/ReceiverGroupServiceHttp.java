package com.sgs.portlet.receivergroup.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.BooleanWrapper;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;

import com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil;


/**
 * <a href="ReceiverGroupServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil</code> service
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverGroupServiceUtil
 * @see com.sgs.portlet.receivergroup.service.http.ReceiverGroupServiceSoap
 *
 */
public class ReceiverGroupServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(ReceiverGroupServiceHttp.class);

    public static void addReceiverToGroup(HttpPrincipal httpPrincipal,
        long groupPK, long receiverUserId, java.lang.String receiverUserName,
        int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(groupPK);

            Object paramObj1 = new LongWrapper(receiverUserId);

            Object paramObj2 = receiverUserName;

            if (receiverUserName == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new IntegerWrapper(receiverType);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverGroupServiceUtil.class.getName(),
                    "addReceiverToGroup",
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

    public static void deleteReceiverGroup(HttpPrincipal httpPrincipal,
        long receiverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(receiverGroupId);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverGroupServiceUtil.class.getName(),
                    "deleteReceiverGroup", new Object[] { paramObj0 });

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

    public static java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup> getReceiverGroups(
        HttpPrincipal httpPrincipal, int type)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new IntegerWrapper(type);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverGroupServiceUtil.class.getName(),
                    "getReceiverGroups", new Object[] { paramObj0 });

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

            return (java.util.List<com.sgs.portlet.receivergroup.model.ReceiverGroup>) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void removeReceiverFromGroup(HttpPrincipal httpPrincipal,
        long receiverGroupId, long receiverUserId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(receiverGroupId);

            Object paramObj1 = new LongWrapper(receiverUserId);

            Object paramObj2 = receiverUserName;

            if (receiverUserName == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new IntegerWrapper(receiverType);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverGroupServiceUtil.class.getName(),
                    "removeReceiverFromGroup",
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

    public static com.sgs.portlet.receivergroup.model.ReceiverGroup updateReceiverGroup(
        HttpPrincipal httpPrincipal, long receiverGroupId,
        java.lang.String receiverGroupName, java.lang.String description,
        int type, boolean active)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(receiverGroupId);

            Object paramObj1 = receiverGroupName;

            if (receiverGroupName == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = description;

            if (description == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = new IntegerWrapper(type);

            Object paramObj4 = new BooleanWrapper(active);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverGroupServiceUtil.class.getName(),
                    "updateReceiverGroup",
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

            return (com.sgs.portlet.receivergroup.model.ReceiverGroup) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
