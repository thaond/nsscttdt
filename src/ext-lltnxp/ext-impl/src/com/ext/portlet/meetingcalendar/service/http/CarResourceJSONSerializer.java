package com.ext.portlet.meetingcalendar.service.http;

import com.ext.portlet.meetingcalendar.model.CarResource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Date;
import java.util.List;


/**
 * <a href="CarResourceJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.ext.portlet.meetingcalendar.service.http.CarResourceServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.ext.portlet.meetingcalendar.service.http.CarResourceServiceJSON
 *
 */
public class CarResourceJSONSerializer {
    public static JSONObject toJSONObject(CarResource model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("carId", model.getCarId());
        jsonObj.put("companyId", model.getCompanyId());
        jsonObj.put("userId", model.getUserId());

        Date createDate = model.getCreateDate();

        String createDateJSON = StringPool.BLANK;

        if (createDate != null) {
            createDateJSON = String.valueOf(createDate.getTime());
        }

        jsonObj.put("createDate", createDateJSON);

        Date modifiedDate = model.getModifiedDate();

        String modifiedDateJSON = StringPool.BLANK;

        if (modifiedDate != null) {
            modifiedDateJSON = String.valueOf(modifiedDate.getTime());
        }

        jsonObj.put("modifiedDate", modifiedDateJSON);
        jsonObj.put("carName", model.getCarName());
        jsonObj.put("carCode", model.getCarCode());
        jsonObj.put("description", model.getDescription());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.ext.portlet.meetingcalendar.model.CarResource> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (CarResource model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
