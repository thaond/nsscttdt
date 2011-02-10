package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;


/**
 * <a href="CarResourceServiceJSON.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class provides a JSON utility for the
 * <code>com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil</code>
 * service utility. The static methods of this class calls the same methods of
 * the service utility. However, the signatures are different because it is
 * difficult for JSON to support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONArray</code>. If the method in the
 * service utility returns a <code>com.ext.portlet.meetingcalendar.model.CarResource</code>,
 * that is translated to a
 * <code>com.liferay.portal.kernel.json.JSONObject</code>. Methods that JSON
 * cannot safely use are skipped. The logic for the translation is encapsulated
 * in <code>com.ext.portlet.meetingcalendar.service.http.CarResourceJSONSerializer</code>.
 * </p>
 *
 * <p>
 * This allows you to call the the backend services directly from JavaScript.
 * See <code>portal-web/docroot/html/portlet/tags_admin/unpacked.js</code> for a
 * reference of how that portlet uses the generated JavaScript in
 * <code>portal-web/docroot/html/js/service.js</code> to call the backend
 * services directly from JavaScript.
 * </p>
 *
 * <p>
 * The JSON utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.CarResourceServiceUtil
 * @see com.ext.portlet.meetingcalendar.service.http.CarResourceJSONSerializer
 *
 */
public class CarResourceServiceJSON {
    public static JSONObject updateCarResource(long carId,
        java.lang.String carCode, java.lang.String carName,
        java.lang.String description)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        com.ext.portlet.meetingcalendar.model.CarResource returnValue = CarResourceServiceUtil.updateCarResource(carId,
                carCode, carName, description);

        return CarResourceJSONSerializer.toJSONObject(returnValue);
    }

    public static JSONArray getCarResources()
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        java.util.List<com.ext.portlet.meetingcalendar.model.CarResource> returnValue =
            CarResourceServiceUtil.getCarResources();

        return CarResourceJSONSerializer.toJSONArray(returnValue);
    }

    public static void deleteCarResource(long carId)
        throws java.rmi.RemoteException, com.liferay.portal.PortalException,
            com.liferay.portal.SystemException {
        CarResourceServiceUtil.deleteCarResource(carId);
    }
}
