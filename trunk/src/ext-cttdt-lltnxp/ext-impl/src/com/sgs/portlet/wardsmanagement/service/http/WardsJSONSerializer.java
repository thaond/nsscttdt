package com.sgs.portlet.wardsmanagement.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.wardsmanagement.model.Wards;

import java.util.List;


/**
 * <a href="WardsJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.wardsmanagement.service.http.WardsServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.wardsmanagement.service.http.WardsServiceJSON
 *
 */
public class WardsJSONSerializer {
    public static JSONObject toJSONObject(Wards model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("wardsId", model.getWardsId());
        jsonObj.put("wardsCode", model.getWardsCode());
        jsonObj.put("wardsName", model.getWardsName());
        jsonObj.put("districtId", model.getDistrictId());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.wardsmanagement.model.Wards> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Wards model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
