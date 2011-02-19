package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.model.MeetingCalendar;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.List;


/**
 * <a href="MeetingCalendarJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.MeetingCalendarServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.MeetingCalendarServiceJSON
 *
 */
public class MeetingCalendarJSONSerializer {
    public static JSONObject toJSONObject(MeetingCalendar model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("uuid", model.getUuid());
        jsonObj.put("mcalId", model.getMcalId());
        jsonObj.put("groupId", model.getGroupId());
        jsonObj.put("companyId", model.getCompanyId());
        jsonObj.put("userId", model.getUserId());
        jsonObj.put("userName", model.getUserName());
        jsonObj.put("state", model.getState());
        jsonObj.put("place", model.getPlace());
        jsonObj.put("place_diff", model.getPlace_diff());
        jsonObj.put("sponsor", model.getSponsor());
        jsonObj.put("component", model.getComponent());
        jsonObj.put("note", model.getNote());
        jsonObj.put("userApproved", model.getUserApproved());

        Date dateApproved = model.getDateApproved();

        String dateApprovedJSON = StringPool.BLANK;

        if (dateApproved != null) {
            dateApprovedJSON = String.valueOf(dateApproved.getTime());
        }

        jsonObj.put("dateApproved", dateApprovedJSON);
        jsonObj.put("moveMcalId", model.getMoveMcalId());
        jsonObj.put("repeatWeek", model.getRepeatWeek());
        jsonObj.put("filename", model.getFilename());
        jsonObj.put("morning", model.getMorning());
        jsonObj.put("afternoon", model.getAfternoon());
        jsonObj.put("evening", model.getEvening());
        jsonObj.put("stt", model.getStt());
        jsonObj.put("prior", model.getPrior());
        jsonObj.put("deleted", model.getDeleted());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.ext.portlet.meetingcalendar.model.MeetingCalendar> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (MeetingCalendar model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
