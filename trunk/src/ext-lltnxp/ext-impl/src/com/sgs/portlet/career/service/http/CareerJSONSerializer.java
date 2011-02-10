package com.sgs.portlet.career.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.career.model.Career;

import java.util.List;


/**
 * <a href="CareerJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.career.service.http.CareerServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.career.service.http.CareerServiceJSON
 *
 */
public class CareerJSONSerializer {
    public static JSONObject toJSONObject(Career model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("careerId", model.getCareerId());
        jsonObj.put("careerCode", model.getCareerCode());
        jsonObj.put("careerName", model.getCareerName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.career.model.Career> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Career model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
