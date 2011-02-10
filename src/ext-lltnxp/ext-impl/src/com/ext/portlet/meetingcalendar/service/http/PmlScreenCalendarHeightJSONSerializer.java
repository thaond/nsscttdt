package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;


/**
 * <a href="PmlScreenCalendarHeightJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.PmlScreenCalendarHeightServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.PmlScreenCalendarHeightServiceJSON
 *
 */
public class PmlScreenCalendarHeightJSONSerializer {
    public static JSONObject toJSONObject(PmlScreenCalendarHeight model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("screenCalendarHeightId", model.getScreenCalendarHeightId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.ext.portlet.meetingcalendar.model.PmlScreenCalendarHeight> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlScreenCalendarHeight model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
