package com.sgs.portlet.country.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.country.model.Country;

import java.util.List;


/**
 * <a href="CountryJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.country.service.http.CountryServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.country.service.http.CountryServiceJSON
 *
 */
public class CountryJSONSerializer {
    public static JSONObject toJSONObject(Country model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("countryId", model.getCountryId());
        jsonObj.put("countryCode", model.getCountryCode());
        jsonObj.put("countryName", model.getCountryName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.country.model.Country> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Country model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
