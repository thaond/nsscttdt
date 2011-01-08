package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;


/**
 * <a href="MeetingDetailWeekJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.MeetingDetailWeekServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingDetailWeekServiceJSON
 *
 */
public class MeetingDetailWeekJSONSerializer {
    public static JSONObject toJSONObject(MeetingDetailWeek model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("mdweekId", model.getMdweekId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("userName", model.getUserName());
        jsonObj.put("focus", model.getFocus());
        jsonObj.put("note", model.getNote());
        jsonObj.put("receive", model.getReceive());
        jsonObj.put("week", model.getWeek());
        jsonObj.put("year", model.getYear());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.ext.portlet.meetingcalendar.model.MeetingDetailWeek> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MeetingDetailWeek model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
