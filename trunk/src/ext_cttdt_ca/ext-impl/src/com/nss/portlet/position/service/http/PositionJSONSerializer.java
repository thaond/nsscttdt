package com.nss.portlet.position.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.position.model.Position;

import java.util.List;


/**
 * <a href="PositionJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.position.service.http.PositionServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.position.service.http.PositionServiceJSON
 *
 */
public class PositionJSONSerializer {
    public static JSONObject toJSONObject(Position model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("positionId", model.getPositionId());
        jsonObj.put("positionCode", model.getPositionCode());
        jsonObj.put("positionName", model.getPositionName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.position.model.Position[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Position model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.position.model.Position[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Position[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.position.model.Position> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (Position model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
