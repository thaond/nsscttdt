package com.sgs.portlet.holiday_calendar.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.holiday_calendar.model.AttactFileHoliday;

import java.util.List;


/**
 * <a href="AttactFileHolidayJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.holiday_calendar.service.http.AttactFileHolidayServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.http.AttactFileHolidayServiceJSON
 *
 */
public class AttactFileHolidayJSONSerializer {
    public static JSONObject toJSONObject(AttactFileHoliday model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("attactFileHolidayId", model.getAttactFileHolidayId());
        jsonObj.put("attactFileHolidayTitle", model.getAttactFileHolidayTitle());
        jsonObj.put("attactFileHolidayPath", model.getAttactFileHolidayPath());
        jsonObj.put("holidayCalendarId", model.getHolidayCalendarId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.holiday_calendar.model.AttactFileHoliday> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (AttactFileHoliday model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
