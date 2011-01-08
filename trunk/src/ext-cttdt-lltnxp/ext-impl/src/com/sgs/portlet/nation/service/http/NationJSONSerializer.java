package com.sgs.portlet.nation.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.sgs.portlet.nation.model.Nation;

import java.util.List;


/**
 * <a href="NationJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.sgs.portlet.nation.service.http.NationServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.sgs.portlet.nation.service.http.NationServiceJSON
 *
 */
public class NationJSONSerializer {
    public static JSONObject toJSONObject(Nation model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("nationId", model.getNationId());
        jsonObj.put("nationCode", model.getNationCode());
        jsonObj.put("nationName", model.getNationName());
        jsonObj.put("countryId", model.getCountryId());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        List<com.sgs.portlet.nation.model.Nation> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Nation model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
