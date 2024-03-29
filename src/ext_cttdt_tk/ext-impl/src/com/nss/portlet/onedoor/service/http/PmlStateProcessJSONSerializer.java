package com.nss.portlet.onedoor.service.http;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import com.nss.portlet.onedoor.model.PmlStateProcess;

import java.util.List;


/**
 * <a href="PmlStateProcessJSONSerializer.java.html"><b><i>View Source</i></b></a>
 *
 * <p>
 * ServiceBuilder generated this class. Modifications in this class will be
 * overwritten the next time is generated.
 * </p>
 *
 * <p>
 * This class is used by
 * <code>com.nss.portlet.onedoor.service.http.PmlStateProcessServiceJSON</code>
 * to translate objects.
 * </p>
 *
 * @author Brian Wing Shun Chan
 *
 * @see com.nss.portlet.onedoor.service.http.PmlStateProcessServiceJSON
 *
 */
public class PmlStateProcessJSONSerializer {
    public static JSONObject toJSONObject(PmlStateProcess model) {
        JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

        jsonObj.put("stateProcessId", model.getStateProcessId());
        jsonObj.put("stateProcessCode", model.getStateProcessCode());
        jsonObj.put("stateProcessName", model.getStateProcessName());
        jsonObj.put("fileStatusId", model.getFileStatusId());
        jsonObj.put("description", model.getDescription());
        jsonObj.put("active", model.getActive());

        return jsonObj;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlStateProcess[] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateProcess model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        com.nss.portlet.onedoor.model.PmlStateProcess[][] models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateProcess[] model : models) {
            jsonArray.put(toJSONArray(model));
        }

        return jsonArray;
    }

    public static JSONArray toJSONArray(
        List<com.nss.portlet.onedoor.model.PmlStateProcess> models) {
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

        for (PmlStateProcess model : models) {
            jsonArray.put(toJSONObject(model));
        }

        return jsonArray;
    }
}
