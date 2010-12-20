package com.nss.portlet.holidaymanagement.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import com.nss.portlet.holidaymanagement.model.PmlHoliday;

import java.util.Date;
import java.util.List;


/**
 * <a href="PmlHolidayJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.holidaymanagement.service.http.PmlHolidayServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.holidaymanagement.service.http.PmlHolidayServiceJSON
 *
 */
public class PmlHolidayJSONSerializer {
    public static JSONObject toJSONObject(PmlHoliday model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("holidayId", model.getHolidayId());
        jsonObj.put("holiday_type", model.getHoliday_type());
        jsonObj.put("holiday_value", model.getHoliday_value());

        Date from_date = model.getFrom_date();

        String from_dateJSON = StringPool.BLANK;

        if (from_date != null) {
            from_dateJSON = String.valueOf(from_date.getTime());
        }

        jsonObj.put("from_date", from_dateJSON);

        Date to_date = model.getTo_date();

        String to_dateJSON = StringPool.BLANK;

        if (to_date != null) {
            to_dateJSON = String.valueOf(to_date.getTime());
        }

        jsonObj.put("to_date", to_dateJSON);

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.holidaymanagement.model.PmlHoliday[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlHoliday model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.holidaymanagement.model.PmlHoliday[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlHoliday[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.holidaymanagement.model.PmlHoliday> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlHoliday model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
