package com.sgs.portlet.receivergroup.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;

import com.sgs.portlet.receivergroup.service.ReceiverServiceUtil;


/**
 * <a href="ReceiverServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.sgs.portlet.receivergroup.service.ReceiverServiceUtil</code> service
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
 * @see com.sgs.portlet.receivergroup.service.ReceiverServiceUtil
 * @see com.sgs.portlet.receivergroup.service.http.ReceiverServiceSoap
 *
 */
public class ReceiverServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(ReceiverServiceHttp.class);

    public static com.sgs.portlet.receivergroup.model.Receiver addReceiver(
        HttpPrincipal httpPrincipal, long receiverUserId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(receiverUserId);

            Object paramObj1 = receiverUserName;

            if (receiverUserName == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new IntegerWrapper(receiverType);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverServiceUtil.class.getName(),
                    "addReceiver",
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

            return (com.sgs.portlet.receivergroup.model.Receiver) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static com.sgs.portlet.receivergroup.model.Receiver getReceiver(
        HttpPrincipal httpPrincipal, long receiverUserId,
        java.lang.String receiverUserName, int receiverType)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(receiverUserId);

            Object paramObj1 = receiverUserName;

            if (receiverUserName == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = new IntegerWrapper(receiverType);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverServiceUtil.class.getName(),
                    "getReceiver",
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

            return (com.sgs.portlet.receivergroup.model.Receiver) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.util.List<com.sgs.portlet.receivergroup.model.Receiver> getReceivers(
        HttpPrincipal httpPrincipal, long receiverGroupId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(receiverGroupId);

            MethodWrapper methodWrapper = new MethodWrapper(ReceiverServiceUtil.class.getName(),
                    "getReceivers", new Object[] { paramObj0 });

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

            return (java.util.List<com.sgs.portlet.receivergroup.model.Receiver>) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
