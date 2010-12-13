package com.nss.portlet.agency.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.agency.model.PmlAgencyLeader;

import java.util.List;


/**
 * <a href="PmlAgencyLeaderJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.agency.service.http.PmlAgencyLeaderServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.agency.service.http.PmlAgencyLeaderServiceJSON
 *
 */
public class PmlAgencyLeaderJSONSerializer {
    public static JSONObject toJSONObject(PmlAgencyLeader model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("agencyId", model.getAgencyId());
        jsonObj.put("userId", model.getUserId());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.agency.model.PmlAgencyLeader[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlAgencyLeader model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.agency.model.PmlAgencyLeader[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlAgencyLeader[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.agency.model.PmlAgencyLeader> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlAgencyLeader model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
