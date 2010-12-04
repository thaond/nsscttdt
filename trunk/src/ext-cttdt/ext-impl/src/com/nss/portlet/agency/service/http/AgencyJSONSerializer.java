package com.nss.portlet.agency.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.agency.model.Agency;

import java.util.List;


/**
 * <a href="AgencyJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.agency.service.http.AgencyServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.agency.service.http.AgencyServiceJSON
 *
 */
public class AgencyJSONSerializer {
    public static JSONObject toJSONObject(Agency model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("agencyId", model.getAgencyId());
        jsonObj.put("agencyCode", model.getAgencyCode());
        jsonObj.put("agencyName", model.getAgencyName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.agency.model.Agency[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Agency model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.agency.model.Agency[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Agency[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.agency.model.Agency> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Agency model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
