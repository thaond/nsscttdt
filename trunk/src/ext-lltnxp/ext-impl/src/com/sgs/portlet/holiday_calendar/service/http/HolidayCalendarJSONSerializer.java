package com.sgs.portlet.holiday_calendar.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.sgs.portlet.holiday_calendar.model.HolidayCalendar;

import java.util.Date;
import java.util.List;


/**
 * <a href="HolidayCalendarJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.holiday_calendar.service.http.HolidayCalendarServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.holiday_calendar.service.http.HolidayCalendarServiceJSON
 *
 */
public class HolidayCalendarJSONSerializer {
    public static JSONObject toJSONObject(HolidayCalendar model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("holidayCalendarId", model.getHolidayCalendarId());
        jsonObj.put("holidayCalendarCode", model.getHolidayCalendarCode());

        Date holidayCalendarDateCreate = model.getHolidayCalendarDateCreate();

        String holidayCalendarDateCreateJSON = StringPool.BLANK;

        if (holidayCalendarDateCreate != null) {
            holidayCalendarDateCreateJSON = String.valueOf(holidayCalendarDateCreate.getTime());
        }

        jsonObj.put("holidayCalendarDateCreate", holidayCalendarDateCreateJSON);
        jsonObj.put("holidayCalendarTitle", model.getHolidayCalendarTitle());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.holiday_calendar.model.HolidayCalendar> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (HolidayCalendar model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
