package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LongWrapper;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.kernel.util.NullWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;


/**
 * <a href="CarResourceServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil</code> service
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
 * @see com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.CarResourceServiceSoap
 *
 */
public class CarResourceServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(CarResourceServiceHttp.class);

    public static com.ext.portlet.meetingcalendar.model.CarResource updateCarResource(
        HttpPrincipal httpPrincipal, long carId, java.lang.String carCode,
        java.lang.String carName, java.lang.String description)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(carId);

            Object paramObj1 = carCode;

            if (carCode == null) {
                paramObj1 = new NullWrapper("java.lang.String");
            }

            Object paramObj2 = carName;

            if (carName == null) {
                paramObj2 = new NullWrapper("java.lang.String");
            }

            Object paramObj3 = description;

            if (description == null) {
                paramObj3 = new NullWrapper("java.lang.String");
            }

            MethodWrapper methodWrapper = new MethodWrapper(CarResourceServiceUtil.class.getName(),
                    "updateCarResource",
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

            return (com.ext.portlet.meetingcalendar.model.CarResource) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> getCarResources(
        HttpPrincipal httpPrincipal)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            MethodWrapper methodWrapper = new MethodWrapper(CarResourceServiceUtil.class.getName(),
                    "getCarResources", new Object[0]);

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

            return (java.util.List<com.ext.portlet.meetingcalendar.model.CarResource>) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }

    public static void deleteCarResource(HttpPrincipal httpPrincipal, long carId)
        throws com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        try {
            Object paramObj0 = new LongWrapper(carId);

            MethodWrapper methodWrapper = new MethodWrapper(CarResourceServiceUtil.class.getName(),
                    "deleteCarResource", new Object[] { paramObj0 });

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
}
