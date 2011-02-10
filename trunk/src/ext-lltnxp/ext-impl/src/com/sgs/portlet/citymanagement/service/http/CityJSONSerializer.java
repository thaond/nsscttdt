package com.sgs.portlet.citymanagement.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.citymanagement.model.City;

import java.util.List;


/**
 * <a href="CityJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.citymanagement.service.http.CityServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.citymanagement.service.http.CityServiceJSON
 *
 */
public class CityJSONSerializer {
    public static JSONObject toJSONObject(City model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("cityID", model.getCityID());
        jsonObj.put("cityCode", model.getCityCode());
        jsonObj.put("cityName", model.getCityName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());
        jsonObj.put("countryId", model.getCountryId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.citymanagement.model.City> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (City model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
