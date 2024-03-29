package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.onedoor.model.PmlFileStatus;

import java.util.List;


/**
 * <a href="PmlFileStatusJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlFileStatusServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlFileStatusServiceJSON
 *
 */
public class PmlFileStatusJSONSerializer {
    public static JSONObject toJSONObject(PmlFileStatus model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("fileStatusId", model.getFileStatusId());
        jsonObj.put("fileStatusCode", model.getFileStatusCode());
        jsonObj.put("fileStatusName", model.getFileStatusName());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());
        jsonObj.put("type", model.getType());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFileStatus[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileStatus model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlFileStatus[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileStatus[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlFileStatus> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlFileStatus model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
