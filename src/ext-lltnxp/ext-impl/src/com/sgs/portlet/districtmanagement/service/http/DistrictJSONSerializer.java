package com.sgs.portlet.districtmanagement.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.districtmanagement.model.District;

import java.util.List;


/**
 * <a href="DistrictJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.districtmanagement.service.http.DistrictServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.districtmanagement.service.http.DistrictServiceJSON
 *
 */
public class DistrictJSONSerializer {
    public static JSONObject toJSONObject(District model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("districtId", model.getDistrictId());
        jsonObj.put("districtCode", model.getDistrictCode());
        jsonObj.put("districtName", model.getDistrictName());
        jsonObj.put("cityID", model.getCityID());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.districtmanagement.model.District> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (District model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
