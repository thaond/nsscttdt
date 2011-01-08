package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.List;


/**
 * <a href="MeetingCalComponentJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.MeetingCalComponentServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingCalComponentServiceJSON
 *
 */
public class MeetingCalComponentJSONSerializer {
    public static JSONObject toJSONObject(MeetingCalComponent model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("mcalId", model.getMcalId());
        jsonObj.put("groupIds", model.getGroupIds());

        Date startDate = model.getStartDate();

        String startDateJSON = StringPool.BLANK;

        if (startDate != null) {
            startDateJSON = String.valueOf(startDate.getTime());
        }

        jsonObj.put("startDate", startDateJSON);

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.ext.portlet.meetingcalendar.model.MeetingCalComponent> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MeetingCalComponent model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
