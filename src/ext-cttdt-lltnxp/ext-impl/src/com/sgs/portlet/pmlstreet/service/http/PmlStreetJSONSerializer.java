package com.sgs.portlet.pmlstreet.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.pmlstreet.model.PmlStreet;

import java.util.List;


/**
 * <a href="PmlStreetJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.pmlstreet.service.http.PmlStreetServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.pmlstreet.service.http.PmlStreetServiceJSON
 *
 */
public class PmlStreetJSONSerializer {
    public static JSONObject toJSONObject(PmlStreet model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("streetId", model.getStreetId());
        jsonObj.put("streetName", model.getStreetName());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.pmlstreet.model.PmlStreet> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStreet model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
