package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodWrapper;
import com.liferay.portal.security.auth.HttpPrincipal;
import com.liferay.portal.service.http.TunnelUtil;


/**
 * <a href="PmlScreenCalendarHeightServiceHttp.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a HTTP utility for the
 * <code>com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightServiceUtil</code> service
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
 * @see com.ext.portlet.meetingcalendar.service.PmlScreenCalendarHeightServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.PmlScreenCalendarHeightServiceSoap
 *
 */
public class PmlScreenCalendarHeightServiceHttp {
    private static Log _log = LogFactoryUtil.getLog(PmlScreenCalendarHeightServiceHttp.class);

    public static com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight getScreenCalendarHeigth(
        HttpPrincipal httpPrincipal) throws com.liferay.portal.SystemException {
        try {
            MethodWrapper methodWrapper = new MethodWrapper(PmlScreenCalendarHeightServiceUtil.class.getName(),
                    "getScreenCalendarHeigth", new Object[0]);

            Object returnObj = null;

            try {
                returnObj = TunnelUtil.invoke(httpPrincipal, methodWrapper);
            } catch (Exception e) {
                throw new com.liferay.portal.SystemException(e);
            }

            return (com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight) returnObj;
        } catch (com.liferay.portal.SystemException se) {
            _log.error(se, se);

            throw se;
        }
    }
}
